package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ManglikPresentRule {

    @SerializedName("based_on_aspect")
    @Expose
    private List<String> basedOnAspect = null;
    @SerializedName("based_on_house")
    @Expose
    private List<String> basedOnHouse = null;

    public List<String> getBasedOnAspect() {
        return basedOnAspect;
    }

    public void setBasedOnAspect(List<String> basedOnAspect) {
        this.basedOnAspect = basedOnAspect;
    }

    public List<String> getBasedOnHouse() {
        return basedOnHouse;
    }

    public void setBasedOnHouse(List<String> basedOnHouse) {
        this.basedOnHouse = basedOnHouse;
    }

}