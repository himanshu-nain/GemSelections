package tech.iosd.gemselections.MainContent;


import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import tech.iosd.gemselections.Adapters.SarvaManokaamnaPraptiYugalSliderAdapter;
import tech.iosd.gemselections.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SarvaManokaamnaPraptiYugal extends Fragment {
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;
    private TextView textView;
    private YouTubePlayer YPlayer;


    public SarvaManokaamnaPraptiYugal() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sarva_manokaamna_prapti_yugal, container, false);
        textView = view.findViewById(R.id.yuText);
        String content = "1. Get all your desires fulfilled." + "\n" +
                " 2. Overcome all the troubles in your life." + "\n" +
                " 3. Get blessings of Lord Shiva.\n" +
                " 4. Empower Jupiter (brahaspati) in your Horoscope.\n";

        textView.setText(content
        );
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.yugal_slider_recycler);
        SarvaManokaamnaPraptiYugalSliderAdapter aadapter = new SarvaManokaamnaPraptiYugalSliderAdapter(SarvaManokaamnaPraptiYugal.this.getActivity(), ModelSarvaManokaamnaPraptiYugalSlider.getObList());
        recyclerView.setAdapter(aadapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(SarvaManokaamnaPraptiYugal.this.getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        youTubePlayerFragment.initialize(DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

                if (!wasRestored) {
                    YPlayer = player;
                    YPlayer.cueVideo("T_lWZcwEvjI");
                    YPlayer.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
                        @Override
                        public void onFullscreen(boolean b) {
                            if (!b) {
                                //YPlayer.setFullscreen(false);
                                if (getActivity().getResources().getConfiguration().orientation != Configuration.ORIENTATION_PORTRAIT) {
                                    getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                                }
                            }
                        }
                    });
                }

            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {
                if (arg1.isUserRecoverableError()) {
                    arg1.getErrorDialog(getActivity(), RECOVERY_REQUEST).show();
                } else {
                    String error = String.format(getString(tech.iosd.gemselections.R.string.player_error), arg1.toString());
                    Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
                }
            }
        });
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.add(R.id.yugal_vid, youTubePlayerFragment).commit();


        return view;


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Sarva Mannokaamna Prapti Yugal");
    }

}


