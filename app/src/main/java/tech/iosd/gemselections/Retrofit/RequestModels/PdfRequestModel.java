package tech.iosd.gemselections.Retrofit.RequestModels;

import com.google.gson.annotations.SerializedName;

public class PdfRequestModel {
    @SerializedName("name")
    private String name;
    @SerializedName("gender")
    private String gender;
    @SerializedName("day")
    private int day;
    @SerializedName("month")
    private int month;
    @SerializedName("year")
    private int year;
    @SerializedName("hour")
    private int hour;
    @SerializedName("min")
    private int min;
    @SerializedName("lat")
    private double lat;
    @SerializedName("lon")
    private double lon;
    @SerializedName("language")
    private String language;
    @SerializedName("tzone")
    private double tzone;
    @SerializedName("place")
    private String place;
    @SerializedName("chart_style")
    private String chartStyle;
    @SerializedName("footer_link")
    private String footerLink;
    @SerializedName("logo_url")
    private String logoUrl;
    @SerializedName("company_name")
    private String companyName;
    @SerializedName("company_info")
    private String companyInfo;
    @SerializedName("domain_url")
    private String domainUrl;
    @SerializedName("company_email")
    private String companyEmail;
    @SerializedName("company_landline")
    private String companyLandline;
    @SerializedName("company_mobile")
    private String companyMobile;

    public PdfRequestModel(String name, String gender, int day, int month, int year, int hour, int min, double lat, double lon, String language, double tzone, String place, String chartStyle, String footerLink, String logoUrl, String companyName, String companyInfo, String domainUrl, String companyEmail, String companyLandline, String companyMobile) {
        this.name = name;
        this.gender = gender;
        this.day = day;
        this.month = month;
        this.year = year;
        this.hour = hour;
        this.min = min;
        this.lat = lat;
        this.lon = lon;
        this.language = language;
        this.tzone = tzone;
        this.place = place;
        this.chartStyle = chartStyle;
        this.footerLink = footerLink;
        this.logoUrl = logoUrl;
        this.companyName = companyName;
        this.companyInfo = companyInfo;
        this.domainUrl = domainUrl;
        this.companyEmail = companyEmail;
        this.companyLandline = companyLandline;
        this.companyMobile = companyMobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getTzone() {
        return tzone;
    }

    public void setTzone(double tzone) {
        this.tzone = tzone;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getChartStyle() {
        return chartStyle;
    }

    public void setChartStyle(String chartStyle) {
        this.chartStyle = chartStyle;
    }

    public String getFooterLink() {
        return footerLink;
    }

    public void setFooterLink(String footerLink) {
        this.footerLink = footerLink;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyInfo() {
        return companyInfo;
    }

    public void setCompanyInfo(String companyInfo) {
        this.companyInfo = companyInfo;
    }

    public String getDomainUrl() {
        return domainUrl;
    }

    public void setDomainUrl(String domainUrl) {
        this.domainUrl = domainUrl;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    public String getCompanyLandline() {
        return companyLandline;
    }

    public void setCompanyLandline(String companyLandline) {
        this.companyLandline = companyLandline;
    }

    public String getCompanyMobile() {
        return companyMobile;
    }

    public void setCompanyMobile(String companyMobile) {
        this.companyMobile = companyMobile;
    }
}

//"name" : "Ajeet Kanojia", -- Name of the user "gender"
// : "male", -- Gender of the user "day" : 10, --
// Birth date of the user
// "month" : 07, -- Birth month of the user
// "year" :1992, -- Birth year of the user
// "hour" : 5, -- Birth hour of the user
// "min" : 12, -- Birth minute of the user
// "lat" : 19.231, -- Latitude of user birth place
// "lon" : 72.4242, -- Longitude of user birth place
// "language" : "hi", -- Pdf Language eg,en,hi,ma,bn,ta,te,kn,ml
// "tzone" : 5.5, -- Timezone of user birth place
// "place" : "Mumbai,Maharashtra India", -- User birth place
// "chart_style" : "NORTH_INDIAN", -- For south style SOUTH_INDIAN OR for eastern style EAST_INDIAN
// "footer_link" : "astrologyapi.com", -- Your domain link
// "logo_url" : "logo_url", -- Your company logo url
// "company_name" :"Vedic Rishi Astro Solutions Pvt. Ltd.", -- Your company name
// "company_info" : "Your Company Info", -- NOTE- SHOULD BE LESS THAN 500 CHARACTER
// "domain_url" : "https://www.astrologyapi.com", -- Your domain full url
// "company_email" : "mail@astrologyapi.com", -- Your company email
// "company_landline" : "+91- 221232 22", -- Your company Landline number
// "company_mobile" : "+91 1212 1212 12", -- Your company mobile number }
