package tech.iosd.gemselections.AstrologyFragments.Western;

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
import tech.iosd.gemselections.Retrofit.ResponseModels.LifeForecast;
import tech.iosd.gemselections.Retrofit.SunsignCompatibilityResponse;
import tech.iosd.gemselections.Utils.Constants;

/**
 * Created by anubhavmalik on 27/03/18.
 */

public class SunsignCompatibilityFragment extends Fragment {
    Retrofit retrofit;
    ArrayList<LifeForecast> arrayList = new ArrayList<>();
    private String primaryZodiac,secondaryZodiac;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.general_report_frag, container, false);

        primaryZodiac = "null";
        secondaryZodiac = "null";
        AstrologyApiClient astrologyApiClient = new AstrologyApiClient();
        retrofit = astrologyApiClient.getRetrofit();

        AstrologyApiInterface astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        final TextView responseTextView = view.findViewById(R.id.general_report_text_view);

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading ... ");
        progressDialog.show();

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            primaryZodiac = bundle.getString(Constants.PRIMARY_ZODIAC);
            secondaryZodiac = bundle.getString(Constants.SECONDARY_ZODIAC);
            Call<SunsignCompatibilityResponse> call = astrologyApiInterface
                    .getSunSignCompatibilityReport(AstrologyApiInterface.HEADER_TOKEN
                            , bundle.getString(Constants.PRIMARY_ZODIAC)
                            , bundle.getString(Constants.PRIMARY_RISING_SUN)
                            , bundle.getString(Constants.SECONDARY_ZODIAC)
                            , bundle.getString(Constants.SECONDARY_RISING_SUN));

            call.enqueue(new Callback<SunsignCompatibilityResponse>() {
                @Override
                public void onResponse(Call<SunsignCompatibilityResponse> call, Response<SunsignCompatibilityResponse> response) {
                    Log.d("TAGGER", "RESPONSE CODE : " + response.code());
                    Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                    progressDialog.dismiss();
                    if (response.isSuccessful() && response.body() != null) {
//                        String responseString = "";
                        Log.d("TAGGER", "RESPONSE SUCCESS");
//                        arrayList.addAll(response.body().getLifeForecast());
//                            responseString = responseString.concat(response.body().getReport().get(i));
                        responseTextView.append("\n Your Sign : " + primaryZodiac);
                        responseTextView.append("\n Your Partner Sign : " + secondaryZodiac);
                        responseTextView.append("\n\n Compatibility Percentage : "+ response.body().getCompatibilityPercentage());
                        responseTextView.append("\n\n Compatibility Report : " + response.body().getCompatibilityReport());
                        responseTextView.append("\n\n");

//                        responseTextView.append("\n Key Quality : "+response.body().getKeyQuality());
//                        responseTextView.append("\n Spiritual Lesson : "+ response.body().getSpiritualLesson());
                    }
                }

                @Override
                public void onFailure(Call<SunsignCompatibilityResponse> call, Throwable t) {

                    Log.d("TAGGER", "RESPONSE FAILURE");
                    Log.d("error77", t.getMessage());
                    Snackbar.make(responseTextView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);

                    progressDialog.dismiss();
                }
            });


        } else {
            progressDialog.dismiss();
            Snackbar.make(responseTextView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);
        }
        return view;
    }
}
