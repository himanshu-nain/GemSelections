package tech.iosd.gemselections.Retrofit.ResponseModels;

import android.util.Log;

import com.google.gson.annotations.SerializedName;

import java.util.UUID;

/**
 * Created by anubhavmalik on 23/03/18.
 */

public class Paytm {

//    @SerializedName("REQUEST_TYPE")
//    String requestType;

    @SerializedName("MID")
    String mId;

    @SerializedName("ORDER_ID")
    String orderId;

    @SerializedName("CUST_ID")
    String custId;

    @SerializedName("CHANNEL_ID")
    String channelId;

    @SerializedName("TXN_AMOUNT")
    String txnAmount;

    @SerializedName("WEBSITE")
    String website;

    @SerializedName("CALLBACK_URL")
    String callBackUrl;

    @SerializedName("INDUSTRY_TYPE_ID")
    String industryTypeId;

    @SerializedName("CHECKSUMHASH")
    String checksumHash;

    @SerializedName("MOBILE_NO")
    String mobileNumber;

    @SerializedName("EMAIL")
    String email;

    public String getmId() {
        return mId;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustId() {
        return custId;
    }

//    public String getChecksumHash() {
//        return checksumHash;
//    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public Paytm(String mId, String orderId, String custId, String channelId, String txnAmount, String website, String callBackUrl, String industryTypeId,/*String checksumHash,*/ String mobileNumber, String email) {

//        this.requestType =requestType;
        this.mId = mId;
        this.orderId = orderId;
        this.custId = custId;
        this.channelId = channelId;
        this.txnAmount = txnAmount;
        this.website = website;
        this.callBackUrl = callBackUrl;
        this.industryTypeId = industryTypeId;
//        this.checksumHash = checksumHash;
        this.mobileNumber = mobileNumber;
        this.email = email;

        Log.d("orderId", orderId);
        Log.d("customerId", custId);

    }

//    public String getRequestType() {
//        return requestType;
//    }

    public String getChannelId() {
        return channelId;
    }

    public String getTxnAmount() {
        return txnAmount;
    }

    public String getWebsite() {
        return website;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public String getIndustryTypeId() {
        return industryTypeId;
    }

    public String getChecksumHash() {
        return checksumHash;
    }

    /*
        * The following method we are using to generate a random string everytime
        * As we need a unique customer id and order id everytime
        * For real scenario you can implement it with your own application logic
        * */
    public static String generateString() {
        String uuid = UUID.randomUUID().toString()+"KhannaGemSelectionsAndroidApp";
        return uuid.replaceAll("-", "");
    }
}
