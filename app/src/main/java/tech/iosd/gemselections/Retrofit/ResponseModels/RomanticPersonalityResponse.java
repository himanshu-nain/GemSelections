package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/romantic_personality_report/tropical
public class RomanticPersonalityResponse {
    @SerializedName("report")
    @Expose
    private List<String> report = null;

    public List<String> getReport() {
        return report;
    }

    public void setReport(List<String> report) {
        this.report = report;
    }
}
