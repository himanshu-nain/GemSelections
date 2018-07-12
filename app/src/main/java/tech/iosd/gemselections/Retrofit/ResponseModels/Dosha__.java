package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dosha__ {

    @SerializedName("planet")
    @Expose
    private String planet;
    @SerializedName("position")
    @Expose
    private int position;
    @SerializedName("doshaUnits")
    @Expose
    private float doshaUnits;

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public float getDoshaUnits() {
        return doshaUnits;
    }

    public void setDoshaUnits(float doshaUnits) {
        this.doshaUnits = doshaUnits;
    }

}