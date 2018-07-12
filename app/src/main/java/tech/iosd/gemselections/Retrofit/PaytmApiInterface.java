package tech.iosd.gemselections.Retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import tech.iosd.gemselections.Retrofit.ResponseModels.Checksum;
import tech.iosd.gemselections.Retrofit.ResponseModels.Paytm;

/**
 * Created by anubhavmalik on 23/03/18.
 */

public interface PaytmApiInterface {


    @POST("generate_checksum")
    Call<Checksum> getChecksum(
            @Body Paytm paytm
    );
}
