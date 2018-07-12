package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anubhavmalik on 06/03/18.
 */

public class WeeklyPredictionResponse implements Serializable {
    @SerializedName("sun_sign")
    private String sunSign;

    @SerializedName("prediction_start_date")
    private String predictionStartDate;

    @SerializedName("prediction_end_date")
    private String predictionEndDate;

    @SerializedName("prediction")
    private String prediction;

    public WeeklyPredictionResponse() {
    }

    public WeeklyPredictionResponse(String sunSign, String predictionStartDate, String predictionEndDate, String prediction) {

        this.sunSign = sunSign;
        this.predictionStartDate = predictionStartDate;
        this.predictionEndDate = predictionEndDate;
        this.prediction = prediction;
    }

    public String getSunSign() {
        return sunSign;
    }

    public void setSunSign(String sunSign) {
        this.sunSign = sunSign;
    }

    public String getPredictionStartDate() {
        return predictionStartDate;
    }

    public void setPredictionStartDate(String predictionStartDate) {
        this.predictionStartDate = predictionStartDate;
    }

    public String getPredictionEndDate() {
        return predictionEndDate;
    }

    public void setPredictionEndDate(String predictionEndDate) {
        this.predictionEndDate = predictionEndDate;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
}
