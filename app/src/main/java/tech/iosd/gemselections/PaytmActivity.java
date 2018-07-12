package tech.iosd.gemselections;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.paytm.pgsdk.PaytmOrder;
import com.paytm.pgsdk.PaytmPGService;
import com.paytm.pgsdk.PaytmPaymentTransactionCallback;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import tech.iosd.gemselections.Retrofit.PaytmApiClient;
import tech.iosd.gemselections.Retrofit.PaytmApiInterface;
import tech.iosd.gemselections.Retrofit.ResponseModels.Checksum;
import tech.iosd.gemselections.Retrofit.ResponseModels.Paytm;
import tech.iosd.gemselections.Utils.Constants;
import tech.iosd.gemselections.Utils.SharedPreferencesUtils;

public class PaytmActivity extends AppCompatActivity implements PaytmPaymentTransactionCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paytm);

        generateCheckSum();


    }

    private void initializePaytmPayment(String checksumHash, Paytm paytm) {

        //getting paytm service
        PaytmPGService Service = null;
        Service = PaytmPGService.getProductionService();
//        PaytmMerchant merchant = new PaytmMerchant("https://checksumpaytm.herokuapp.com/generate_checksum", "https://checksumpaytm.herokuapp.com/verify_checksum");


        //use this when using for production
        //PaytmPGService Service = PaytmPGService.getProductionService();

        //creating a hashmap and adding all the values required
        Log.d("TAGGER", paytm.getmId());
        Log.d("TAGGER", paytm.getOrderId());
        Log.d("TAGGER", paytm.getCustId());
        Log.d("TAGGER", paytm.getChannelId());
        Log.d("TAGGER", paytm.getTxnAmount());
        Log.d("TAGGER", paytm.getWebsite());
        Log.d("TAGGER", paytm.getCallBackUrl());
        Log.d("TAGGER", paytm.getIndustryTypeId());
        Log.d("TAGGER", paytm.getMobileNumber());
        Log.d("TAGGER", paytm.getEmail());
        Log.d("TAGGER", checksumHash);

        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("MID", paytm.getmId());
        paramMap.put("ORDER_ID", paytm.getOrderId());
        paramMap.put("CUST_ID", paytm.getCustId());
        paramMap.put("CHANNEL_ID", paytm.getChannelId());
        paramMap.put("TXN_AMOUNT", paytm.getTxnAmount());
        paramMap.put("WEBSITE", paytm.getWebsite());
        paramMap.put("CALLBACK_URL", paytm.getCallBackUrl());
        paramMap.put("INDUSTRY_TYPE_ID", paytm.getIndustryTypeId());
        paramMap.put("MOBILE_NO", paytm.getMobileNumber());
        paramMap.put("EMAIL", paytm.getEmail());
        paramMap.put("CHECKSUMHASH", checksumHash);


        //  creating a paytm order object using the hashmap
        //	public PaytmOrder(String inOrderId, String inCustomerId, String inTransactionAmount, String inEmail, String inMobileNumber)

        PaytmOrder order = new PaytmOrder(paramMap);//paytm.getOrderId(),paytm.getCustId(),paytm.getTxnAmount(),paytm.getEmail(),paytm.getMobileNumber());


//        PaytmClientCertificate paytmClientCertificate = new PaytmClientCertificate()
        //intializing the paytm service
        Service.initialize(order, null);

        //finally starting the payment transaction

        Service.startPaymentTransaction(this, false, true, this);

    }

    private void generateCheckSum() {

        //getting the tax amount first.
        //creating a retrofit object.
        PaytmApiClient paytmApiClient = new PaytmApiClient();
        Retrofit retrofit = paytmApiClient.getRetrofit();

        //creating the retrofit api service
        PaytmApiInterface apiService = retrofit.create(PaytmApiInterface.class);

        //creating paytm object
        //containing all the values required
        String orderId = Paytm.generateString();
        String custId = getSharedPreferences(SharedPreferencesUtils.sharedPreferencesName, MODE_PRIVATE)
                .getString(SharedPreferencesUtils.prefsUserEmail, Paytm.generateString());
        final Paytm paytm = new Paytm(
//                "DEFAULT",
                Constants.M_ID,
                orderId,
                custId,
                Constants.CHANNEL_ID,
                "10",
                Constants.WEBSITE,
//                Constants.CALLBACK_URL+orderId,
                Constants.CALLBACK_URL,
//                "https://pguat.paytm.com/paytmchecksum/paytmCallback.jsp",
                Constants.INDUSTRY_TYPE_ID,
//                Constants.CHECKSUM_HASH,
                "9711318036",
                "anubhavmalik97@gmail.com"

        );


        //creating a call object from the apiService
        Call<Checksum> call = apiService.getChecksum(
                paytm
        );

        //making the call to generate checksum
        call.enqueue(new Callback<Checksum>() {
            @Override
            public void onResponse(Call<Checksum> call, Response<Checksum> response) {

                //once we get the checksum we will initiailize the payment.
                Log.d("TAGGERResponse", response.body().getChecksumHash() + "");
                //the method is taking the checksum we got and the paytm object as the parameter
                initializePaytmPayment(response.body().getChecksumHash(), paytm);

            }

            @Override
            public void onFailure(Call<Checksum> call, Throwable t) {

                Log.d("TAGGERFailure", "FAILURE : " + t.getMessage());
            }
        });
    }

    @Override
    public void onTransactionResponse(Bundle inResponse) {
        Toast.makeText(PaytmActivity.this, inResponse.toString() + "called", Toast.LENGTH_LONG).show();
        Log.d("TAGGER", "Response called");
    }

    @Override
    public void networkNotAvailable() {
        Toast.makeText(PaytmActivity.this, "Network error", Toast.LENGTH_LONG).show();
        Log.d("TAGGER", "Network error called");
    }

    @Override
    public void clientAuthenticationFailed(String inErrorMessage) {
        Toast.makeText(PaytmActivity.this, inErrorMessage, Toast.LENGTH_LONG).show();
        Log.d("TAGGER", "Auth failed called");
    }

    @Override
    public void someUIErrorOccurred(String inErrorMessage) {
        Toast.makeText(PaytmActivity.this, inErrorMessage, Toast.LENGTH_LONG).show();
        Log.d("TAGGER", "UI ERROR called");
    }

    @Override
    public void onErrorLoadingWebPage(int iniErrorCode, String inErrorMessage, String inFailingUrl) {
        Toast.makeText(PaytmActivity.this, inErrorMessage, Toast.LENGTH_LONG).show();
        Log.d("TAGGER", "Error web page called");
    }

    @Override
    public void onBackPressedCancelTransaction() {
        Toast.makeText(PaytmActivity.this, "Back Pressed", Toast.LENGTH_LONG).show();
        Log.d("TAGGER", "Cancelled called");

    }

    @Override
    public void onTransactionCancel(String inErrorMessage, Bundle inResponse) {
        Toast.makeText(PaytmActivity.this, inErrorMessage + inResponse.toString(), Toast.LENGTH_LONG).show();

        Log.d("TAGGER", "transcancel called");
    }


    //all these overriden method is to detect the payment result accordingly


}

