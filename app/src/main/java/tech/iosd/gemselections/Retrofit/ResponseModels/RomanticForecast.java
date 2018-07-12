package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anubhavmalik on 26/03/18.
 */

public class RomanticForecast {
    @SerializedName("planet_position")
    @Expose
    private String planetPosition;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("forecast")
    @Expose
    private String forecast;

    public String getPlanetPosition() {
        return planetPosition;
    }

    public void setPlanetPosition(String planetPosition) {
        this.planetPosition = planetPosition;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }
}
