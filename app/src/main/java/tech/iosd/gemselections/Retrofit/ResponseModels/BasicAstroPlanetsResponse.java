package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasicAstroPlanetsResponse {
    @SerializedName("id")
    @Expose
    private long id;
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
    @SerializedName("house")
    @Expose
    private long house;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setSpeed(long speed) {
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

    public long getHouse() {
        return house;
    }

    public void setHouse(long house) {
        this.house = house;
    }
}
