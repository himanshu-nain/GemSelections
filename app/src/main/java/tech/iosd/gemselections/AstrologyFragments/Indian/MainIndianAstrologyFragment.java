package tech.iosd.gemselections.AstrologyFragments.Indian;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import tech.iosd.gemselections.AstrologyFragments.RequestFragments.IndianDataCollectorOneFragment;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.Constants;

public class MainIndianAstrologyFragment extends Fragment {

    String[] array = {
            "General House Report"
            , "General Ascendant Report"
            , "General Planet Nature Report"
            , "General Moon Biorythm Report"
            , "Moon Horoscope Report Chart"
            , "Kal Sarpa Details"
            , "Basic Astrology Report"
            , "Basic Astrology Details"
            , "Basic Astrology Planets"
            , "Madhya Bhav"
            , "Ayanmsha"
            , "Major Char Dasha"
            , "Current Char Dasha"
            , "Sub Char Dasha"
            , "Sub Sub Char Dasha"
            , "Gemstone Suggestion"
//            , "Numerology Gem Suggestion"
            , "Basic Panchang"
            , "Planet Panchang"
            , "Yogini Dasha"
            , "Numerology Report"
            , "Numerology Favorable Time"
            , "Numerology Place Vastu"
            , "Numerology Daily Prediction"};

    Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.astro_western_list_frag, container, false);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, array);
        bundle = new Bundle();

        ListView listView = view.findViewById(R.id.western_astrology_list_view);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 1:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 2:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 3:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 4:
                        setFragment(new MoonPhaseReport());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 5:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 6:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 7:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 8:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 9:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 10:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 11:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 12:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 13:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 14:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 15:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 16:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 17:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 18:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 19:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 20:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 21:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 22:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 23:
                        setFragment(new IndianDataCollectorOneFragment());
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                }
            }
        });
        return view;
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .replace(R.id.indian_astrology_main_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("Main")
                .commit();
    }
}
