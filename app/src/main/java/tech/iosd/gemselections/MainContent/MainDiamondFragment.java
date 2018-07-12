package tech.iosd.gemselections.MainContent;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.io.IOException;
import java.io.InputStream;

import tech.iosd.gemselections.JewelleryAlpha.JewelleryAlpha;
import tech.iosd.gemselections.R;

/**
 * Created by anonymous on 27/6/17.
 */

public class MainDiamondFragment extends Fragment {

    private ImageView banner, ring, loose;

    private YouTubePlayer YPlayer;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(tech.iosd.gemselections.R.layout.frag_main_diamond, container, false);

        ScrollView scrollView = (ScrollView)view.findViewById(tech.iosd.gemselections.R.id.scroll);
        scrollView.setBackground(getResources().getDrawable(tech.iosd.gemselections.R.drawable.back));
        CardView solitareRing = (CardView) view.findViewById(R.id.diamond_solitare_ring);
        CardView looseSolitare = (CardView)view.findViewById(R.id.diamond_loose_solitare);

        solitareRing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        getActivity().getApplicationContext(), JewelleryAlpha.class
                ));
            }
        });

        looseSolitare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(
                        getActivity().getApplicationContext(),NewWebView.class
                ));
            }
        });
        banner = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.diamond_banner);
        ring = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.diamondring);
        loose = (ImageView)view.findViewById(tech.iosd.gemselections.R.id.diamond);
        try {
            InputStream is;
            is= getActivity().getAssets().open("images/Heera-stone.jpg");
            banner.setImageBitmap(BitmapFactory.decodeStream(is));
            is= getActivity().getAssets().open("images/Solitaire-Rings.jpg");
            ring.setImageBitmap(BitmapFactory.decodeStream(is));
            is= getActivity().getAssets().open("images/Loose-Solitair.jpg");
            loose.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }

        YouTubePlayerSupportFragment youTubePlayerFragment = YouTubePlayerSupportFragment.newInstance();

        youTubePlayerFragment.initialize(DEVELOPER_KEY, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player, boolean wasRestored) {

                if (!wasRestored) {
                    YPlayer = player;
                    YPlayer.cueVideo("TCWMjYKcvpY");
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
        transaction.add(tech.iosd.gemselections.R.id.diamond_video, youTubePlayerFragment).commit();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getActivity().setTitle("Diamonds");
    }
}
