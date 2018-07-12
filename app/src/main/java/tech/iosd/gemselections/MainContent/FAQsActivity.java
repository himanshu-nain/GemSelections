package tech.iosd.gemselections.MainContent;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import tech.iosd.gemselections.R;

public class FAQsActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private YouTubePlayerView playerView;
    public static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    public static final int RECOVERY_REQUEST = 1;
    public Resources r;
    private android.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tech.iosd.gemselections.R.layout.activity_faqs);
        r = getResources();
        int Number_of_Faqs = 16;
        for (int i = 1;i<(Number_of_Faqs*2);i+=2)
            initialise_faq(i);

        toolbar =  findViewById(R.id.faq_toolbar);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);

        playerView = findViewById(tech.iosd.gemselections.R.id.faq_video);
        playerView.initialize(DEVELOPER_KEY, this);

        ScrollView scrollView = (ScrollView)findViewById(tech.iosd.gemselections.R.id.faq_scroll);
        scrollView.setBackground(getResources().getDrawable(tech.iosd.gemselections.R.drawable.back));

    }
    //Function to initialise the faqs
    private void initialise_faq(final int i) {
        //Getting Layout id
        final String[] id = {"faq" + String.valueOf(i) + String.valueOf(i + 1)};
        int resId = r.getIdentifier(id[0], "id", getPackageName());
        LinearLayout linearLayout = findViewById(resId);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FAQsActivity.this,FaqIntentActivity.class);
                //Passing title, text and link to Faq bit activity
                id[0] = "faq"+String.valueOf(i);
                intent.putExtra("title", r.getIdentifier(id[0], "string", getPackageName()));
                id[0] = "faq"+String.valueOf(i+1);
                intent.putExtra("text" ,r.getIdentifier(id[0], "string", getPackageName()));
                id[0] = "faq"+String.valueOf(i)+"_link";
                intent.putExtra("link" ,r.getIdentifier(id[0], "string", getPackageName()));
                startActivity(intent);
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
            youTubePlayer.cueVideo("mdOWDD0YA7c");
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
            youTubeInitializationResult.getErrorDialog(FAQsActivity.this, RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(tech.iosd.gemselections.R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(FAQsActivity.this, error, Toast.LENGTH_LONG).show();
        }
    }
}