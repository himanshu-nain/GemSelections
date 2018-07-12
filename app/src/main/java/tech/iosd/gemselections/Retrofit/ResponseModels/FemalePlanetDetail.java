package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kushalgupta on 26/03/18.
 */



public class FemalePlanetDetail {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("fullDegree")
    @Expose
    private double fullDegree;
    @SerializedName("normDegree")
    @Expose
    private double normDegree;
    @SerializedName("speed")
    @Expose
    private double speed;
    @SerializedName("isRetro")
    @Expose
    private boolean isRetro;
    @SerializedName("sign")
    @Expose
    private String sign;
    @SerializedName("signLord")
    @Expose
    private String signLord;
    @SerializedName("nakshatra")
    @Expose
    private String nakshatra;
    @SerializedName("nakshatraLord")
    @Expose
    private String nakshatraLord;
    @SerializedName("nakshatra_pad")
    @Expose
    private int nakshatraPad;
    @SerializedName("house")
    @Expose
    private int house;
    @SerializedName("is_planet_set")
    @Expose
    private boolean isPlanetSet;
    @SerializedName("planet_awastha")
    @Expose
    private String planetAwastha;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public double getNormDegree() {
        return normDegree;
    }

    public void setNormDegree(double normDegree) {
        this.normDegree = normDegree;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
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

    public String getSignLord() {
        return signLord;
    }

    public void setSignLord(String signLord) {
        this.signLord = signLord;
    }

    public String getNakshatra() {
        return nakshatra;
    }

    public void setNakshatra(String nakshatra) {
        this.nakshatra = nakshatra;
    }

    public String getNakshatraLord() {
        return nakshatraLord;
    }

    public void setNakshatraLord(String nakshatraLord) {
        this.nakshatraLord = nakshatraLord;
    }

    public int getNakshatraPad() {
        return nakshatraPad;
    }

    public void setNakshatraPad(int nakshatraPad) {
        this.nakshatraPad = nakshatraPad;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public boolean isIsPlanetSet() {
        return isPlanetSet;
    }

    public void setIsPlanetSet(boolean isPlanetSet) {
        this.isPlanetSet = isPlanetSet;
    }

    public String getPlanetAwastha() {
        return planetAwastha;
    }

    public void setPlanetAwastha(String planetAwastha) {
        this.planetAwastha = planetAwastha;
    }

}