package tech.iosd.gemselections.Lehsunia;

import android.app.Fragment;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import tech.iosd.gemselections.R;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by anonymous on 29/6/17.
 */

public class PrehniteCatsEye extends Fragment {

    private ImageView img;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_prehnite_catseye, container, false);
        img = (ImageView)view.findViewById(R.id.img_prehnite_catseye);
        try{
            InputStream is = getActivity().getAssets().open("images/precious-gems/gems/prehnite-cats-eye.jpg");
            img.setImageBitmap(BitmapFactory.decodeStream(is));
        }catch (IOException e){
            e.printStackTrace();
        }
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
