package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GeneralHoroscopeChartReportResponse {

    @SerializedName("sign")
    private long sign;
    @SerializedName("sign_name")
    private String signName;
    @SerializedName("planet")
    private List<String> planet = null;

    public long getSign() {
        return sign;
    }

    public void setSign(long sign) {
        this.sign = sign;
    }

    public String getSignName() {
        return signName;
    }

    public void setSignName(String signName) {
        this.signName = signName;
    }

    public List<String> getPlanet() {
        return planet;
    }

    public void setPlanet(List<String> planet) {
        this.planet = planet;
    }
}
