package tech.iosd.gemselections.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.ResponseModels.House;

/**
 * Created by anubhavmalik on 27/03/18.
 */

public class WesternHoroscopeHouseAdapter extends RecyclerView.Adapter<WesternHoroscopeHouseAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<House> obList;

    public WesternHoroscopeHouseAdapter(Context mContext, ArrayList<House> obList) {
        this.mContext = mContext;
        this.obList = obList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.western_horoscope_house_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {

        if (obList.get(position).getSign() == null) holder.signTextView.setText("Sign : ");
        else holder.signTextView.setText(("Sign : " + obList.get(position).getSign()));

        if (String.valueOf(obList.get(position).getHouse()) == null || obList.get(position).getHouse() == 0 )
            holder.houseTextView.setText("House : ");
        else holder.houseTextView.setText("House : " + obList.get(position).getHouse());

//        if (String.valueOf(obList.get(position).getEndDegree()) == null || obList.get(position).getEndDegree() == 0)
//            holder.houseTextView.setText("End Degree : 0");
//        else holder.houseTextView.setText("End Degree : " + obList.get(position).getHouse());

        if (String.valueOf(obList.get(position).getDegree()) == null)
            holder.degreeTextView.setText("Degree : ");
        else holder.degreeTextView.setText("Degree : " + (obList.get(position).getDegree()));



    }

    @Override
    public int getItemCount() {
        return obList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView houseTextView, degreeTextView, signTextView;

        MyViewHolder(final View itemView) {
            super(itemView);

            houseTextView = itemView.findViewById(R.id.western_horoscope_item_house_degree);
            degreeTextView = itemView.findViewById(R.id.western_horoscope_item_house_house);
            signTextView = itemView.findViewById(R.id.western_horoscope_item_house_sign);

        }
    }
}
