package tech.iosd.gemselections.MainContent;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import tech.iosd.gemselections.AstrologyFragments.Western.MainWesternListFragment;
import tech.iosd.gemselections.R;

public class WesternAstrologyActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_western_astrology);

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.western_astrology_container, new MainWesternListFragment())
//                .addToBackStack("Main")
                .commit();
    }


}
