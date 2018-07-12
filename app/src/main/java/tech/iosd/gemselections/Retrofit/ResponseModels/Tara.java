package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tara {

    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("total_points")
    @Expose
    private int totalPoints;
    @SerializedName("received_points")
    @Expose
    private int receivedPoints;
    @SerializedName("male_koot_attribute")
    @Expose
    private String maleKootAttribute;
    @SerializedName("female_koot_attribute")
    @Expose
    private String femaleKootAttribute;
    @SerializedName("m_attr")
    @Expose
    private String mAttr;
    @SerializedName("f_attr")
    @Expose
    private String fAttr;

    public String getDescription() {
        return description;
    }
    public String getMaleKootAttribute() {
        return maleKootAttribute;
    }

    public void setMaleKootAttribute(String maleKootAttribute) {
        this.maleKootAttribute = maleKootAttribute;
    }

    public String getFemaleKootAttribute() {
        return femaleKootAttribute;
    }

    public void setFemaleKootAttribute(String femaleKootAttribute) {
        this.femaleKootAttribute = femaleKootAttribute;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(int totalPoints) {
        this.totalPoints = totalPoints;
    }

    public int getReceivedPoints() {
        return receivedPoints;
    }

    public void setReceivedPoints(int receivedPoints) {
        this.receivedPoints = receivedPoints;
    }

    public String getMAttr() {
        return mAttr;
    }

    public void setMAttr(String mAttr) {
        this.mAttr = mAttr;
    }

    public String getFAttr() {
        return fAttr;
    }

    public void setFAttr(String fAttr) {
        this.fAttr = fAttr;
    }


}