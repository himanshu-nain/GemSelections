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
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchDashakootPointsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchPercentageResponse;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchPercentageFragment extends Fragment {
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;
    TextView ashtakootaPerc,manglikPerc,vedhaperc,perc,rajjuperc;
    double mlat, mlongilo, flat, flongilo;

    public static final String TAG = "percent";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_percentage_astrology, container, false);

        ashtakootaPerc = view.findViewById(R.id.ashtakoota_per_val);
        manglikPerc = view.findViewById(R.id.manglik_per_val);
        vedhaperc = view.findViewById(R.id.vedha_per_val);
        perc = view.findViewById(R.id.per_val);
        rajjuperc = view.findViewById(R.id.rajju_per_val);

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
        Log.d("Check Object",String.valueOf(matchMakingSimpleRequest.getFdob()));
        astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        Call<MatchPercentageResponse> call = astrologyApiInterface.getMatchPercentageResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);
        call.enqueue(new Callback<MatchPercentageResponse>() {
            @Override
            public void onResponse(Call<MatchPercentageResponse> call, Response<MatchPercentageResponse> response) {
                progressDialog.dismiss();
                MatchPercentageResponse matchPercentageResponse = response.body();
                // List<FemalePlanetDetail> list = matchPlanetDetailsResponse.getFemalePlanetDetails();
              //  Toast.makeText(view.getContext(), "response:" + matchPercentageResponse.getAshtakootaPercentage(), Toast.LENGTH_SHORT).show();
             ashtakootaPerc.setText(Integer.toString(matchPercentageResponse.getAshtakootaPercentage()));
                manglikPerc.setText(Integer.toString(matchPercentageResponse.getManglikMatchPercentage()));
                perc.setText(Integer.toString(matchPercentageResponse.getMatchPercentage()));
               rajjuperc.setText(Integer.toString(matchPercentageResponse.getRajjuMatchPercentage()));
               vedhaperc.setText(Integer.toString(matchPercentageResponse.getVedhaMatchPercentage()));
                //Toast.makeText(view.getContext(), "r"+matchPercentageResponse.getAshtakootaPercentage(), Toast.LENGTH_SHORT).show();
              //  int ashtaP = matchPercentageResponse.getAshtakootaPercentage()
                        ;
               // ashtakootaPerc.setText(Integer.toString(ashtaP));

            }

            @Override
            public void onFailure(Call<MatchPercentageResponse> call, Throwable t) {

            }
        });

        return view;
    }
}