package tech.iosd.gemselections.AstrologyFragments.MatchMaking;

import android.app.DatePickerDialog;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import tech.iosd.gemselections.AstrologyFragments.RequestFragments.MatchMakingInputFragment1;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingPapasamyamReportRequest;

public class MatchMakingInputFragment3 extends Fragment {
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private EditText mmhtob, mmmtob, mmpob,mgenderR;
    private int mmonth, myear, mday, mhtob, mmtob;
    private String mpob,mgender;
    private float[] mloc;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_making_input3, container, false);
        mDisplayDate = view.findViewById(R.id.tv_mDate);
        Button submitButton = view.findViewById(R.id.bt_submit);
        mmhtob = view.findViewById(R.id.et_mhtob);
        mmmtob = view.findViewById(R.id.et_mmtob);
        mmpob = view.findViewById(R.id.et_mpob);
        mgenderR = view.findViewById(R.id.et_gender);
        mloc = new float[2];

        final int caseNo = getArguments().getInt("caseNo");

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                //int year = cal.get(Calendar.YEAR);
                myear = 1997;
                mmonth = cal.get(Calendar.MONTH);
                mday = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        view.getContext(),
                        mDateSetListener,
                        myear, mmonth, mday);
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int myear, int mmonth, int mday) {
                mmonth = mmonth + 1;
                String date = mmonth + "/" + mday + "/" + myear;
                mDisplayDate.setText(date);
            }
        };

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mhtob = Integer.parseInt(mmhtob.getText().toString());
                mmtob = Integer.parseInt(mmmtob.getText().toString());
                mpob = mmpob.getText().toString();
                mgender = mgenderR.getText().toString();
                if (mday!=0 && mmonth!=0 && myear!=0 && mgender!=null) {
                    Bundle args = new Bundle();
                    mloc = getLocationLatandLong(mpob,getContext());
                    MatchMakingPapasamyamReportRequest matchMakingPapasamyamReportRequest = new MatchMakingPapasamyamReportRequest(mday,mmonth,myear,mhtob,mmtob,mloc[0]
                            ,mloc[1],(float)5.5,mgender);
                    //checking input
                    //Log.d("Check input",matchMakingPapasamyamReportRequest.getGender().toString());
                    args.putSerializable("match_making_object",matchMakingPapasamyamReportRequest);
                    switch (caseNo) {
                        case 13:
                            PapasamyamDetailsFragment papasamyamDetailsFragment = new PapasamyamDetailsFragment();
                            papasamyamDetailsFragment.setArguments(args);
                            getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                    papasamyamDetailsFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                    .addToBackStack("Main").commit();
                    }
                } else {
                    Toast.makeText(view.getContext(), "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return view;
    }

    public static float[] getLocationLatandLong(String location,Context context) {
        if (Geocoder.isPresent()) {
            try {
                float[] loc = new float[2];
                Geocoder gc = new Geocoder(context);
                List<Address> addresses = gc.getFromLocationName(location, 5); // get the found Address Objects
                loc[0] = (float) addresses.get(0).getLatitude();
                loc[1] = (float) addresses.get(0).getLongitude();
                //  TimeZone tz=TimeZone.getDefault();
                Log.d("check Location", "onCreateView: " + loc[0] + "," +loc[1]+ ",");//+tz.getDisplayName(false,TimeZone.SHORT));
                return loc;
            } catch (IOException e) {
                // handle the exception
            }
        }
        float[] loc = {0.0f,0.0f};
        return loc;
    }
}
