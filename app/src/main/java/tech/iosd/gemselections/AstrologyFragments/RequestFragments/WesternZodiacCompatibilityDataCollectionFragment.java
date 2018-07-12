package tech.iosd.gemselections.AstrologyFragments.RequestFragments;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.pepperonas.materialdialog.MaterialDialog;

import tech.iosd.gemselections.AstrologyFragments.Western.SunsignCompatibilityFragment;
import tech.iosd.gemselections.AstrologyFragments.Western.ZodiacCompatibilityFragment;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.Constants;

public class WesternZodiacCompatibilityDataCollectionFragment extends Fragment {

    Button primarySunSignButton;
    Button primaryRisingSignButton;
    Button secondarySunSignButton;
    Button secondaryRisingSignButton;
    String var1="", var2="", var3="", var4="";
    Bundle bundle;
    int fragmentId;

    String[] sunSignListToShow = {"Aries (Mar. 21–Apr. 19)\n",
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
    String[] sunSignList = {"Aries",
            "Taurus",
            "Gemini",
            "Cancer",
            "Leo",
            "Virgo",
            "Libra",
            "Scorpio",
            "Sagittarius",
            "Capricorn",
            "Aquarius",
            "Pisces"};

    Bundle fragmentIdBundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.western_sunsign_compatibility_frag, container, false);

        primarySunSignButton = view.findViewById(R.id.sun_sign_primary_button);
        primaryRisingSignButton = view.findViewById(R.id.rising_sun_primary_button);
        secondarySunSignButton = view.findViewById(R.id.sun_sign_secondary_button);
        secondaryRisingSignButton = view.findViewById(R.id.rising_sign_secondary_button);

        fragmentIdBundle = getArguments();

        if (fragmentIdBundle.getInt(Constants.FRAGMENT_ID) == 20) {
            secondaryRisingSignButton.setEnabled(false);
            secondaryRisingSignButton.setVisibility(View.GONE);

            primaryRisingSignButton.setEnabled(false);
            primaryRisingSignButton.setVisibility(View.GONE);
            fragmentId = 20;
        } else
            fragmentId = 21;

        primarySunSignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDialog.Builder sunSignDialog = new MaterialDialog.Builder(getContext())
                        .title("Choose your sun sign")
                        .message(null)
                        .positiveText("Okay")
                        .negativeText("Cancel")
                        .positiveColor(R.color.colorAccent)
                        .negativeColor(R.color.colorAccent)
                        .listItemsSingleSelection(true, sunSignListToShow)
                        .selection(0)
                        .itemClickListener(new MaterialDialog.ItemClickListener() {
                            @Override
                            public void onClick(View v, int position, long id) {
                                super.onClick(v, position, id);
                                primarySunSignButton.setText(sunSignListToShow[position]);
                                var1 = sunSignList[position];
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

        primaryRisingSignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDialog.Builder sunSignDialog = new MaterialDialog.Builder(getContext())
                        .title("Choose your sun sign")
                        .message(null)
                        .positiveText("Okay")
                        .negativeText("Cancel")
                        .positiveColor(R.color.colorAccent)
                        .negativeColor(R.color.colorAccent)
                        .listItemsSingleSelection(true, sunSignListToShow)
                        .selection(0)
                        .itemClickListener(new MaterialDialog.ItemClickListener() {
                            @Override
                            public void onClick(View v, int position, long id) {
                                super.onClick(v, position, id);
                                primaryRisingSignButton.setText(sunSignListToShow[position]);
                                var2 = sunSignList[position];

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

        secondarySunSignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDialog.Builder sunSignDialog = new MaterialDialog.Builder(getContext())
                        .title("Choose your sun sign")
                        .message(null)
                        .positiveText("Okay")
                        .negativeText("Cancel")
                        .positiveColor(R.color.colorAccent)
                        .negativeColor(R.color.colorAccent)
                        .listItemsSingleSelection(true, sunSignListToShow)
                        .selection(0)
                        .itemClickListener(new MaterialDialog.ItemClickListener() {
                            @Override
                            public void onClick(View v, int position, long id) {
                                super.onClick(v, position, id);
                                secondarySunSignButton.setText(sunSignListToShow[position]);
                                var3 = sunSignList[position];

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

        secondaryRisingSignButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialDialog.Builder sunSignDialog = new MaterialDialog.Builder(getContext())
                        .title("Choose your sun sign")
                        .message(null)
                        .positiveText("Okay")
                        .negativeText("Cancel")
                        .positiveColor(R.color.colorAccent)
                        .negativeColor(R.color.colorAccent)
                        .listItemsSingleSelection(true, sunSignListToShow)
                        .selection(0)
                        .itemClickListener(new MaterialDialog.ItemClickListener() {
                            @Override
                            public void onClick(View v, int position, long id) {
                                super.onClick(v, position, id);
                                secondaryRisingSignButton.setText(sunSignListToShow[position]);
                                var4 = sunSignList[position];

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

        view.findViewById(R.id.sun_sign_submit_buttom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!var1.isEmpty() && !var2.isEmpty() && !var3.isEmpty() && !var4.isEmpty()&&fragmentId==21 || !var1.isEmpty() && !var3.isEmpty() && fragmentId==20) {
                    bundle = new Bundle();
                    bundle.putString(Constants.PRIMARY_ZODIAC, var1);
                    bundle.putString(Constants.PRIMARY_RISING_SUN, var2);
                    bundle.putString(Constants.SECONDARY_ZODIAC, var3);
                    bundle.putString(Constants.SECONDARY_RISING_SUN, var4);

                    if (fragmentId==21)
                        setFragment(new SunsignCompatibilityFragment());
                    else if(fragmentId==20) {
                        bundle.putString(Constants.PRIMARY_ZODIAC,var1);
                        bundle.putString(Constants.SECONDARY_ZODIAC,var3);
                        setFragment(new ZodiacCompatibilityFragment());
                    }
                }
            }
        });

        return view;
    }

    private void setFragment(Fragment fragment) {
        bundle.putInt("id",fragmentId);
        FragmentManager fragmentManager = getFragmentManager();
        fragment.setArguments(bundle);
        fragmentManager.beginTransaction()
                .replace(R.id.western_astrology_container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .addToBackStack("Main")
                .commit();
    }


}


