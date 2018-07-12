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
import tech.iosd.gemselections.Adapters.WesternHoroscopeAspectAdapter;
import tech.iosd.gemselections.Adapters.WesternHoroscopeHouseAdapter;
import tech.iosd.gemselections.Adapters.WesternHoroscopePlanetAdapter;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiClient;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.WesternAstrologySimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.Aspect;
import tech.iosd.gemselections.Retrofit.ResponseModels.House;
import tech.iosd.gemselections.Retrofit.ResponseModels.Planet;
import tech.iosd.gemselections.Retrofit.ResponseModels.WesternHoroscopeResponse;
import tech.iosd.gemselections.Utils.Constants;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class WesternHoroscopeFragment extends Fragment {
    RecyclerView houseRecyclerView, planetRecyclerView, aspectRecyclerView;
    WesternHoroscopePlanetAdapter westernHoroscopePlanetAdapter;
    WesternHoroscopeAspectAdapter westernHoroscopeAspectAdapter;
    WesternHoroscopeHouseAdapter westernHoroscopeHouseAdapter;
    Retrofit retrofit;
    ArrayList<House> houseArrayList = new ArrayList<>();
    ArrayList<Planet> planetArrayList =new ArrayList<>();
    ArrayList<Aspect> aspectArrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.western_horoscope_fragment, container, false);

        houseRecyclerView = view.findViewById(R.id.western_horoscope_house_recycler_list);
        aspectRecyclerView = view.findViewById(R.id.western_horoscope_aspect_recycler_list);
        planetRecyclerView = view.findViewById(R.id.western_horoscope_planet_recycler_list);
        houseRecyclerView.setNestedScrollingEnabled(false);
        aspectRecyclerView.setNestedScrollingEnabled(false);
        planetRecyclerView.setNestedScrollingEnabled(false);

        AstrologyApiClient astrologyApiClient = new AstrologyApiClient();
        retrofit = astrologyApiClient.getRetrofit();

        AstrologyApiInterface astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading ... ");
        progressDialog.show();

        Bundle bundle = this.getArguments();
//        bundle = new Bundle();
        if(bundle!=null){

        WesternAstrologySimpleRequest westernAstrologySimpleRequest  =  new WesternAstrologySimpleRequest(bundle.getInt(Constants.PRIMARY_DAY)
                ,bundle.getInt(Constants.PRIMARY_MONTH)
                ,bundle.getInt(Constants.PRIMARY_YEAR)
                ,bundle.getInt(Constants.PRIMARY_HOUR)
                ,bundle.getInt(Constants.PRIMARY_MIN)
                ,Constants.PRIMARY_LAT
                ,Constants.PRIMARY_LNG
                ,Constants.TIMEZONE);
//                = new WesternAstrologySimpleRequest(bundle.getInt(Constants.PRIMARY_DAY,1)
//                ,bundle.getInt(Constants.PRIMARY_MONTH,1)
//                ,bundle.getInt(Constants.PRIMARY_YEAR,2018)
//                ,bundle.getInt(Constants.PRIMARY_HOUR,1)
//                ,bundle.getInt(Constants.PRIMARY_MIN,1)
//                ,Constants.PRIMARY_LAT
//                ,Constants.PRIMARY_LNG
//                ,Constants.TIMEZONE);

        Call<WesternHoroscopeResponse> call = astrologyApiInterface
                .getWesternHoroscope(AstrologyApiInterface.HEADER_TOKEN, westernAstrologySimpleRequest);

        call.enqueue(new Callback<WesternHoroscopeResponse>() {
            @Override
            public void onResponse(Call<WesternHoroscopeResponse> call, Response<WesternHoroscopeResponse> response) {
                Log.d("TAGGER","RESPONSE CODE : "+response.code());
                Log.d("TAGGER","RESPONSE BODY : "+response.body());
                progressDialog.dismiss();
                if(response.isSuccessful()){
                    Log.d("TAGGER","RESPONSE SUCCESS");
                    if(response.body().getHouses()!=null) {
                        Log.d("TAGGER","RESPONSE SUCCESS1");

                        houseArrayList.addAll(response.body().getHouses());
                        westernHoroscopeHouseAdapter = new WesternHoroscopeHouseAdapter(getContext(), houseArrayList);
                        houseRecyclerView.setAdapter(westernHoroscopeHouseAdapter);
                        houseRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    }
                    if(response.body().getPlanets()!=null) {

                        planetArrayList.addAll(response.body().getPlanets());
                        Log.d("TAGGER","RESPONSE SUCCESS2"+planetArrayList.get(2).getName());

                        westernHoroscopePlanetAdapter = new WesternHoroscopePlanetAdapter(getContext(), planetArrayList);
                        planetRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        planetRecyclerView.setAdapter(westernHoroscopePlanetAdapter);
                    }
                    if(response.body().getAspects()!=null){
                        Log.d("TAGGER","RESPONSE SUCCESS3");

                        aspectArrayList.addAll(response.body().getAspects());
                        westernHoroscopeAspectAdapter = new WesternHoroscopeAspectAdapter(getContext(), aspectArrayList);
                        aspectRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        aspectRecyclerView.setAdapter(westernHoroscopeAspectAdapter);
                    }
                    westernHoroscopeAspectAdapter.notifyDataSetChanged();
                    westernHoroscopePlanetAdapter.notifyDataSetChanged();
                    westernHoroscopeHouseAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<WesternHoroscopeResponse> call, Throwable t) {

                Log.d("TAGGER","RESPONSE FAILURE");
                Log.d("TAGGER",t.getMessage());
                Snackbar.make(houseRecyclerView,"PLEASE RETRY",Snackbar.LENGTH_INDEFINITE);

                progressDialog.dismiss();
            }
        });


        }

        else{
            progressDialog.dismiss();
            Snackbar.make(houseRecyclerView,"PLEASE RETRY",Snackbar.LENGTH_INDEFINITE);
        }
        return view;
    }
}
