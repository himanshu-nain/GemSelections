package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class TransitRelation {
    @SerializedName("transit_planet")
    @Expose
    private String transitPlanet;
    @SerializedName("natal_planet")
    @Expose
    private String natalPlanet;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("orb")
    @Expose
    private double orb;
    @SerializedName("date")
    @Expose
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTransitPlanet() {
        return transitPlanet;
    }

    public void setTransitPlanet(String transitPlanet) {
        this.transitPlanet = transitPlanet;
    }

    public String getNatalPlanet() {
        return natalPlanet;
    }

    public void setNatalPlanet(String natalPlanet) {
        this.natalPlanet = natalPlanet;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getOrb() {
        return orb;
    }

    public void setOrb(double orb) {
        this.orb = orb;
    }

}
