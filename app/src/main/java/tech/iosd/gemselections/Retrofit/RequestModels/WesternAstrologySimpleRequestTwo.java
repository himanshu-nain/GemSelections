package tech.iosd.gemselections.Retrofit.RequestModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by anubhavmalik on 29/03/18.
 */

public class WesternAstrologySimpleRequestTwo {
    @SerializedName("day")
    int day;
    @SerializedName("month")
    int month;
    @SerializedName("year")
    int year;
    @SerializedName("hour")
    int hour;
    @SerializedName("min")
    int min;
    @SerializedName("lat")
    float lat;
    @SerializedName("lon")
    float lon;
    @SerializedName("tzone")
    float tzone;
    @SerializedName("prediction_timezone")
    float prediction_timezone;


    public WesternAstrologySimpleRequestTwo() {
    }

    public WesternAstrologySimpleRequestTwo(int day, int month, int year, int hour, int min, float lat, float lon, float tzone, float prediction_timezone) {

        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.min = min;
        this.lat = lat;
        this.lon = lon;
        this.tzone = tzone;
        this.prediction_timezone = prediction_timezone;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getTzone() {
        return tzone;
    }

    public void setTzone(float tzone) {
        this.tzone = tzone;
    }

    public float getPrediction_timezone() {
        return prediction_timezone;
    }

    public void setPrediction_timezone(float prediction_timezone) {
        this.prediction_timezone = prediction_timezone;
    }
}
