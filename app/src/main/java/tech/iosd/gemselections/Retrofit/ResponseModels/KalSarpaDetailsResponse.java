package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

public class KalSarpaDetailsResponse {
    @SerializedName("present")
    private boolean present;
    @SerializedName("type")
    private String type;
    @SerializedName("one_line")
    private String oneLine;
    @SerializedName("report")
    private Report report;

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOneLine() {
        return oneLine;
    }

    public void setOneLine(String oneLine) {
        this.oneLine = oneLine;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

}
