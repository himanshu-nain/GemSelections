package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/composite_horoscope
public class CompositeHoroscopeResponse {
    @SerializedName("first")
    @Expose
    private List<Planet> first = null;
    @SerializedName("second")
    @Expose
    private List<Planet> second = null;
    @SerializedName("composite")
    @Expose
    private Composite composite;
    @SerializedName("synastry")
    @Expose
    private Synastry synastry;

    public List<Planet> getFirst() {
        return first;
    }

    public void setFirst(List<Planet> first) {
        this.first = first;
    }

    public List<Planet> getSecond() {
        return second;
    }

    public void setSecond(List<Planet> second) {
        this.second = second;
    }

    public Composite getComposite() {
        return composite;
    }

    public void setComposite(Composite composite) {
        this.composite = composite;
    }

    public Synastry getSynastry() {
        return synastry;
    }

    public void setSynastry(Synastry synastry) {
        this.synastry = synastry;
    }

}
