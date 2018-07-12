package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/love_compatibility_report/tropical
public class LoveCompatibilityResponse {
    @SerializedName("love_report")
    @Expose
    private List<String> loveReport = null;

    public List<String> getLoveReport() {
        return loveReport;
    }

    public void setLoveReport(List<String> loveReport) {
        this.loveReport = loveReport;
    }
}
