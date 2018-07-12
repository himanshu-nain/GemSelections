package tech.iosd.gemselections.Rudraksha;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import tech.iosd.gemselections.MainContent.FAQsActivity;
import tech.iosd.gemselections.R;

import static tech.iosd.gemselections.MainContent.FAQsActivity.DEVELOPER_KEY;

public class YoutubeDialogActivity extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener {

    YouTubePlayerView playerView;
    public String link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.youtube_player_dialog_activity);
        Bundle extras = getIntent().getExtras();
        playerView = findViewById(R.id.rudraksha_video);
        playerView.initialize(DEVELOPER_KEY, this);
        int content = extras.getInt("string");
        link = extras.getString("link");
        Log.e("Error77",link+getString(content));
        TextView showdetail,title;
        showdetail = findViewById(R.id.info_text);
        title = findViewById(R.id.title);
        showdetail.setText(content);
        title.setText(extras.getString("title"));
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
            youTubeInitializationResult.getErrorDialog(YoutubeDialogActivity.this, FAQsActivity.RECOVERY_REQUEST).show();
        }
        else {
            String error = String.format(getString(tech.iosd.gemselections.R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }
}