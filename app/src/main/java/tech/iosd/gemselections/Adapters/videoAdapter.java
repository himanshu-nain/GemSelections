package tech.iosd.gemselections.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import tech.iosd.gemselections.Astro_RemediesFragment;
import tech.iosd.gemselections.R;

/**
 * Created by Deepanshi Bansal on 26-01-2018.
 */

public class videoAdapter extends RecyclerView.Adapter<videoAdapter.VideoInfoHolder> {

    //these ids are the unique id for each video
    String[] VideoID = {"f7J8xIY4lMU", "bbzEEnHJSWs", "dqjWgQpkfrE","YkrABS9KCVc","xgfTETNpLfk","J3ow9VBpO_s","6L7OD0u6T0s","hx6I6jh0ess","BkgOKAJIw5M","92XT5Uhk2-A","MWf0T72Ch4c","6RIWj8tqr2Q","tno4pBs5p4M"};
    Context ctx;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";

    public videoAdapter(Context context) {
        this.ctx = context;
    }

    @Override
    public VideoInfoHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_remedies_video, parent, false);
        return new VideoInfoHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final VideoInfoHolder holder, final int position) {
        holder.episode.setText("Episode "+(position+1));
        holder.youTubeThumbnailView.initialize(DEVELOPER_KEY, new YouTubeThumbnailView.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, final YouTubeThumbnailLoader youTubeThumbnailLoader) {

                youTubeThumbnailLoader.setVideo(VideoID[position]);
                youTubeThumbnailLoader.setOnThumbnailLoadedListener(new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                    @Override
                    public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                        youTubeThumbnailLoader.release();
                        youTubeThumbnailView.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

                    }
                });
            }

            @Override
            public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
            }
        });
        holder.youTubeThumbnailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity) ctx, DEVELOPER_KEY, VideoID[position]);
                ((Activity) ctx).startActivityForResult(intent,0);
            }
        });
    }

    @Override
    public int getItemCount() {
        return VideoID.length;
    }

    public class VideoInfoHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        YouTubeThumbnailView youTubeThumbnailView;
        TextView episode;

        public VideoInfoHolder(View itemView) {
            super(itemView);
            youTubeThumbnailView = (YouTubeThumbnailView) itemView.findViewById(R.id.youtube_thumbnail);
            episode=itemView.findViewById(R.id.episode);


        }

        @Override
        public void onClick(View v) {
            Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity) ctx, DEVELOPER_KEY, VideoID[getLayoutPosition()]);
            ctx.startActivity(intent);
        }
    }
}