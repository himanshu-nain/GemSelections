package tech.iosd.gemselections.MainContent;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.pepperonas.materialdialog.MaterialDialog;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.ResponseModels.MonthlyPredictionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.NextPredictionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.PredictionResponse;
import tech.iosd.gemselections.Retrofit.ResponseModels.WeeklyPredictionResponse;

public class DailyHoroscopeActivity extends AppCompatActivity {
    Button sunSignButton, spanButton, getHoroscopeButton;
    TextView titleTextView, detailsTextView;
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;

    String[] sunSignList = {"Aries (Mar. 21–Apr. 19)\n",
            "Taurus (Apr. 20–May 20)\n",
            "Gemini (May 21–June 21)\n",
            "Cancer (June 22–July 22)\n",
            "Leo (July 23–Aug. 22)\n",
            "Virgo (Aug. 23–Sept. 22)\n",
            "Libra (Sept. 23–Oct. 23)\n",
            "Scorpio (Oct. 24–Nov. 21)\n",
            "Sagittarius (Nov. 22–Dec. 21)\n",
            "Capricorn (Dec. 22–Jan. 19)\n",
            "Aquarius (Jan. 20–Feb. 18)\n",
            "Pisces (Feb. 19–Mar. 20)"};

    String[] spanList = {"Today",
            "Tomorrow",
            "Yesterday",
            "Weekly",
            "Monthly"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_horoscope);
        sunSignButton = findViewById(R.id.daily_horoscope_sun_sign);
        spanButton = findViewById(R.id.daily_horoscope_span);
        getHoroscopeButton = findViewById(R.id.daily_horoscope_get_horoscope);

        titleTextView = findViewById(R.id.daily_horoscope_title);
        detailsTextView = findViewById(R.id.daily_horoscope_detail);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://json.astrologyapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);


        sunSignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDialog.Builder sunSignDialog = new MaterialDialog.Builder(DailyHoroscopeActivity.this)
                        .title("Choose your sun sign")
                        .message(null)
                        .positiveText("Okay")
                        .negativeText("Cancel")
                        .positiveColor(R.color.colorAccent)
                        .negativeColor(R.color.colorAccent)
                        .listItemsSingleSelection(true, sunSignList)
                        .selection(0)
                        .itemClickListener(new MaterialDialog.ItemClickListener() {
                            @Override
                            public void onClick(View v, int position, long id) {
                                super.onClick(v, position, id);
                                sunSignButton.setText(sunSignList[position]);
                            }
                        })
                        .showListener(new MaterialDialog.ShowListener() {
                            @Override
                            public void onShow(AlertDialog dialog) {
                                super.onShow(dialog);
                            }
                        });
                sunSignDialog.show();
            }
        });

        spanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialDialog.Builder sunSignDialog = new MaterialDialog.Builder(DailyHoroscopeActivity.this)
                        .title("Choose")
                        .message(null)
                        .positiveText("Okay")
                        .negativeText("Cancel")
                        .positiveColor(R.color.colorAccent)
                        .negativeColor(R.color.colorAccent)
                        .listItemsSingleSelection(true, spanList)
                        .selection(0)
                        .itemClickListener(new MaterialDialog.ItemClickListener() {
                            @Override
                            public void onClick(View v, int position, long id) {
                                super.onClick(v, position, id);
                                spanButton.setText(spanList[position]);
                            }
                        })
                        .showListener(new MaterialDialog.ShowListener() {
                            @Override
                            public void onShow(AlertDialog dialog) {
                                super.onShow(dialog);
                            }
                        });
                sunSignDialog.show();
            }
        });


        getHoroscopeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!sunSignButton.getText().toString().equals("Select a sun sign") && !spanButton.getText().toString().equals("Select span")) {
                    if (spanButton.getText().toString().equals(spanList[0])) {
                        getTodayHoroscope(extractSunSign(sunSignButton.getText().toString()));
//                        Log.d("called",sunSignButton.getText().toString());
                    }
                    if (spanButton.getText().toString().equals(spanList[1])){
                        getNextHoroscope(extractSunSign(sunSignButton.getText().toString()));
                    }
                    if (spanButton.getText().toString().equals(spanList[2])){
                        getPreviousHoroscope(extractSunSign(sunSignButton.getText().toString()));
                    }
                    if (spanButton.getText().toString().equals(spanList[3])){
                        getWeeklyHoroscope(extractSunSign(sunSignButton.getText().toString()));
                    }
                    if (spanButton.getText().toString().equals(spanList[4])){
                        getMonthlyHoroscope(extractSunSign(sunSignButton.getText().toString()));
                    }
                }
            }
        });
    }

    private void getTodayHoroscope(final String sunSign) {


        Call<PredictionResponse> call = astrologyApiInterface.getTodaysHoroscope(AstrologyApiInterface.HEADER_TOKEN, sunSign);

        call.enqueue(new Callback<PredictionResponse>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(Call<PredictionResponse> call, Response<PredictionResponse> response) {
                if (response.isSuccessful()) {
                    titleTextView.setText(sunSign);
                    detailsTextView.setText(
                            "Health : " + response.body().getPredictionModel().getHealth()
                                    + "\n \nLuck : " + response.body().getPredictionModel().getLuck()
                                    + "\n \nEmotions : " + response.body().getPredictionModel().getEmotions()
                                    + "\n \nTravel : " + response.body().getPredictionModel().getTravel()
                                    + "\n \nPersonal Life : " + response.body().getPredictionModel().getPersonalLife()
                                    + "\n \nProfession : " + response.body().getPredictionModel().getProfession());
//                    Toast.makeText(getContext(), "done", Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(DailyHoroscopeActivity.this, "Couldn't connect. Error : " + response.code(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PredictionResponse> call, Throwable t) {
                Toast.makeText(DailyHoroscopeActivity.this, "Failed to connect.", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void getNextHoroscope(final String sunSign){

        Call<NextPredictionResponse> call = astrologyApiInterface.getNextHoroscope(AstrologyApiInterface.HEADER_TOKEN,sunSign);

        call.enqueue(new Callback<NextPredictionResponse>() {
            @Override
            public void onResponse(Call<NextPredictionResponse> call, Response<NextPredictionResponse> response) {
                if(response.isSuccessful()){
                    titleTextView.setText(sunSign+" on "+response.body().getPredictionDate());
                    detailsTextView.setText(response.body().getPrediction());
                }
                else
                    Toast.makeText(DailyHoroscopeActivity.this, "Couldn't connect. Error : " + response.code(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<NextPredictionResponse> call, Throwable t) {
                Toast.makeText(DailyHoroscopeActivity.this, "Failed to connect.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getPreviousHoroscope(final String sunSign){

        Call<NextPredictionResponse> call = astrologyApiInterface.getPreviousHoroscope(AstrologyApiInterface.HEADER_TOKEN,sunSign);

        call.enqueue(new Callback<NextPredictionResponse>() {
            @Override
            public void onResponse(Call<NextPredictionResponse> call, Response<NextPredictionResponse> response) {
                if(response.isSuccessful()){
                    titleTextView.setText(sunSign+" on "+response.body().getPredictionDate());
                    detailsTextView.setText(response.body().getPrediction());
                }
                else
                    Toast.makeText(DailyHoroscopeActivity.this, "Couldn't connect. Error : " + response.code(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<NextPredictionResponse> call, Throwable t) {
                Toast.makeText(DailyHoroscopeActivity.this, "Failed to connect.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getWeeklyHoroscope(final String sunSign){

        Call<WeeklyPredictionResponse> call = astrologyApiInterface.getWeeklyHoroscope(AstrologyApiInterface.HEADER_TOKEN,sunSign);

        call.enqueue(new Callback<WeeklyPredictionResponse>() {
            @Override
            public void onResponse(Call<WeeklyPredictionResponse> call, Response<WeeklyPredictionResponse> response) {
                if(response.isSuccessful()){
                    titleTextView.setText(sunSign+" from "+response.body().getPredictionStartDate()+" to "+response.body().getPredictionEndDate());
                    detailsTextView.setText(response.body().getPrediction());
                }
                else
                    Toast.makeText(DailyHoroscopeActivity.this, "Couldn't connect. Error : " + response.code(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<WeeklyPredictionResponse> call, Throwable t) {
                Toast.makeText(DailyHoroscopeActivity.this, "Failed to connect.", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void getMonthlyHoroscope(final String sunSign){

        Call<MonthlyPredictionResponse> call = astrologyApiInterface.getMonthlyHoroscope(AstrologyApiInterface.HEADER_TOKEN,sunSign);

        call.enqueue(new Callback<MonthlyPredictionResponse>() {
            @Override
            public void onResponse(Call<MonthlyPredictionResponse> call, Response<MonthlyPredictionResponse> response) {
                if(response.isSuccessful()){
                    titleTextView.setText(sunSign+" for "+response.body().getPredictionMonth());
                    StringBuffer sb = new StringBuffer("");
                    for(int i=0;i<response.body().getPrediction().size();i++){
                        sb.append(response.body().getPrediction().get(i));
                    }
                    detailsTextView.setText(sb.toString());
                }
                else
                    Toast.makeText(DailyHoroscopeActivity.this, "Couldn't connect. Error : " + response.code(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<MonthlyPredictionResponse> call, Throwable t) {
                Toast.makeText(DailyHoroscopeActivity.this, "Failed to connect. "+t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("Response",t.getMessage());
            }
        });
    }

    private String extractSunSign(String sunSign){
        return sunSign.substring(0,sunSign.indexOf("(")-1);
    }
}
