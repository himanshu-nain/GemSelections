package tech.iosd.gemselections.Models;

/**
 * Created by anubhavmalik on 25/03/18.
 */

public class CreateOwnModel {
    String user_name;
    String image_url;
    String user_email;
    String user_number;

    public CreateOwnModel() {
    }

    public String getUser_name() {

        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

    public CreateOwnModel(String user_name, String image_url, String user_email, String user_number) {

        this.user_name = user_name;
        this.image_url = image_url;
        this.user_email = user_email;
        this.user_number = user_number;
    }
}
