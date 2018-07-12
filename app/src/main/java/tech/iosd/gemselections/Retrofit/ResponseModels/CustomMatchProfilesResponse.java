package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */
//https://json.astrologyapi.com/v1/custom_match_profiles



        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class CustomMatchProfilesResponse {

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("profile_id")
    @Expose
    private int profileId;
    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("match_results")
    @Expose
    private List<MatchResult> matchResults = null;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getProfileId() {
        return profileId;
    }

    public void setProfileId(int profileId) {
        this.profileId = profileId;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<MatchResult> getMatchResults() {
        return matchResults;
    }

    public void setMatchResults(List<MatchResult> matchResults) {
        this.matchResults = matchResults;
    }

}


