package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

public class GeneralMoonBioRythmResponse {
    @SerializedName("birth_pakshi")
    private String birthPakshi;
    @SerializedName("birth_pakshi_details")
    private BirthPakshiDetails birthPakshiDetails;
    @SerializedName("requested_day")
    private String requestedDay;
    @SerializedName("activity_cycle")
    private ActivityCycle activityCycle;

    public String getBirthPakshi() {
        return birthPakshi;
    }

    public void setBirthPakshi(String birthPakshi) {
        this.birthPakshi = birthPakshi;
    }

    public BirthPakshiDetails getBirthPakshiDetails() {
        return birthPakshiDetails;
    }

    public void setBirthPakshiDetails(BirthPakshiDetails birthPakshiDetails) {
        this.birthPakshiDetails = birthPakshiDetails;
    }

    public String getRequestedDay() {
        return requestedDay;
    }

    public void setRequestedDay(String requestedDay) {
        this.requestedDay = requestedDay;
    }

    public ActivityCycle getActivityCycle() {
        return activityCycle;
    }

    public void setActivityCycle(ActivityCycle activityCycle) {
        this.activityCycle = activityCycle;
    }
}
