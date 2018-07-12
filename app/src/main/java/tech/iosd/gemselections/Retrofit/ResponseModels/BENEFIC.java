package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BENEFIC {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("semi_gem")
    @Expose
    private String semiGem;
    @SerializedName("wear_finger")
    @Expose
    private String wearFinger;
    @SerializedName("weight_caret")
    @Expose
    private String weightCaret;
    @SerializedName("wear_metal")
    @Expose
    private String wearMetal;
    @SerializedName("wear_day")
    @Expose
    private String wearDay;
    @SerializedName("gem_deity")
    @Expose
    private String gemDeity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemiGem() {
        return semiGem;
    }

    public void setSemiGem(String semiGem) {
        this.semiGem = semiGem;
    }

    public String getWearFinger() {
        return wearFinger;
    }

    public void setWearFinger(String wearFinger) {
        this.wearFinger = wearFinger;
    }

    public String getWeightCaret() {
        return weightCaret;
    }

    public void setWeightCaret(String weightCaret) {
        this.weightCaret = weightCaret;
    }

    public String getWearMetal() {
        return wearMetal;
    }

    public void setWearMetal(String wearMetal) {
        this.wearMetal = wearMetal;
    }

    public String getWearDay() {
        return wearDay;
    }

    public void setWearDay(String wearDay) {
        this.wearDay = wearDay;
    }

    public String getGemDeity() {
        return gemDeity;
    }

    public void setGemDeity(String gemDeity) {
        this.gemDeity = gemDeity;
    }
}
