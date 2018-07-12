package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */
//https://json.astrologyapi.com/v1/match_birth_details
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchBirthDetailResponse {
    @SerializedName("male_astro_details")
    @Expose
    private MaleBirthDetails male_birth_details;
    @SerializedName("female_astro_details")
    @Expose
    private MaleBirthDetails femaleBirthDetails;

    public MaleBirthDetails getMaleBirthDetails() {
        return male_birth_details;
    }

    public void setMaleBirthDetails(MaleBirthDetails maleBirthDetails) {
        this.male_birth_details = maleBirthDetails;
    }

    public MaleBirthDetails getFemaleBirthDetails() {
        return femaleBirthDetails;
    }

    public void setFemaleBirthDetails(MaleBirthDetails femaleBirthDetails) {
        this.femaleBirthDetails = femaleBirthDetails;
    }


}