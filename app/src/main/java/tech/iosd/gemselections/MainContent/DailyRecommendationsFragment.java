package tech.iosd.gemselections.MainContent;

import android.app.ProgressDialog;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import tech.iosd.gemselections.Models.DailyRecommendationModel;
import tech.iosd.gemselections.R;

/**
 * Created by anubhavmalik on 03/03/18.
 */

public class DailyRecommendationsFragment extends Fragment{

    private DatabaseReference mDatabase;
    private YouTubePlayer YPlayer;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    DailyRecommendationModel dailyRecommendationModel;
    YouTubePlayerSupportFragment youTubePlayerFragment;
    TextView titleTextView;
    TextView detailTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        final ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.setCancelable(true);
        progressDialog.setTitle("Loading ...");
        progressDialog.setMessage("Fetching the latest details for you...");
        progressDialog.show();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        View view = inflater.inflate(R.layout.frag_daily_recommendations_layout,container,false);

        titleTextView = view.findViewById(R.id.daily_recommendation_title);
        detailTextView = view.findViewById(R.id.daily_recommendation_detail);


        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date();
        String dayOfTheWeek = sdf.format(d);
        String day = dayOfTheWeek;

//        Log.d("DAYOFWEEK",day);

        mDatabase.child("dailyrecommendation")
                .child(day.toLowerCase())
                .addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dailyRecommendationModel = dataSnapshot.getValue(DailyRecommendationModel.class);
                PopulateData(dailyRecommendationModel);
                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
//                Log.d("FIREBASEERROR","Failed : "+databaseError.getMessage());
            }
        });

        youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        return view;
    }

    private void PopulateData(final DailyRecommendationModel dailyRecommendationModel) {
        youTubePlayerFragment.initialize(DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                if(!b){
                YPlayer = youTubePlayer;
                YPlayer.cueVideo(dailyRecommendationModel.getLink());
                    YPlayer.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
                        @Override
                        public void onFullscreen(boolean b) {
                            if(!b){
                                //YPlayer.setFullscreen(false);
                                if(getActivity().getResources().getConfiguration().orientation != Configuration.ORIENTATION_PORTRAIT)
                                {
                                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                                }
                            }
                        }
                    });
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        });
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.youtube_container, youTubePlayerFragment).commit();

//        Log.d("DAILYRECO","TITLE : "+dailyRecommendationModel.getTitle());
//
//        Log.d("DAILYRECO","DETAIL : "+dailyRecommendationModel.getDetails());

        titleTextView.setText(dailyRecommendationModel.getTitle());
        detailTextView.setText(dailyRecommendationModel.getDetails());

    }
}
