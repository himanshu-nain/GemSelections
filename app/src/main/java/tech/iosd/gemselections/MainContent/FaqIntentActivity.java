package tech.iosd.gemselections.MainContent;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import tech.iosd.gemselections.R;

import static tech.iosd.gemselections.MainContent.FAQsActivity.DEVELOPER_KEY;

public class FaqIntentActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener{
    YouTubePlayerView playerView;
    public String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq_intent_acitivity);
        TextView title, text;
        title = findViewById(R.id.faq_intent_tittle);
        text = findViewById(R.id.faq_intent_text);
        Bundle extras = getIntent().getExtras();
        playerView = findViewById(R.id.questions_video);
        playerView.initialize(DEVELOPER_KEY, this);
        title.setText(getResources().getString(extras.getInt("title")));
        text.setText(getResources().getString(extras.getInt("text")));
        link = (getResources().getString(extras.getInt("link")));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == FAQsActivity.RECOVERY_REQUEST)
            getYouTubePlayerProvider().initialize(FAQsActivity.DEVELOPER_KEY, this);
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return playerView;
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b){
            youTubePlayer.cueVideo(link);
            Log.e("Posting link",link+" ");
            youTubePlayer.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
                @Override
                public void onFullscreen(boolean b) {
                    if(!b){
                        //youTubePlayer.setFullscreen(false);
                        if(getResources().getConfiguration().orientation != Configuration.ORIENTATION_PORTRAIT)
                            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    }
                }
            });
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(FaqIntentActivity.this, FAQsActivity.RECOVERY_REQUEST).show();
        }
        else {
            String error = String.format(getString(tech.iosd.gemselections.R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(FaqIntentActivity.this, error, Toast.LENGTH_LONG).show();
        }
    }
}
