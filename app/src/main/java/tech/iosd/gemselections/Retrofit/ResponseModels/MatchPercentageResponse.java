package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */

//https://json.astrologyapi.com/v1/match_percentage

        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class MatchPercentageResponse {

    @SerializedName("ashtakoota_percentage")
    @Expose
    private int ashtakootaPercentage;
    @SerializedName("manglik_match_percentage")
    @Expose
    private int manglikMatchPercentage;
    @SerializedName("rajju_match_percentage")
    @Expose
    private int rajjuMatchPercentage;
    @SerializedName("vedha_match_percentage")
    @Expose
    private int vedhaMatchPercentage;
    @SerializedName("match_percentage")
    @Expose
    private int matchPercentage;
    @SerializedName("is_match_good")
    @Expose
    private boolean isMatchGood;

    public int getAshtakootaPercentage() {
        return ashtakootaPercentage;
    }

    public void setAshtakootaPercentage(int ashtakootaPercentage) {
        this.ashtakootaPercentage = ashtakootaPercentage;
    }

    public int getManglikMatchPercentage() {
        return manglikMatchPercentage;
    }

    public void setManglikMatchPercentage(int manglikMatchPercentage) {
        this.manglikMatchPercentage = manglikMatchPercentage;
    }

    public int getRajjuMatchPercentage() {
        return rajjuMatchPercentage;
    }

    public void setRajjuMatchPercentage(int rajjuMatchPercentage) {
        this.rajjuMatchPercentage = rajjuMatchPercentage;
    }

    public int getVedhaMatchPercentage() {
        return vedhaMatchPercentage;
    }

    public void setVedhaMatchPercentage(int vedhaMatchPercentage) {
        this.vedhaMatchPercentage = vedhaMatchPercentage;
    }

    public int getMatchPercentage() {
        return matchPercentage;
    }

    public void setMatchPercentage(int matchPercentage) {
        this.matchPercentage = matchPercentage;
    }

    public boolean isIsMatchGood() {
        return isMatchGood;
    }

    public void setIsMatchGood(boolean isMatchGood) {
        this.isMatchGood = isMatchGood;
    }

}