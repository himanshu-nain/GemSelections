package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/personalized_planet_prediction/daily/:planetName
public class PersonalizedPlanetPredictionResponse {
    @SerializedName("report_date")
    @Expose
    private String reportDate;
    @SerializedName("personalised_report")
    @Expose
    private ArrayList<String> personalisedReport ;

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public ArrayList<String> getPersonalisedReport() {
        return personalisedReport;
    }

    public void setPersonalisedReport(ArrayList<String> personalisedReport) {
        this.personalisedReport = personalisedReport;
    }
}
