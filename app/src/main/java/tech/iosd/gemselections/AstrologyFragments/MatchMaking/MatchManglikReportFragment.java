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
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingSimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.FemalePlanetDetail;
import tech.iosd.gemselections.Retrofit.ResponseModels.Male;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchManglikReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchPlanetDetailsResponse;

/**
 * Created by kushalgupta on 27/03/18.
 */


public class MatchManglikReportFragment extends Fragment {
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;
    TextView male_manglik,female_manglik,conclusion;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_manglik_report_astrology, container, false);
        male_manglik = view.findViewById(R.id.tv_male_manglik_report);
        female_manglik = view.findViewById(R.id.tv_female_manglik_report);
        conclusion = view.findViewById(R.id.tv_conclusion);
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
        astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        Call<MatchManglikReportResponse> call = astrologyApiInterface.getMatchManglikReportResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);
        call.enqueue(new Callback<MatchManglikReportResponse>() {
            @Override
            public void onResponse(Call<MatchManglikReportResponse> call, Response<MatchManglikReportResponse> response) {
                progressDialog.dismiss();
                MatchManglikReportResponse matchManglikReportResponse = response.body();
                // List<FemalePlanetDetail> list = matchPlanetDetailsResponse.getFemalePlanetDetails();
//                Toast.makeText(view.getContext(), "response:" + matchManglikReportResponse.getMale().getManglikPresentRule().getBasedOnAspect().toString(), Toast.LENGTH_SHORT).show();
                male_manglik.setText(getManglikDetailsString(matchManglikReportResponse.getMale()));
                female_manglik.setText(getManglikDetailsString(matchManglikReportResponse.getFemale()));
                conclusion.setText("Match: "+matchManglikReportResponse.getConclusion().isMatch()+"\nReport:"+matchManglikReportResponse.getConclusion().getReport());
            }

            @Override
            public void onFailure(Call<MatchManglikReportResponse> call, Throwable t) {

            }
        });

        return view;
    }
    private String getManglikDetailsString(Male object){
        String details = "Manglik present rule:\n" +
                "1. based on aspect: "+object.getManglikPresentRule().getBasedOnHouse()+"\n" +
                "2. based on house: "+object.getManglikPresentRule().getBasedOnAspect()+"\n" +
                "\n" ;
        if(object.getManglikCancelRule().size()!=0){
            details = details + "Manglik cancel rule: "+object.getManglikCancelRule().get(0)+"\n" ;

        }
        details =  details +
                "Is mars manglik cancelled: "+object.isIsMarsManglikCancelled()+"\n" +
                "Manglik status: "+object.getManglikStatus()+"\n" +
                "percentage manglik present: "+object.getPercentageManglikPresent()+"\n" +
                "percentage manglik after cancellation: "+object.getPercentageManglikAfterCancellation()+"\n" +
                "Manglik mainTV: "+object.getManglikReport()+"\n" +
                "Is present ? : "+object.isIsPresent();
        return details;
    }
}