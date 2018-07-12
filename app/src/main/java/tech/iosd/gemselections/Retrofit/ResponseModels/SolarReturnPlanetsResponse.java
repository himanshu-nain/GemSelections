package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/solar_return_planet_aspects
public class SolarReturnPlanetsResponse {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("fullDegree")
    @Expose
    private double fullDegree;
    @SerializedName("normDegree")
    @Expose
    private String normDegree;
    @SerializedName("speed")
    @Expose
    private String speed;
    @SerializedName("isRetro")
    @Expose
    private boolean isRetro;
    @SerializedName("sign")
    @Expose
    private String sign;
    @SerializedName("house")
    @Expose
    private long house;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFullDegree() {
        return fullDegree;
    }

    public void setFullDegree(double fullDegree) {
        this.fullDegree = fullDegree;
    }

    public String getNormDegree() {
        return normDegree;
    }

    public void setNormDegree(String normDegree) {
        this.normDegree = normDegree;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public boolean isIsRetro() {
        return isRetro;
    }

    public void setIsRetro(boolean isRetro) {
        this.isRetro = isRetro;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public long getHouse() {
        return house;
    }

    public void setHouse(long house) {
        this.house = house;
    }
}
