package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/tropical_transits/monthly
public class MonthlyTransitResponse {
    @SerializedName("month_start_date")
    @Expose
    private String monthStartDate;
    @SerializedName("month_end_date")
    @Expose
    private String monthEndDate;
    @SerializedName("ascendant")
    @Expose
    private String ascendant;
    @SerializedName("transit_relation")
    @Expose
    private List<TransitRelation> transitRelation = null;
    @SerializedName("retrogrades")
    @Expose
    private List<Object> retrogrades = null;
    @SerializedName("moon_phase")
    @Expose
    private List<MoonPhase> moonPhase = null;

    public String getMonthStartDate() {
        return monthStartDate;
    }

    public void setMonthStartDate(String monthStartDate) {
        this.monthStartDate = monthStartDate;
    }

    public String getMonthEndDate() {
        return monthEndDate;
    }

    public void setMonthEndDate(String monthEndDate) {
        this.monthEndDate = monthEndDate;
    }

    public String getAscendant() {
        return ascendant;
    }

    public void setAscendant(String ascendant) {
        this.ascendant = ascendant;
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

    public List<MoonPhase> getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(List<MoonPhase> moonPhase) {
        this.moonPhase = moonPhase;
    }
}
