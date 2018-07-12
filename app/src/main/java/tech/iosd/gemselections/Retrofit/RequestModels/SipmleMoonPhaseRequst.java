package tech.iosd.gemselections.Retrofit.RequestModels;

public class SipmleMoonPhaseRequst {
    Float prediction_timezone;

    public Float getPrediction_timezone() {
        return prediction_timezone;
    }

    public void setPrediction_timezone(Float prediction_timezone) {
        this.prediction_timezone = prediction_timezone;
    }

    public SipmleMoonPhaseRequst(Float prediction_timezone) {
        this.prediction_timezone = prediction_timezone;
    }
}
