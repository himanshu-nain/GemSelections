package tech.iosd.gemselections.AstrologyFragments.RequestFragments;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import tech.iosd.gemselections.AstrologyFragments.MatchMaking.PartnerReportFragment;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.RequestModels.MatchMakingPartnerReport;

/**
 * Created by kushalgupta on 31/03/18.
 */

public class MatchMakingInputFragment2 extends Fragment {
    private TextView mDisplayDate, fDisplayDate;

    private DatePickerDialog.OnDateSetListener mDateSetListener;
    private DatePickerDialog.OnDateSetListener fDateSetListener;
    private Button submitButton;
    private EditText mgendeR,fgender,nameOfPartner;
    private int mmonth, myear, mday, fmonth, fyear, fday, mhtob, mmtob, fhtob, fmtob;
    private String mgender, fgendera,fName;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.match_making_input2, container, false);
        mDisplayDate = (TextView) view.findViewById(R.id.tv_mDate);
        fDisplayDate = view.findViewById(R.id.tv_fDate);
        submitButton = view.findViewById(R.id.bt_submit);
        mgendeR = view.findViewById(R.id.et_mpob);
        fgender = view.findViewById(R.id.et_fpob);
        nameOfPartner = view.findViewById(R.id.name_of_partner);



        final int caseNo = getArguments().getInt("caseNo");
        // Toast.makeText(view.getContext(), "argu:"+caseNo, Toast.LENGTH_SHORT).show();

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


        fDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                //int year = cal.get(Calendar.YEAR);
                fyear = 1997;
                fmonth = cal.get(Calendar.MONTH);
                fday = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        view.getContext(),
                        fDateSetListener,
                        fyear, fmonth, fday);
                dialog.show();
            }
        });

        fDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int fyear, int fmonth, int fday) {
                fmonth = fmonth + 1;

                String date = fmonth + "/" + fday + "/" + fyear;
                fDisplayDate.setText(date);
            }
        };

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mgender = mgendeR.getText().toString();
                fgendera = fgender.getText().toString();
                fName = nameOfPartner.getText().toString();
                if (mday!=0 && mmonth!=0 && myear!=0 && fday!=0 && fmonth!=0 && fyear!=0 && mgender!=null && fgender!=null && fName!=null) {
                    Bundle args = new Bundle();
                    MatchMakingPartnerReport matchMakingPartnerReport = new MatchMakingPartnerReport(mday, mmonth,
                            myear, mgender, fday, fmonth, fyear, fgendera, fName);
                    args.putSerializable("match_making_object",matchMakingPartnerReport);
                    switch (caseNo) {
                        case 11:
                            PartnerReportFragment partnerReportFragment = new PartnerReportFragment();
                            partnerReportFragment.setArguments(args);
                            getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                    partnerReportFragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                    .addToBackStack("Main").commit();
                    }
                } else {
                    Toast.makeText(view.getContext(), "All fields are mandatory", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;

    }

}