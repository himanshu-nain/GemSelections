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
import tech.iosd.gemselections.Retrofit.ResponseModels.SolarReturnResponse;
import tech.iosd.gemselections.Utils.Constants;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class SolarReturnFragment extends Fragment {
    TextView nativeBirthDateTextView, nativeAgeTextView, solarReturnDateTextView;
    Retrofit retrofit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.western_solar_return_frag, container, false);

        AstrologyApiClient astrologyApiClient = new AstrologyApiClient();
        retrofit = astrologyApiClient.getRetrofit();

        nativeBirthDateTextView = view.findViewById(R.id.solar_return_native_birth_date);
        nativeAgeTextView = view.findViewById(R.id.solar_return_native_age);
        solarReturnDateTextView = view.findViewById(R.id.solar_return_date);

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


            retrofit2.Call<SolarReturnResponse> call = astrologyApiInterface
                    .getSolarReturn(AstrologyApiInterface.HEADER_TOKEN, westernAstrologySimpleRequest);

            call.enqueue(new Callback<SolarReturnResponse>() {
                @Override
                public void onResponse(retrofit2.Call<SolarReturnResponse> call, Response<SolarReturnResponse> response) {
                    Log.d("TAGGER", "RESPONSE CODE : " + response.code());
                    Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                    progressDialog.dismiss();
                    if (response.isSuccessful()) {
                        Log.d("TAGGER", "RESPONSE SUCCESS");
                        if (response.body().getNativeAge() != null)
                            nativeAgeTextView.append(response.body().getNativeAge().toString());
                        if (response.body().getNativeBirthDate() != null)
                            nativeBirthDateTextView.append(response.body().getNativeBirthDate());
                        if (response.body().getSolarReturnDate() != null)
                            solarReturnDateTextView.append(response.body().getSolarReturnDate());

                    }
                }

                @Override
                public void onFailure(retrofit2.Call<SolarReturnResponse> call, Throwable t) {

                    Log.d("TAGGER", "RESPONSE FAILURE");
                    Log.d("TAGGER", t.getMessage());
                    Snackbar.make(nativeAgeTextView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);

                    progressDialog.dismiss();
                }
            });


        } else {
            progressDialog.dismiss();
            Snackbar.make(nativeAgeTextView, "PLEASE RETRY", Snackbar.LENGTH_INDEFINITE);
        }

        return view;

    }
}
