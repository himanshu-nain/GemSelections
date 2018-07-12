package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anubhavmalik on 02/04/18.
 */

public class TransitHouses {
    @SerializedName("planet")
    String planet;

    @SerializedName("natal_sign")
    String natalSign;

    @SerializedName("transit_house")
    int transitHouse;

    @SerializedName("is_retrograde")
    String isRetrograde;


    public TransitHouses(String planet, String natalSign, int transitHouse, String isRetrograde) {
        this.planet = planet;
        this.natalSign = natalSign;
        this.transitHouse = transitHouse;
        this.isRetrograde = isRetrograde;
    }

    public TransitHouses() {
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public String getNatalSign() {
        return natalSign;
    }

    public void setNatalSign(String natalSign) {
        this.natalSign = natalSign;
    }

    public int getTransitHouse() {
        return transitHouse;
    }

    public void setTransitHouse(int transitHouse) {
        this.transitHouse = transitHouse;
    }

    public String getIsRetrograde() {
        return isRetrograde;
    }

    public void setIsRetrograde(String isRetrograde) {
        this.isRetrograde = isRetrograde;
    }
}
