package tech.iosd.gemselections.Retrofit.RequestModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kushalgupta on 27/03/18.
 */

public class MatchMakingPapasamyamReportRequest implements Serializable {

    @SerializedName("day")
    private int mdob;

    @SerializedName("month")
    private int mmob;

    @SerializedName("year")
    private int myob;

    @SerializedName("hour")
    private int mhour;

    @SerializedName("min")
    private int mminute;

    @SerializedName("lat")
    private float m_lat;

    @SerializedName("lon")
    private float mlongitude;

    @SerializedName("tzone")
    private float mtimezone;

    @SerializedName("gender")
    private String gender;

    public MatchMakingPapasamyamReportRequest(int mdob, int mmob, int myob, int mhour, int mminute, float m_lat, float mlongitude, float mtimezone, String gender) {
        this.mdob = mdob;
        this.mmob = mmob;
        this.myob = myob;
        this.mhour = mhour;
        this.mminute = mminute;
        this.m_lat = m_lat;
        this.mlongitude = mlongitude;
        this.mtimezone = mtimezone;
        this.gender = gender;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
















