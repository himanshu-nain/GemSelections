package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/lunar_metrics
public class LunarMetricsHoroscopeResponse {
    @SerializedName("month")
    @Expose
    private String month;
    @SerializedName("within_perigee_range")
    @Expose
    private boolean withinPerigeeRange;
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("within_apogee_range")
    @Expose
    private boolean withinApogeeRange;
    @SerializedName("apogee_distance")
    @Expose
    private String apogeeDistance;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public boolean isWithinPerigeeRange() {
        return withinPerigeeRange;
    }

    public void setWithinPerigeeRange(boolean withinPerigeeRange) {
        this.withinPerigeeRange = withinPerigeeRange;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public boolean isWithinApogeeRange() {
        return withinApogeeRange;
    }

    public void setWithinApogeeRange(boolean withinApogeeRange) {
        this.withinApogeeRange = withinApogeeRange;
    }

    public String getApogeeDistance() {
        return apogeeDistance;
    }

    public void setApogeeDistance(String apogeeDistance) {
        this.apogeeDistance = apogeeDistance;
    }
}
