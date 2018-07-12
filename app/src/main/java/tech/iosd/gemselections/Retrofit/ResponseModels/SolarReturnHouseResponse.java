package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/solar_return_house_cusps
public class SolarReturnHouseResponse {

    @SerializedName("houses")
    @Expose
    private List<House> houses = null;
    @SerializedName("ascendant")
    @Expose
    private double ascendant;
    @SerializedName("midheaven")
    @Expose
    private double midheaven;
    @SerializedName("vertex")
    @Expose
    private double vertex;

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

}
