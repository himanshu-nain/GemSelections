package tech.iosd.gemselections.AstrologyFragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingSimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchDashakootPointsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchPercentageResponse;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchpercentageFragment extends Fragment {
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_percentage_astrology, container, false);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://json.astrologyapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final MatchMakingSimpleRequest matchMakingSimpleRequest = new MatchMakingSimpleRequest(17, 03,
                1997, 05, 30, (float) 19.2056, (float) 25.2056, (float) 5.5, 29, 11, 1997, 02, 03, (float) 19.2056, (float) 25.2056, (float) 5.5);
        astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        Call<MatchPercentageResponse> call = astrologyApiInterface.getMatchPercentageResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);
        call.enqueue(new Callback<MatchPercentageResponse>() {
            @Override
            public void onResponse(Call<MatchPercentageResponse> call, Response<MatchPercentageResponse> response) {
                MatchPercentageResponse matchPercentageResponse = response.body();
                // List<FemalePlanetDetail> list = matchPlanetDetailsResponse.getFemalePlanetDetails();
                Toast.makeText(view.getContext(), "response:" + matchPercentageResponse, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MatchPercentageResponse> call, Throwable t) {

            }
        });

        return view;
    }
}