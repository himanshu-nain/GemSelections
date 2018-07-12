package tech.iosd.gemselections.JewelleryAlpha.Diamond;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;

import tech.iosd.gemselections.Adapters.BannerArrayAdapter;
import tech.iosd.gemselections.JewelleryAlpha.DiamondStudded.DiamondStudded;
import tech.iosd.gemselections.JewelleryAlpha.JewelleryAlpha;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.Banner;

/**
 * Created by anonymous on 28/8/17.
 */

public class DiamondActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

   // private String[] items = {,"Diamond Pendants", "Diamond Tops","Diamond Rings","Diamond Bracelets","Diamond Nose Pins","Diamond Studs"};

    private ArrayList<Banner> arraylist = new ArrayList<Banner>();

    private YouTubePlayerView playerView;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond);

        arraylist.add(new Banner( getDrawable(R.drawable.diamond_sets),"Diamond Sets"));
        arraylist.add(new Banner( getDrawable(R.drawable.diamond_pendants),"Diamond Pendants"));
        arraylist.add(new Banner( getDrawable(R.drawable.diamond_tops),"Diamond Tops"));
        arraylist.add(new Banner( getDrawable(R.drawable.diamond_rings),"Diamond Rings"));
        arraylist.add(new Banner( getDrawable(R.drawable.diamond_bracelets),"Diamond Bracelets"));
        arraylist.add(new Banner( getDrawable(R.drawable.diamond_nose_pin),"Diamond Nose Pins"));
        arraylist.add(new Banner( getDrawable(R.drawable.diamond_studs),"Diamond Studs"));
        arraylist.add(new Banner( getDrawable(R.drawable.diamond_accessories),"Diamond Studded"));


        GridView gridView;
        //ArrayAdapter<String> arrayAdapter;
        BannerArrayAdapter arrayAdapter= new  BannerArrayAdapter(this,arraylist);

        playerView = (YouTubePlayerView)findViewById(R.id._diamond_video);
        playerView.initialize(DEVELOPER_KEY, this);

        gridView = (GridView) findViewById(R.id.diamond_grid_view);
       //arrayAdapter = new ArrayAdapter<String>(DiamondActivity.this, R.layout.layout_banner, items);
        gridView.setAdapter(arrayAdapter);




        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:

                        startActivity(new Intent(
                                DiamondActivity.this, DiamondSets.class
                        ));

                        break;
                    case 1:

                        startActivity(new Intent(
                                DiamondActivity.this, DiamondPendants.class
                        ));

                        break;
                    case 2:

                        startActivity(new Intent(
                                DiamondActivity.this, DiamondTops.class
                        ));

                        break;
                    case 3:

                        startActivity(new Intent(
                                DiamondActivity.this, DiamondRings.class
                        ));

                        break;
                    case 4:

                        startActivity(new Intent(
                                DiamondActivity.this, DiamondBracelets.class
                        ));

                        break;
                    case 5:

                        startActivity(new Intent(
                                DiamondActivity.this, DiamondNosePin.class
                        ));

                        break;
                    case 6:

                        startActivity(new Intent(
                                DiamondActivity.this, DiamondStuds.class
                        ));

                        break;
                    case 7:

                        startActivity(new Intent(DiamondActivity.this , DiamondStudded.class));

                        break;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {

            getYouTubePlayerProvider().initialize(DEVELOPER_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return playerView;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b){
            youTubePlayer.cueVideo("okVOrm2cM6s");
            youTubePlayer.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
                @Override
                public void onFullscreen(boolean b) {
                    if(!b){
                        //youTubePlayer.setFullscreen(false);
                        if(getResources().getConfiguration().orientation != Configuration.ORIENTATION_PORTRAIT)
                        {
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                        }
                    }
                }
            });
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(DiamondActivity.this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(DiamondActivity.this, error, Toast.LENGTH_LONG).show();
        }
    }
}
