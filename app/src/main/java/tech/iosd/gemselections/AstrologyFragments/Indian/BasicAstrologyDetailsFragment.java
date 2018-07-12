package tech.iosd.gemselections.AstrologyFragments.Indian;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiClient;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.WesternAstrologySimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.BasicAstroDetailsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.BasicAstroResponse;
import tech.iosd.gemselections.Utils.Constants;

public class BasicAstrologyDetailsFragment  extends Fragment {
    Retrofit retrofit;
    ArrayList<String> arrayList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.general_report_frag, container, false);

        AstrologyApiClient astrologyApiClient = new AstrologyApiClient();
        retrofit = astrologyApiClient.getRetrofit();

        AstrologyApiInterface astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        final TextView responseTextView = view.findViewById(R.id.general_report_text_view);

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading ... ");
        progressDialog.show();

        Bundle bundle = this.getArguments();
//        bundle = new Bundle();
        if (bundle != null) {

            WesternAstrologySimpleRequest westernAstrologySimpleRequest //= new WesternAstrologySimpleRequest(20, 2, 1992, 12, 12, Constants.PRIMARY_LAT, Constants.PRIMARY_LNG, Constants.TIMEZONE);
                = new WesternAstrologySimpleRequest(bundle.getInt(Constants.PRIMARY_DAY,1)
                ,bundle.getInt(Constants.PRIMARY_MONTH,1)
                ,bundle.getInt(Constants.PRIMARY_YEAR,2018)
                ,bundle.getInt(Constants.PRIMARY_HOUR,1)
                ,bundle.getInt(Constants.PRIMARY_MIN,1)
                ,Constants.PRIMARY_LAT
                ,Constants.PRIMARY_LNG
                ,Constants.TIMEZONE);


            Call<BasicAstroDetailsResponse> call = astrologyApiInterface
                    .getBasicAstroDetails(AstrologyApiInterface.HEADER_TOKEN, westernAstrologySimpleRequest);

            call.enqueue(new Callback<BasicAstroDetailsResponse>() {
                @Override
                public void onResponse(Call<BasicAstroDetailsResponse> call, Response<BasicAstroDetailsResponse> response) {
                    Log.d("TAGGER", "RESPONSE CODE : " + response.code());
                    Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                    progressDialog.dismiss();
                    if (response.isSuccessful() && response.body() != null) {
//                        String responseString = "";
                        Log.d("TAGGER", "RESPONSE SUCCESS");
//                            responseString = responseString.concat(response.body().getReport().get(i));
                        try {
                            responseTextView.append("\n\n ");

                            responseTextView.append("\nAscendant : " + response.body().getAscendant());
                            responseTextView.append("\nVarna : " + response.body().getVarna());
                            responseTextView.append("\nVashya : " + response.body().getVashya());
                            responseTextView.append("\nYoni : " + response.body().getYoni());
                            responseTextView.append("\nGan : " + response.body().getGan());
                            responseTextView.append("\nNadi : " + response.body().getNadi());
                            responseTextView.append("\nSign Lord : " + response.body().getSignLord());
                            responseTextView.append("\nSign : " + response.body().getSign());
                            responseTextView.append("\nNakshatra : " + response.body().getNaksahtra());
                            responseTextView.append("\nNakshatra Lord : " + response.body().getNaksahtraLord());
                            responseTextView.append("\nCharan : " + response.body().getCharan());
                            responseTextView.append("\nYog : " + response.body().getYog());
                            responseTextView.append("\nKaran : " + response.body().getKaran());
                            responseTextView.append("\nTithi : " + response.body().getTithi());
                            responseTextView.append("\nYunja : " + response.body().getYunja());
                            responseTextView.append("\nTatva : " + response.body().getTatva());
                            responseTextView.append("\nName Alphabet : " + response.body().getNameAlphabet());
                            responseTextView.append("\nPaya : " + response.body().getPaya());


                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }


                @Override
                public void onFailure(Call<BasicAstroDetailsResponse> call, Throwable t) {

                    Log.d("TAGGER", "RESPONSE FAILURE");
                    Log.d("TAGGER", t.getMessage());
                    Snackbar.make(responseTextView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);

                    progressDialog.dismiss();
                }
            });


        }
        return view;
    }
}