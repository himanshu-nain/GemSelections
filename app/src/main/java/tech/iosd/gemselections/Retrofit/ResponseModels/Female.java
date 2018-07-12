package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Female {
    //todo this file should be deleted it is same as male model
    @SerializedName("manglik_present_rule")
    @Expose
    private ManglikPresentRule_ manglikPresentRule;
    @SerializedName("manglik_cancel_rule")
    @Expose
    private List<String> manglikCancelRule = null;
    @SerializedName("is_mars_manglik_cancelled")
    @Expose
    private boolean isMarsManglikCancelled;
    @SerializedName("manglik_status")
    @Expose
    private String manglikStatus;
    @SerializedName("percentage_manglik_present")
    @Expose
    private double percentageManglikPresent;
    @SerializedName("percentage_manglik_after_cancellation")
    @Expose
    private double percentageManglikAfterCancellation;
    @SerializedName("manglik_report")
    @Expose
    private String manglikReport;
    @SerializedName("is_present")
    @Expose
    private boolean isPresent;

    public ManglikPresentRule_ getManglikPresentRule() {
        return manglikPresentRule;
    }

    public void setManglikPresentRule(ManglikPresentRule_ manglikPresentRule) {
        this.manglikPresentRule = manglikPresentRule;
    }

    public List<String> getManglikCancelRule() {
        return manglikCancelRule;
    }

    public void setManglikCancelRule(List<String> manglikCancelRule) {
        this.manglikCancelRule = manglikCancelRule;
    }

    public boolean isIsMarsManglikCancelled() {
        return isMarsManglikCancelled;
    }

    public void setIsMarsManglikCancelled(boolean isMarsManglikCancelled) {
        this.isMarsManglikCancelled = isMarsManglikCancelled;
    }

    public String getManglikStatus() {
        return manglikStatus;
    }

    public void setManglikStatus(String manglikStatus) {
        this.manglikStatus = manglikStatus;
    }

    public double getPercentageManglikPresent() {
        return percentageManglikPresent;
    }

    public void setPercentageManglikPresent(double percentageManglikPresent) {
        this.percentageManglikPresent = percentageManglikPresent;
    }

    public double getPercentageManglikAfterCancellation() {
        return percentageManglikAfterCancellation;
    }

    public void setPercentageManglikAfterCancellation(double percentageManglikAfterCancellation) {
        this.percentageManglikAfterCancellation = percentageManglikAfterCancellation;
    }

    public String getManglikReport() {
        return manglikReport;
    }

    public void setManglikReport(String manglikReport) {
        this.manglikReport = manglikReport;
    }

    public boolean isIsPresent() {
        return isPresent;
    }

    public void setIsPresent(boolean isPresent) {
        this.isPresent = isPresent;
    }

}