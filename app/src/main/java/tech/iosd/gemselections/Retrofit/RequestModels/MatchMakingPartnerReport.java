package tech.iosd.gemselections.Retrofit.RequestModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchMakingPartnerReport implements Serializable{

    @SerializedName("you_date")
    private int mdob;

    @SerializedName("you_month")
    private int mmob;

    @SerializedName("you_year")
    private int myob;

    @SerializedName("you_gender")
    private String mGender;

    @SerializedName("match_date")
    private int fdob;

    @SerializedName("match_month")
    private int fmob;

    @SerializedName("match_year")
    private int fyob;

    @SerializedName("match_gender")
    private String fGender;

    @SerializedName("match_name")
    private  String partnerNAme;

    public MatchMakingPartnerReport(int mdob, int mmob, int myob, String mGender, int fdob, int fmob, int fyob, String fGender, String partnerNAme) {
        this.mdob = mdob;
        this.mmob = mmob;
        this.myob = myob;
        this.mGender = mGender;
        this.fdob = fdob;
        this.fmob = fmob;
        this.fyob = fyob;
        this.fGender = fGender;
        this.partnerNAme = partnerNAme;
    }


    public int getMdob() {
        return mdob;
    }

    public void setMdob(int mdob) {
        this.mdob = mdob;
    }

    public int getMmob() {
        return mmob;
    }

    public void setMmob(int mmob) {
        this.mmob = mmob;
    }

    public int getMyob() {
        return myob;
    }

    public void setMyob(int myob) {
        this.myob = myob;
    }

    public String getmGender() {
        return mGender;
    }

    public void setmGender(String mGender) {
        this.mGender = mGender;
    }

    public int getFdob() {
        return fdob;
    }

    public void setFdob(int fdob) {
        this.fdob = fdob;
    }

    public int getFmob() {
        return fmob;
    }

    public void setFmob(int fmob) {
        this.fmob = fmob;
    }

    public int getFyob() {
        return fyob;
    }

    public void setFyob(int fyob) {
        this.fyob = fyob;
    }

    public String getfGender() {
        return fGender;
    }

    public void setfGender(String fGender) {
        this.fGender = fGender;
    }

    public String getPartnerNAme() {
        return partnerNAme;
    }

    public void setPartnerNAme(String partnerNAme) {
        this.partnerNAme = partnerNAme;
    }
}







