package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AyanmshaResponse {
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("degree")
    @Expose
    private double degree;
    @SerializedName("formatted")
    @Expose
    private String formatted;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getDegree() {
        return degree;
    }

    public void setDegree(double degree) {
        this.degree = degree;
    }

    public String getFormatted() {
        return formatted;
    }

    public void setFormatted(String formatted) {
        this.formatted = formatted;
    }

}
