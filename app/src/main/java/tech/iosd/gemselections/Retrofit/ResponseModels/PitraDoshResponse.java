package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PitraDoshResponse {
    @SerializedName("what_is_pitri_dosha")
    @Expose
    private String whatIsPitriDosha;
    @SerializedName("is_pitri_dosha_present")
    @Expose
    private boolean isPitriDoshaPresent;
    @SerializedName("rules_matched")
    @Expose
    private List<String> rulesMatched = null;
    @SerializedName("conclusion")
    @Expose
    private String conclusion;
    @SerializedName("remedies")
    @Expose
    private List<String> remedies = null;
    @SerializedName("effects")
    @Expose
    private List<String> effects = null;

    public String getWhatIsPitriDosha() {
        return whatIsPitriDosha;
    }

    public void setWhatIsPitriDosha(String whatIsPitriDosha) {
        this.whatIsPitriDosha = whatIsPitriDosha;
    }

    public boolean isIsPitriDoshaPresent() {
        return isPitriDoshaPresent;
    }

    public void setIsPitriDoshaPresent(boolean isPitriDoshaPresent) {
        this.isPitriDoshaPresent = isPitriDoshaPresent;
    }

    public List<String> getRulesMatched() {
        return rulesMatched;
    }

    public void setRulesMatched(List<String> rulesMatched) {
        this.rulesMatched = rulesMatched;
    }

    public String getConclusion() {
        return conclusion;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public List<String> getRemedies() {
        return remedies;
    }

    public void setRemedies(List<String> remedies) {
        this.remedies = remedies;
    }

    public List<String> getEffects() {
        return effects;
    }

    public void setEffects(List<String> effects) {
        this.effects = effects;
    }

}
