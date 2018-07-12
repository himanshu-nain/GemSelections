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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiClient;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.ResponseModels.ZodiacCompatibilityResponse;
import tech.iosd.gemselections.Utils.Constants;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class ZodiacCompatibilityFragment extends Fragment {
    Retrofit retrofit;

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
        if (bundle != null) {

            Call<ZodiacCompatibilityResponse> call = astrologyApiInterface
                    .getZodiacCompatibility(AstrologyApiInterface.HEADER_TOKEN
                            , bundle.getString(Constants.PRIMARY_ZODIAC)
                            , bundle.getString(Constants.SECONDARY_ZODIAC));

            call.enqueue(new Callback<ZodiacCompatibilityResponse>() {
                @Override
                public void onResponse(Call<ZodiacCompatibilityResponse> call, Response<ZodiacCompatibilityResponse> response) {
                    Log.d("TAGGER", "RESPONSE CODE : " + response.code());
                    Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                    progressDialog.dismiss();
                    if (response.isSuccessful() && response.body() != null) {
//                        String responseString = "";
                        Log.d("TAGGER", "RESPONSE SUCCESS");
//                        arrayList.addAll(response.body().getLifeForecast());
//                            responseString = responseString.concat(response.body().getReport().get(i));
                        responseTextView.append("\t\t\t\t\t\t\t\t\t" + "ZODIAC COMPATIBILITY");
                        responseTextView.append("\n\n Your Sign : " + response.body().getYourSign());
                        responseTextView.append("\n\n Your Partner's Sign : " + response.body().getYourPartnerSign());
                        responseTextView.append("\n\n Compatibility Report : " + response.body().getCompatibilityReport());
                        responseTextView.append("\n\n Compatibility Percentage : " + response.body().getCompatibilityPercentage());
                        responseTextView.append("\n\n");


//                        responseTextView.append("\n Key Quality : "+response.body().getKeyQuality());
//                        responseTextView.append("\n Spiritual Lesson : "+ response.body().getSpiritualLesson());

                    }
                }

                @Override
                public void onFailure(Call<ZodiacCompatibilityResponse> call, Throwable t) {

                    Log.d("TAGGER", "RESPONSE FAILURE");
                    Log.d("TAGGER", t.getMessage());
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
