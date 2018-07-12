package tech.iosd.gemselections.Models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by anubhavmalik on 03/03/18.
 */

@IgnoreExtraProperties
public class OrderModel {

    private String ordered_on;
    private String product_id;
    private String product_url;
    private String remarks;
    private String status;
    private String user_id;
    private String user_name;
    private String user_number;

    public OrderModel() {
    }

    public OrderModel(String ordered_on, String product_id, String product_url, String remarks, String status, String user_id, String user_name, String user_number) {

        this.ordered_on = ordered_on;
        this.product_id = product_id;
        this.product_url = product_url;
        this.remarks = remarks;
        this.status = status;
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_number = user_number;
    }

    public String getOrdered_on() {
        return ordered_on;
    }

    public void setOrdered_on(String ordered_on) {
        this.ordered_on = ordered_on;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_number() {
        return user_number;
    }

    public void setUser_number(String user_number) {
        this.user_number = user_number;
    }

    public String getProduct_url() {
        return product_url;
    }

    public void setProduct_url(String product_url) {
        this.product_url = product_url;
    }
}

//ordered_on:
//        product_id:
//        product_url:
//        remarks:
//        status:
//        user_id:
//        user_name:
//        user_number: