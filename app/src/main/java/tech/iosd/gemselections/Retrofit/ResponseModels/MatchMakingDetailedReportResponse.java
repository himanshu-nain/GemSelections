package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kushalgupta on 26/03/18.
 */
//https://json.astrologyapi.com/v1/match_making_detailed_report

public class MatchMakingDetailedReportResponse{

    @SerializedName("ashtakoota")
    @Expose
    private Ashtakoota ashtakoota;
    @SerializedName("manglik")
    @Expose
    private Manglik manglik;
    @SerializedName("rajju_dosha")
    @Expose
    private RajjuDosha rajjuDosha;
    @SerializedName("vedha_dosha")
    @Expose
    private VedhaDosha vedhaDosha;
    @SerializedName("conclusion")
    @Expose
    private Conclusion_ conclusion;

    public Ashtakoota getAshtakoota() {
        return ashtakoota;
    }

    public void setAshtakoota(Ashtakoota ashtakoota) {
        this.ashtakoota = ashtakoota;
    }

    public Manglik getManglik() {
        return manglik;
    }

    public void setManglik(Manglik manglik) {
        this.manglik = manglik;
    }

    public RajjuDosha getRajjuDosha() {
        return rajjuDosha;
    }

    public void setRajjuDosha(RajjuDosha rajjuDosha) {
        this.rajjuDosha = rajjuDosha;
    }

    public VedhaDosha getVedhaDosha() {
        return vedhaDosha;
    }

    public void setVedhaDosha(VedhaDosha vedhaDosha) {
        this.vedhaDosha = vedhaDosha;
    }

    public Conclusion_ getConclusion() {
        return conclusion;
    }

    public void setConclusion(Conclusion_ conclusion) {
        this.conclusion = conclusion;
    }

}












