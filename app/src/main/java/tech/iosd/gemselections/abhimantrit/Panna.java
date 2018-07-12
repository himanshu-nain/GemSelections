package tech.iosd.gemselections.abhimantrit;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnFullscreenListener;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

import tech.iosd.gemselections.R;

public class Panna
        extends YouTubeBaseActivity
        implements YouTubePlayer.OnInitializedListener
{
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;
    YouTubePlayerView playerView;
    private int x;

    public Panna() {}

    protected void onCreate(Bundle paramBundle)
    {
        super.onCreate(paramBundle);
        setContentView(R.layout.activity_panna);
        x = getIntent().getIntExtra("V", 1);
        playerView = ((YouTubePlayerView)findViewById(R.id.panna_video));
        playerView.initialize("AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8", this);
    }

    public void onInitializationFailure(YouTubePlayer.Provider paramProvider, YouTubeInitializationResult paramYouTubeInitializationResult)
    {
        if (paramYouTubeInitializationResult.isUserRecoverableError())
        {
            paramYouTubeInitializationResult.getErrorDialog(this, 1).show();
            return;
        }
    }

    public void onInitializationSuccess(YouTubePlayer.Provider paramProvider, YouTubePlayer paramYouTubePlayer, boolean paramBoolean)
    {
        if (!paramBoolean)
        {

            if (x == 1) {
                paramYouTubePlayer.cueVideo("QcjlAmjn_-U");
            } else if (x == 2) {
                paramYouTubePlayer.cueVideo("Pu_NqgEa0TQ");
            } else if (x == 3) {
                paramYouTubePlayer.cueVideo("Kt99XEBQ3pw");
            }
            paramYouTubePlayer.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener()
            {
                public void onFullscreen(boolean paramAnonymousBoolean)
                {
                    if ((!paramAnonymousBoolean) && (getResources().getConfiguration().orientation != 1)) {
                        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                    }
                }
            });
        }
    }
}
