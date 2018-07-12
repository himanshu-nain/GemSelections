package tech.iosd.gemselections.AstrologyFragments.MatchMaking;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingPartnerReport;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingSimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.MatchPercentageResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.PartnerReportResponse;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class PartnerReportFragment extends Fragment {
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;

    TextView titlea,message;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.partner_report_astrology, container, false);

        titlea = view.findViewById(R.id.title_val);
        message = view.findViewById(R.id.msg_val);
        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading ... ");
        progressDialog.show();

        retrofit = new Retrofit.Builder()
                .baseUrl("https://json.astrologyapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MatchMakingPartnerReport matchMakingPartnerReport = (MatchMakingPartnerReport) getArguments().getSerializable("match_making_object");
        astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);
        Call<PartnerReportResponse> call = astrologyApiInterface.getPartnerReportResponse(AstrologyApiInterface.HEADER_TOKEN, matchMakingPartnerReport);
        call.enqueue(new Callback<PartnerReportResponse>() {
            @Override
            public void onResponse(Call<PartnerReportResponse> call, Response<PartnerReportResponse> response) {
                progressDialog.dismiss();
                PartnerReportResponse partnerReportResponse = response.body();
                // List<FemalePlanetDetail> list = matchPlanetDetailsResponse.getFemalePlanetDetails();
                String msg = partnerReportResponse.getMsg();
                String title = partnerReportResponse.getTitle();

                titlea.setText(title);
                message.setText(msg);

            }

            @Override
            public void onFailure(Call<PartnerReportResponse> call, Throwable t) {

            }
        });

        return view;
    }
}
