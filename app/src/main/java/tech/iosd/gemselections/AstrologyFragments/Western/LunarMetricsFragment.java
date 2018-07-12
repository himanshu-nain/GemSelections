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

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiClient;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.WesternAstrologySimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.LunarMetricsResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.SolarReturnResponse;
import tech.iosd.gemselections.Utils.Constants;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class LunarMetricsFragment extends Fragment {
    TextView monthTextView, withinPerigeeRangeTextView, distance, withinApogeeRangeTextView, apogeeDistanceTextView;
    Retrofit retrofit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.western_lunar_metrics_frag, container, false);

        AstrologyApiClient astrologyApiClient = new AstrologyApiClient();
        retrofit = astrologyApiClient.getRetrofit();

        withinApogeeRangeTextView = view.findViewById(R.id.lunar_metrics_within_apogee_range);
        apogeeDistanceTextView = view.findViewById(R.id.lunar_metrics_apogee_range);
        monthTextView = view.findViewById(R.id.lunar_metrics_month);
        withinPerigeeRangeTextView = view.findViewById(R.id.lunar_metrics_within_perigee_range);
        distance = view.findViewById(R.id.lunar_metrics_distance);

        AstrologyApiInterface astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setTitle("Please Wait");
        progressDialog.setMessage("Loading ... ");
        progressDialog.show();

        Bundle bundle = this.getArguments();
        if (bundle != null) {

            WesternAstrologySimpleRequest westernAstrologySimpleRequest = new WesternAstrologySimpleRequest(bundle.getInt(Constants.PRIMARY_DAY)
                    , bundle.getInt(Constants.PRIMARY_MONTH)
                    , bundle.getInt(Constants.PRIMARY_YEAR)
                    , bundle.getInt(Constants.PRIMARY_HOUR)
                    , bundle.getInt(Constants.PRIMARY_MIN)
                    , Constants.PRIMARY_LAT
                    , Constants.PRIMARY_LNG
                    , Constants.TIMEZONE);//                = new WesternAstrologySimpleRequest(bundle.getInt(Constants.PRIMARY_DAY,1)
//                ,bundle.getInt(Constants.PRIMARY_MONTH,1)
//                ,bundle.getInt(Constants.PRIMARY_YEAR,2018)
//                ,bundle.getInt(Constants.PRIMARY_HOUR,1)
//                ,bundle.getInt(Constants.PRIMARY_MIN,1)
//                ,Constants.PRIMARY_LAT
//                ,Constants.PRIMARY_LNG
//                ,Constants.TIMEZONE);


            retrofit2.Call<LunarMetricsResponse> call = astrologyApiInterface
                    .getLunarMetrics(AstrologyApiInterface.HEADER_TOKEN, westernAstrologySimpleRequest);

            call.enqueue(new Callback<LunarMetricsResponse>() {
                @Override
                public void onResponse(retrofit2.Call<LunarMetricsResponse> call, Response<LunarMetricsResponse> response) {
                    Log.d("TAGGER", "RESPONSE CODE : " + response.code());
                    Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                    progressDialog.dismiss();
                    if (response.isSuccessful()) {
                        Log.d("TAGGER", "RESPONSE SUCCESS");
                        if (response.body().getApogeeDistance() != null)
                            apogeeDistanceTextView.append(response.body().getApogeeDistance().toString());
                        if (response.body().getWithinApogeeRange() != null)
                            withinApogeeRangeTextView.append(response.body().getWithinApogeeRange());
                        if (response.body().getWithinPerigeeRange() != null)
                            withinPerigeeRangeTextView.append(response.body().getWithinPerigeeRange());
                        if (response.body().getDistance() != null)
                            distance.append(response.body().getDistance());
                        if (response.body().getMonth() != null)
                            monthTextView.append(response.body().getMonth());

                    }
                }

                @Override
                public void onFailure(retrofit2.Call<LunarMetricsResponse> call, Throwable t) {

                    Log.d("TAGGER", "RESPONSE FAILURE");
                    Log.d("TAGGER", t.getMessage());
                    Snackbar.make(monthTextView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);

                    progressDialog.dismiss();
                }
            });


        } else {
            progressDialog.dismiss();
            Snackbar.make(monthTextView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);
        }

        return view;

    }
}
