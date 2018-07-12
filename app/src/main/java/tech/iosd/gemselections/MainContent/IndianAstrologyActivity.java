package tech.iosd.gemselections.MainContent;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import tech.iosd.gemselections.AstrologyFragments.Indian.MainIndianAstrologyFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.MainWesternListFragment;
import tech.iosd.gemselections.R;

public class IndianAstrologyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian_astrology);


        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .add(R.id.indian_astrology_main_container, new MainIndianAstrologyFragment())
//                .addToBackStack("Main")
                .commit();
    }
}
