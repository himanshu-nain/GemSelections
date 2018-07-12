package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BhavSandhi {
    @SerializedName("house")
    @Expose
    private long house;
    @SerializedName("degree")
    @Expose
    private double degree;
    @SerializedName("sign")
    @Expose
    private String sign;
    @SerializedName("norm_degree")
    @Expose
    private double normDegree;
    @SerializedName("sign_id")
    @Expose
    private long signId;

    public long getHouse() {
        return house;
    }

    public void setHouse(long house) {
        this.house = house;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public double getNormDegree() {
        return normDegree;
    }

    public void setNormDegree(double normDegree) {
        this.normDegree = normDegree;
    }

    public long getSignId() {
        return signId;
    }

    public void setSignId(long signId) {
        this.signId = signId;
    }

}
