package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//htps://json.astrologyapi.com/v1/western_horoscope
public class WesternHoroscopeResponse {

    @SerializedName("planets")
    private List<Planet> planets = null;
    @SerializedName("houses")
    private List<House> houses = null;
    @SerializedName("ascendant")
    private double ascendant;
    @SerializedName("midheaven")
    private double midheaven;
    @SerializedName("vertex")
    private double vertex;
    @SerializedName("aspects")
    private List<Aspect> aspects = null;

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }

    public List<House> getHouses() {
        return houses;
    }

    public void setHouses(List<House> houses) {
        this.houses = houses;
    }

    public double getAscendant() {
        return ascendant;
    }

    public void setAscendant(double ascendant) {
        this.ascendant = ascendant;
    }

    public double getMidheaven() {
        return midheaven;
    }

    public void setMidheaven(double midheaven) {
        this.midheaven = midheaven;
    }

    public double getVertex() {
        return vertex;
    }

    public void setVertex(double vertex) {
        this.vertex = vertex;
    }

    public List<Aspect> getAspects() {
        return aspects;
    }

    public void setAspects(List<Aspect> aspects) {
        this.aspects = aspects;
    }
}
