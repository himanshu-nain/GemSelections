package tech.iosd.gemselections.AstrologyFragments.MatchMaking;

import android.app.ProgressDialog;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingSimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchAshtakootPointsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchObstructionsResponse;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchVedhaObstructionsFragment extends Fragment {
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;
    double mlat, mlongilo, flat, flongilo;

    TextView report;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_obstructions_astrology, container, false);

        report = view.findViewById(R.id.report);
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading ... ");
        progressDialog.show();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://json.astrologyapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //Getting request object from previous fragment
        MatchMakingSimpleRequest matchMakingSimpleRequest = (MatchMakingSimpleRequest) getArguments().getSerializable("match_making_obj");
        Log.d("Check Object",String.valueOf(matchMakingSimpleRequest.getFdob()));astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        Call<MatchObstructionsResponse> call = astrologyApiInterface.getMatchObstructionsResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);
        call.enqueue(new Callback<MatchObstructionsResponse>() {
            @Override
            public void onResponse(Call<MatchObstructionsResponse> call, Response<MatchObstructionsResponse> response) {
                progressDialog.dismiss();
                MatchObstructionsResponse matchObstructionsResponse = response.body();
               // Toast.makeText(view.getContext(), "response:" + matchObstructionsResponse.getVedhaReport(), Toast.LENGTH_SHORT).show();
          report.setText(matchObstructionsResponse.getVedhaReport());
            }

            @Override
            public void onFailure(Call<MatchObstructionsResponse> call, Throwable t) {

            }
        });

        return view;
    }
}