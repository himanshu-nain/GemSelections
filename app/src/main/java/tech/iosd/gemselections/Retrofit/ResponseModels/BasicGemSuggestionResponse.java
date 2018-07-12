package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BasicGemSuggestionResponse {
    @SerializedName("LIFE")
    @Expose
    private LIFE lIFE;
    @SerializedName("BENEFIC")
    @Expose
    private BENEFIC bENEFIC;
    @SerializedName("LUCKY")
    @Expose
    private LUCKY lUCKY;

    public LIFE getLIFE() {
        return lIFE;
    }

    public void setLIFE(LIFE lIFE) {
        this.lIFE = lIFE;
    }

    public BENEFIC getBENEFIC() {
        return bENEFIC;
    }

    public void setBENEFIC(BENEFIC bENEFIC) {
        this.bENEFIC = bENEFIC;
    }

    public LUCKY getLUCKY() {
        return lUCKY;
    }

    public void setLUCKY(LUCKY lUCKY) {
        this.lUCKY = lUCKY;
    }
}
