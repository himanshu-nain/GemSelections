package tech.iosd.gemselections.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.ResponseModels.SolarReturnPlanetsResponse;

/**
 * Created by anubhavmalik on 03/04/18.
 */

public class WesternSolarReturnPlanetAdapter extends RecyclerView.Adapter<WesternSolarReturnPlanetAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<SolarReturnPlanetsResponse> obList;

    public WesternSolarReturnPlanetAdapter(Context mContext, ArrayList<SolarReturnPlanetsResponse> obList) {
        this.mContext = mContext;
        this.obList = obList;
    }

    @Override
    public WesternSolarReturnPlanetAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WesternSolarReturnPlanetAdapter.MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.western_solar_return_planet_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final WesternSolarReturnPlanetAdapter.MyViewHolder holder, final int position) {

        if (obList.get(position).getName() == null)
            holder.name.append("");
        else
            holder.name.append(( obList.get(position).getName()));

        if ((String.valueOf(obList.get(position).getFullDegree())) == null)
            holder.fullDegree.append("");
        else
            holder.fullDegree.append(obList.get(position).getFullDegree()+"");

        if (String.valueOf(obList.get(position).getNormDegree()) == null)
            holder.normDegree.append("");
        else
            holder.normDegree.append((obList.get(position).getNormDegree()) + "");

        if (String.valueOf(obList.get(position).getSpeed()) == null)
            holder.speed.append("");
        else
            holder.speed.append((obList.get(position).getSpeed()) + "");

        if ((obList.get(position).isIsRetro()+"").equals(null))
            holder.retro.append("");
        else
            holder.retro.append((""+obList.get(position).isIsRetro()));

        if ((String.valueOf(obList.get(position).getSign())) == null)
            holder.sign.append("");
        else
            holder.sign.append(obList.get(position).getSign() + "");

        if (String.valueOf(obList.get(position).getHouse()) == null)
            holder.house.append("");
        else
            holder.house.append((obList.get(position).getHouse()) + "");

    }

    @Override
    public int getItemCount() {
        return obList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, fullDegree, normDegree, speed, retro, sign, house;

        MyViewHolder(final View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.western_solar_return_planet_name_text_view);
            fullDegree = itemView.findViewById(R.id.western_solar_return_planet_full_degree_text_view);
            normDegree = itemView.findViewById(R.id.western_solar_return_planet_norm_degree_text_view);
            speed = itemView.findViewById(R.id.western_solar_return_planet_speed_text_view);
            retro = itemView.findViewById(R.id.western_solar_return_planet_retro_text_view);
            sign = itemView.findViewById(R.id.western_solar_return_planet_sign_text_view);
            house = itemView.findViewById(R.id.western_solar_return_planet_house_text_view);
        }
    }
}
