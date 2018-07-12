package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by anubhavmalik on 04/03/18.
 */

public class PredictionModel implements Serializable {
    @SerializedName("health")
    private String health;

    @SerializedName("emotions")
    private String emotions;

    @SerializedName("personal_life")
    private String personalLife;

    @SerializedName("profession")
    private String profession;

    @SerializedName("luck")
    private String luck;

    @SerializedName("travel")
    private String travel;

    public PredictionModel() {
    }

    public PredictionModel(String health, String emotions, String personalLife, String profession, String luck, String travel) {

        this.health = health;
        this.emotions = emotions;
        this.personalLife = personalLife;
        this.profession = profession;
        this.luck = luck;
        this.travel = travel;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getEmotions() {
        return emotions;
    }

    public void setEmotions(String emotions) {
        this.emotions = emotions;
    }

    public String getPersonalLife() {
        return personalLife;
    }

    public void setPersonalLife(String personalLife) {
        this.personalLife = personalLife;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getLuck() {
        return luck;
    }

    public void setLuck(String luck) {
        this.luck = luck;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }

    //    "health": "Today someone will inspire you to start a new diet or new exercise pattern.",
//            "emotions": "It will be a happy-go-lucky day for you and you will continue feeling calm and composed. ",
//            "personal_life": "You will be able to enjoy some quality and reflective time with your partner.",
//            "profession": "Your rivals may try to disrupt your work and demoralize you. Just ignore them and continue with diligence.",
//            "luck": "Your handwork will show great results today. Absorb yourself completely in whatever you do. ",
//            "travel": "
}
