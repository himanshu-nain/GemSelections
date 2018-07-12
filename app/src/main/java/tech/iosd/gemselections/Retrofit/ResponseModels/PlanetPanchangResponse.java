package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlanetPanchangResponse {

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
    @SerializedName("isRetro")
    @Expose
    private boolean isRetro;
    @SerializedName("sign")
    @Expose
    private String sign;
    @SerializedName("sign_lord")
    @Expose
    private String signLord;
    @SerializedName("nakshatra")
    @Expose
    private String nakshatra;
    @SerializedName("nakshatra_lord")
    @Expose
    private String nakshatraLord;

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

}
