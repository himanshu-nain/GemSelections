package tech.iosd.gemselections.AstrologyFragments.MatchMaking;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import tech.iosd.gemselections.AstrologyFragments.RequestFragments.MatchMakingInputFragment1;
import tech.iosd.gemselections.AstrologyFragments.RequestFragments.MatchMakingInputFragment2;
import tech.iosd.gemselections.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MatchMakingListFragment extends Fragment {
    String[] array = {
            "Match Birth Details"
            , "Match Ashtakoot Points"
            , "Match Vedha (Obstructions)"
            , "Match Astro Details"
            , "Match Planet Details"
            , "Match Manglik Report"
            , "Match Making Report"
            , "Match Simple Report"
            , "Match Making detailed Report"
            , "Match Dashakoot Points"
            , "Match percentage"
            , "Partner Report"

    };

    Bundle args = new Bundle();
    public MatchMakingListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_match_making_list, container, false);

        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, array);

        ListView listView = view.findViewById(R.id.match_making_list_view);
        listView.setAdapter(arrayAdapter);
        //Todo There is fragment inconsistency correct it
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        callMatchMakingInputFragment1(0);
                        break;
                    case 1:
                        callMatchMakingInputFragment1(1);
                        break;
                    case 2:
                        callMatchMakingInputFragment1(2);
                        break;
                    case 3:
                        callMatchMakingInputFragment1(3);
                        break;
                    case 4:
                        callMatchMakingInputFragment1(4);
                        break;
                    case 5:
                        callMatchMakingInputFragment1(5);
                        break;
                    case 6:
                        callMatchMakingInputFragment1(6);
                        break;
                    case 7:
                        callMatchMakingInputFragment1(7);
                        break;
                    case 8:
                        callMatchMakingInputFragment1(8);
                        break;
                    case 9:
                        callMatchMakingInputFragment1(9);
                        break;
                    case 10:
                        callMatchMakingInputFragment1(10);
                        break;
                    case 11:
                        args.putInt("caseNo", 11);
                        MatchMakingInputFragment2 matchMakingInputFragment2 = new MatchMakingInputFragment2();
                        matchMakingInputFragment2.setArguments(args);
                        getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                                matchMakingInputFragment2).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .addToBackStack("Main").commit();
                        break;

                }
            }
        });
        return view;
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.match_making_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("Main")
                .commit();
    }
    public void callMatchMakingInputFragment1(int i){
        MatchMakingInputFragment1 matchMakingInputFragment1 = new MatchMakingInputFragment1();
        args.putInt("caseNo", i);
        matchMakingInputFragment1.setArguments(args);
        getFragmentManager().beginTransaction().replace(R.id.match_making_container,
                matchMakingInputFragment1).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("Main").commit();
    }
}


