package tech.iosd.gemselections.AstrologyFragments.Western;

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
import android.widget.Toast;

import tech.iosd.gemselections.AstrologyFragments.RequestFragments.WesternComplexDataCollectorFragment;
import tech.iosd.gemselections.AstrologyFragments.RequestFragments.WesternDataCollectorOneFragment;
import tech.iosd.gemselections.AstrologyFragments.RequestFragments.WesternZodiacCompatibilityDataCollectionFragment;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.Constants;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class MainWesternListFragment extends Fragment {

    String[] array = {
            "Western Horoscope"
            , "Western Chart"
            , "Daily Tropical Transit"
            , "Weekly Tropical Transit"
            , "Monthly Tropical Transit"
            , "Solar Return"
            , "Solar Return Planet"
            , "Solar Return House"
            , "Lunar Metrics"
            , "Composite Horoscope"
            , "Synastry Horoscope"
            , "Personality Report"
            , "Romantic Personality Report"
            , "Personalized Planet Prediction"
            , "Life Forecast Report"
            , "Romantic Forecast Report"
            , "Friendship Report"
            , "Karma Destiny Report"
            , "Love Compatibility Report"
            , "Romantic Forecast Couple Report"
            , "Zodiac Compatibility"
            , "Sun Sign Compatibility"};

    Fragment fragment;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.astro_western_list_frag, container, false);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, array);

        ListView listView = view.findViewById(R.id.western_astrology_list_view);
        listView.setAdapter(arrayAdapter);

        final Bundle bundle = new Bundle();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        fragment = new WesternDataCollectorOneFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 1:
                        fragment = new WesternDataCollectorOneFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 2:
                        fragment = new WesternDataCollectorOneFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 3:
                        fragment = new WesternDataCollectorOneFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 4:
                        fragment = new WesternDataCollectorOneFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 5:
                        fragment = new WesternDataCollectorOneFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 6:
                        fragment = new WesternDataCollectorOneFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 7:
                        fragment = new WesternDataCollectorOneFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 8:
                        fragment = new WesternDataCollectorOneFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 9:
                        fragment = new WesternComplexDataCollectorFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 10:
                        fragment = new WesternComplexDataCollectorFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 11:
                        fragment = new WesternDataCollectorOneFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 12:
                        fragment = new WesternDataCollectorOneFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 13:
                        fragment = new WesternDataCollectorOneFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 14:
                        fragment = new WesternDataCollectorOneFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 15:
                        fragment = new WesternComplexDataCollectorFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 16:
                        fragment = new WesternComplexDataCollectorFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 17:
                        fragment = new WesternComplexDataCollectorFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 18:
                        fragment = new WesternComplexDataCollectorFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 19:
                        fragment = new WesternComplexDataCollectorFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        break;
                    case 20:
                        fragment = new WesternZodiacCompatibilityDataCollectionFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        //Toast.makeText(getContext(),"hey",Toast.LENGTH_LONG).show();

                        break;
                    case 21:
                        fragment = new WesternZodiacCompatibilityDataCollectionFragment();
                        bundle.putInt(Constants.FRAGMENT_ID,i);
                        //Toast.makeText(getContext(),"hey",Toast.LENGTH_LONG).show();

                        break;
                }
                fragment.setArguments(bundle);
                setFragment(fragment);
            }
        });
        return view;
    }

    public void setFragment (Fragment fragment){
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.western_astrology_container,fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("Main")
                .commit();
    }
}
