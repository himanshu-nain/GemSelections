package tech.iosd.gemselections.AstrologyFragments;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingSimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchBirthDetailResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchMakingDetailedReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.PredictionResponse;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchBirthDetailFragment extends Fragment {

    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;
    public static final String TAG = "latlong";
    double mlat,mlongilo,flat,flongilo;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_birth_detail_astrology, container, false);

        // getting arguments from matchmakinginputfrag1
        int mdob = getArguments().getInt("mdob");
        int mmob = getArguments().getInt("mmob");
        int myob = getArguments().getInt("myob");
        int fdob = getArguments().getInt("fdob");
        int fmob = getArguments().getInt("fmob");
        int mhtob = getArguments().getInt("mhtob");
        int mmtob = getArguments().getInt("mmtob");
        int fhtob = getArguments().getInt("fhtob");
        int fmtob = getArguments().getInt("fmtob");
        String mpob = getArguments().getString("mpob");
        String fpob = getArguments().getString("fpob");
        int fyob = getArguments().getInt("fyob");
        if (Geocoder.isPresent()) {
            try {
                String location = mpob;
                Geocoder gc = new Geocoder(view.getContext());
                List<Address> addresses = gc.getFromLocationName(location, 5); // get the found Address Objects
                 mlat = addresses.get(0).getLatitude();
                 mlongilo = addresses.get(0).getLongitude();
                //  TimeZone tz=TimeZone.getDefault();

              //  Log.d(TAG, "onCreateView: " + (float) lat + "," + (float) longilo + ",");//+tz.getDisplayName(false,TimeZone.SHORT));

            } catch (IOException e) {
                // handle the exception
            }
        }
        if (Geocoder.isPresent()) {
            try {
                String location = fpob;
                Geocoder gc = new Geocoder(view.getContext());
                List<Address> addresses = gc.getFromLocationName(location, 5); // get the found Address Objects
                 flat = addresses.get(0).getLatitude();
                 flongilo = addresses.get(0).getLongitude();
                //  TimeZone tz=TimeZone.getDefault();

               // Log.d(TAG, "onCreateView: " + (float) lat + "," + (float) longilo + ",");//+tz.getDisplayName(false,TimeZone.SHORT));

            } catch (IOException e) {
                // handle the exception
                Toast.makeText(view.getContext(), "oops! Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }

        retrofit = new Retrofit.Builder()
                .baseUrl("https://json.astrologyapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MatchMakingSimpleRequest matchMakingSimpleRequest = new MatchMakingSimpleRequest(mdob, mmob,
                myob, mhtob, mmtob, (float) mlat, (float) mlongilo, (float) 5.5, fdob, fmob, fyob, fhtob, fmtob, (float) flat, (float) flongilo, (float) 5.5);
        astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        Call<MatchBirthDetailResponse> call = astrologyApiInterface.getMatchBirthDetailResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);
        call.enqueue(new Callback<MatchBirthDetailResponse>() {
            @Override
            public void onResponse(Call<MatchBirthDetailResponse> call, Response<MatchBirthDetailResponse> response) {
                MatchBirthDetailResponse matchBirthDetailResponse = response.body();
                Toast.makeText(view.getContext(), "response:" + matchBirthDetailResponse.getFemaleBirthDetails(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MatchBirthDetailResponse> call, Throwable t) {

            }
        });

        return view;
    }
}
