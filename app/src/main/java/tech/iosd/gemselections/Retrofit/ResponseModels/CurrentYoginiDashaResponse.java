package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentYoginiDashaResponse {
    @SerializedName("major_dasha")
    @Expose
    private MajorDasha majorDasha;
    @SerializedName("sub_dasha")
    @Expose
    private SubDasha subDasha;
    @SerializedName("sub_sub_dasha")
    @Expose
    private SubSubDasha subSubDasha;

    public MajorDasha getMajorDasha() {
        return majorDasha;
    }

    public void setMajorDasha(MajorDasha majorDasha) {
        this.majorDasha = majorDasha;
    }

    public SubDasha getSubDasha() {
        return subDasha;
    }

    public void setSubDasha(SubDasha subDasha) {
        this.subDasha = subDasha;
    }

    public SubSubDasha getSubSubDasha() {
        return subSubDasha;
    }

    public void setSubSubDasha(SubSubDasha subSubDasha) {
        this.subSubDasha = subSubDasha;
    }
}
