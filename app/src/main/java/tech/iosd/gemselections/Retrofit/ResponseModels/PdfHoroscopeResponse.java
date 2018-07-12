package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.SerializedName;

public class PdfHoroscopeResponse {
    @SerializedName("status")
    boolean status;
    @SerializedName("pdf_url")
    String pdfUrl;

    public PdfHoroscopeResponse() {
    }

    public PdfHoroscopeResponse(boolean status, String pdfUrl) {

        this.status = status;
        this.pdfUrl = pdfUrl;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
