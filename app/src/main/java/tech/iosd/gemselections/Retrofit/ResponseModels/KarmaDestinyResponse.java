package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/karma_destiny_report/tropical
public class KarmaDestinyResponse {
    @SerializedName("karma_destiny_report")
    @Expose
    private List<String> karmaDestinyReport = null;

    public List<String> getKarmaDestinyReport() {
        return karmaDestinyReport;
    }

    public void setKarmaDestinyReport(List<String> karmaDestinyReport) {
        this.karmaDestinyReport = karmaDestinyReport;
    }
}
