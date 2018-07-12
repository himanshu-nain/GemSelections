package tech.iosd.gemselections.MainContent;

import android.os.Bundle;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

/**
 * Created by SAM33R on 23-03-2018.
 */

public class PlayerYouTubeFrag extends YouTubePlayerSupportFragment {
    private String currentVideoID = "video_id";
    private YouTubePlayer activePlayer;

    public static PlayerYouTubeFrag newInstance(String url) {
        PlayerYouTubeFrag playerYouTubeFrag = new PlayerYouTubeFrag();

        Bundle bundle = new Bundle();
        bundle.putString("url", url);

        playerYouTubeFrag.setArguments(bundle);

        return playerYouTubeFrag;
    }

    private void init() {
        initialize("AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8", new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
            }

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {
                activePlayer = player;
                activePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);
                if (!wasRestored) {
                    activePlayer.loadVideo(getArguments().getString("url"), 0);

                }
            }
        });
    }

   /* @Override
    public void onYouTubeVideoPaused() {
        activePlayer.pause();
    }*/
}