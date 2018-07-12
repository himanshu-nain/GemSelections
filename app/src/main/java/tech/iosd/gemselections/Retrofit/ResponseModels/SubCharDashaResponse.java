package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class SubCharDashaResponse {

    @SerializedName("major_dasha")
    @Expose
    private MajorDasha majorDasha;
//    @SerializedName("sub_dasha")
//    @Expose
//    private List<SubDasha> subDasha = new ArrayList<>();

    public MajorDasha getMajorDasha() {
        return majorDasha;
    }

    public void setMajorDasha(MajorDasha majorDasha) {
        this.majorDasha = majorDasha;
    }

//    public List<SubDasha> getSubDasha() {
//        return subDasha;
//    }
//
//    public void setSubDasha(List<SubDasha> subDasha) {
//        this.subDasha = subDasha;
//    }
}
