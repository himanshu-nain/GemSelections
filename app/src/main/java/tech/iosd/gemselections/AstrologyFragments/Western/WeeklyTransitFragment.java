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
import tech.iosd.gemselections.Retrofit.RequestModels.WesternAstrologySimpleRequest;
import tech.iosd.gemselections.Retrofit.RequestModels.WesternAstrologySimpleRequestTwo;
import tech.iosd.gemselections.Retrofit.ResponseModels.MoonPhase;
import tech.iosd.gemselections.Retrofit.ResponseModels.TransitRelation;
import tech.iosd.gemselections.Retrofit.ResponseModels.WeeklyTransitResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.WesternChartResponse;
import tech.iosd.gemselections.Utils.Constants;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class WeeklyTransitFragment extends Fragment {

    RecyclerView weeklyTransitRecyclerView, moonPhaseRecyclerView;
    WesternTransitRelationAdapter westernTransitRelationAdapter;
    WesternMoonPhaseAdapter westernMoonPhaseAdapter;
    Retrofit retrofit;
    ArrayList<TransitRelation> houseArrayList = new ArrayList<>();
    ArrayList<MoonPhase> moonPhaseArrayList = new ArrayList<>();
    TextView startDateTextView, endDateTextView, ascendantTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.western_weekly_transit_frag, container, false);
        weeklyTransitRecyclerView = view.findViewById(R.id.weekly_transit_recycler_view);
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
        bundle = new Bundle();
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

            Call<WeeklyTransitResponse> call = astrologyApiInterface
                    .getWeeklyTransit(AstrologyApiInterface.HEADER_TOKEN, westernAstrologySimpleRequestTwo);

            call.enqueue(new Callback<WeeklyTransitResponse>() {
                @Override
                public void onResponse(Call<WeeklyTransitResponse> call, Response<WeeklyTransitResponse> response) {
//                    Log.d("TAGGER", "RESPONSE CODE : " + response.code());
//                    Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                    progressDialog.dismiss();
                    if (response.isSuccessful()) {
//                        Log.d("TAGGER", "RESPONSE SUCCESS");
                        if (response.body().getTransitRelation() != null) {

                            if (response.body().getAscendant() != null)
                            ascendantTextView.append(response.body().getAscendant());
                            if (response.body().getWeekEndDate() != null)
                            endDateTextView.append(response.body().getWeekEndDate());
                            if (response.body().getWeekStartDate() != null)
                            startDateTextView.append(response.body().getWeekStartDate());

//                            Log.d("TAGGER", "RESPONSE SUCCESS1");

                            houseArrayList.addAll(response.body().getTransitRelation());
                            westernTransitRelationAdapter = new WesternTransitRelationAdapter(getContext(), houseArrayList);
                            weeklyTransitRecyclerView.setAdapter(westernTransitRelationAdapter);
                            weeklyTransitRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        }

                        if(response.body().getMoonPhase() != null){
                            moonPhaseArrayList.addAll(response.body().getMoonPhase());

                            westernMoonPhaseAdapter = new WesternMoonPhaseAdapter(getContext(),moonPhaseArrayList);
                            moonPhaseRecyclerView.setAdapter(westernMoonPhaseAdapter);
                            moonPhaseRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        }
                    }
                }

                @Override
                public void onFailure(Call<WeeklyTransitResponse> call, Throwable t) {

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
