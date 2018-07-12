package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */
//https://json.astrologyapi.com/v1/papasamyam_details

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class PapasamyamDetailsResponse {

    @SerializedName("ascendant")
    @Expose
    private Ascendant ascendant;
    @SerializedName("moon")
    @Expose
    private Moon moon;
    @SerializedName("venus")
    @Expose
    private Venus venus;
    @SerializedName("final")
    @Expose
    private double _final;

    public Ascendant getAscendant() {
        return ascendant;
    }

    public void setAscendant(Ascendant ascendant) {
        this.ascendant = ascendant;
    }

    public Moon getMoon() {
        return moon;
    }

    public void setMoon(Moon moon) {
        this.moon = moon;
    }

    public Venus getVenus() {
        return venus;
    }

    public void setVenus(Venus venus) {
        this.venus = venus;
    }

    public double getFinal() {
        return _final;
    }

    public void setFinal(double _final) {
        this._final = _final;
    }

}



