package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class TransitHouse {
    @SerializedName("transit_date")
    @Expose
    private String transitDate;
    @SerializedName("ascendant")
    @Expose
    private String ascendant;
    @SerializedName("transit_house")
    @Expose
    private List<TransitHouses> transitHouse = null;
    @SerializedName("transit_relation")
    @Expose
    private List<TransitRelation> transitRelation = null;
    @SerializedName("retrogrades")
    @Expose
    private List<Object> retrogrades = null;
    @SerializedName("moon_phase")
    @Expose
    private Object moonPhase;

    public String getTransitDate() {
        return transitDate;
    }

    public void setTransitDate(String transitDate) {
        this.transitDate = transitDate;
    }

    public String getAscendant() {
        return ascendant;
    }

    public void setAscendant(String ascendant) {
        this.ascendant = ascendant;
    }

    public List<TransitHouses> getTransitHouse() {
        return transitHouse;
    }

    public void setTransitHouse(List<TransitHouses> transitHouse) {
        this.transitHouse = transitHouse;
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

    public Object getMoonPhase() {
        return moonPhase;
    }

    public void setMoonPhase(Object moonPhase) {
        this.moonPhase = moonPhase;
    }

}
