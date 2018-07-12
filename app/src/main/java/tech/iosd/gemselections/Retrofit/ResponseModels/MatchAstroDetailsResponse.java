package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */



        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;
//https://json.astrologyapi.com/v1/match_astro_detail
public class MatchAstroDetailsResponse {

    @SerializedName("male_astro_details")
    @Expose
    private MaleAstroDetails maleAstroDetails;
    @SerializedName("female_astro_details")
    @Expose
    private MaleAstroDetails femaleAstroDetails;

    public MaleAstroDetails getMaleAstroDetails() {
        return maleAstroDetails;
    }

    public void setMaleAstroDetails(MaleAstroDetails maleAstroDetails) {
        this.maleAstroDetails = maleAstroDetails;
    }

    public MaleAstroDetails getFemaleAstroDetails() {
        return femaleAstroDetails;
    }

    public void setFemaleAstroDetails(MaleAstroDetails femaleAstroDetails) {
        this.femaleAstroDetails = femaleAstroDetails;
    }

}

