package tech.iosd.gemselections.AstrologyFragments.RequestFragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import tech.iosd.gemselections.AstrologyFragments.Western.CompositeHoroscopeFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.DailyTransitsFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.FriendshipReportFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.KarmaDestinyFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.LifeForecastFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.LoveCompatibilityFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.LunarMetricsFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.MonthlyTransitFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.PersonalityReportFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.PersonalizedPlanetPredictionFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.RomanticForecastCoupleReportFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.RomanticForecastFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.RomanticPersonalityFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.SolarReturnFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.SolarReturnHouseFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.SolarReturnPlanetFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.SynastryFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.WeeklyTransitFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.WesternChartFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.WesternHoroscopeFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.ZodiacCompatibilityFragment;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.Constants;
import tech.iosd.gemselections.Utils.SharedPreferencesUtils;

public class WesternZodiacDataCollectorFragment extends Fragment {

    Bundle bundle;
    String[] array = {"Aries - March 21 - April 20",
            "Taurus - April 21 - May 21",
            "Gemini - May 22 - June 21",
            "Cancer - June 22 - July 22",
            "Leo - July 23 -August 21",
            "Virgo - August 22 - September 23",
            "Libra - September 24 - October 23",
            "Scorpio - October 24 - November 22",
            "Sagittarius - November 23 - December 22",
            "Capricorn - December 23 - January 20",
            "Aquarius - January 21 - February 19",
            "Pisces - February 20- March 20"};

    String variable;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.western_zodiac_data_collector,container,false);

       bundle = getArguments();
        ListView listView = view.findViewById(R.id.western_zodiac_data_collector_list_view);
        listView.setAdapter(new ArrayAdapter<>(getContext(),android.R.layout.simple_list_item_1,array));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        variable = "Aries";
                        break;
                    case 1:
                        variable = "Taurus";
                        break;
                    case 2:
                        variable = "Gemini";
                        break;
                    case 3:
                        variable = "Cancer";
                        break;
                    case 4:
                        variable = "Leo";
                        break;
                    case 5:
                        variable = "Virgo";
                        break;
                    case 6:
                        variable = "Libra";
                        break;
                    case 7:
                        variable = "Scorpio";
                        break;
                    case 8:
                        variable = "Sagittarius";
                        break;
                    case 9:
                        variable = "Capricorn";
                        break;
                    case 10:
                        variable = "Aquarius";
                        break;
                    case 11:
                        variable = "Pisces";
                        break;
                }
                bundle.putString(Constants.PRIMARY_ZODIAC,variable);
            }
        });

        setFragment(new ZodiacCompatibilityFragment());




       return view;
    }



    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .replace(R.id.western_astrology_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("Main")
                .commit();
    }

}


