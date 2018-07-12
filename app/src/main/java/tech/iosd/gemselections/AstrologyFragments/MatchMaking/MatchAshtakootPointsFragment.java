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

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchAshtakootPointsFragment extends Fragment {
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;
    TextView varnaDescription, maleKootAttriVal, femaleKootAttriVal,
            vashyaDescription, vashyamaleKootAttriVal, vashyafemaleKootAttriVal,
            taraDescription, yoniDescription,
            maitriDescription, maitrimaleKootAttriVal, maitrifemaleKootAttriVal,
            ganDescription, ganmaleKootAttriVal, ganfemaleKootAttriVal,
            bhakutDescription, bhakutmaleKootAttriVal, bhakutfemaleKootAttriVal,
            nadiDescription, nadimaleKootAttriVal, nadifemaleKootAttriVal, conclusion;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_ashtakoot_points_astrology, container, false);

        //varna
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
        Call<MatchAshtakootPointsResponse> call = astrologyApiInterface.getMatchAshtakootPointsResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);
        call.enqueue(new Callback<MatchAshtakootPointsResponse>() {
            @Override
            public void onResponse(Call<MatchAshtakootPointsResponse> call, Response<MatchAshtakootPointsResponse> response) {
                progressDialog.dismiss();
                MatchAshtakootPointsResponse matchAshtakootPointsResponse = response.body();
                // Toast.makeText(view.getContext(), "response:" + matchAshtakootPointsResponse.getGan(), Toast.LENGTH_SHORT).show();
                varnaDescription.setText(matchAshtakootPointsResponse.getVarna().getDescription());
                maleKootAttriVal.setText(matchAshtakootPointsResponse.getVarna().getMaleKootAttribute());
                femaleKootAttriVal.setText(matchAshtakootPointsResponse.getVarna().getFemaleKootAttribute());
//                varnaTotalPoints.setText(matchAshtakootPointsResponse.getVarna().getTotalPoints());
//                varnaReceivedPoints.setText(matchAshtakootPointsResponse.getVarna().getReceivedPoints());
                // Toast.makeText(view.getContext(), "mattr:"+matchAshtakootPointsResponse.getVarna().getMAttr(), Toast.LENGTH_SHORT).show();

                //vashya
                String vashyaDescriptiona = matchAshtakootPointsResponse.getVashya().getDescription();
                String vashyaMaleKoot = matchAshtakootPointsResponse.getVashya().getMaleKootAttribute();
                String vashyaFemaleKoot = matchAshtakootPointsResponse.getVashya().getFemaleKootAttribute();

                vashyaDescription.setText(vashyaDescriptiona);
                vashyamaleKootAttriVal.setText(vashyaMaleKoot);
                vashyafemaleKootAttriVal.setText(vashyaFemaleKoot);

                //tara

                String tarades = matchAshtakootPointsResponse.getTara().getDescription();
                taraDescription.setText(tarades);


                //yoni

                String yoniDes = matchAshtakootPointsResponse.getYoni().getDescription();
                yoniDescription.setText(yoniDes);

                //maitri

                String maitriDes = matchAshtakootPointsResponse.getMaitri().getDescription();
                String maitriMaleKoot = matchAshtakootPointsResponse.getMaitri().getMaleKootAttribute();
                String maitriFemaleKoot = matchAshtakootPointsResponse.getMaitri().getFemaleKootAttribute();

                maitriDescription.setText(maitriDes);
                maitrimaleKootAttriVal.setText(maitriMaleKoot);
                maitrifemaleKootAttriVal.setText(maitriFemaleKoot);

                //gan
                String ganDes = matchAshtakootPointsResponse.getGan().getDescription();

                String ganMaleKoot = matchAshtakootPointsResponse.getGan().getMaleKootAttribute();
                String ganFemaleKoot = matchAshtakootPointsResponse.getGan().getFemaleKootAttribute();
                // Toast.makeText(view.getContext(), "gan:"+ganMaleKoot+ganFemaleKoot, Toast.LENGTH_SHORT).show();
                ganDescription.setText(ganDes);
                ganmaleKootAttriVal.setText(ganMaleKoot);
                ganfemaleKootAttriVal.setText(ganFemaleKoot);

                //bhakut

                String bhakutDes = matchAshtakootPointsResponse.getBhakut().getDescription();
                String bhakutMaleKoot = matchAshtakootPointsResponse.getBhakut().getMaleKootAttribute();
                String bhakutFemaleKoot = matchAshtakootPointsResponse.getBhakut().getFemaleKootAttribute();

                bhakutDescription.setText(bhakutDes);
                bhakutmaleKootAttriVal.setText(bhakutMaleKoot);
                bhakutfemaleKootAttriVal.setText(bhakutFemaleKoot);

                //nadi

                String nadiDes = matchAshtakootPointsResponse.getNadi().getDescription();
                String nadiMaleKoot = matchAshtakootPointsResponse.getNadi().getMaleKootAttribute();
                String nadiFemaleKoot = matchAshtakootPointsResponse.getNadi().getFemaleKootAttribute();

                nadiDescription.setText(nadiDes);
                nadimaleKootAttriVal.setText(nadiMaleKoot);
                nadifemaleKootAttriVal.setText(nadiFemaleKoot);

                //conclusion

                conclusion.setText(matchAshtakootPointsResponse.getConclusion().getReport());
            }

            @Override
            public void onFailure(Call<MatchAshtakootPointsResponse> call, Throwable t) {

            }
        });

        return view;
    }
}
