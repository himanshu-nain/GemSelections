package tech.iosd.gemselections.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by anubhavmalik on 27/03/18.
 */

public class AstrologyApiClient {

    Retrofit retrofit;

    public Retrofit getRetrofit() {
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://json.astrologyapi.com/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        }
        return retrofit;
    }
}
