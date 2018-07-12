package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

public class Night {
    @SerializedName("start_time")
    private String startTime;
    @SerializedName("end_time")
    private String endTime;
    @SerializedName("start_hours")
    private double startHours;
    @SerializedName("end_hours")
    private double endHours;
    @SerializedName("activity")
    private String activity;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getStartHours() {
        return startHours;
    }

    public void setStartHours(double startHours) {
        this.startHours = startHours;
    }

    public double getEndHours() {
        return endHours;
    }

    public void setEndHours(double endHours) {
        this.endHours = endHours;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }
}
