package tech.iosd.gemselections.MainContent;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.Random;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Retrofit.AstrologyApiInterface;
import tech.iosd.gemselections.Retrofit.RequestModels.PdfRequestModel;
import tech.iosd.gemselections.Retrofit.ResponseModels.PdfHoroscopeResponse;
import tech.iosd.gemselections.Utils.Constants;

public class PdfHoroscopeActivity extends AppCompatActivity {
    Button datePickerButton, timePickerButton, submitButton;
    EditText nameEditText, genderEditText, placeEditText;
    Spinner languageSpinner, typeSpinner;
    int hourOfTheDay = -1, minute = -1;
    int dayNumber = -1, monthNumber = -1, yearNumber = -1;
    Retrofit retrofit;
    AstrologyApiInterface astrologyApiInterface;
    String chartType, chartLanguage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_horoscope);

        datePickerButton = findViewById(R.id.pdf_horoscope_dob);
        timePickerButton = findViewById(R.id.pdf_horoscope_tob);
        submitButton = findViewById(R.id.pdf_horoscope_submit_button);

        nameEditText = findViewById(R.id.pdf_horoscope_name);
        genderEditText = findViewById(R.id.pdf_horoscope_gender);
        placeEditText = findViewById(R.id.pdf_horoscope_birth_place);

        languageSpinner = findViewById(R.id.pdf_horoscope_language);
        typeSpinner = findViewById(R.id.pdf_horoscope_style);

        languageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chartLanguage = languageSpinner.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        typeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                chartType = typeSpinner.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        languageSpinner.setSelection(1);
        typeSpinner.setSelection(1);

        retrofit = new Retrofit.Builder()
                .baseUrl("https://pdf.astrologyapi.com/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        astrologyApiInterface = retrofit.create(AstrologyApiInterface.class);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (minute != -1
                        && hourOfTheDay != -1
                        && yearNumber != -1
                        && dayNumber != -1
                        && monthNumber != -1
                        && !nameEditText.getText().toString().isEmpty()
                        && !genderEditText.getText().toString().isEmpty()
                        && !placeEditText.getText().toString().isEmpty()) {

                    Log.d("TAGGERPDF",nameEditText.getText().toString()+"");
                    Log.d("TAGGERPDF",genderEditText.getText().toString()+"");
                    Log.d("TAGGERPDF",dayNumber+"");
                    Log.d("TAGGERPDF",monthNumber+"");
                    Log.d("TAGGERPDF",yearNumber+"");
                    Log.d("TAGGERPDF",hourOfTheDay+"");
                    Log.d("TAGGERPDF",minute+"");
                    Log.d("TAGGERPDF",Constants.PRIMARY_LAT+"");
                    Log.d("TAGGERPDF",Constants.PRIMARY_LNG+"");
                    Log.d("TAGGERPDF",placeEditText.getText().toString()+"");
                    Log.d("TAGGERPDF",minute+"");
                    Log.d("TAGGERPDF",minute+"");
                    Log.d("TAGGERPDF",minute+"");
                    Log.d("TAGGERPDF",minute+"");
                    Log.d("TAGGERPDF",minute+"");

                    PdfRequestModel pdfRequestModel = new PdfRequestModel(nameEditText.getText().toString()
                            , genderEditText.getText().toString()
                            , dayNumber
                            , monthNumber
                            , yearNumber
                            , hourOfTheDay
                            , minute
                            , Constants.PRIMARY_LAT
                            , Constants.PRIMARY_LNG
                            , "en"
                            , Constants.TIMEZONE
                            , placeEditText.getText().toString()
                            , "NORTH_INDIAN"
                            , "Footer Link"
                            , "https://avatars1.githubusercontent.com/u/26330940?s=400&v=4"
                            , "Gem Selections"
                            , "Gem selections company info"
                            , "gem selections domain url"
                            , "care@khannagems.com"
                            , "9711318036"
                            , "9711318036");

                    sendPdfRequest(pdfRequestModel);

                }
            }
        });

        datePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(PdfHoroscopeActivity.this, 2018, 1, 1);
            }
        });

        timePickerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePicker(PdfHoroscopeActivity.this,12,0,true);
            }
        });

    }

    public void sendPdfRequest(PdfRequestModel pdfRequestModel) {

        Call<PdfHoroscopeResponse> call = astrologyApiInterface.sendPdfDetails(astrologyApiInterface.HEADER_TOKEN, pdfRequestModel);

        call.enqueue(new Callback<PdfHoroscopeResponse>() {
            @Override
            public void onResponse(Call<PdfHoroscopeResponse> call, Response<PdfHoroscopeResponse> response) {
                if (response.isSuccessful()) {
                    Log.d("PDF", "RESPONSE SUCCESSFUL");
                    if (response.body().getStatus()) {
                        getPdfFile(response.body().getPdfUrl());
                    }
                }
                else
                    Log.d("PDF", "BAD RESPONSE " + response.code());
            }

            @Override
            public void onFailure(Call<PdfHoroscopeResponse> call, Throwable t) {
                Log.d("PDF", "RESPONSE FAILED"+t.getLocalizedMessage());
            }
        });


    }

    public void getPdfFile(String pdfUrl) {
        Call<ResponseBody> call = astrologyApiInterface.getPdfHoroscope(astrologyApiInterface.HEADER_TOKEN, pdfUrl);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) {
                    savePdfFile(response.body());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });
    }

    public void savePdfFile(ResponseBody body) {

        if (ContextCompat.checkSelfPermission(getApplicationContext(),
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(PdfHoroscopeActivity.this,
                    new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
        } else {
            save_image(body);
        }

    }

    private boolean save_image(ResponseBody body) {
        final String filePath = Environment.getExternalStorageDirectory().toString();

        File dir = new File(filePath + "/gemselections_images");
        dir.mkdirs();

        Random generate = new Random();
        int n = 10000;
        n = generate.nextInt(n);

        String fName = "GemSelectionsPDF-" + n + ".pdf";

        File file = new File(dir, fName);
        if (file.exists()) {
            n++;
            fName = "GemSelectionsPDF-" + n * 10 + ".pdf";
            file = new File(dir, fName);
        }

        try {
            InputStream inputStream = null;
            OutputStream outputStream = null;

            try {
                byte[] fileReader = new byte[4096];

                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(file);

                while (true) {
                    int read = inputStream.read(fileReader);

                    if (read == -1) {
                        break;
                    }

                    outputStream.write(fileReader, 0, read);

                    fileSizeDownloaded += read;

                    Log.d("TAG", "file download: " + fileSizeDownloaded + " of " + fileSize);
                }

                outputStream.flush();

                return true;
            } catch (IOException e) {
                return false;
            } finally {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (outputStream != null) {
                    outputStream.close();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(PdfHoroscopeActivity.this, "Could not save image", Toast.LENGTH_SHORT).show();
        } catch (NullPointerException e) {
            Toast.makeText(PdfHoroscopeActivity.this, "Could not save image", Toast.LENGTH_SHORT).show();
        }
        return true;
    }


    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    public void showDatePicker(Context context, int year, int month, int defaultdate) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                datePickerButton.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                setDayNumber(dayOfMonth);
                setYearNumber(year);
                setMonthNumber(month + 1);
            }
        }, year, month, 1);
        datePickerDialog.show();
    }

    public void showTimePicker(Context context, int hour, int minute, boolean mode) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.i("Hour of the day", hourOfDay + "");
                Log.i("minute of the day", minute + "");
                setHourOfTheDay(hourOfDay);
                setMinute(minute);

                String minute_string = "";
                if (minute < 10) {
                    minute_string = "0" + minute;
                } else if (minute > 9) {
                    minute_string = "" + minute;
                }

                timePickerButton.setText(hourOfDay + ":" + minute_string);
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }

    public int getHourOfTheDay() {
        return hourOfTheDay;
    }

    public void setHourOfTheDay(int hourOfTheDay) {
        this.hourOfTheDay = hourOfTheDay;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getDayNumber() {
        return dayNumber;
    }

    public void setDayNumber(int dayNumber) {
        this.dayNumber = dayNumber;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }
}