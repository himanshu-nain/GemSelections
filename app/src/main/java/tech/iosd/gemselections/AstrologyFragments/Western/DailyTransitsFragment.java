package tech.iosd.gemselections.AstrologyFragments.Western;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tech.iosd.gemselections.Adapters.WesternTransitHouseAdapter;
import tech.iosd.gemselections.Adapters.WesternTransitRelationAdapter;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiClient;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.WesternAstrologySimpleRequestTwo;
import tech.iosd.gemselections.Retrofit.ResponseModels.DailyTransitsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.TransitHouses;
import tech.iosd.gemselections.Retrofit.ResponseModels.TransitRelation;
import tech.iosd.gemselections.Utils.Constants;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class DailyTransitsFragment extends Fragment {
    RecyclerView transitHouseRecyclerView, transitRelationRecyclerView;
    Retrofit retrofit;
    WesternTransitHouseAdapter westernHoroscopeHouseAdapter;
    WesternTransitRelationAdapter westernHoroscopePlanetAdapter;
    ArrayList<TransitHouses> houseArrayList = new ArrayList<>();
    ArrayList<TransitRelation> planetArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.western_daily_transit_fragment, container, false);

        transitHouseRecyclerView = view.findViewById(R.id.western_transit_recycler_list_one);
        transitRelationRecyclerView = view.findViewById(R.id.western_transit_recycler_list_two);
        transitHouseRecyclerView.setNestedScrollingEnabled(false);
        transitRelationRecyclerView.setNestedScrollingEnabled(false);
        AstrologyApiClient astrologyApiClient = new AstrologyApiClient();
        retrofit = astrologyApiClient.getRetrofit();

        AstrologyApiInterface astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading ... ");
        progressDialog.show();

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            WesternAstrologySimpleRequestTwo westernAstrologySimpleRequest //= new WesternAstrologySimpleRequestTwo(20, 2, 1992, 12, 12, Constants.PRIMARY_LAT, Constants.PRIMARY_LNG, Constants.TIMEZONE, Constants.TIMEZONE);
                    = new WesternAstrologySimpleRequestTwo(bundle.getInt(Constants.PRIMARY_DAY, 1)
                    , bundle.getInt(Constants.PRIMARY_MONTH, 1)
                    , bundle.getInt(Constants.PRIMARY_YEAR, 2018)
                    , bundle.getInt(Constants.PRIMARY_HOUR, 1)
                    , bundle.getInt(Constants.PRIMARY_MIN, 1)
                    , Constants.PRIMARY_LAT
                    , Constants.PRIMARY_LNG
                    , Constants.TIMEZONE
                    , 5);


            Call<DailyTransitsResponse> call = astrologyApiInterface
                    .getDailyTransit(AstrologyApiInterface.HEADER_TOKEN, westernAstrologySimpleRequest);

            call.enqueue(new Callback<DailyTransitsResponse>() {
                @Override
                public void onResponse(Call<DailyTransitsResponse> call, Response<DailyTransitsResponse> response) {
                    Log.d("TAGGER", "RESPONSE CODE : " + response.code());
                    Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                    progressDialog.dismiss();
                    if (response.isSuccessful()) {
                        Log.d("TAGGER", "RESPONSE SUCCESS");
                        if (response.body().getTransitHouse() != null) {
                            Log.d("TAGGER", "RESPONSE SUCCESS1");

                            houseArrayList.addAll(response.body().getTransitHouse());
                            westernHoroscopeHouseAdapter = new WesternTransitHouseAdapter(getContext(), houseArrayList);
                            transitHouseRecyclerView.setAdapter(westernHoroscopeHouseAdapter);
                            transitHouseRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        }
                        if (response.body().getTransitRelation() != null) {

                            planetArrayList.addAll(response.body().getTransitRelation());
//                            Log.d("TAGGER", "RESPONSE SUCCESS2" + planetArrayList.get(2)./());

                            westernHoroscopePlanetAdapter = new WesternTransitRelationAdapter(getContext(), planetArrayList);
                            transitRelationRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                            transitRelationRecyclerView.setAdapter(westernHoroscopePlanetAdapter);
                        }
                        westernHoroscopePlanetAdapter.notifyDataSetChanged();
                        westernHoroscopeHouseAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<DailyTransitsResponse> call, Throwable t) {

                    Log.d("TAGGER", "RESPONSE FAILURE");
                    Log.d("TAGGER", t.getMessage());
                    Snackbar.make(transitHouseRecyclerView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);

                    progressDialog.dismiss();
                }
            });


        } else {
            progressDialog.dismiss();
            Snackbar.make(transitRelationRecyclerView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);
        }
        return view;
    }
}

