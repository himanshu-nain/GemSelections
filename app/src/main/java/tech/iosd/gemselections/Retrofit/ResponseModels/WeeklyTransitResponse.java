package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/tropical_transits/weekly
public class WeeklyTransitResponse {
    @SerializedName("week_start_date")
    @Expose
    private String weekStartDate;
    @SerializedName("week_end_date")
    @Expose
    private String weekEndDate;
    @SerializedName("ascendant")
    @Expose
    private String ascendant;
    @SerializedName("moon_phase")
    @Expose
    private List<MoonPhase> moonPhase;
    @SerializedName("transit_relation")
    @Expose
    private List<TransitRelation> transitRelation = null;
    @SerializedName("retrogrades")
    @Expose
    private List<Object> retrogrades = null;

    public String getWeekStartDate() {
        return weekStartDate;
    }

    public void setWeekStartDate(String weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

    public String getWeekEndDate() {
        return weekEndDate;
    }

    public void setWeekEndDate(String weekEndDate) {
        this.weekEndDate = weekEndDate;
    }

    public String getAscendant() {
        return ascendant;
    }

    public void setAscendant(String ascendant) {
        this.ascendant = ascendant;
    }

    public List<MoonPhase> getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(List<MoonPhase> moonPhase) {
        this.moonPhase = moonPhase;
    }

    public List<TransitRelation> getTransitRelation() {
        return transitRelation;
    }

    public void setTransitRelation(List<TransitRelation> transitRelation) {
        this.transitRelation = transitRelation;
    }

    public List<Object> getRetrogrades() {
        return retrogrades;
    }

    public void setRetrogrades(List<Object> retrogrades) {
        this.retrogrades = retrogrades;
    }
}
