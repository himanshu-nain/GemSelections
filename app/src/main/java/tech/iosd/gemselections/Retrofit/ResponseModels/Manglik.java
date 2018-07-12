package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Manglik {

    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("male_percentage")
    @Expose
    private double malePercentage;
    @SerializedName("female_percentage")
    @Expose
    private double femalePercentage;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public double getMalePercentage() {
        return malePercentage;
    }

    public void setMalePercentage(double malePercentage) {
        this.malePercentage = malePercentage;
    }

    public double getFemalePercentage() {
        return femalePercentage;
    }

    public void setFemalePercentage(double femalePercentage) {
        this.femalePercentage = femalePercentage;
    }

}