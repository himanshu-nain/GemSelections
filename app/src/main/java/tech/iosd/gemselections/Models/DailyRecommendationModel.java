package tech.iosd.gemselections.Models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by anubhavmalik on 03/03/18.
 */

@IgnoreExtraProperties
public class DailyRecommendationModel {
    private String details;
    private String title;
    private String link;

    public DailyRecommendationModel() {
    }

    public DailyRecommendationModel(String details, String title, String link) {

        this.details = details;
        this.title = title;
        this.link = link;
    }

    public String getDetails() {
        return details;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }
}
