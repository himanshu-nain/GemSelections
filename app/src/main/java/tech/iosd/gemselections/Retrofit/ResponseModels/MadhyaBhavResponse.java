package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MadhyaBhavResponse {
    @SerializedName("ascendant")
    @Expose
    private double ascendant;
    @SerializedName("midheaven")
    @Expose
    private double midheaven;
    @SerializedName("ayanamsha")
    @Expose
    private double ayanamsha;
    @SerializedName("bhav_madhya")
    @Expose
    private List<BhavMadhya> bhavMadhya = null;
    @SerializedName("bhav_sandhi")
    @Expose
    private List<BhavSandhi> bhavSandhi = null;

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

    public double getAyanamsha() {
        return ayanamsha;
    }

    public void setAyanamsha(double ayanamsha) {
        this.ayanamsha = ayanamsha;
    }

    public List<BhavMadhya> getBhavMadhya() {
        return bhavMadhya;
    }

    public void setBhavMadhya(List<BhavMadhya> bhavMadhya) {
        this.bhavMadhya = bhavMadhya;
    }

    public List<BhavSandhi> getBhavSandhi() {
        return bhavSandhi;
    }

    public void setBhavSandhi(List<BhavSandhi> bhavSandhi) {
        this.bhavSandhi = bhavSandhi;
    }
}
