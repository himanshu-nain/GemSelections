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
import tech.iosd.gemselections.Retrofit.ResponseModels.GeneralMoonBioRythmResponse;
import tech.iosd.gemselections.Utils.Constants;

public class GeneralMoonBioRythmReportFragment extends Fragment {
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
                ,bundle.getInt(Constants.PRIMARY_YEAR,1997)
                ,bundle.getInt(Constants.PRIMARY_HOUR,1)
                ,bundle.getInt(Constants.PRIMARY_MIN,1)
                ,Constants.PRIMARY_LAT
                ,Constants.PRIMARY_LNG
                ,Constants.TIMEZONE);


            Call<GeneralMoonBioRythmResponse> call = astrologyApiInterface
                    .getGeneralMoonBioRythmReport(AstrologyApiInterface.HEADER_TOKEN, westernAstrologySimpleRequest);

            call.enqueue(new Callback<GeneralMoonBioRythmResponse>() {
                @Override
                public void onResponse(Call<GeneralMoonBioRythmResponse> call, Response<GeneralMoonBioRythmResponse> response) {
                    Log.d("TAGGER", "RESPONSE CODE : " + response.code());
                    Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                    progressDialog.dismiss();
                    if (response.isSuccessful() && response.body() != null) {
//                        String responseString = "";
                        Log.d("TAGGER", "RESPONSE SUCCESS");
//                            responseString = responseString.concat(response.body().getReport().get(i));
                        try {
                            responseTextView.append("\nBirth Pakshi : " + response.body().getBirthPakshi());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            responseTextView.append("\nDay Ruling Days : ");

                            for (int i = 0; i < response.body().getBirthPakshiDetails().getDayRulingDays().size(); i++) {
                                responseTextView.append(" " + response.body().getBirthPakshiDetails().getDayRulingDays().get(i));
                               }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            responseTextView.append("\nNight Ruling Days : ");

                            for (int i = 0; i < response.body().getBirthPakshiDetails().getNightRulingDays().size(); i++) {
                                responseTextView.append(" " + response.body().getBirthPakshiDetails().getNightRulingDays().get(i));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            responseTextView.append("\nName Letters : ");

                            for (int i = 0; i < response.body().getBirthPakshiDetails().getNameLetter().size(); i++) {
                                responseTextView.append(" " + response.body().getBirthPakshiDetails().getNameLetter().get(i));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            responseTextView.append("\nDeath Day : ");

                            for (int i = 0; i < response.body().getBirthPakshiDetails().getDeathDay().size(); i++) {
                                responseTextView.append(" " + response.body().getBirthPakshiDetails().getDeathDay().get(i));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            responseTextView.append("\nEnemy  : ");

                            for (int i = 0; i < response.body().getBirthPakshiDetails().getEnemy().size(); i++) {
                                responseTextView.append(" " + response.body().getBirthPakshiDetails().getEnemy().get(i));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            responseTextView.append("\nFriend : ");

                            for (int i = 0; i < response.body().getBirthPakshiDetails().getFriend().size(); i++) {
                                responseTextView.append(" " + response.body().getBirthPakshiDetails().getFriend().get(i));
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            responseTextView.append("\nColor : " + response.body().getBirthPakshiDetails().getColor());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            responseTextView.append("\nDirection : " + response.body().getBirthPakshiDetails().getDirection());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            responseTextView.append("\nRequested Day : " + response.body().getRequestedDay());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            responseTextView.append("\nDay : ");

                            for (int i = 0; i < response.body().getActivityCycle().getDay().size(); i++) {
                                responseTextView.append("\nStart Time : " + response.body().getActivityCycle().getDay().get(i).getStartTime());
                                responseTextView.append("\nEnd Time : " + response.body().getActivityCycle().getDay().get(i).getEndTime());
                                responseTextView.append("\nStart Hours : " + response.body().getActivityCycle().getDay().get(i).getStartHours());
                                responseTextView.append("\nEnd Hours : " + response.body().getActivityCycle().getDay().get(i).getEndHours());
                                responseTextView.append("\nActivity : " + response.body().getActivityCycle().getDay().get(i).getActivity());
                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        try {
                            responseTextView.append("\nNight : ");

                            for (int i = 0; i < response.body().getActivityCycle().getNight().size(); i++) {
                                responseTextView.append("\nStart Time : " + response.body().getActivityCycle().getNight().get(i).getStartTime());
                                responseTextView.append("\nEnd Time : " + response.body().getActivityCycle().getNight().get(i).getEndTime());
                                responseTextView.append("\nStart Hours : " + response.body().getActivityCycle().getNight().get(i).getStartHours());
                                responseTextView.append("\nEnd Hours : " + response.body().getActivityCycle().getNight().get(i).getEndHours());
                                responseTextView.append("\nActivity : " + response.body().getActivityCycle().getNight().get(i).getActivity());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }



                    }
                }

                @Override
                public void onFailure(Call<GeneralMoonBioRythmResponse> call, Throwable t) {

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