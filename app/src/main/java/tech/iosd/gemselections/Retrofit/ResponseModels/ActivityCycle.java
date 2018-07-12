package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ActivityCycle {
    @SerializedName("day")
    private List<Day> day = null;
    @SerializedName("night")
    private List<Night> night = null;

    public List<Day> getDay() {
        return day;
    }

    public void setDay(List<Day> day) {
        this.day = day;
    }

    public List<Night> getNight() {
        return night;
    }

    public void setNight(List<Night> night) {
        this.night = night;
    }
}
