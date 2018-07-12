package tech.iosd.gemselections.Retrofit.ResponseModels;

/**
 * Created by kushalgupta on 26/03/18.
 */    import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//https://json.astrologyapi.com/v1/partner_report

public class PartnerReportResponse {



        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("msg")
        @Expose
        private String msg;
        @SerializedName("tags")
        @Expose
        private String tags;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

    }

