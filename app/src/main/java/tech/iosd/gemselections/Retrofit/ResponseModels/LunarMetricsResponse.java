package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class LunarMetricsResponse {
    @SerializedName("month")
    @Expose
    private String month;
    @SerializedName("within_perigee_range")
    @Expose
    private String withinPerigeeRange;
    @SerializedName("distance")
    @Expose
    private String distance;
    @SerializedName("within_apogee_range")
    @Expose
    private String withinApogeeRange;
    @SerializedName("apogee_distance")
    @Expose
    private String apogeeDistance;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getWithinPerigeeRange() {
        return withinPerigeeRange;
    }

    public void setWithinPerigeeRange(String withinPerigeeRange) {
        this.withinPerigeeRange = withinPerigeeRange;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getWithinApogeeRange() {
        return withinApogeeRange;
    }

    public void setWithinApogeeRange(String withinApogeeRange) {
        this.withinApogeeRange = withinApogeeRange;
    }

    public String getApogeeDistance() {
        return apogeeDistance;
    }

    public void setApogeeDistance(String apogeeDistance) {
        this.apogeeDistance = apogeeDistance;
    }
}
