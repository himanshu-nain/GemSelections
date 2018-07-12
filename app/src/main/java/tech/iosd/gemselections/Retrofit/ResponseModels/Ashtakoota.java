package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ashtakoota {

    @SerializedName("status")
    @Expose
    private boolean status;
    @SerializedName("received_points")
    @Expose
    private int receivedPoints;

    @SerializedName("varna")
    @Expose
    private Varna varna;
    @SerializedName("vashya")
    @Expose
    private Vashya vashya;
    @SerializedName("tara")
    @Expose
    private Tara tara;
    @SerializedName("yoni")
    @Expose
    private Yoni yoni;
    @SerializedName("maitri")
    @Expose
    private Maitri maitri;
    @SerializedName("gan")
    @Expose
    private Gan gan;
    @SerializedName("bhakut")
    @Expose
    private Bhakut bhakut;
    @SerializedName("nadi")
    @Expose
    private Nadi nadi;
    @SerializedName("total")
    @Expose
    private Total total;
    @SerializedName("conclusion")
    @Expose
    private Conclusion conclusion;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getReceivedPoints() {
        return receivedPoints;
    }

    public void setReceivedPoints(int receivedPoints) {
        this.receivedPoints = receivedPoints;
    }
    public Varna getVarna() {
        return varna;
    }

    public void setVarna(Varna varna) {
        this.varna = varna;
    }

    public Vashya getVashya() {
        return vashya;
    }

    public void setVashya(Vashya vashya) {
        this.vashya = vashya;
    }

    public Tara getTara() {
        return tara;
    }

    public void setTara(Tara tara) {
        this.tara = tara;
    }

    public Yoni getYoni() {
        return yoni;
    }

    public void setYoni(Yoni yoni) {
        this.yoni = yoni;
    }

    public Maitri getMaitri() {
        return maitri;
    }

    public void setMaitri(Maitri maitri) {
        this.maitri = maitri;
    }

    public Gan getGan() {
        return gan;
    }

    public void setGan(Gan gan) {
        this.gan = gan;
    }

    public Bhakut getBhakut() {
        return bhakut;
    }

    public void setBhakut(Bhakut bhakut) {
        this.bhakut = bhakut;
    }

    public Nadi getNadi() {
        return nadi;
    }

    public void setNadi(Nadi nadi) {
        this.nadi = nadi;
    }

    public Total getTotal() {
        return total;
    }

    public void setTotal(Total total) {
        this.total = total;
    }

    public Conclusion getConclusion() {
        return conclusion;
    }

    public void setConclusion(Conclusion conclusion) {
        this.conclusion = conclusion;
    }
}