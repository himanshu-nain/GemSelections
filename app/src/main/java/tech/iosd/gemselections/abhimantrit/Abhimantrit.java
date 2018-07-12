package tech.iosd.gemselections.abhimantrit;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import tech.iosd.gemselections.Emerald.EmeraldActivity;
import tech.iosd.gemselections.Gomed.GomedActivity;
import tech.iosd.gemselections.Lehsunia.LehsuniaActivity;
import tech.iosd.gemselections.MoongaActivity;
import tech.iosd.gemselections.Neelam.NeelamActivity;
import tech.iosd.gemselections.Pukhraj.BainganiPukhraj;
import tech.iosd.gemselections.Pukhraj.GulabiPukhraj;
import tech.iosd.gemselections.Pukhraj.HaraPukhraj;
import tech.iosd.gemselections.Pukhraj.PitambariNeelam;
import tech.iosd.gemselections.Pukhraj.PukhrajActivity;
import tech.iosd.gemselections.Pukhraj.SafedPukhraj;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Ruby.RubyActivity;
import tech.iosd.gemselections.SemiPreciousGems.MotiActivity;
import tech.iosd.gemselections.Utils.WebViewActivity;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class Abhimantrit extends Fragment implements View.OnClickListener {


    private  ImageView panna,neelam,pukhraj;
    private static final String DEVELOPER_KEY = "AIzaSyBKlHdEkS-X7Vb2mW2qQSlF1TOxKzWpSU8";
    private static final int RECOVERY_REQUEST = 1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_abhimantrit, container, false);
        panna=view.findViewById(R.id.abhi_panna);
        neelam=view.findViewById(R.id.abhi_neelam);
        pukhraj=view.findViewById(R.id.abhi_pukhraj);
        panna.setOnClickListener(this);
        neelam.setOnClickListener(this);
        pukhraj.setOnClickListener(this);
        InputStream is;
        try {
            is = getActivity().getAssets().open("images/abhi_neelam.PNG");
            neelam.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/abhi_panna.PNG");
            panna.setImageBitmap(BitmapFactory.decodeStream(is));
            is = getActivity().getAssets().open("images/abhi_pukhraj.PNG");
            pukhraj.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
//        panna.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//              Toast.makeText(getContext(),"Panna clicked",Toast.LENGTH_SHORT);
//              Intent i=new Intent(getActivity(),Panna.class);
//              i.putExtra("V",1);
//              startActivity(i);
//            }
//        });
//        neelam.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(getContext(),"Neelam clicked",Toast.LENGTH_SHORT);
//                Intent i=new Intent(getContext(),Panna.class);
//                i.putExtra("V",2);
//                startActivity(i);
//
//            }
//        });
//        pukhraj.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(getContext(),"Pukhraj clicked",Toast.LENGTH_SHORT);
//                Intent i=new Intent(getActivity(),Panna.class);
//                i.putExtra("V",3);
//                startActivity(i);
//            }
//        });
        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Abhimantarit");
    }


    @Override
    public void onClick(View view) {


    }
}
