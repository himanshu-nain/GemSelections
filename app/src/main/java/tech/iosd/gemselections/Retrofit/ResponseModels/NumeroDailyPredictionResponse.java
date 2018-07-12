package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NumeroDailyPredictionResponse {

    @SerializedName("prediction")
    @Expose
    private String prediction;
    @SerializedName("lucky_color")
    @Expose
    private String luckyColor;
    @SerializedName("lucky_number")
    @Expose
    private String luckyNumber;
    @SerializedName("prediction_date")
    @Expose
    private String predictionDate;

    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }

    public String getLuckyColor() {
        return luckyColor;
    }

    public void setLuckyColor(String luckyColor) {
        this.luckyColor = luckyColor;
    }

    public String getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(String luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    public String getPredictionDate() {
        return predictionDate;
    }

    public void setPredictionDate(String predictionDate) {
        this.predictionDate = predictionDate;
    }
}
