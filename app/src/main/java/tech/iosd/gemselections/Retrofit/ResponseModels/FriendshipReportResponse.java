package tech.iosd.gemselections.Retrofit.ResponseModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by anubhavmalik on 26/03/18.
 */
//https://json.astrologyapi.com/v1/friendship_report/tropical
public class FriendshipReportResponse {

    @SerializedName("friendship_report")
    @Expose
    private List<String> friendshipReport = null;

    public List<String> getFriendshipReport() {
        return friendshipReport;
    }

    public void setFriendshipReport(List<String> friendshipReport) {
        this.friendshipReport = friendshipReport;
    }

}
