package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Venus {

    @SerializedName("total")
    @Expose
    private double total;
    @SerializedName("dosha")
    @Expose
    private List<Dosha__> dosha = null;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Dosha__> getDosha() {
        return dosha;
    }

    public void setDosha(List<Dosha__> dosha) {
        this.dosha = dosha;
    }

}