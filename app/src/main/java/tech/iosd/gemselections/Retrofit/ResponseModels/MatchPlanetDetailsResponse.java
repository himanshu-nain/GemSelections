package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */


//https://json.astrologyapi.com/v1/match_planet_details
        import java.util.List;
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class MatchPlanetDetailsResponse{

    @SerializedName("male_planet_details")
    @Expose
    private List<MalePlanetDetail> malePlanetDetails = null;
    @SerializedName("female_planet_details")
    @Expose
    private List<FemalePlanetDetail> femalePlanetDetails = null;

    public List<MalePlanetDetail> getMalePlanetDetails() {
        return malePlanetDetails;
    }

    public void setMalePlanetDetails(List<MalePlanetDetail> malePlanetDetails) {
        this.malePlanetDetails = malePlanetDetails;
    }

    public List<FemalePlanetDetail> getFemalePlanetDetails() {
        return femalePlanetDetails;
    }

    public void setFemalePlanetDetails(List<FemalePlanetDetail> femalePlanetDetails) {
        this.femalePlanetDetails = femalePlanetDetails;
    }

}
