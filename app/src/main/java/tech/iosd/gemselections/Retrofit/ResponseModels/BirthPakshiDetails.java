package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BirthPakshiDetails {
    @SerializedName("name_letter")
    private List<String> nameLetter = null;
    @SerializedName("death_day")
    private List<String> deathDay = null;
    @SerializedName("day_ruling_days")
    private List<String> dayRulingDays = null;
    @SerializedName("night_ruling_days")
    private List<String> nightRulingDays = null;
    @SerializedName("color")
    private String color;
    @SerializedName("direction")
    private String direction;
    @SerializedName("enemy")
    private List<String> enemy = null;
    @SerializedName("friend")
    private List<String> friend = null;

    public List<String> getNameLetter() {
        return nameLetter;
    }

    public void setNameLetter(List<String> nameLetter) {
        this.nameLetter = nameLetter;
    }

    public List<String> getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(List<String> deathDay) {
        this.deathDay = deathDay;
    }

    public List<String> getDayRulingDays() {
        return dayRulingDays;
    }

    public void setDayRulingDays(List<String> dayRulingDays) {
        this.dayRulingDays = dayRulingDays;
    }

    public List<String> getNightRulingDays() {
        return nightRulingDays;
    }

    public void setNightRulingDays(List<String> nightRulingDays) {
        this.nightRulingDays = nightRulingDays;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public List<String> getEnemy() {
        return enemy;
    }

    public void setEnemy(List<String> enemy) {
        this.enemy = enemy;
    }

    public List<String> getFriend() {
        return friend;
    }

    public void setFriend(List<String> friend) {
        this.friend = friend;
    }
}
