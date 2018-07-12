package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/romantic_forecast_report/tropical
public class RomanticForecastResponse {

    @SerializedName("romantic_forecast")
    @Expose
    private List<RomanticForecast> romanticForecast = null;

    public List<RomanticForecast> getRomanticForecast() {
        return romanticForecast;
    }

    public void setRomanticForecast(List<RomanticForecast> romanticForecast) {
        this.romanticForecast = romanticForecast;
    }

}
