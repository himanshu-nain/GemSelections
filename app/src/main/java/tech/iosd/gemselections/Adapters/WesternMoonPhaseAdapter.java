package tech.iosd.gemselections.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.ResponseModels.MoonPhase;

/**
 * Created by anubhavmalik on 03/04/18.
 */

public class WesternMoonPhaseAdapter extends RecyclerView.Adapter<WesternMoonPhaseAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<MoonPhase> obList;

    public WesternMoonPhaseAdapter(Context mContext, ArrayList<MoonPhase> obList) {
        this.mContext = mContext;
        this.obList = obList;
    }

    @Override
    public WesternMoonPhaseAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WesternMoonPhaseAdapter.MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.western_moon_phase_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final WesternMoonPhaseAdapter.MyViewHolder holder, final int position) {

        if (obList.get(position).getPhaseType() == null) holder.phaseType.setText("Phase : ");
        else holder.phaseType.setText(("Phase : " + obList.get(position).getPhaseType()));

        if ((String.valueOf(obList.get(position).getDate())) == null)
            holder.date.setText("Date : ");
        else
            holder.date.setText("Date : " + obList.get(position).getDate() + "");

        if (String.valueOf(obList.get(position).getSign()) == null)
            holder.sign.setText("Sign : ");
        else
            holder.sign.setText("Sign : " + (obList.get(position).getSign()) + "");

        if (String.valueOf(obList.get(position).getHouse()) == null)
            holder.house.setText("House : ");
        else
            holder.house.setText("House : " + (obList.get(position).getHouse()) + "");

    }

    @Override
    public int getItemCount() {
        return obList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView phaseType, date, sign, house;

        MyViewHolder(final View itemView) {
            super(itemView);

            phaseType = itemView.findViewById(R.id.western_horoscope_moon_phase_type_text_view);
            date = itemView.findViewById(R.id.western_horoscope_moon_phase_date_text_view);
            sign = itemView.findViewById(R.id.western_horoscope_moon_phase_sign_text_view);
            house = itemView.findViewById(R.id.western_horoscope_moon_phase_house_text_view);

        }
    }
}
