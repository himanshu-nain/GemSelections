package tech.iosd.gemselections.AstrologyFragments.Indian;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
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
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiClient;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.SipmleMoonPhaseRequst;
import tech.iosd.gemselections.Retrofit.ResponseModels.GeneralHoroscopeChartReportResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.MoonPhase;
import tech.iosd.gemselections.Retrofit.ResponseModels.ResponseForMoonPhaseReport;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoonPhaseReport extends Fragment {

    ProgressDialog progressDialog;
    TextView mainTV;

    public MoonPhaseReport() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.moon_phase_report, container, false);
        progressDialog =  new ProgressDialog(getContext());
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Loading..");
        progressDialog.show();
        AstrologyApiClient astrologyApiClient = new AstrologyApiClient();
        Retrofit retrofit = astrologyApiClient.getRetrofit();
        mainTV =  view.findViewById(R.id.moon_report_main_textview);


        AstrologyApiInterface astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);

        SipmleMoonPhaseRequst sipmleMoonPhaseRequst =  new SipmleMoonPhaseRequst((float)5.5);
        Call<ResponseForMoonPhaseReport> call = astrologyApiInterface
                .getMoonPhaseReport(AstrologyApiInterface.HEADER_TOKEN, sipmleMoonPhaseRequst);

        call.enqueue(new Callback<ResponseForMoonPhaseReport>() {
            @Override
            public void onResponse(Call<ResponseForMoonPhaseReport> call, Response<ResponseForMoonPhaseReport> response) {
                progressDialog.dismiss();
                mainTV.append("Considered date: "+response.body().getConsidered_date()+"\n"+"\n");
                mainTV.append("Moon Phase: "+response.body().getMoon_phase()+"\n"+"\n");
                mainTV.append("Significance: "+response.body().getSignificance()+"\n"+"\n");
                mainTV.append("Report: "+response.body().getReport()+"\n"+"\n");




            }

            @Override
            public void onFailure(Call<ResponseForMoonPhaseReport> call, Throwable t) {
                progressDialog.dismiss();

                Toast.makeText(getContext(),"TRY AGAIN!",Toast.LENGTH_LONG).show();
                Log.d("error77",t.getMessage());
            }



            /*@Override
            public void onResponse(Call<ResponseForMoonPhaseReport> call, Response<List<GeneralHoroscopeChartReportResponse>> response) {
                Log.d("TAGGER", "RESPONSE CODE : " + response.code());
                Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {
//                        String responseString = "";
                    Log.d("TAGGER", "RESPONSE SUCCESS");
//                            responseString = responseString.concat(response.body().getReport().get(i));
                    try {
                        responseTextView.append("\n\n ");

                        for (int i = 0; i < response.body().size(); i++) {
                            responseTextView.append("\nSign Name : " + response.body().get(i).getSignName());
                            responseTextView.append("\nSign : " + response.body().get(i).getSign());
                            responseTextView.append("\nPlanets : ");
                            for (int j = 0; j < response.body().size(); j++)
                                responseTextView.append(" " + response.body().get(i).getPlanet().get(j));
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<List<GeneralHoroscopeChartReportResponse>> call, Throwable t) {

                Log.d("TAGGER", "RESPONSE FAILURE");
                Log.d("TAGGER", t.getMessage());
                Snackbar.make(responseTextView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);

                progressDialog.dismiss();
            }*/
        });


        return  view;
    }

}
