package tech.iosd.gemselections.JewelleryAlpha.GemStudded;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
import tech.iosd.gemselections.JewelleryAlpha.Diamond.DiamondActivity;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.Banner;

/**
 * Created by anonymous on 28/8/17.
 */

public class GemStuddedActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private String[] items = {"Gem-Studded Sets", "Gem-Studded Pendants", "Gem-Studded Tops", "Gem-Studded Rings", "Gem-Studded Bracelets"};

    private YouTubePlayerView playerView;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gemstudded);

        playerView = (YouTubePlayerView)findViewById(R.id.gemstudded_video);
        playerView.initialize(DEVELOPER_KEY, this);

        ArrayList<Banner> arraylist = new ArrayList<Banner>();

        arraylist.add(new Banner( getDrawable(R.drawable.gem_studded_sets),"Gem-Studded Sets"));
        arraylist.add(new Banner( getDrawable(R.drawable.gem_studded_pendants),"Gem-Studded Pendants"));
        arraylist.add(new Banner( getDrawable(R.drawable.gem_studded_tops),"Gem-Studded Tops"));
        arraylist.add(new Banner( getDrawable(R.drawable.gem_studded_rings),"Gem-Studded Rings"));
        arraylist.add(new Banner( getDrawable(R.drawable.gem_studded_bracelets),"Gem-Studded Bracelets"));


        GridView listView = (GridView) findViewById(R.id.gemstudded_list);
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(GemStuddedActivity.this, android.R.layout.simple_list_item_1, items);
        BannerArrayAdapter arrayAdapter= new  BannerArrayAdapter(this,arraylist);
        listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){

                    case 0:

                        startActivity(new Intent(
                                GemStuddedActivity.this, GemStuddedSets.class
                        ));

                        break;

                    case 1:

                        startActivity(new Intent(
                                GemStuddedActivity.this, GemStuddedPendants.class
                        ));

                        break;

                    case 2:

                        startActivity(new Intent(
                                GemStuddedActivity.this, GemStuddedTops.class
                        ));

                        break;

                    case 3:

                        startActivity(new Intent(
                                GemStuddedActivity.this, GemStuddedRings.class
                        ));

                        break;

                    case 4:

                        startActivity(new Intent(
                                GemStuddedActivity.this, GemStuddedBracelet.class
                        ));

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
            youTubePlayer.cueVideo("1k7gaSAvbiU");
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
            youTubeInitializationResult.getErrorDialog(GemStuddedActivity.this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(GemStuddedActivity.this, error, Toast.LENGTH_LONG).show();
        }
    }
}
