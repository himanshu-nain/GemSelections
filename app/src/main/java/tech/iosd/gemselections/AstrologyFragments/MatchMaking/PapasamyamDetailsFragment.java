package tech.iosd.gemselections.AstrologyFragments.MatchMaking;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingPapasamyamReportRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.PapasamyamDetailsResponse;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class PapasamyamDetailsFragment extends Fragment {
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;
    ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.papasamyam_report_astrology, container, false);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait.");
        progressDialog.setCancelable(false);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://json.astrologyapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MatchMakingPapasamyamReportRequest matchMakingPapasamyamReportRequest = (MatchMakingPapasamyamReportRequest) getArguments().getSerializable("match_making_object");
        //checking input
        Log.d("Check input",matchMakingPapasamyamReportRequest.getGender().toString());
        astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        progressDialog.show();
        Call<PapasamyamDetailsResponse> call = astrologyApiInterface.getPapaResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingPapasamyamReportRequest);
        call.enqueue(new Callback<PapasamyamDetailsResponse>() {
            @Override
            public void onResponse(Call<PapasamyamDetailsResponse> call, Response<PapasamyamDetailsResponse> response) {
                //todo response is not coming correct and make layout to display
                progressDialog.dismiss();
                PapasamyamDetailsResponse partnerReportResponse = response.body();
                // List<FemalePlanetDetail> list = matchPlanetDetailsResponse.getFemalePlanetDetails();
                Toast.makeText(view.getContext(), "response:" + partnerReportResponse.getAscendant().getTotal(), Toast.LENGTH_SHORT).show();
                Log.d("Response","response :"+partnerReportResponse.toString());
            }

            @Override
            public void onFailure(Call<PapasamyamDetailsResponse> call, Throwable t) {
                progressDialog.dismiss();
                Log.d("error77",t.getMessage());
                getFragmentManager().popBackStack();

            }
        });

        return view;
    }
}
