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

/**
 * Created by anubhavmalik on 30/03/18.
 */

public class WesternChartHouseAdapter extends RecyclerView.Adapter<WesternChartHouseAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<House> obList;

    public WesternChartHouseAdapter(Context mContext, ArrayList<House> obList) {
        this.mContext = mContext;
        this.obList = obList;
    }

    @Override
    public WesternChartHouseAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new WesternChartHouseAdapter.MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.western_chart_house_item, parent, false));
    }

    @Override
    public void onBindViewHolder(final WesternChartHouseAdapter.MyViewHolder holder, final int position) {

        if (obList.get(position).getSign() == null) holder.signTextView.setText("Sign : ");
        else holder.signTextView.setText(("Sign : " + obList.get(position).getSign()));

        if ((String.valueOf(obList.get(position).getStartDegree())) == null)
            holder.startDegreeTextView.setText("Start Degree : ");
        else
            holder.startDegreeTextView.setText("Start Degree : " + obList.get(position).getHouse() + "");

        Log.d("TAGGER", obList.get(position).getHouse() + "");

        if (String.valueOf(obList.get(position).getDegree()) == null)
            holder.endDegreeTextView.setText("End Degree : ");
        else
            holder.endDegreeTextView.setText("End Degree : " + (obList.get(position).getDegree()) + "");

    }

    @Override
    public int getItemCount() {
        return obList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView startDegreeTextView, endDegreeTextView, signTextView;

        MyViewHolder(final View itemView) {
            super(itemView);

            startDegreeTextView = itemView.findViewById(R.id.western_chart_start_degree_text_view);
            endDegreeTextView = itemView.findViewById(R.id.western_chart_end_degree_text_view);
            signTextView = itemView.findViewById(R.id.western_chart_sign_text_view);

        }
    }
}
