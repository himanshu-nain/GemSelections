package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class House {
    @SerializedName("start_degree")
    @Expose
    private double startDegree;
    @SerializedName("end_degree")
    private double endDegree;
    @SerializedName("house")
    @Expose
    private long house;
    @SerializedName("sign")
    @Expose
    private String sign;
    @SerializedName("degree")
    @Expose
    private double degree;
    @SerializedName("planets")
    @Expose
    private List<Planet> planets = null;


    public House() {
    }

    public House(double startDegree, double endDegree, long house, String sign, double degree, List<Planet> planets) {

        this.startDegree = startDegree;
        this.endDegree = endDegree;
        this.house = house;
        this.sign = sign;
        this.degree = degree;
        this.planets = planets;
    }

    public double getStartDegree() {
        return startDegree;
    }

    public void setStartDegree(double startDegree) {
        this.startDegree = startDegree;
    }

    public double getEndDegree() {
        return endDegree;
    }

    public void setEndDegree(double endDegree) {
        this.endDegree = endDegree;
    }

    public long getHouse() {
        return house;
    }

    public void setHouse(long house) {
        this.house = house;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(List<Planet> planets) {
        this.planets = planets;
    }
}
