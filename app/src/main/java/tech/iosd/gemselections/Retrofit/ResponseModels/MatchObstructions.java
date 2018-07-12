package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchObstructions {

    @SerializedName("is_present")
    @Expose
    private boolean isPresent;
    @SerializedName("vedha_report")
    @Expose
    private String vedhaReport;
    @SerializedName("vedha_name")
    @Expose
    private boolean vedhaName;

    public boolean isIsPresent() {
        return isPresent;
    }

    public void setIsPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }

    public String getVedhaReport() {
        return vedhaReport;
    }

    public void setVedhaReport(String vedhaReport) {
        this.vedhaReport = vedhaReport;
    }

    public boolean isVedhaName() {
        return vedhaName;
    }

    public void setVedhaName(boolean vedhaName) {
        this.vedhaName = vedhaName;
    }

}