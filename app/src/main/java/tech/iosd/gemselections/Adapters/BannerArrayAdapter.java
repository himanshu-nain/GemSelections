package tech.iosd.gemselections.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.Banner;

/**
 * Created by SAM33R on 21-03-2018.
 */

public class BannerArrayAdapter extends ArrayAdapter<Banner> {
public BannerArrayAdapter(Context context, ArrayList<Banner> users) {
        super(context, 0, users);
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {

        Banner banner = getItem(position);

        if (convertView == null) {
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_banner, parent, false);
        }

        ImageView mainImage = (ImageView) convertView.findViewById(R.id.banner_main_image);
        TextView name = (TextView) convertView.findViewById(R.id.banner_name_tv);



        mainImage.setImageDrawable(banner.getMainImage());
        name.setText(banner.getName());

        return convertView;
        }
        }