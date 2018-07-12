package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasicPanchangResponse {
    @SerializedName("day")
    @Expose
    private String day;
    @SerializedName("tithi")
    @Expose
    private String tithi;
    @SerializedName("yog")
    @Expose
    private String yog;
    @SerializedName("nakshatra")
    @Expose
    private String nakshatra;
    @SerializedName("karan")
    @Expose
    private String karan;
    @SerializedName("sunrise")
    @Expose
    private String sunrise;
    @SerializedName("sunset")
    @Expose
    private String sunset;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTithi() {
        return tithi;
    }

    public void setTithi(String tithi) {
        this.tithi = tithi;
    }

    public String getYog() {
        return yog;
    }

    public void setYog(String yog) {
        this.yog = yog;
    }

    public String getNakshatra() {
        return nakshatra;
    }

    public void setNakshatra(String nakshatra) {
        this.nakshatra = nakshatra;
    }

    public String getKaran() {
        return karan;
    }

    public void setKaran(String karan) {
        this.karan = karan;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

}
