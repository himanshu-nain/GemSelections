package tech.iosd.gemselections.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.ResponseModels.Aspect;

/**
 * Created by anubhavmalik on 27/03/18.
 */

public class WesternHoroscopeAspectAdapter extends RecyclerView.Adapter<WesternHoroscopeAspectAdapter.MyViewHolder>
{
    private Context mContext;
    private ArrayList<Aspect> obList;

    public WesternHoroscopeAspectAdapter(Context mContext, ArrayList<Aspect> obList)
    {
        this.mContext = mContext;
        this.obList = obList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.western_horoscope_aspect_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position)
    {
        if (obList.get(position).getAspectedPlanet() == null) holder.aspectedTextView.setText("Aspected : ");
        else holder.aspectedTextView.setText("Aspected : " +obList.get(position).getAspectedPlanet());

        if (obList.get(position).getAspectingPlanet() == null) holder.aspectingTextView.setText("Aspecting : ");
        else holder.aspectingTextView.setText(("Aspecting : "+ obList.get(position).getAspectingPlanet()));

        if((String.valueOf(obList.get(position).getDiff()))==null) holder.aspectDifferenceTextView.setText("");
        else holder.aspectDifferenceTextView.setText("Diff : " + obList.get(position).getDiff());

        if (String.valueOf(obList.get(position).getOrb())==null) holder.aspectOrbTextView.setText("");
        else holder.aspectOrbTextView.setText(("Orb : " + obList.get(position).getOrb()));

        if(obList.get(position).getType()==null) holder.aspectTypeTextView.setText("Type : ");
        else holder.aspectTypeTextView.setText("Type : " + obList.get(position).getType());
    }

    @Override
    public int getItemCount() {
        return obList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView aspectingTextView, aspectedTextView, aspectDifferenceTextView, aspectOrbTextView, aspectTypeTextView;

        MyViewHolder(final View itemView)
        {
            super(itemView);

            aspectingTextView = itemView.findViewById(R.id.western_horoscope_item_aspect_aspecting);
            aspectedTextView = itemView.findViewById(R.id.western_horoscope_item_aspect_aspected);
            aspectDifferenceTextView = itemView.findViewById(R.id.western_horoscope_item_aspect_diff);
            aspectOrbTextView = itemView.findViewById(R.id.western_horoscope_item_aspect_orb);
            aspectTypeTextView = itemView.findViewById(R.id.western_horoscope_item_aspect_type);

        }
    }
}