package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Total {

    @SerializedName("total_points")
    @Expose
    private int totalPoints;
    @SerializedName("received_points")
    @Expose
    private int receivedPoints;
    @SerializedName("minimum_required")
    @Expose
    private int minimumRequired;

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getReceivedPoints() {
        return receivedPoints;
    }

    public void setReceivedPoints(int receivedPoints) {
        this.receivedPoints = receivedPoints;
    }

    public int getMinimumRequired() {
        return minimumRequired;
    }

    public void setMinimumRequired(int minimumRequired) {
        this.minimumRequired = minimumRequired;
    }

}