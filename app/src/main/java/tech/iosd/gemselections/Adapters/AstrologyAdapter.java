/**
 * Created by anubhavmalik on 26/03/18.
 */


package tech.iosd.gemselections.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tech.iosd.gemselections.JewelleryAlpha.GemStudded.GemStuddedActivity;
import tech.iosd.gemselections.JewelleryAlpha.Victorian.VictorianActivity;
import tech.iosd.gemselections.MainContent.DailyHoroscopeActivity;
import tech.iosd.gemselections.MainContent.IndianAstrologyActivity;
import tech.iosd.gemselections.MainContent.MatchMakingActivity;
import tech.iosd.gemselections.MainContent.PdfHoroscopeActivity;
import tech.iosd.gemselections.MainContent.WesternAstrologyActivity;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.Banner;

/**
 * Created by anubhav on 26/3/18.
 */

public class AstrologyAdapter extends RecyclerView.Adapter<tech.iosd.gemselections.Adapters.AstrologyAdapter.ViewHolder> {

    private Context context;
    private List<Banner> typesList;

    public AstrologyAdapter(Context context, List<Banner> typesList) {
        this.context = context;
        this.typesList = typesList;
    }

    @Override
    public tech.iosd.gemselections.Adapters.AstrologyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_banner, parent, false);
        return new tech.iosd.gemselections.Adapters.AstrologyAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(tech.iosd.gemselections.Adapters.AstrologyAdapter.ViewHolder holder, int position) {
        holder.text.setText(typesList.get(position).getName());
        holder.mainImage.setImageDrawable(typesList.get(position).getMainImage());
        holder.mainImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        final int pos = position;
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (pos) {
                    case 0:
                        context.startActivity(new Intent(context, MatchMakingActivity.class));
                        break;
                    case 1:
                        context.startActivity(new Intent(context, WesternAstrologyActivity.class));
                        break;
                    case 2:
                        context.startActivity(new Intent(context, DailyHoroscopeActivity.class));
                        break;
                    case 3:
                        context.startActivity(new Intent(context, IndianAstrologyActivity.class));
                        break;
                    case 4:
                        context.startActivity(new Intent(context, PdfHoroscopeActivity.class));
                        break;
                    default:
                        Log.e("Jewel Types", "Wrong item clicked");
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return typesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView text;
        private ImageView mainImage;
        private CardView linearLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.banner_name_tv);
            mainImage = itemView.findViewById(R.id.banner_main_image);
            linearLayout = itemView.findViewById(R.id.banner_cv);
        }
    }
}


