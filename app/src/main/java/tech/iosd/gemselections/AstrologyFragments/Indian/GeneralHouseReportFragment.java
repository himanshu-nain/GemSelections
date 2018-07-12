package tech.iosd.gemselections.AstrologyFragments.Indian;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiClient;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.WesternAstrologySimpleRequest;
import tech.iosd.gemselections.Retrofit.ResponseModels.GeneralHouseReportResponse;
import tech.iosd.gemselections.Utils.Constants;

public class GeneralHouseReportFragment extends Fragment {
    Retrofit retrofit;
    ArrayList<String> arrayList = new ArrayList<>();
    boolean isPlanetSelected = false;
    Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.general_report_frag, container, false);

        final AlertDialog.Builder builderSingle = new AlertDialog.Builder(getContext());
        builderSingle.setTitle("Select One Planet:-");

//        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getContext(), android.R.layout.select_dialog_singlechoice);
//        arrayAdapter.add("Sun");
//        arrayAdapter.add("Moon");
//        arrayAdapter.add("Mars");
//        arrayAdapter.add("Jupiter");
//        arrayAdapter.add("Venus");
//        arrayAdapter.add("Saturn");

        bundle = this.getArguments();

        final TextView responseTextView = view.findViewById(R.id.general_report_text_view);

        List<String> planetsList = new ArrayList<>();
        planetsList.add("Sun");
        planetsList.add("Moon");
        planetsList.add("Mars");
        planetsList.add("Jupiter");
        planetsList.add("Venus");
        planetsList.add("Saturn");
        //Create sequence of items
        final CharSequence[] Animals = planetsList.toArray(new String[planetsList.size()]);
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
        dialogBuilder.setTitle("Planets");
        dialogBuilder.setCancelable(false);
        dialogBuilder.setItems(Animals, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String selectedText = Animals[item].toString();

                AstrologyApiClient astrologyApiClient = new AstrologyApiClient();
                retrofit = astrologyApiClient.getRetrofit();

                AstrologyApiInterface astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);

                final ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.setTitle("Please Wait");
                progressDialog.setMessage("Loading ... ");
                progressDialog.show();

                if (bundle != null) {

                    WesternAstrologySimpleRequest westernAstrologySimpleRequest // = new WesternAstrologySimpleRequest(20, 2, 1992, 12, 12, Constants.PRIMARY_LAT, Constants.PRIMARY_LNG, Constants.TIMEZONE);
                            = new WesternAstrologySimpleRequest(bundle.getInt(Constants.PRIMARY_DAY, 1)
                            , bundle.getInt(Constants.PRIMARY_MONTH, 1)
                            , bundle.getInt(Constants.PRIMARY_YEAR, 1997)
                            , bundle.getInt(Constants.PRIMARY_HOUR, 1)
                            , bundle.getInt(Constants.PRIMARY_MIN, 1)
                            , Constants.PRIMARY_LAT
                            , Constants.PRIMARY_LNG
                            , Constants.TIMEZONE);


                    Call<GeneralHouseReportResponse> call = astrologyApiInterface
                            .getGeneralHouseReport(AstrologyApiInterface.HEADER_TOKEN, selectedText, westernAstrologySimpleRequest);

                    call.enqueue(new Callback<GeneralHouseReportResponse>() {
                        @Override
                        public void onResponse(Call<GeneralHouseReportResponse> call, Response<GeneralHouseReportResponse> response) {
                            Log.d("TAGGER", "RESPONSE CODE : " + response.code());
                            Log.d("TAGGER", "RESPONSE BODY : " + response.body());
                            progressDialog.dismiss();
                            if (response.isSuccessful() && response.body() != null) {
//                        String responseString = "";
                                Log.d("TAGGER", "RESPONSE SUCCESS");
//                            responseString = responseString.concat(response.body().getReport().get(i));
                                responseTextView.append("\nPlanet : " + response.body().getPlanet() + "\n");
                                responseTextView.append("\nHouse Report : " + response.body().getHouseReport() + "\n");

//                        responseTextView.append("\n Key Quality : "+response.body().getKeyQuality());
//                        responseTextView.append("\n Spiritual Lesson : "+ response.body().getSpiritualLesson());

                            }
                        }

                        @Override
                        public void onFailure(Call<GeneralHouseReportResponse> call, Throwable t) {

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


            }
        }).show();
        //Create alert dialog object via builder
//        AlertDialog alertDialogObject = dialogBuilder.create();
//        //Show the dialog
//        alertDialogObject.show();
//
//        builderSingle.setCancelable(false);
//        builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//                getFragmentManager().popBackStack();
//            }
//        });
//
//        builderSingle.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//
//        builderSingle.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                String strName = arrayAdapter.getItem(which);
//                AlertDialog.Builder builderInner = new AlertDialog.Builder(getContext());
//                builderInner.setMessage(strName);
//                builderInner.setCancelable(false);
//                builderInner.setTitle("Your Selected Item is");
//                builderInner.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
////                        dialog.dismiss();
//
//                        dialog.dismiss();
//
//
//                    }
//                });
//                builderInner.show();
//            }
//        });
//        builderSingle.show();

        return view;
    }
}
