package tech.iosd.gemselections.AstrologyFragments.MatchMaking;

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
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.TimeZone;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.iosd.gemselections.AuthRelated.LoginActivity;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingSimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchAshtakootPointsResponse;
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
    TextView mainTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_birth_detail_astrology, container, false);
        // getting arguments from matchmakinginputfrag1 getting the whole object
        MatchMakingSimpleRequest matchMakingSimpleRequest = (MatchMakingSimpleRequest) getArguments().getSerializable("match_making_obj");
        Log.d("Check Object",String.valueOf(matchMakingSimpleRequest.getFdob()));

        mainTV =  view.findViewById(R.id.match_birth_details_main_textview);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://json.astrologyapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        Call<MatchBirthDetailResponse> call = astrologyApiInterface.getMatchBirthDetailsResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);
        call.enqueue(new Callback<MatchBirthDetailResponse>() {
            @Override
            public void onResponse(Call<MatchBirthDetailResponse> call, Response<MatchBirthDetailResponse> response) {
                if (response.isSuccessful()){
                    Log.d("error77","success\n"+String.valueOf(response));

                }
                Log.d("Testing api",String.valueOf(response));
                MatchBirthDetailResponse matchBirthDetailResponse = response.body();
                Log.d("Testing api",String.valueOf(matchBirthDetailResponse));
                Toast.makeText(view.getContext(), "response:" + matchBirthDetailResponse.getMaleBirthDetails().getDay(), Toast.LENGTH_SHORT).show();
                mainTV.append("MALE BIRTH DETAILS\n");
                mainTV.append("year: "+matchBirthDetailResponse.getMaleBirthDetails().getYear()+"\n");
                mainTV.append("month: "+matchBirthDetailResponse.getMaleBirthDetails().getMonth()+"\n");
                mainTV.append("day: "+matchBirthDetailResponse.getMaleBirthDetails().getDay()+"\n");
                mainTV.append("hour: "+matchBirthDetailResponse.getMaleBirthDetails().getHour()+"\n");
                mainTV.append("minute: "+matchBirthDetailResponse.getMaleBirthDetails().getMinute()+"\n");
                mainTV.append("latitude: "+matchBirthDetailResponse.getMaleBirthDetails().getLatitude()+"\n");
                mainTV.append("longitude: "+matchBirthDetailResponse.getMaleBirthDetails().getLongitude()+"\n");
                mainTV.append("time zone: "+matchBirthDetailResponse.getMaleBirthDetails().getTimezone()+"\n");
                mainTV.append("sunrise: "+matchBirthDetailResponse.getMaleBirthDetails().getSunrise()+"\n");
                mainTV.append("sunset: "+matchBirthDetailResponse.getMaleBirthDetails().getSunset()+"\n");
                mainTV.append("ayanamsha: "+matchBirthDetailResponse.getMaleBirthDetails().getAyanamsha()+"\n");

                mainTV.append("\nFEMALE BIRTH DETAILS\n");
                mainTV.append("year: "+matchBirthDetailResponse.getFemaleBirthDetails().getYear()+"\n");
                mainTV.append("month: "+matchBirthDetailResponse.getFemaleBirthDetails().getMonth()+"\n");
                mainTV.append("day: "+matchBirthDetailResponse.getFemaleBirthDetails().getDay()+"\n");
                mainTV.append("hour: "+matchBirthDetailResponse.getFemaleBirthDetails().getHour()+"\n");
                mainTV.append("minute: "+matchBirthDetailResponse.getFemaleBirthDetails().getMinute()+"\n");
                mainTV.append("latitude: "+matchBirthDetailResponse.getFemaleBirthDetails().getLatitude()+"\n");
                mainTV.append("longitude: "+matchBirthDetailResponse.getFemaleBirthDetails().getLongitude()+"\n");
                mainTV.append("time zone: "+matchBirthDetailResponse.getFemaleBirthDetails().getTimezone()+"\n");
                mainTV.append("sunrise: "+matchBirthDetailResponse.getFemaleBirthDetails().getSunrise()+"\n");
                mainTV.append("sunset: "+matchBirthDetailResponse.getFemaleBirthDetails().getSunset()+"\n");
                mainTV.append("ayanamsha: "+matchBirthDetailResponse.getFemaleBirthDetails().getAyanamsha()+"\n");










            }

            @Override
            public void onFailure(Call<MatchBirthDetailResponse> call, Throwable t) {
                Log.d("error77",t.getMessage());
            }
        });
        return view;
    }
}
