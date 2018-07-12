package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

public class GeneralAscendantReportResponse {
    @SerializedName("asc_report")
    private AscReport ascReport;

    public AscReport getAscReport() {
        return ascReport;
    }

    public void setAscReport(AscReport ascReport) {
        this.ascReport = ascReport;
    }
}
