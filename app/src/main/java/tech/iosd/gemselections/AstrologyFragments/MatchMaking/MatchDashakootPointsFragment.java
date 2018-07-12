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
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchMakingDetailedReportResponse;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchDashakootPointsFragment extends Fragment {

    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;
    double mlat, mlongilo, flat, flongilo;

    TextView dinaDescription, maleKootAttriVal, femaleKootAttriVal,
            vashyaDescription, vashyamaleKootAttriVal, vashyafemaleKootAttriVal,
            yoniDescription, yonimaleKootAttriVal, yonifemaleKootAttriVal,
            rashiDescription, rashimaleKootAttriVal,  rashifemaleKootAttriVal,
            rasyadhipatiDescription, rasyadhipatimaleKootAttriVal,  rasyadhipatifemaleKootAttriVal,
            rajjuDescription,rajjumaleKootAttriVal,  rajjufemaleKootAttriVal,
           vedhaDescription, vedhamaleKootAttriVal,  vedhafemaleKootAttriVal,
            mahendraDescription, mahendramaleKootAttriVal,  mahendrafemaleKootAttriVal,
            streedeerghaDescription, streedeerghamaleKootAttriVal,  streedeerghafemaleKootAttriVal,

    ganaDescription, ganamaleKootAttriVal, ganafemaleKootAttriVal;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_dashakoot_points_astrology, container, false);



        dinaDescription = view.findViewById(R.id.tv_dina_description);
        maleKootAttriVal = view.findViewById(R.id.male_koot_atri_val);
        femaleKootAttriVal = view.findViewById(R.id.female_koot_atri_val);
        vashyaDescription = view.findViewById(R.id.tv_vashya_description);
        vashyamaleKootAttriVal = view.findViewById(R.id.vashya_male_koot_atri_val);
        vashyafemaleKootAttriVal = view.findViewById(R.id.vashya_female_koot_atri_val);
        yoniDescription = view.findViewById(R.id.tv_yoni_description);
        yonimaleKootAttriVal = view.findViewById(R.id.yoni_male_koot_atri_val);
        yonifemaleKootAttriVal = view.findViewById(R.id.yoni_female_koot_atri_val);
        ganaDescription = view.findViewById(R.id.tv_gana_description);
        ganamaleKootAttriVal = view.findViewById(R.id.gana_male_koot_atri_val);
        ganafemaleKootAttriVal = view.findViewById(R.id.gana_female_koot_atri_val);
        rashiDescription = view.findViewById(R.id.tv_rashi_description);
        rashimaleKootAttriVal = view.findViewById(R.id.rashi_male_koot_atri_val);
        rashifemaleKootAttriVal = view.findViewById(R.id.rashi_female_koot_atri_val);
        rasyadhipatiDescription = view.findViewById(R.id.tv_rasyadhipati_description);
        rasyadhipatimaleKootAttriVal = view.findViewById(R.id.rasyadhipati_male_koot_atri_val);
        rasyadhipatifemaleKootAttriVal = view.findViewById(R.id.rasyadhipati_female_koot_atri_val);
        rajjuDescription = view.findViewById(R.id.tv_rajju_description);
        rajjumaleKootAttriVal = view.findViewById(R.id.rajju_male_koot_atri_val);
        rajjufemaleKootAttriVal = view.findViewById(R.id.rajju_female_koot_atri_val);
        vedhaDescription = view.findViewById(R.id.tv_vedha_description);
        vedhamaleKootAttriVal = view.findViewById(R.id.vedha_male_koot_atri_val);
        vedhafemaleKootAttriVal = view.findViewById(R.id.vedha_female_koot_atri_val);
        mahendraDescription = view.findViewById(R.id.tv_mahendra_description);
        mahendramaleKootAttriVal = view.findViewById(R.id.mahendra_male_koot_atri_val);
        mahendrafemaleKootAttriVal = view.findViewById(R.id.mahendra_female_koot_atri_val);
        streedeerghaDescription = view.findViewById(R.id.tv_streedeergha_description);
        streedeerghamaleKootAttriVal = view.findViewById(R.id.streedeergha_male_koot_atri_val);
        streedeerghafemaleKootAttriVal = view.findViewById(R.id.streedeergha_female_koot_atri_val);

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
        Call<MatchDashakootPointsResponse> call = astrologyApiInterface.getMatchMakingDashakootPointsResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);
        call.enqueue(new Callback<MatchDashakootPointsResponse>() {
            @Override
            public void onResponse(Call<MatchDashakootPointsResponse> call, Response<MatchDashakootPointsResponse> response) {

                progressDialog.dismiss();
                MatchDashakootPointsResponse matchDashakootPointsResponse = response.body();



                dinaDescription.setText(matchDashakootPointsResponse.getDina().getDescription());
                maleKootAttriVal.setText(matchDashakootPointsResponse.getDina().getMaleKootAttribute());
                femaleKootAttriVal.setText(matchDashakootPointsResponse.getDina().getFemaleKootAttribute());
//                varnaTotalPoints.setText(matchAshtakootPointsResponse.getVarna().getTotalPoints());
//                varnaReceivedPoints.setText(matchAshtakootPointsResponse.getVarna().getReceivedPoints());
                // Toast.makeText(view.getContext(), "mattr:"+matchAshtakootPointsResponse.getVarna().getMAttr(), Toast.LENGTH_SHORT).show();

                //vashya
                String vashyaDescriptiona = matchDashakootPointsResponse.getVashya().getDescription();
                String vashyaMaleKoot = matchDashakootPointsResponse.getVashya().getMaleKootAttribute();
                String vashyaFemaleKoot = matchDashakootPointsResponse.getVashya().getFemaleKootAttribute();

                vashyaDescription.setText(vashyaDescriptiona);
                vashyamaleKootAttriVal.setText(vashyaMaleKoot);
                vashyafemaleKootAttriVal.setText(vashyaFemaleKoot);




                //yoni

                String yoniDes = matchDashakootPointsResponse.getYoni().getDescription();
                yoniDescription.setText(yoniDes);
                String yoniMaleKoot = matchDashakootPointsResponse.getYoni().getMaleKootAttribute();
                String yoniFemaleKoot = matchDashakootPointsResponse.getYoni().getFemaleKootAttribute();
                yonimaleKootAttriVal.setText(yoniMaleKoot);
                yonifemaleKootAttriVal.setText(yoniFemaleKoot);

                //rashi

                String rashiDes = matchDashakootPointsResponse.getRashi().getDescription();
                String rashiMaleKoot = matchDashakootPointsResponse.getRashi().getMaleKootAttribute();
                String rashiFemaleKoot = matchDashakootPointsResponse.getRashi().getFemaleKootAttribute();

                rashiDescription.setText(rashiDes);
                rashimaleKootAttriVal.setText(rashiMaleKoot);
                rashifemaleKootAttriVal.setText(rashiFemaleKoot);

                //gana
                String ganDes = matchDashakootPointsResponse.getGana().getDescription();

                String ganMaleKoot = matchDashakootPointsResponse.getGana().getMaleKootAttribute();
                String ganFemaleKoot = matchDashakootPointsResponse.getGana().getFemaleKootAttribute();
                // Toast.makeText(view.getContext(), "gan:"+ganMaleKoot+ganFemaleKoot, Toast.LENGTH_SHORT).show();
                ganaDescription.setText(ganDes);
                ganamaleKootAttriVal.setText(ganMaleKoot);
                ganafemaleKootAttriVal.setText(ganFemaleKoot);

                //rasyadhipati

                String rasyadhipatiDes = matchDashakootPointsResponse.getRasyadhipati().getDescription();
                String rasyadhipatiMaleKoot = matchDashakootPointsResponse.getRasyadhipati().getMaleKootAttribute();
                String rasyadhipatiFemaleKoot = matchDashakootPointsResponse.getRasyadhipati().getFemaleKootAttribute();

                rasyadhipatiDescription.setText(rasyadhipatiDes);
                rasyadhipatimaleKootAttriVal.setText(rasyadhipatiMaleKoot);
                rasyadhipatifemaleKootAttriVal.setText(rasyadhipatiFemaleKoot);

                //rajju

                String rajjuDes = matchDashakootPointsResponse.getRajju().getDescription();
                String rajjuMaleKoot = matchDashakootPointsResponse.getRajju().getMaleKootAttribute();
                String rajjuFemaleKoot = matchDashakootPointsResponse.getRajju().getFemaleKootAttribute();

                rajjuDescription.setText(rajjuDes);
                rajjumaleKootAttriVal.setText(rajjuMaleKoot);
                rajjufemaleKootAttriVal.setText(rajjuFemaleKoot);

                //vedha

                String vedhaDes = matchDashakootPointsResponse.getVedha().getDescription();
                String vedhaMaleKoot = matchDashakootPointsResponse.getVedha().getMaleKootAttribute();
                String vedhaFemaleKoot = matchDashakootPointsResponse.getVedha().getFemaleKootAttribute();

                vedhaDescription.setText(vedhaDes);
                vedhamaleKootAttriVal.setText(vedhaMaleKoot);
                vedhafemaleKootAttriVal.setText(vedhaFemaleKoot);

                //mahendra

                String mahendraDes = matchDashakootPointsResponse.getMahendra().getDescription();
                String mahendraMaleKoot = matchDashakootPointsResponse.getMahendra().getMaleKootAttribute();
                String mahendraFemaleKoot = matchDashakootPointsResponse.getMahendra().getFemaleKootAttribute();

                mahendraDescription.setText(mahendraDes);
                mahendramaleKootAttriVal.setText(mahendraMaleKoot);
                mahendrafemaleKootAttriVal.setText(mahendraFemaleKoot);

                //streedeergha

                String streedeerghaDes = matchDashakootPointsResponse.getStreeDeergha().getDescription();
                String streedeerghaMaleKoot = matchDashakootPointsResponse.getStreeDeergha().getMaleKootAttribute();
                String streedeerghaFemaleKoot = matchDashakootPointsResponse.getStreeDeergha().getFemaleKootAttribute();

                streedeerghaDescription.setText(streedeerghaDes);
                streedeerghamaleKootAttriVal.setText(streedeerghaMaleKoot);
                streedeerghafemaleKootAttriVal.setText(streedeerghaFemaleKoot);

                //conclusion
                // List<FemalePlanetDetail> list = matchPlanetDetailsResponse.getFemalePlanetDetails();
               // Toast.makeText(view.getContext(), "response:" + matchDashakootPointsResponse, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<MatchDashakootPointsResponse> call, Throwable t) {

            }
        });

        return view;
    }
}
