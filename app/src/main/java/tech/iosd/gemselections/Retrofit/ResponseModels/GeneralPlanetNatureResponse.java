package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GeneralPlanetNatureResponse {
    @SerializedName("GOOD")
    private List<String> gOOD = null;
    @SerializedName("BAD")
    private List<String> bAD = null;
    @SerializedName("KILLER")
    private List<String> kILLER = null;
    @SerializedName("YOGAKARAKA")
    private List<String> yOGAKARAKA = null;

    public List<String> getGOOD() {
        return gOOD;
    }

    public void setGOOD(List<String> gOOD) {
        this.gOOD = gOOD;
    }

    public List<String> getBAD() {
        return bAD;
    }

    public void setBAD(List<String> bAD) {
        this.bAD = bAD;
    }

    public List<String> getKILLER() {
        return kILLER;
    }

    public void setKILLER(List<String> kILLER) {
        this.kILLER = kILLER;
    }

    public List<String> getYOGAKARAKA() {
        return yOGAKARAKA;
    }

    public void setYOGAKARAKA(List<String> yOGAKARAKA) {
        this.yOGAKARAKA = yOGAKARAKA;
    }
}
