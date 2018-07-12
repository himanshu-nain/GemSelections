package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchResult {

    @SerializedName("ashtakoot")
    @Expose
    private Ashtakoot ashtakoot;
    @SerializedName("match_report")
    @Expose
    private MatchReport matchReport;
    @SerializedName("match_obstructions")
    @Expose
    private MatchObstructions matchObstructions;
    @SerializedName("profile_id")
    @Expose
    private int profileId;

    public Ashtakoot getAshtakoot() {
        return ashtakoot;
    }

    public void setAshtakoot(Ashtakoot ashtakoot) {
        this.ashtakoot = ashtakoot;
    }

    public MatchReport getMatchReport() {
        return matchReport;
    }

    public void setMatchReport(MatchReport matchReport) {
        this.matchReport = matchReport;
    }

    public MatchObstructions getMatchObstructions() {
        return matchObstructions;
    }

    public void setMatchObstructions(MatchObstructions matchObstructions) {
        this.matchObstructions = matchObstructions;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

}