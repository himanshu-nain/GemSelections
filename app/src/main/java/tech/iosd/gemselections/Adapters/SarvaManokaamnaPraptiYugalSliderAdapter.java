package tech.iosd.gemselections.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import tech.iosd.gemselections.MainContent.ModelSarvaManokaamnaPraptiYugalSlider;
import tech.iosd.gemselections.R;

/**
 * Created by kushalgupta on 24/02/18.
 */

public class SarvaManokaamnaPraptiYugalSliderAdapter extends RecyclerView.Adapter<SarvaManokaamnaPraptiYugalSliderAdapter.MyViewHolder>  {
    private ArrayList<ModelSarvaManokaamnaPraptiYugalSlider> obList;
    private LayoutInflater inflater;

    public SarvaManokaamnaPraptiYugalSliderAdapter(Context c, ArrayList<ModelSarvaManokaamnaPraptiYugalSlider> obList) {
        inflater = LayoutInflater.from(c);
        this.obList=obList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_sarva_manokaamna_prapti_yugal, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
       ModelSarvaManokaamnaPraptiYugalSlider modelSarvaManokaamnaPraptiYugalSlider = obList.get(position);
        holder.setData(modelSarvaManokaamnaPraptiYugalSlider, position);

    }

    @Override
    public int getItemCount() {
        return obList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
       private ImageView iv;
       private ModelSarvaManokaamnaPraptiYugalSlider modelSarvaManokaamnaPraptiYugalSlider;
       private int position;
        public MyViewHolder(View itemView) {
            super(itemView);
            iv=(ImageView) itemView.findViewById(R.id.manokaamna_image_slider);
        }

        public void setData(ModelSarvaManokaamnaPraptiYugalSlider modelSarvaManokaamnaPraptiYugalSlider, int position) {

            this.iv.setImageResource(modelSarvaManokaamnaPraptiYugalSlider.getSliderImage());

            this.modelSarvaManokaamnaPraptiYugalSlider = modelSarvaManokaamnaPraptiYugalSlider;
            this.position=position;
        }
    }
}
