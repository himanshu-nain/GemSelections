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
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchMakingDetailedReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchSimpleReportResponse;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchMakingdetailedReportFragment extends Fragment {
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;
    double mlat, mlongilo, flat, flongilo;
    TextView varnaDescription, maleKootAttriVal, femaleKootAttriVal,
            vashyaDescription, vashyamaleKootAttriVal, vashyafemaleKootAttriVal,
            taraDescription, yoniDescription,
            maitriDescription, maitrimaleKootAttriVal, maitrifemaleKootAttriVal,
            ganDescription, ganmaleKootAttriVal, ganfemaleKootAttriVal,
            bhakutDescription, bhakutmaleKootAttriVal, bhakutfemaleKootAttriVal,
            nadiDescription, nadimaleKootAttriVal, nadifemaleKootAttriVal
            ,conclusion,matchReport;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_making_detailed_report_astrology, container, false);

        varnaDescription = view.findViewById(R.id.tv_varna_description);
        maleKootAttriVal = view.findViewById(R.id.male_koot_atri_val);
        femaleKootAttriVal = view.findViewById(R.id.female_koot_atri_val);
        vashyaDescription = view.findViewById(R.id.tv_vashya_description);
        vashyamaleKootAttriVal = view.findViewById(R.id.vashya_male_koot_atri_val);
        vashyafemaleKootAttriVal = view.findViewById(R.id.vashya_female_koot_atri_val);
        taraDescription = view.findViewById(R.id.tv_tara_description);
        yoniDescription = view.findViewById(R.id.tv_yoni_description);
        maitriDescription = view.findViewById(R.id.tv_maitri_description);
        maitrimaleKootAttriVal = view.findViewById(R.id.maitri_male_koot_atri_val);
        maitrifemaleKootAttriVal = view.findViewById(R.id.maitri_female_koot_atri_val);
        ganDescription = view.findViewById(R.id.tv_gan_description);
        ganmaleKootAttriVal = view.findViewById(R.id.gan_male_koot_atri_val);
        ganfemaleKootAttriVal = view.findViewById(R.id.gan_female_koot_atri_val);
        bhakutDescription = view.findViewById(R.id.tv_bhakut_description);
        bhakutmaleKootAttriVal = view.findViewById(R.id.bhakut_male_koot_atri_val);
        bhakutfemaleKootAttriVal = view.findViewById(R.id.bhakut_female_koot_atri_val);
        nadiDescription = view.findViewById(R.id.tv_nadi_description);
        nadimaleKootAttriVal = view.findViewById(R.id.nadi_male_koot_atri_val);
        nadifemaleKootAttriVal = view.findViewById(R.id.nadi_female_koot_atri_val);
        conclusion = view.findViewById(R.id.conclusion);
        matchReport = view.findViewById(R.id.match_report);
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
        Call<MatchMakingDetailedReportResponse> call = astrologyApiInterface.getMatchMakingDetailedReportResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);
        call.enqueue(new Callback<MatchMakingDetailedReportResponse>() {
            @Override
            public void onResponse(Call<MatchMakingDetailedReportResponse> call, Response<MatchMakingDetailedReportResponse> response) {

                progressDialog.dismiss();
                MatchMakingDetailedReportResponse matchMakingDetailedReportResponse = response.body();
                // List<FemalePlanetDetail> list = matchPlanetDetailsResponse.getFemalePlanetDetails();
               // Toast.makeText(view.getContext(), "response:" + matchMakingDetailedReportResponse, Toast.LENGTH_SHORT).show();


                varnaDescription.setText(matchMakingDetailedReportResponse.getAshtakoota().getVarna().getDescription());
                maleKootAttriVal.setText(matchMakingDetailedReportResponse.getAshtakoota().getVarna().getMaleKootAttribute());
                femaleKootAttriVal.setText(matchMakingDetailedReportResponse.getAshtakoota().getVarna().getFemaleKootAttribute());
//                varnaTotalPoints.setText(matchAshtakootPointsResponse.getVarna().getTotalPoints());
//                varnaReceivedPoints.setText(matchAshtakootPointsResponse.getVarna().getReceivedPoints());
                // Toast.makeText(view.getContext(), "mattr:"+matchAshtakootPointsResponse.getVarna().getMAttr(), Toast.LENGTH_SHORT).show();

                //vashya
                String vashyaDescriptiona = matchMakingDetailedReportResponse.getAshtakoota().getVashya().getDescription();
                String vashyaMaleKoot = matchMakingDetailedReportResponse.getAshtakoota().getVashya().getMaleKootAttribute();
                String vashyaFemaleKoot = matchMakingDetailedReportResponse.getAshtakoota().getVashya().getFemaleKootAttribute();

                vashyaDescription.setText(vashyaDescriptiona);
                vashyamaleKootAttriVal.setText(vashyaMaleKoot);
                vashyafemaleKootAttriVal.setText(vashyaFemaleKoot);

                //tara

                String tarades = matchMakingDetailedReportResponse.getAshtakoota().getTara().getDescription();
                taraDescription.setText(tarades);


                //yoni

                String yoniDes = matchMakingDetailedReportResponse.getAshtakoota().getYoni().getDescription();
                yoniDescription.setText(yoniDes);

                //maitri

                String maitriDes = matchMakingDetailedReportResponse.getAshtakoota().getMaitri().getDescription();
                String maitriMaleKoot = matchMakingDetailedReportResponse.getAshtakoota().getMaitri().getMaleKootAttribute();
                String maitriFemaleKoot = matchMakingDetailedReportResponse.getAshtakoota().getMaitri().getFemaleKootAttribute();

                maitriDescription.setText(maitriDes);
                maitrimaleKootAttriVal.setText(maitriMaleKoot);
                maitrifemaleKootAttriVal.setText(maitriFemaleKoot);

                //gan
                String ganDes = matchMakingDetailedReportResponse.getAshtakoota().getGan().getDescription();

                String ganMaleKoot = matchMakingDetailedReportResponse.getAshtakoota().getGan().getMaleKootAttribute();
                String ganFemaleKoot = matchMakingDetailedReportResponse.getAshtakoota().getGan().getFemaleKootAttribute();
                // Toast.makeText(view.getContext(), "gan:"+ganMaleKoot+ganFemaleKoot, Toast.LENGTH_SHORT).show();
                ganDescription.setText(ganDes);
                ganmaleKootAttriVal.setText(ganMaleKoot);
                ganfemaleKootAttriVal.setText(ganFemaleKoot);

                //bhakut

                String bhakutDes = matchMakingDetailedReportResponse.getAshtakoota().getBhakut().getDescription();
                String bhakutMaleKoot = matchMakingDetailedReportResponse.getAshtakoota().getBhakut().getMaleKootAttribute();
                String bhakutFemaleKoot = matchMakingDetailedReportResponse.getAshtakoota().getBhakut().getFemaleKootAttribute();

                bhakutDescription.setText(bhakutDes);
                bhakutmaleKootAttriVal.setText(bhakutMaleKoot);
                bhakutfemaleKootAttriVal.setText(bhakutFemaleKoot);

                //nadi

                String nadiDes = matchMakingDetailedReportResponse.getAshtakoota().getNadi().getDescription();
                String nadiMaleKoot = matchMakingDetailedReportResponse.getAshtakoota().getNadi().getMaleKootAttribute();
                String nadiFemaleKoot = matchMakingDetailedReportResponse.getAshtakoota().getNadi().getFemaleKootAttribute();

                nadiDescription.setText(nadiDes);
                nadimaleKootAttriVal.setText(nadiMaleKoot);
                nadifemaleKootAttriVal.setText(nadiFemaleKoot);

                //conclusion

                conclusion.setText(matchMakingDetailedReportResponse.getAshtakoota().getConclusion().getReport());

                matchReport.setText(matchMakingDetailedReportResponse.getConclusion().getMatchReport());
            }

            @Override
            public void onFailure(Call<MatchMakingDetailedReportResponse> call, Throwable t) {

            }
        });

        return view;
    }
}
