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
import tech.iosd.gemselections.Retrofit.ResponseModels.MalePlanetDetail;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchPlanetDetailsResponse;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchPlanetDetailsFragment extends Fragment {
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;
    TextView mainTV;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_planet_details_astrology, container, false);
        mainTV = view.findViewById(R.id.match_planet_details_main_textview);
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
        //todo make layout
        Call<MatchPlanetDetailsResponse> call = astrologyApiInterface.getMAtchPlanetDetailsResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingSimpleRequest);

        call.enqueue(new Callback<MatchPlanetDetailsResponse>() {
            @Override
            public void onResponse(Call<MatchPlanetDetailsResponse> call, Response<MatchPlanetDetailsResponse> response) {
                progressDialog.dismiss();
                MatchPlanetDetailsResponse matchPlanetDetailsResponse = response.body();
                List<FemalePlanetDetail> listFemale = matchPlanetDetailsResponse.getFemalePlanetDetails();
                List<MalePlanetDetail> listMale = matchPlanetDetailsResponse.getMalePlanetDetails();

                mainTV.append("MALE\n");
                for (int i=0; i<listMale.size();i++){
                    mainTV.append("\n");
                    mainTV.append("\tName: "+listMale.get(i).getName()+"\n");
                    mainTV.append("\tFull degree: "+listMale.get(i).getFullDegree()+"\n");
                    mainTV.append("\tNorm degree: "+listMale.get(i).getNormDegree()+"\n");
                    mainTV.append("\tSpeed: "+listMale.get(i).getSpeed()+"\n");
                    mainTV.append("\tRetro: "+listMale.get(i).isIsRetro()+"\n");
                    mainTV.append("\tSign: "+listMale.get(i).getSign()+"\n");
                    mainTV.append("\tSign lord: "+listMale.get(i).getSignLord()+"\n");
                    mainTV.append("\tNakshatra: "+listMale.get(i).getNakshatra()+"\n");
                    mainTV.append("\tNakshatra lord: "+listMale.get(i).getNakshatraLord()+"\n");
                    mainTV.append("\tNakshatra pad: "+listMale.get(i).getNakshatraPad()+"\n");
                    mainTV.append("\tHouse: "+listMale.get(i).getHouse()+"\n");
                    mainTV.append("\tIs planet set: "+listMale.get(i).isIsPlanetSet()+"\n");
                    mainTV.append("\tPlanet awastha: "+listMale.get(i).getPlanetAwastha()+"\n"+"\n");
                }
                mainTV.append("\n\n"+"\n");

                mainTV.append("FEMALE\n");
                for (int i=0; i<listMale.size();i++){
                    mainTV.append("\n");
                    mainTV.append("\tName: "+listFemale.get(i).getName()+"\n");
                    mainTV.append("\tFull degree: "+listFemale.get(i).getFullDegree()+"\n");
                    mainTV.append("\tNorm degree: "+listFemale.get(i).getNormDegree()+"\n");
                    mainTV.append("\tSpeed: "+listFemale.get(i).getSpeed()+"\n");
                    mainTV.append("\tRetro: "+listFemale.get(i).isIsRetro()+"\n");
                    mainTV.append("\tSign: "+listFemale.get(i).getSign()+"\n");
                    mainTV.append("\tSign lord: "+listFemale.get(i).getSignLord()+"\n");
                    mainTV.append("\tNakshatra: "+listFemale.get(i).getNakshatra()+"\n");
                    mainTV.append("\tNakshatra lord: "+listFemale.get(i).getNakshatraLord()+"\n");
                    mainTV.append("\tNakshatra pad: "+listFemale.get(i).getNakshatraPad()+"\n");
                    mainTV.append("\tHouse: "+listFemale.get(i).getHouse()+"\n");
                    mainTV.append("\tIs planet set: "+listFemale.get(i).isIsPlanetSet()+"\n");
                    mainTV.append("\tPlanet awastha: "+listFemale.get(i).getPlanetAwastha()+"\n"+"\n");
                }
                mainTV.append("\n\n"+"\n");
               // Toast.makeText(view.getContext(), "response:" + list.get(0).getName(), Toast.LENGTH_SHORT).show();


            }

            @Override
            public void onFailure(Call<MatchPlanetDetailsResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(),"Some error occured",Toast.LENGTH_LONG).show();
                Log.d("error77",t.getMessage());
                getFragmentManager().popBackStack();
            }
        });

        return view;
    }
}
