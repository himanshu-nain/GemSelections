package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class Aspect {
    @SerializedName("aspecting_planet")
    @Expose
    private String aspectingPlanet;
    @SerializedName("aspected_planet")
    @Expose
    private String aspectedPlanet;
    @SerializedName("aspecting_planet_id")
    @Expose
    private long aspectingPlanetId;
    @SerializedName("aspected_planet_id")
    @Expose
    private long aspectedPlanetId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("orb")
    @Expose
    private double orb;
    @SerializedName("diff")
    @Expose
    private double diff;

    public String getAspectingPlanet() {
        return aspectingPlanet;
    }

    public void setAspectingPlanet(String aspectingPlanet) {
        this.aspectingPlanet = aspectingPlanet;
    }

    public String getAspectedPlanet() {
        return aspectedPlanet;
    }

    public void setAspectedPlanet(String aspectedPlanet) {
        this.aspectedPlanet = aspectedPlanet;
    }

    public long getAspectingPlanetId() {
        return aspectingPlanetId;
    }

    public void setAspectingPlanetId(long aspectingPlanetId) {
        this.aspectingPlanetId = aspectingPlanetId;
    }

    public long getAspectedPlanetId() {
        return aspectedPlanetId;
    }

    public void setAspectedPlanetId(long aspectedPlanetId) {
        this.aspectedPlanetId = aspectedPlanetId;
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

    public double getDiff() {
        return diff;
    }

    public void setDiff(double diff) {
        this.diff = diff;
    }
}
