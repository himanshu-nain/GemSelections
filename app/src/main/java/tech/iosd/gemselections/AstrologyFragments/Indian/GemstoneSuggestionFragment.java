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
import tech.iosd.gemselections.Retrofit.ResponseModels.BasicGemSuggestionResponse;
import tech.iosd.gemselections.Utils.Constants;

public class GemstoneSuggestionFragment extends Fragment {
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

            WesternAstrologySimpleRequest westernAstrologySimpleRequest// = new WesternAstrologySimpleRequest(20, 2, 1992, 12, 12, Constants.PRIMARY_LAT, Constants.PRIMARY_LNG, Constants.TIMEZONE);
                = new WesternAstrologySimpleRequest(bundle.getInt(Constants.PRIMARY_DAY,1)
                ,bundle.getInt(Constants.PRIMARY_MONTH,1)
                ,bundle.getInt(Constants.PRIMARY_YEAR,2018)
                ,bundle.getInt(Constants.PRIMARY_HOUR,1)
                ,bundle.getInt(Constants.PRIMARY_MIN,1)
                ,Constants.PRIMARY_LAT
                ,Constants.PRIMARY_LNG
                ,Constants.TIMEZONE);


            Call<BasicGemSuggestionResponse> call = astrologyApiInterface
                    .getBasicGemSuggestion(AstrologyApiInterface.HEADER_TOKEN, westernAstrologySimpleRequest);

            call.enqueue(new Callback<BasicGemSuggestionResponse>() {
                @Override
                public void onResponse(Call<BasicGemSuggestionResponse> call, Response<BasicGemSuggestionResponse> response) {
                    Log.d("TAGGER", "RESPONSE CODE : " + response.code());
                    Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                    progressDialog.dismiss();
                    if (response.isSuccessful() && response.body() != null) {
//                        String responseString = "";
                        Log.d("TAGGER", "RESPONSE SUCCESS");
//                            responseString = responseString.concat(response.body().getReport().get(i));
                        try {
                            responseTextView.append("\n\n ");
                            responseTextView.append("\n\nLIFE : \n");
                            responseTextView.append("\n\t\t Name : " + response.body().getLIFE().getName());
                            responseTextView.append("\n\t\tSemi_Gem : " + response.body().getLIFE().getSemiGem());
                            responseTextView.append("\n\t\tWear Finger : " + response.body().getLIFE().getWearFinger());
                            responseTextView.append("\n\t\tWeight Caret  : " + response.body().getLIFE().getWeightCaret());
                            responseTextView.append("\n\t\tWear Metal  : " + response.body().getLIFE().getWearMetal());
                            responseTextView.append("\n\t\tWear Day  : " + response.body().getLIFE().getWearDay());
                            responseTextView.append("\n\t\tGem Deity  : " + response.body().getLIFE().getGemDeity());

                            responseTextView.append("\n\nBENEFIC : \n");
                            responseTextView.append("\n\t\t Name : " + response.body().getBENEFIC().getName());
                            responseTextView.append("\n\t\tSemi_Gem : " + response.body().getBENEFIC().getSemiGem());
                            responseTextView.append("\n\t\tWear Finger : " + response.body().getBENEFIC().getWearFinger());
                            responseTextView.append("\n\t\tWeight Caret  : " + response.body().getBENEFIC().getWeightCaret());
                            responseTextView.append("\n\t\tWear Metal  : " + response.body().getBENEFIC().getWearMetal());
                            responseTextView.append("\n\t\tWear Day  : " + response.body().getBENEFIC().getWearDay());
                            responseTextView.append("\n\t\tGem Deity  : " + response.body().getBENEFIC().getGemDeity());

                            responseTextView.append("\n\nLUCKY : \n");
                            responseTextView.append("\n\t\t Name : " + response.body().getLUCKY().getName());
                            responseTextView.append("\n\t\tSemi_Gem : " + response.body().getLUCKY().getSemiGem());
                            responseTextView.append("\n\t\tWear Finger : " + response.body().getLUCKY().getWearFinger());
                            responseTextView.append("\n\t\tWeight Caret  : " + response.body().getLUCKY().getWeightCaret());
                            responseTextView.append("\n\t\tWear Metal  : " + response.body().getLUCKY().getWearMetal());
                            responseTextView.append("\n\t\tWear Day  : " + response.body().getLUCKY().getWearDay());
                            responseTextView.append("\n\t\tGem Deity  : " + response.body().getLUCKY().getGemDeity());

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }

                @Override
                public void onFailure(Call<BasicGemSuggestionResponse> call, Throwable t) {

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
