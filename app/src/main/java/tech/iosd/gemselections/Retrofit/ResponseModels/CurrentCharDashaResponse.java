package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class CurrentCharDashaResponse {
    @SerializedName("dasha_date")
    @Expose
    private String dashaDate;
    @SerializedName("major_dasha")
    @Expose
    private MajorDasha majorDasha;
    @SerializedName("sub_dasha")
    @Expose
    private SubDasha subDasha;
    //todo error is here Expected BEGIN_ARRAY but was BEGIN_OBJECT still not resolved
    @SerializedName("sub_sub_dasha")
    @Expose
    private SubSubDasha subSubDasha;

    public SubSubDasha getSubSubDasha() {
        return subSubDasha;
    }

    public void setSubSubDasha(SubSubDasha subSubDasha) {
        this.subSubDasha = subSubDasha;
    }

    public String getDashaDate() {
        return dashaDate;
    }

    public void setDashaDate(String dashaDate) {
        this.dashaDate = dashaDate;
    }

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

    /*public SubDashaArrayObj getSubSubDasha() {
        return subSubDasha;
    }

    public void setSubSubDasha(SubDashaArrayObj subSubDasha) {
        this.subSubDasha = subSubDasha;
    }
*/
    public class SubDashaArrayObj {
        private SubDasha[] subSubDashas = new SubDasha[12];

        public SubDasha[] getSubSubDashas() {
            return subSubDashas;
        }

        public void setSubSubDashas(SubDasha[] subSubDashas) {
            this.subSubDashas = subSubDashas;
        }

        public SubDashaArrayObj(SubDasha[] subSubDashas) {
            this.subSubDashas = subSubDashas;
        }
    }
}
