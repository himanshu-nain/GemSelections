package tech.iosd.gemselections.MainContent;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import tech.iosd.gemselections.AstrologyFragments.MatchMaking.MatchMakingListFragment;
import tech.iosd.gemselections.R;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchMakingActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_making);

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.match_making_container, new MatchMakingListFragment())
//                .addToBackStack("Main")
                .commit();
    }


}
