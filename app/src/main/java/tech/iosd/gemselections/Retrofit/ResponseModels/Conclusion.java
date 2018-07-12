package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Conclusion {

    @SerializedName("match")
    @Expose
    private boolean match;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("report")
    @Expose
    private String report;
    @SerializedName("match_report")
    @Expose
    private String matchReport;

    public String getMatchReport() {
        return matchReport;
    }

    public void setMatchReport(String matchReport) {
        this.matchReport = matchReport;
    }




    public boolean isMatch() {
        return match;
    }

    public void setMatch(boolean match) {
        this.match = match;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

}