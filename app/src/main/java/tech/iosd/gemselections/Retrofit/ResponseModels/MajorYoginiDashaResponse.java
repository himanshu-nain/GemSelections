package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MajorYoginiDashaResponse {
    @SerializedName("dasha_id")
    @Expose
    private long dashaId;
    @SerializedName("dasha_name")
    @Expose
    private String dashaName;
    @SerializedName("start_date")
    @Expose
    private String startDate;
    @SerializedName("end_date")
    @Expose
    private String endDate;
    @SerializedName("start_ms")
    @Expose
    private long startMs;
    @SerializedName("end_ms")
    @Expose
    private long endMs;
    @SerializedName("duration")
    @Expose
    private long duration;

    public long getDashaId() {
        return dashaId;
    }

    public void setDashaId(long dashaId) {
        this.dashaId = dashaId;
    }

    public String getDashaName() {
        return dashaName;
    }

    public void setDashaName(String dashaName) {
        this.dashaName = dashaName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public long getStartMs() {
        return startMs;
    }

    public void setStartMs(long startMs) {
        this.startMs = startMs;
    }

    public long getEndMs() {
        return endMs;
    }

    public void setEndMs(long endMs) {
        this.endMs = endMs;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
