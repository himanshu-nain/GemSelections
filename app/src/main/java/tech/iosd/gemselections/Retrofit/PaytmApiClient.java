package tech.iosd.gemselections.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anubhavmalik on 23/03/18.
 */

public class PaytmApiClient {

    private Retrofit retrofit;

    public Retrofit getRetrofit() {
        if (retrofit == null) {
            String BASE_URL = "https://checksumpaytm.herokuapp.com/";
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
