package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */


//https://json.astrologyapi.com/v1/match_dashakoot_points
        import com.google.gson.annotations.Expose;
        import com.google.gson.annotations.SerializedName;

public class MatchDashakootPointsResponse {

    @SerializedName("dina")
    @Expose
    private Dina dina;
    @SerializedName("gana")
    @Expose
    private Gana gana;
    @SerializedName("yoni")
    @Expose
    private Yoni yoni;
    @SerializedName("rashi")
    @Expose
    private Rashi rashi;
    @SerializedName("rasyadhipati")
    @Expose
    private Rasyadhipati rasyadhipati;
    @SerializedName("rajju")
    @Expose
    private Rajju rajju;
    @SerializedName("vedha")
    @Expose
    private Vedha vedha;
    @SerializedName("vashya")
    @Expose
    private Vashya vashya;
    @SerializedName("mahendra")
    @Expose
    private Mahendra mahendra;
    @SerializedName("streeDeergha")
    @Expose
    private StreeDeergha streeDeergha;
    @SerializedName("total")
    @Expose
    private Total total;

    public Dina getDina() {
        return dina;
    }

    public void setDina(Dina dina) {
        this.dina = dina;
    }

    public Gana getGana() {
        return gana;
    }

    public void setGana(Gana gana) {
        this.gana = gana;
    }

    public Yoni getYoni() {
        return yoni;
    }

    public void setYoni(Yoni yoni) {
        this.yoni = yoni;
    }

    public Rashi getRashi() {
        return rashi;
    }

    public void setRashi(Rashi rashi) {
        this.rashi = rashi;
    }

    public Rasyadhipati getRasyadhipati() {
        return rasyadhipati;
    }

    public void setRasyadhipati(Rasyadhipati rasyadhipati) {
        this.rasyadhipati = rasyadhipati;
    }

    public Rajju getRajju() {
        return rajju;
    }

    public void setRajju(Rajju rajju) {
        this.rajju = rajju;
    }

    public Vedha getVedha() {
        return vedha;
    }

    public void setVedha(Vedha vedha) {
        this.vedha = vedha;
    }

    public Vashya getVashya() {
        return vashya;
    }

    public void setVashya(Vashya vashya) {
        this.vashya = vashya;
    }

    public Mahendra getMahendra() {
        return mahendra;
    }

    public void setMahendra(Mahendra mahendra) {
        this.mahendra = mahendra;
    }

    public StreeDeergha getStreeDeergha() {
        return streeDeergha;
    }

    public void setStreeDeergha(StreeDeergha streeDeergha) {
        this.streeDeergha = streeDeergha;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

}
