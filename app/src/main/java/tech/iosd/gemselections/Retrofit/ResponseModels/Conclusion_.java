package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Conclusion_ {

    @SerializedName("match_report")
    @Expose
    private String matchReport;

    public String getMatchReport() {
        return matchReport;
    }

    public void setMatchReport(String matchReport) {
        this.matchReport = matchReport;
    }

}