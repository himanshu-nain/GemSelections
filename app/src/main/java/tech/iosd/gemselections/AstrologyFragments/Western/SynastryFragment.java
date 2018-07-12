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
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tech.iosd.gemselections.Adapters.WesternHoroscopeAspectAdapter;
import tech.iosd.gemselections.Adapters.WesternHoroscopeHouseAdapter;
import tech.iosd.gemselections.Adapters.WesternHoroscopePlanetAdapter;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiClient;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.WesternAstrologyComplexRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.Aspect;
import tech.iosd.gemselections.Retrofit.ResponseModels.CompositeHoroscopeResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.House;
import tech.iosd.gemselections.Retrofit.ResponseModels.Planet;
import tech.iosd.gemselections.Utils.Constants;

/**
 * Created by anubhavmalik on 27/03/18.
 */

public class SynastryFragment extends Fragment {
    RecyclerView compositeHouseRecyclerView, compositePlanetRecyclerView, compositeAspectRecyclerView, compositeFirstRecyclerView, compositeSecondRecyclerView;
    Retrofit retrofit;
    WesternHoroscopeHouseAdapter westernHoroscopeHouseAdapter;
    WesternHoroscopePlanetAdapter westernHoroscopePlanetAdapter, westernHoroscopeFirstAdapter, westernHoroscopeSecondAdapter;
    WesternHoroscopeAspectAdapter westernHoroscopeAspectAdapter;
    ArrayList<House> houseArrayList = new ArrayList<>();
    ArrayList<Planet> planetArrayList = new ArrayList<>();
    ArrayList<Planet> firstArrayList = new ArrayList<>();
    ArrayList<Planet> secondArrayList = new ArrayList<>();
    ArrayList<Aspect> aspectArrayList = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.western_composite_horoscope_frag, container, false);

        compositeAspectRecyclerView = view.findViewById(R.id.western_composite_aspect_recycler_list);
        compositeFirstRecyclerView = view.findViewById(R.id.western_composite_first_recycler_list);
        compositeHouseRecyclerView = view.findViewById(R.id.western_composite_house_recycler_list);
        compositeSecondRecyclerView = view.findViewById(R.id.western_composite_second_recycler_list);
        compositePlanetRecyclerView = view.findViewById(R.id.western_composite_planet_recycler_list);
//        final TextView ascendantTextView = view.findViewById(R.id.western_composite_ascendant);
//        final TextView midHeavenTextView = view.findViewById(R.id.western_composite_midheaven);

        compositeAspectRecyclerView.setNestedScrollingEnabled(false);
        compositeFirstRecyclerView.setNestedScrollingEnabled(false);
        compositeHouseRecyclerView.setNestedScrollingEnabled(false);
        compositeSecondRecyclerView.setNestedScrollingEnabled(false);

        view.findViewById(R.id.western_composite_chart_card_0).setVisibility(View.GONE);
        view.findViewById(R.id.western_composite_chart_card_3).setVisibility(View.GONE);
        view.findViewById(R.id.western_composite_chart_card_4).setVisibility(View.GONE);

        final AstrologyApiClient astrologyApiClient = new AstrologyApiClient();
        retrofit = astrologyApiClient.getRetrofit();

        AstrologyApiInterface astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading ... ");
        progressDialog.show();

        Bundle bundle = this.getArguments();
        if (bundle != null) {


            WesternAstrologyComplexRequest westernAstrologyComplexRequest = new WesternAstrologyComplexRequest(bundle.getInt(Constants.PRIMARY_DAY)
                    , bundle.getInt(Constants.PRIMARY_MONTH)
                    , bundle.getInt(Constants.PRIMARY_YEAR)
                    , bundle.getInt(Constants.PRIMARY_HOUR)
                    , bundle.getInt(Constants.PRIMARY_MIN)
                    , Constants.PRIMARY_LAT
                    , Constants.PRIMARY_LNG
                    , Constants.TIMEZONE
                    , bundle.getInt(Constants.SECONDARY_DAY)
                    , bundle.getInt(Constants.SECONDARY_MONTH)
                    , bundle.getInt(Constants.SECONDARY_YEAR)
                    , bundle.getInt(Constants.SECONDARY_HOUR)
                    , bundle.getInt(Constants.SECONDARY_MIN)
                    , Constants.PRIMARY_LAT
                    , Constants.PRIMARY_LNG
                    , Constants.TIMEZONE);//  //         //                = new WesternAstrologySimpleRequest(bundle.getInt(Constants.PRIMARY_DAY,1)
//                ,bundle.getInt(Constants.PRIMARY_MONTH,1)
//                ,bundle.getInt(Constants.PRIMARY_YEAR,2018)
//                ,bundle.getInt(Constants.PRIMARY_HOUR,1)
//                ,bundle.getInt(Constants.PRIMARY_MIN,1)
//                ,Constants.PRIMARY_LAT
//                ,Constants.PRIMARY_LNG
//                ,Constants.TIMEZONE);


            Call<CompositeHoroscopeResponse> call = astrologyApiInterface
                    .getSynastryHoroscope(AstrologyApiInterface.HEADER_TOKEN, westernAstrologyComplexRequest);

            call.enqueue(new Callback<CompositeHoroscopeResponse>() {
                @Override
                public void onResponse(Call<CompositeHoroscopeResponse> call, Response<CompositeHoroscopeResponse> response) {
                    Log.d("TAGGER", "RESPONSE CODE : " + response.code());
                    Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                    progressDialog.dismiss();
                    if (response.isSuccessful()) {
//                        ascendantTextView.append(response.body().getSynastry().getAscendant()+"");
//                        midHeavenTextView.append(response.body().getSynastry().getMidheaven()+"");
                        Log.d("TAGGER", "RESPONSE SUCCESS");
                        if (response.body().getSynastry().getAspects() != null) {
                            Log.d("TAGGER", "RESPONSE SUCCESS1");

                            aspectArrayList.addAll(response.body().getSynastry().getAspects());
                            westernHoroscopeAspectAdapter = new WesternHoroscopeAspectAdapter(getContext(), aspectArrayList);
                            compositeAspectRecyclerView.setAdapter(westernHoroscopeAspectAdapter);
                            compositeAspectRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        }
                        if (response.body().getFirst() != null) {

                            firstArrayList.addAll(response.body().getFirst());
//                            Log.d("TAGGER", "RESPONSE SUCCESS2" + planetArrayList.get(2)./());

                            westernHoroscopePlanetAdapter = new WesternHoroscopePlanetAdapter(getContext(), firstArrayList);
                            compositeFirstRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                            compositeFirstRecyclerView.setAdapter(westernHoroscopePlanetAdapter);
                        }
//                        if (response.body().getComposite().getHouses() != null) {
//                            Log.d("TAGGER", "RESPONSE SUCCESS1");
//
//                            houseArrayList.addAll(response.body().getComposite().getHouses());
//                            westernHoroscopeHouseAdapter = new WesternHoroscopeHouseAdapter(getContext(), houseArrayList);
//                            compositeHouseRecyclerView.setAdapter(westernHoroscopeHouseAdapter);
//                            compositeHouseRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//                        }
//                        if (response.body().getComposite().getPlanets() != null) {
//
//                            planetArrayList.addAll(response.body().getComposite().getPlanets());
//                            Log.d("TAGGER", "RESPONSE SUCCESS2" + planetArrayList.get(2)./());
//
//                            westernHoroscopePlanetAdapter = new WesternHoroscopePlanetAdapter(getContext(), planetArrayList);
//                            compositePlanetRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//                            compositePlanetRecyclerView.setAdapter(westernHoroscopePlanetAdapter);
//                        }
                        if (response.body().getSecond() != null) {
                            Log.d("TAGGER", "RESPONSE SUCCESS1");

                            secondArrayList.addAll(response.body().getSecond());
                            westernHoroscopeSecondAdapter = new WesternHoroscopePlanetAdapter(getContext(), secondArrayList);
                            compositeSecondRecyclerView.setAdapter(westernHoroscopeSecondAdapter);
                            compositeSecondRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        }

//                        westernHoroscopePlanetAdapter.notifyDataSetChanged();
//                        westernHoroscopeHouseAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(Call<CompositeHoroscopeResponse> call, Throwable t) {

                    Log.d("TAGGER", "RESPONSE FAILURE");
                    Log.d("TAGGER", t.getMessage());
                    Snackbar.make(compositeAspectRecyclerView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);

                    progressDialog.dismiss();
                }
            });


        } else {
            progressDialog.dismiss();
            Snackbar.make(compositeAspectRecyclerView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);
        }
        return view;
    }
}
