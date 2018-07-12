package tech.iosd.gemselections.Retrofit.RequestModels;

import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchMakingSimpleRequest implements Serializable {
    @SerializedName("m_day")
    private int mdob;

    @SerializedName("m_month")
    private int mmob;

    @SerializedName("m_year")
    private int myob;

    @SerializedName("m_hour")
    private int mhour;

    @SerializedName("m_min")
    private int mminute;

    @SerializedName("m_lat")
    private float m_lat;

    @SerializedName("m_lon")
    private float mlongitude;

    @SerializedName("m_tzone")
    private float mtimezone;

    @SerializedName("f_day")
    private int fdob;

    @SerializedName("f_month")
    private int fmob;

    @SerializedName("f_year")
    private int fyob;

    @SerializedName("f_hour")
    private int fhour;

    @SerializedName("f_min")
    private int fminute;

    @SerializedName("f_lat")
    private float flatitude;

    @SerializedName("f_lon")
    private float flongitude;

    @SerializedName("f_tzone")
    private float ftimezone;

    public MatchMakingSimpleRequest(int mdob, int mmob, int myob, int mhour, int mminute, float m_lat, float mlongitude, float mtimezone, int fdob, int fmob, int fyob, int fhour, int fminute, float flatitude, float flongitude, float ftimezone) {
        this.mdob = mdob;
        this.mmob = mmob;
        this.myob = myob;
        this.mhour = mhour;
        this.mminute = mminute;
        this.m_lat = m_lat;
        this.mlongitude = mlongitude;
        this.mtimezone = mtimezone;
        this.fdob = fdob;
        this.fmob = fmob;
        this.fyob = fyob;
        this.fhour = fhour;
        this.fminute = fminute;
        this.flatitude = flatitude;
        this.flongitude = flongitude;
        this.ftimezone = ftimezone;
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

    public int getMhour() {
        return mhour;
    }

    public void setMhour(int mhour) {
        this.mhour = mhour;
    }

    public int getMminute() {
        return mminute;
    }

    public void setMminute(int mminute) {
        this.mminute = mminute;
    }

    public float getM_lat() {
        return m_lat;
    }

    public void setM_lat(float m_lat) {
        this.m_lat = m_lat;
    }

    public float getMlongitude() {
        return mlongitude;
    }

    public void setMlongitude(float mlongitude) {
        this.mlongitude = mlongitude;
    }

    public float getMtimezone() {
        return mtimezone;
    }

    public void setMtimezone(float mtimezone) {
        this.mtimezone = mtimezone;
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

    public int getFhour() {
        return fhour;
    }

    public void setFhour(int fhour) {
        this.fhour = fhour;
    }

    public int getFminute() {
        return fminute;
    }

    public void setFminute(int fminute) {
        this.fminute = fminute;
    }

    public float getFlatitude() {
        return flatitude;
    }

    public void setFlatitude(float flatitude) {
        this.flatitude = flatitude;
    }

    public float getFlongitude() {
        return flongitude;
    }

    public void setFlongitude(float flongitude) {
        this.flongitude = flongitude;
    }

    public float getFtimezone() {
        return ftimezone;
    }

    public void setFtimezone(float ftimezone) {
        this.ftimezone = ftimezone;
    }
}
