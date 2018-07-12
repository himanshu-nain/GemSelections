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

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tech.iosd.gemselections.Adapters.WesternChartHouseAdapter;
import tech.iosd.gemselections.Adapters.WesternHoroscopeAspectAdapter;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiClient;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.WesternAstrologySimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.Aspect;
import tech.iosd.gemselections.Retrofit.ResponseModels.House;
import tech.iosd.gemselections.Retrofit.ResponseModels.WesternChartResponse;
import tech.iosd.gemselections.Utils.Constants;

/**
 * Created by anubhavmalik on 27/03/18.
 */

public class WesternChartFragment extends Fragment {
    RecyclerView houseRecyclerView, planetRecyclerView, aspectRecyclerView;
    WesternHoroscopeAspectAdapter westernHoroscopeAspectAdapter;
    WesternChartHouseAdapter westernChartHouseAdapter;
    Retrofit retrofit;
    ArrayList<House> houseArrayList = new ArrayList<>();
    ArrayList<Aspect> aspectArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.western_horoscope_fragment, container, false);
        houseRecyclerView = view.findViewById(R.id.western_horoscope_house_recycler_list);
        aspectRecyclerView = view.findViewById(R.id.western_horoscope_aspect_recycler_list);
//        planetRecyclerView = view.findViewById(R.id.western_horoscope_planet_recycler_list);
        houseRecyclerView.setNestedScrollingEnabled(false);
        aspectRecyclerView.setNestedScrollingEnabled(false);

        view.findViewById(R.id.western_chart_card_2).setVisibility(View.INVISIBLE);


        AstrologyApiClient astrologyApiClient = new AstrologyApiClient();
        retrofit = astrologyApiClient.getRetrofit();

        AstrologyApiInterface astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);

        view.findViewById(R.id.western_chart_card_2).setVisibility(View.INVISIBLE);

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading ... ");
        progressDialog.show();

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            WesternAstrologySimpleRequest westernAstrologySimpleRequest = new WesternAstrologySimpleRequest(bundle.getInt(Constants.PRIMARY_DAY)
                    , bundle.getInt(Constants.PRIMARY_MONTH)
                    , bundle.getInt(Constants.PRIMARY_YEAR)
                    , bundle.getInt(Constants.PRIMARY_HOUR)
                    , bundle.getInt(Constants.PRIMARY_MIN)
                    , Constants.PRIMARY_LAT
                    , Constants.PRIMARY_LNG
                    , Constants.TIMEZONE);

//            = new WesternAstrologySimpleRequest(bundle.getInt(Constants.PRIMARY_DAY,1)
//                ,bundle.getInt(Constants.PRIMARY_MONTH,1)
//                ,bundle.getInt(Constants.PRIMARY_YEAR,2018)
//                ,bundle.getInt(Constants.PRIMARY_HOUR,1)
//                ,bundle.getInt(Constants.PRIMARY_MIN,1)
//                ,Constants.PRIMARY_LAT
//                ,Constants.PRIMARY_LNG
//                ,Constants.TIMEZONE);

            Call<WesternChartResponse> call = astrologyApiInterface
                    .getWesternHoroscopeChart(AstrologyApiInterface.HEADER_TOKEN, westernAstrologySimpleRequest);

            call.enqueue(new Callback<WesternChartResponse>() {
                @Override
                public void onResponse(Call<WesternChartResponse> call, Response<WesternChartResponse> response) {
//                    Log.d("TAGGER", "RESPONSE CODE : " + response.code());
//                    Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                    progressDialog.dismiss();
                    if (response.isSuccessful()) {
//                        Log.d("TAGGER", "RESPONSE SUCCESS");
                        if (response.body().getHouses() != null) {
//                            Log.d("TAGGER", "RESPONSE SUCCESS1");

                            houseArrayList.addAll(response.body().getHouses());
                            westernChartHouseAdapter = new WesternChartHouseAdapter(getContext(), houseArrayList);
                            houseRecyclerView.setAdapter(westernChartHouseAdapter);
                            houseRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        }

                        if (response.body().getAspects() != null) {
//                            Log.d("TAGGER", "RESPONSE SUCCESS3");
                            aspectArrayList.addAll(response.body().getAspects());
                            westernHoroscopeAspectAdapter = new WesternHoroscopeAspectAdapter(getContext(), aspectArrayList);
                            aspectRecyclerView.setAdapter(westernHoroscopeAspectAdapter);
                            aspectRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        }
                        westernHoroscopeAspectAdapter.notifyDataSetChanged();
                        westernChartHouseAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<WesternChartResponse> call, Throwable t) {

//                    Log.d("TAGGER", "RESPONSE FAILURE");
//                    Log.d("TAGGER", t.getMessage());
                    Snackbar.make(houseRecyclerView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);

                    progressDialog.dismiss();
                }
            });

        } else {
            progressDialog.dismiss();
            Snackbar.make(houseRecyclerView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);
        }
        return view;
    }
}

