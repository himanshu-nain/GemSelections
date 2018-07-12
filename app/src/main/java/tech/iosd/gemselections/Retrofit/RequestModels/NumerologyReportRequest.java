package tech.iosd.gemselections.Retrofit.RequestModels;

public class NumerologyReportRequest {
    int day;
    int month;
    int year;
    String name;

    public NumerologyReportRequest() {
    }

    public NumerologyReportRequest(int day, int month, int year, String name) {

        this.day = day;
        this.month = month;
        this.year = year;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
