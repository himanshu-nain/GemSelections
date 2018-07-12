package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/personality_report/tropical
public class PersonalityReportResponse {

    @SerializedName("report")
    @Expose
    private List<String> report = null;
    @SerializedName("spiritual_lesson")
    @Expose
    private String spiritualLesson;
    @SerializedName("key_quality")
    @Expose
    private String keyQuality;

    public List<String> getReport() {
        return report;
    }

    public void setReport(List<String> report) {
        this.report = report;
    }

    public String getSpiritualLesson() {
        return spiritualLesson;
    }

    public void setSpiritualLesson(String spiritualLesson) {
        this.spiritualLesson = spiritualLesson;
    }

    public String getKeyQuality() {
        return keyQuality;
    }

    public void setKeyQuality(String keyQuality) {
        this.keyQuality = keyQuality;
    }

}
