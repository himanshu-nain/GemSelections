package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class First {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("full_degree")
    @Expose
    private double fullDegree;
    @SerializedName("norm_degree")
    @Expose
    private double normDegree;
    @SerializedName("speed")
    @Expose
    private long speed;
    @SerializedName("is_retro")
    @Expose
    private String isRetro;
    @SerializedName("sign_id")
    @Expose
    private long signId;
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

    public double getNormDegree() {
        return normDegree;
    }

    public void setNormDegree(double normDegree) {
        this.normDegree = normDegree;
    }

    public long getSpeed() {
        return speed;
    }

    public void setSpeed(long speed) {
        this.speed = speed;
    }

    public String getIsRetro() {
        return isRetro;
    }

    public void setIsRetro(String isRetro) {
        this.isRetro = isRetro;
    }

    public long getSignId() {
        return signId;
    }

    public void setSignId(long signId) {
        this.signId = signId;
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
