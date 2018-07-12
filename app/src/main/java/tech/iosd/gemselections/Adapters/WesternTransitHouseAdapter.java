package tech.iosd.gemselections.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.ResponseModels.TransitHouses;

/**
 * Created by anubhavmalik on 02/04/18.
 */

public class WesternTransitHouseAdapter extends RecyclerView.Adapter<WesternTransitHouseAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<TransitHouses> obList;

    public WesternTransitHouseAdapter(Context mContext, ArrayList<TransitHouses> obList) {
        this.mContext = mContext;
        this.obList = obList;
    }

    @Override
    public WesternTransitHouseAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WesternTransitHouseAdapter.MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.western_transit_house_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final WesternTransitHouseAdapter.MyViewHolder holder, final int position) {

        if (obList.get(position).getPlanet() == null) holder.planetTextView.setText("Planet : ");
        else holder.planetTextView.setText(("Planet : " + obList.get(position).getPlanet()));

        if ((String.valueOf(obList.get(position).getNatalSign())) == null)
            holder.natalSignTextView.setText("Natal Sign : ");
        else
            holder.natalSignTextView.setText("Natal Sign : " + obList.get(position).getNatalSign() + "");

        if (String.valueOf(obList.get(position).getTransitHouse()) == null)
            holder.transitHouseTextView.setText("Transit House : ");
        else
            holder.transitHouseTextView.setText("Transit House : " + (obList.get(position).getTransitHouse()) + "");

        if (String.valueOf(obList.get(position).getIsRetrograde()) == null)
            holder.retrogradeTextView.setText("Retrograde : ");
        else
            holder.retrogradeTextView.setText("Retrograde : " + (obList.get(position).getIsRetrograde()) + "");

    }

    @Override
    public int getItemCount() {
        return obList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView planetTextView, natalSignTextView, transitHouseTextView, retrogradeTextView;

        MyViewHolder(final View itemView) {
            super(itemView);

            planetTextView = itemView.findViewById(R.id.western_transit_house_planet_text_view);
            natalSignTextView = itemView.findViewById(R.id.western_transit_house_natal_sign_text_view);
            transitHouseTextView = itemView.findViewById(R.id.western_transit_house_transit_house_text_view);
            retrogradeTextView = itemView.findViewById(R.id.western_transit_house_is_retrograde_text_view);

        }
    }
}
