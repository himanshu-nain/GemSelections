package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/zodiac_compatibility/:zodiacName/:partnerZodiacName
public class ZodiacCompatibilityResponse {
    @SerializedName("your_sign")
    @Expose
    private String yourSign;
    @SerializedName("your_partner_sign")
    @Expose
    private String yourPartnerSign;
    @SerializedName("compatibility_report")
    @Expose
    private String compatibilityReport;
    @SerializedName("compatibility_percentage")
    @Expose
    private long compatibilityPercentage;

    public String getYourSign() {
        return yourSign;
    }

    public void setYourSign(String yourSign) {
        this.yourSign = yourSign;
    }

    public String getYourPartnerSign() {
        return yourPartnerSign;
    }

    public void setYourPartnerSign(String yourPartnerSign) {
        this.yourPartnerSign = yourPartnerSign;
    }

    public String getCompatibilityReport() {
        return compatibilityReport;
    }

    public void setCompatibilityReport(String compatibilityReport) {
        this.compatibilityReport = compatibilityReport;
    }

    public long getCompatibilityPercentage() {
        return compatibilityPercentage;
    }

    public void setCompatibilityPercentage(long compatibilityPercentage) {
        this.compatibilityPercentage = compatibilityPercentage;
    }

}
