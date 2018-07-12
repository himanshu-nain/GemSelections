package tech.iosd.gemselections.AstrologyFragments.RequestFragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

import tech.iosd.gemselections.AstrologyFragments.Western.CompositeHoroscopeFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.DailyTransitsFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.FriendshipReportFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.KarmaDestinyFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.LifeForecastFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.LoveCompatibilityFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.LunarMetricsFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.MonthlyTransitFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.PersonalityReportFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.PersonalizedPlanetPredictionFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.RomanticForecastCoupleReportFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.RomanticForecastFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.RomanticPersonalityFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.SolarReturnFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.SolarReturnHouseFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.SolarReturnPlanetFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.SynastryFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.WeeklyTransitFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.WesternChartFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.WesternHoroscopeFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.ZodiacCompatibilityFragment;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.Constants;
import tech.iosd.gemselections.Utils.SharedPreferencesUtils;

public class WesternComplexDataCollectorFragment extends Fragment {

    TextView dateTextView, partnerDateTextView;
    TextView timeTextView, partnerTimeTextView;
    TextView nameTextView, partnerNameTextView;
    int hourOfTheDay, minute, partnerMinute, partnerHourOfTheDay;
    int dayNumber, partnerDayNumber;
    int monthNumber, partnerMonthNumber;
    int yearNumber, partnerYearNumber;
    SharedPreferences sharedPreferences;
    Bundle bundle, dataBundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.western_complex_data_collector, container, false);

        bundle = getArguments();
        dataBundle = new Bundle();

        sharedPreferences = getContext().getSharedPreferences(SharedPreferencesUtils.prefsUserName, Context.MODE_PRIVATE);

        timeTextView = view.findViewById(R.id.complex_data_collection_time_text_view);
        dateTextView = view.findViewById(R.id.complex_data_collection_date_text_view);
        nameTextView = view.findViewById(R.id.complex_data_collection_name_edit_text);

        partnerTimeTextView = view.findViewById(R.id.complex2_data_collection_time_text_view);
        partnerDateTextView = view.findViewById(R.id.complex2_data_collection_date_text_view);
        partnerNameTextView = view.findViewById(R.id.complex2_data_collection_name_edit_text);

        view.findViewById(R.id.complex_collect_info_time_picker_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                showTimePicker(getContext(), hour, minute, false);
            }
        });

        view.findViewById(R.id.complex_collect_info_date_picker_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar newCalendar = Calendar.getInstance();
                int initialmonth = newCalendar.get(java.util.Calendar.MONTH);
                int initialyear = newCalendar.get(java.util.Calendar.YEAR);

                showDatePicker(getContext(), initialyear, initialmonth, 1);
            }
        });

        view.findViewById(R.id.complex2_collect_info_time_picker_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);
                showPartnerTimePicker(getContext(), hour, minute, false);
            }
        });

        view.findViewById(R.id.complex2_collect_info_date_picker_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar newCalendar = Calendar.getInstance();
                int initialmonth = newCalendar.get(java.util.Calendar.MONTH);
                int initialyear = newCalendar.get(java.util.Calendar.YEAR);

                showPartnerDatePicker(getContext(), initialyear, initialmonth, 1);
            }
        });


        monthNumber = sharedPreferences.getInt(SharedPreferencesUtils.prefsAstroMonth, -1);
        dayNumber = sharedPreferences.getInt(SharedPreferencesUtils.prefsAstroDay, -1);
        yearNumber = sharedPreferences.getInt(SharedPreferencesUtils.prefsAstroYear, -1);
        hourOfTheDay = sharedPreferences.getInt(SharedPreferencesUtils.prefsAstroHour, -1);
        minute = sharedPreferences.getInt(SharedPreferencesUtils.prefsAstroMinute, -1);
        nameTextView.setText(sharedPreferences.getString(SharedPreferencesUtils.prefsAstroName, ""));
        dateTextView.setText(dayNumber + "/" + monthNumber + "/" + yearNumber);
        timeTextView.setText(hourOfTheDay + ":" + minute);

        partnerMonthNumber = sharedPreferences.getInt(SharedPreferencesUtils.prefsAstroMonth2, -1);
        partnerDayNumber = sharedPreferences.getInt(SharedPreferencesUtils.prefsAstroDay2, -1);
        partnerYearNumber = sharedPreferences.getInt(SharedPreferencesUtils.prefsAstroYear2, -1);
        partnerHourOfTheDay = sharedPreferences.getInt(SharedPreferencesUtils.prefsAstroHour2, -1);
        partnerMinute = sharedPreferences.getInt(SharedPreferencesUtils.prefsAstroMinute2, -1);
        partnerNameTextView.setText(sharedPreferences.getString(SharedPreferencesUtils.prefsAstroName2, ""));
        partnerDateTextView.setText(partnerDayNumber + "/" + partnerMonthNumber + "/" + partnerYearNumber);
        partnerTimeTextView.setText(partnerHourOfTheDay + ":" + partnerMinute);

        view.findViewById(R.id.complex_data_collection_submit_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!timeTextView.getText().toString().equals("00:00")
                        && !dateTextView.getText().toString().equals("00/00/0000")
                        && !nameTextView.getText().toString().isEmpty()) {

                    sharedPreferences.edit()
                            .putString(SharedPreferencesUtils.prefsAstroName, nameTextView.getText().toString())
                            .putInt(SharedPreferencesUtils.prefsAstroMinute, getMinute())
                            .putInt(SharedPreferencesUtils.prefsAstroHour, getHourOfTheDay())
                            .putInt(SharedPreferencesUtils.prefsAstroDay, getDayNumber())
                            .putInt(SharedPreferencesUtils.prefsAstroMonth, getMonthNumber())
                            .putInt(SharedPreferencesUtils.prefsAstroYear, getYearNumber())
                            .putString(SharedPreferencesUtils.prefsAstroName2, partnerNameTextView.getText().toString())
                            .putInt(SharedPreferencesUtils.prefsAstroMinute2, getPartnerMinute())
                            .putInt(SharedPreferencesUtils.prefsAstroHour2, getPartnerHourOfTheDay())
                            .putInt(SharedPreferencesUtils.prefsAstroDay2, getPartnerDayNumber())
                            .putInt(SharedPreferencesUtils.prefsAstroMonth2, getPartnerMonthNumber())
                            .putInt(SharedPreferencesUtils.prefsAstroYear2, getPartnerYearNumber())
                            .apply();

                    dataBundle.putInt(Constants.PRIMARY_DAY, dayNumber);
                    dataBundle.putInt(Constants.PRIMARY_HOUR, hourOfTheDay);
                    dataBundle.putInt(Constants.PRIMARY_MIN, minute);
                    dataBundle.putInt(Constants.PRIMARY_YEAR, yearNumber);
                    dataBundle.putInt(Constants.PRIMARY_MONTH, monthNumber);
                    dataBundle.putInt(Constants.SECONDARY_DAY, partnerDayNumber);
                    dataBundle.putInt(Constants.SECONDARY_HOUR, partnerHourOfTheDay);
                    dataBundle.putInt(Constants.SECONDARY_MIN, partnerMinute);
                    dataBundle.putInt(Constants.SECONDARY_YEAR, partnerYearNumber);
                    dataBundle.putInt(Constants.SECONDARY_MONTH, partnerMonthNumber);

                    int i = bundle.getInt(Constants.FRAGMENT_ID, -1);
                    if (i >= 0) {

                        switch (i) {
                            case 0:
                                setFragment(new WesternHoroscopeFragment());
                                break;
                            case 1:
                                setFragment(new WesternChartFragment());
                                break;
                            case 2:
                                setFragment(new DailyTransitsFragment());
                                break;
                            case 3:
                                setFragment(new WeeklyTransitFragment());
                                break;
                            case 4:
                                setFragment(new MonthlyTransitFragment());
                                break;
                            case 5:
                                setFragment(new SolarReturnFragment());
                                break;
                            case 6:
                                setFragment(new SolarReturnPlanetFragment());
                                break;
                            case 7:
                                setFragment(new SolarReturnHouseFragment());
                                break;
                            case 8:
                                setFragment(new LunarMetricsFragment());
                                break;
                            case 9:
                                setFragment(new CompositeHoroscopeFragment()); //TODO: COMPLEX
                                break;
                            case 10:
                                setFragment(new SynastryFragment()); //TODO: COMPLEX
                                break;
                            case 11:
                                setFragment(new PersonalityReportFragment());
                                break;
                            case 12:
                                setFragment(new RomanticPersonalityFragment());
                                break;
                            case 13:
                                setFragment(new PersonalizedPlanetPredictionFragment());
                                break;
                            case 14:
                                setFragment(new LifeForecastFragment());
                                break;
                            case 15:
                                setFragment(new RomanticForecastFragment()); //TODO: COMPLEX
                                break;
                            case 16:
                                setFragment(new FriendshipReportFragment());//TODO: COMPLEX
                                break;
                            case 17:
                                setFragment(new KarmaDestinyFragment());//TODO: COMPLEX
                                break;
                            case 18:
                                setFragment(new LoveCompatibilityFragment());//TODO: COMPLEX
                                break;
                            case 19:
                                setFragment(new RomanticForecastCoupleReportFragment());//TODO: COMPLEX
                                break;
                            case 20:
                                setFragment(new ZodiacCompatibilityFragment());
                                break;
                            case 21:
                                setFragment(new LoveCompatibilityFragment());
                                break;

                            default:
                                Toast.makeText(getContext(), "Something went wrong.", Toast.LENGTH_SHORT).show();
                        }

                    }
                } else
                    Toast.makeText(getContext(), "Please fill all fields, they are mandatory", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }


    public void showDatePicker(Context context, int year, int month, int defaultdate) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                dateTextView.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                setMonthNumber(month + 1);
                setYearNumber(year);
                setDayNumber(dayOfMonth);
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

                timeTextView.setText(hourOfDay + ":" + minute_string);
            }
        }, hour, minute, true);
        timePickerDialog.show();
    }

    public void showPartnerDatePicker(Context context, int year, int month, int defaultdate) {
        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, dayOfMonth);
                partnerDateTextView.setText(dayOfMonth + "-" + (month + 1) + "-" + year);
                setPartnerMonthNumber(month + 1);
                setPartnerYearNumber(year);
                setPartnerDayNumber(dayOfMonth);
            }
        }, year, month, 1);
        datePickerDialog.show();
    }

    public void showPartnerTimePicker(Context context, int hour, int minute, boolean mode) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                Log.i("Hour of the day", hourOfDay + "");
                Log.i("minute of the day", minute + "");
                setPartnerHourOfTheDay(hourOfDay);
                setPartnerMinute(minute);

                String minute_string = "";
                if (minute < 10) {
                    minute_string = "0" + minute;
                } else if (minute > 9) {
                    minute_string = "" + minute;
                }

                partnerTimeTextView.setText(hourOfDay + ":" + minute_string);
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

    public int getPartnerMinute() {
        return partnerMinute;
    }

    public void setPartnerMinute(int partnerMinute) {
        this.partnerMinute = partnerMinute;
    }

    public int getPartnerHourOfTheDay() {
        return partnerHourOfTheDay;
    }

    public void setPartnerHourOfTheDay(int partnerHourOfTheDay) {
        this.partnerHourOfTheDay = partnerHourOfTheDay;
    }

    public int getPartnerDayNumber() {
        return partnerDayNumber;
    }

    public void setPartnerDayNumber(int partnerDayNumber) {
        this.partnerDayNumber = partnerDayNumber;
    }

    public int getPartnerMonthNumber() {
        return partnerMonthNumber;
    }

    public void setPartnerMonthNumber(int partnerMonthNumber) {
        this.partnerMonthNumber = partnerMonthNumber;
    }

    public int getPartnerYearNumber() {
        return partnerYearNumber;
    }

    public void setPartnerYearNumber(int partnerYearNumber) {
        this.partnerYearNumber = partnerYearNumber;
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

    public int getYearNumber() {
        return yearNumber;
    }

    public void setYearNumber(int yearNumber) {
        this.yearNumber = yearNumber;
    }

    public int getMonthNumber() {
        return monthNumber;
    }

    public void setMonthNumber(int monthNumber) {
        this.monthNumber = monthNumber;
    }

    public void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        fragment.setArguments(dataBundle);
        fragmentManager.beginTransaction()
                .replace(R.id.western_astrology_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("Main")
                .commit();
    }

}
