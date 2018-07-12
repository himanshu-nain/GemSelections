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
import tech.iosd.gemselections.Retrofit.ResponseModels.CurrentCharDashaResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.SubCharDashaResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.SubSubDasha;
import tech.iosd.gemselections.Utils.Constants;

public class SubSubCharDashaFragment  extends Fragment {
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


            Call<CurrentCharDashaResponse> call = astrologyApiInterface
                    .getSubSubCharDasha(AstrologyApiInterface.HEADER_TOKEN, westernAstrologySimpleRequest);

            call.enqueue(new Callback<CurrentCharDashaResponse>() {
                @Override
                public void onResponse(Call<CurrentCharDashaResponse> call, Response<CurrentCharDashaResponse> response) {
                    Log.d("TAGGER", "RESPONSE CODE : " + response.code());
                    Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                    //todo response is not coming correct
                    progressDialog.dismiss();
                    if (response.isSuccessful() && response.body() != null) {
//                        String responseString = "";
                        Log.d("TAGGER", "RESPONSE SUCCESS");
//                            responseString = responseString.concat(response.body().getReport().get(i));
                        try {
                            responseTextView.append("\n\n ");
                            responseTextView.append("Dasha Date : "+response.body().getDashaDate());
                            responseTextView.append("\n\nMAJOR DASHA : \n");
                            responseTextView.append("\n\t\tSign Name : "+response.body().getMajorDasha().getSignName());
                            responseTextView.append("\n\t\tDuration : "+response.body().getMajorDasha().getDuration());
                            responseTextView.append("\n\t\tStart Date : "+response.body().getMajorDasha().getStartDate());
                            responseTextView.append("\n\t\tEnd Date : "+response.body().getMajorDasha().getEndDate());

                            responseTextView.append("\n\nSUB DASHA : \n");
                            responseTextView.append("\n\t\tSign Name : "+response.body().getSubDasha().getSignName());
                            responseTextView.append("\n\t\tDuration : "+response.body().getSubDasha().getDuration());
                            responseTextView.append("\n\t\tStart Date : "+response.body().getSubDasha().getStartDate());
                            responseTextView.append("\n\t\tEnd Date : "+response.body().getSubDasha().getEndDate());

                            responseTextView.append("\n\nSUB SUB DASHA ");


//                            for (int i = 0; i < response.body().getSubSubDasha().size(); i++) {
//                                responseTextView.append("\n\t\tSign Name : " + response.body().getSubSubDasha().get(i).getSignName());
//                                responseTextView.append("\n\t\tStart Date : " + response.body().getSubSubDasha().get(i).getStartDate());
//                                responseTextView.append("\n\t\tEnd Date : " + response.body().getSubSubDasha().get(i).getEndDate());
//                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<CurrentCharDashaResponse> call, Throwable t) {

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