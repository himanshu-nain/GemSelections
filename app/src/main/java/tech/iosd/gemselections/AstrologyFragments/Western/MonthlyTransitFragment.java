package tech.iosd.gemselections.AstrologyFragments.Western;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tech.iosd.gemselections.Adapters.WesternMoonPhaseAdapter;
import tech.iosd.gemselections.Adapters.WesternTransitRelationAdapter;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiClient;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.WesternAstrologySimpleRequestTwo;
import tech.iosd.gemselections.Retrofit.ResponseModels.MonthlyTransitResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MoonPhase;
import tech.iosd.gemselections.Retrofit.ResponseModels.TransitRelation;
import tech.iosd.gemselections.Retrofit.ResponseModels.WeeklyTransitResponse;
import tech.iosd.gemselections.Utils.Constants;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class MonthlyTransitFragment extends Fragment {
    RecyclerView weeklyTransitRecyclerView, weeklyMoonPhaseRecyclerView;
    WesternMoonPhaseAdapter westernMoonPhaseAdapter;
    WesternTransitRelationAdapter westernTransitRelationAdapter;
    Retrofit retrofit;
    ArrayList<TransitRelation> houseArrayList = new ArrayList<>();
    ArrayList<MoonPhase> moonPhaseArrayList = new ArrayList<>();
    TextView startDateTextView, endDateTextView, ascendantTextView, moonPhaseTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.western_weekly_transit_frag, container, false);
        weeklyTransitRecyclerView = view.findViewById(R.id.weekly_transit_recycler_view);
        weeklyMoonPhaseRecyclerView = view.findViewById(R.id.weekly_transit_moon_phase_recycler_view);

        weeklyMoonPhaseRecyclerView.setNestedScrollingEnabled(false);
        weeklyTransitRecyclerView.setNestedScrollingEnabled(false);

        startDateTextView = view.findViewById(R.id.weekly_transit_week_start_date);
        endDateTextView = view.findViewById(R.id.weekly_transit_week_end_date);
        ascendantTextView = view.findViewById(R.id.weekly_transit_ascendant);

        AstrologyApiClient astrologyApiClient = new AstrologyApiClient();
        retrofit = astrologyApiClient.getRetrofit();

        AstrologyApiInterface astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading ... ");
        progressDialog.show();

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            WesternAstrologySimpleRequestTwo westernAstrologySimpleRequestTwo //= new WesternAstrologySimpleRequestTwo(20, 2, 1992, 12, 12, Constants.PRIMARY_LAT, Constants.PRIMARY_LNG, Constants.TIMEZONE, Constants.TIMEZONE);
                    = new WesternAstrologySimpleRequestTwo(bundle.getInt(Constants.PRIMARY_DAY, 1)
                    , bundle.getInt(Constants.PRIMARY_MONTH, 1)
                    , bundle.getInt(Constants.PRIMARY_YEAR, 2018)
                    , bundle.getInt(Constants.PRIMARY_HOUR, 1)
                    , bundle.getInt(Constants.PRIMARY_MIN, 1)
                    , Constants.PRIMARY_LAT
                    , Constants.PRIMARY_LNG
                    , Constants.TIMEZONE
                    , 5);//                = new WesternAstrologySimpleRequest(bundle.getInt(Constants.PRIMARY_DAY,1)
//                ,bundle.getInt(Constants.PRIMARY_MONTH,1)
//                ,bundle.getInt(Constants.PRIMARY_YEAR,2018)
//                ,bundle.getInt(Constants.PRIMARY_HOUR,1)
//                ,bundle.getInt(Constants.PRIMARY_MIN,1)
//                ,Constants.PRIMARY_LAT
//                ,Constants.PRIMARY_LNG
//                ,Constants.TIMEZONE);

            Call<MonthlyTransitResponse> call = astrologyApiInterface
                    .getMonthlyTransit(AstrologyApiInterface.HEADER_TOKEN, westernAstrologySimpleRequestTwo);

            call.enqueue(new Callback<MonthlyTransitResponse>() {
                @Override
                public void onResponse(Call<MonthlyTransitResponse> call, Response<MonthlyTransitResponse> response) {
//                    Log.d("TAGGER", "RESPONSE CODE : " + response.code());
//                    Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                    progressDialog.dismiss();
                    if (response.isSuccessful()) {
//                        Log.d("TAGGER", "RESPONSE SUCCESS");
                        if (response.body().getTransitRelation() != null) {

                            houseArrayList.addAll(response.body().getTransitRelation());
                            westernTransitRelationAdapter = new WesternTransitRelationAdapter(getContext(), houseArrayList);
                            weeklyTransitRecyclerView.setAdapter(westernTransitRelationAdapter);
                            weeklyTransitRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        }
                        if(response.body().getTransitRelation() != null){
                            moonPhaseArrayList.addAll(response.body().getMoonPhase());

                            westernMoonPhaseAdapter = new WesternMoonPhaseAdapter(getContext(),moonPhaseArrayList);
                            weeklyMoonPhaseRecyclerView.setAdapter(westernMoonPhaseAdapter);
                            weeklyMoonPhaseRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        }

                    }
                }

                @Override
                public void onFailure(Call<MonthlyTransitResponse> call, Throwable t) {

//                    Log.d("TAGGER", "RESPONSE FAILURE");
//                    Log.d("TAGGER", t.getMessage());
                    Snackbar.make(weeklyTransitRecyclerView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);

                    progressDialog.dismiss();
                }
            });

        } else {
            progressDialog.dismiss();
            Snackbar.make(weeklyTransitRecyclerView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);
        }
        return view;
    }
}
