package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anubhavmalik on 06/03/18.
 */

public class PredictionResponse implements Serializable{
    @SerializedName("sun_sign")
    private String sunSign;

    @SerializedName("prediction_date")
    private String predictionDate;

    @SerializedName("prediction")
    private PredictionModel predictionModel;

    public PredictionResponse() {
    }

    public PredictionResponse(String sunSign, String predictionDate, PredictionModel predictionModel) {
        this.sunSign = sunSign;
        this.predictionDate = predictionDate;
        this.predictionModel = predictionModel;
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

    public PredictionModel getPredictionModel() {
        return predictionModel;
    }

    public void setPredictionModel(PredictionModel predictionModel) {
        this.predictionModel = predictionModel;
    }
}
