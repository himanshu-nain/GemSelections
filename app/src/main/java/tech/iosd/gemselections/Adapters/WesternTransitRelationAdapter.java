package tech.iosd.gemselections.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.ResponseModels.House;
import tech.iosd.gemselections.Retrofit.ResponseModels.TransitRelation;

/**
 * Created by anubhavmalik on 02/04/18.
 */

public class WesternTransitRelationAdapter extends RecyclerView.Adapter<WesternTransitRelationAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<TransitRelation> obList;

    public WesternTransitRelationAdapter(Context mContext, ArrayList<TransitRelation> obList) {
        this.mContext = mContext;
        this.obList = obList;
    }

    @Override
    public WesternTransitRelationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WesternTransitRelationAdapter
                .MyViewHolder(LayoutInflater
                .from(mContext)
                .inflate(R.layout.western_transit_relation_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final WesternTransitRelationAdapter.MyViewHolder holder, final int position) {

        if (obList.get(position).getTransitPlanet() == null) holder.transitPlanet.setText("Transit Planet : ");
        else holder.transitPlanet.setText(("Transit Planet : " + obList.get(position).getTransitPlanet()));

        if ((String.valueOf(obList.get(position).getNatalPlanet())) == null)
            holder.natalPlanet.setText("Natal Planet : ");
        else
            holder.natalPlanet.setText("Natal Planet : " + obList.get(position).getNatalPlanet() + "");


        if (String.valueOf(obList.get(position).getType()) == null)
            holder.type.setText("Type : ");
        else
            holder.type.setText("Type : " + (obList.get(position).getType()) + "");

        if (String.valueOf(obList.get(position).getOrb()) == null)
            holder.orb.setText("Orb : ");
        else
            holder.orb.setText("Orb : " + (obList.get(position).getOrb()) + "");

    }

    @Override
    public int getItemCount() {
        return obList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView transitPlanet, natalPlanet, type, orb;

        MyViewHolder(final View itemView) {
            super(itemView);

            transitPlanet = itemView.findViewById(R.id.western_transit_planet_text_view);
            natalPlanet = itemView.findViewById(R.id.western_transit_natal_planet_text_view);
            type = itemView.findViewById(R.id.western_transit_type_text_view);
            orb = itemView.findViewById(R.id.western_transit_orb_text_view);


        }
    }
}
