package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ascendant {

    @SerializedName("total")
    @Expose
    private int total;
    @SerializedName("dosha")
    @Expose
    private List<Dosha> dosha = null;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Dosha> getDosha() {
        return dosha;
    }

    public void setDosha(List<Dosha> dosha) {
        this.dosha = dosha;
    }
}