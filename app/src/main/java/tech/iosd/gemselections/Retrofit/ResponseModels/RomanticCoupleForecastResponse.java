package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 04/04/18.
 */

public class RomanticCoupleForecastResponse {

    @SerializedName("romantic_forecast")
    @Expose
    private List<String> romanticForecast = null;

    public List<String> getRomanticForecast() {
        return romanticForecast;
    }

    public void setRomanticForecast(List<String> romanticForecast) {
        this.romanticForecast = romanticForecast;
    }
}
