package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anubhavmalik on 06/03/18.
 */

public class NextPredictionResponse implements Serializable{

    @SerializedName("sun_sign")
    private String sunSign;

    @SerializedName("prediction_date")
    private String predictionDate;

    @SerializedName("prediction")
    private String prediction;

    public NextPredictionResponse() {
    }

    public NextPredictionResponse(String sunSign, String predictionDate, String prediction) {

        this.sunSign = sunSign;
        this.predictionDate = predictionDate;
        this.prediction = prediction;
    }

    public String getSunSign() {
        return sunSign;
    }

    public void setSunSign(String sunSign) {
        this.sunSign = sunSign;
    }

    public String getPredictionDate() {
        return predictionDate;
    }

    public void setPredictionDate(String predictionDate) {
        this.predictionDate = predictionDate;
    }

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
}
