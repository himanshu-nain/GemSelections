package tech.iosd.gemselections.JewelleryAlpha;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

import tech.iosd.gemselections.Adapters.JewelTypesAdapter;
import tech.iosd.gemselections.DataProviders.JewelTypes;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.Banner;

/**
 * Created by anonymous on 19/8/17.
 */

public class JewelleryAlpha extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private String[] types = {"Create Your Own Jewellery", "Diamond Jewellery", "Victorian Jewellery","Gem-Studded Jewellery"}; //, "Silver Jewellery"};
    private String[] url = {"","","","",""};

    private RecyclerView recyclerView;
    private JewelTypesAdapter adapater;
    private List<Banner> typesList;

    private YouTubePlayerView playerView;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;

    private android.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_jewelleryalpha);

        toolbar = (android.widget.Toolbar)findViewById(R.id.jewel_toolbar);
        setActionBar(toolbar);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        playerView = (YouTubePlayerView)findViewById(R.id.jewellery_video);
        playerView.initialize(DEVELOPER_KEY, this);

        recyclerView = (RecyclerView)findViewById(R.id.jewel_types);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));

        recyclerView.setLayoutManager(new LinearLayoutManager(JewelleryAlpha.this));

        setData();
    }

    private void setData() {

        typesList = new ArrayList<>();
//        JewelTypes data;

        /*for(int i=0; i<types.length; ++i){
            data = new JewelTypes(types[i], url[i]);
            typesList.add(data);
        }*/

        typesList.add(new Banner( getDrawable(R.drawable.category_create_your_own_cewellery),"Create Your Own Jewellery"));
        typesList.add(new Banner( getDrawable(R.drawable.category_diamond_jewellery),"Diamond Jewellery"));
        typesList.add(new Banner( getDrawable(R.drawable.category_victorian_jewellery_),"Victorian Jewellery"));
        typesList.add(new Banner( getDrawable(R.drawable.category_gem_studded_jewellery),"Gem-Studded Jewellery"));
//        typesList.add(new Banner( getDrawable(R.drawable.category_gem_studded_jewellery),"Diamond Studded Jewellery"));


        adapater = new JewelTypesAdapter(JewelleryAlpha.this, typesList);
        recyclerView.setAdapter(adapater);

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
            youTubePlayer.cueVideo("ztD0h3PTkQc");
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
            youTubeInitializationResult.getErrorDialog(JewelleryAlpha.this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(JewelleryAlpha.this, error, Toast.LENGTH_LONG).show();
        }
    }
}