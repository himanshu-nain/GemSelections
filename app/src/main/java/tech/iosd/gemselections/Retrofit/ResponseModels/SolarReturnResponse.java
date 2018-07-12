package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/solar_return_details
public class SolarReturnResponse {
    @SerializedName("native_birth_date")
    @Expose
    private String nativeBirthDate;
    @SerializedName("native_age")
    @Expose
    private Object nativeAge;
    @SerializedName("solar_return_date")
    @Expose
    private String solarReturnDate;

    public String getNativeBirthDate() {
        return nativeBirthDate;
    }

    public void setNativeBirthDate(String nativeBirthDate) {
        this.nativeBirthDate = nativeBirthDate;
    }

    public Object getNativeAge() {
        return nativeAge;
    }

    public void setNativeAge(Object nativeAge) {
        this.nativeAge = nativeAge;
    }

    public String getSolarReturnDate() {
        return solarReturnDate;
    }

    public void setSolarReturnDate(String solarReturnDate) {
        this.solarReturnDate = solarReturnDate;
    }

}
