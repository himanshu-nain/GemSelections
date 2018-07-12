package tech.iosd.gemselections.Retrofit.ResponseModels;

public class ResponseForMoonPhaseReport {
    String considered_date;
    String moon_phase;
    String significance;
    String report;

    public String getConsidered_date() {
        return considered_date;
    }

    public void setConsidered_date(String considered_date) {
        this.considered_date = considered_date;
    }

    public String getMoon_phase() {
        return moon_phase;
    }

    public void setMoon_phase(String moon_phase) {
        this.moon_phase = moon_phase;
    }

    public String getSignificance() {
        return significance;
    }

    public void setSignificance(String significance) {
        this.significance = significance;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }
}
