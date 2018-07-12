package tech.iosd.gemselections.Handicrafts;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import tech.iosd.gemselections.MainContent.MainActivity;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Rudraksha.Rudraksha;
import tech.iosd.gemselections.Utils.WebViewActivity;

public class Handicrafts extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private boolean ISHOMESHOWN=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tech.iosd.gemselections.R.layout.activity_handicrafts);
        Toolbar toolbar = (Toolbar) findViewById(tech.iosd.gemselections.R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(tech.iosd.gemselections.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, tech.iosd.gemselections.R.string.navigation_drawer_open, tech.iosd.gemselections.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(tech.iosd.gemselections.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        display_selected_item(tech.iosd.gemselections.R.id.nav_hand_pots);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case tech.iosd.gemselections.R.id.ac_hand_buy:
                    startActivity(
                            new Intent(Handicrafts.this, WebViewActivity.class)
                                    .putExtra("URL","http://khannagems.com")
                                    .putExtra("parent","Handicrafts")
                    );
                return true;
            case R.id.ac_hand_home :
                startActivity(
                        new Intent(Handicrafts.this, MainActivity.class)
                );
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(tech.iosd.gemselections.R.menu.handicraft, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(tech.iosd.gemselections.R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            if (getSupportFragmentManager().getBackStackEntryCount() != 0) {
                getSupportFragmentManager().popBackStack();
                if (ISHOMESHOWN) {
                    startActivity(
                            new Intent(Handicrafts.this, MainActivity.class)
                    );
                    finish();
                } else {
                    display_selected_item(tech.iosd.gemselections.R.id.nav_hand_pots);
                }
            }else{
                super.onBackPressed();
            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();

        display_selected_item(id);

        return true;
    }

    private void display_selected_item(int id) {

        Fragment fragment = null;
        ISHOMESHOWN = id == tech.iosd.gemselections.R.id.nav_hand_pots;

        switch (id){
            case tech.iosd.gemselections.R.id.nav_hand_pots:
                fragment = new HandPotsFragment();
                break;
            case tech.iosd.gemselections.R.id.nav_hand_clocks:
                fragment = new HandClocksFragment();
                break;
            case tech.iosd.gemselections.R.id.nav_hand_plates:
                fragment = new HandPlatesFragment();
                break;
            case tech.iosd.gemselections.R.id.nav_hand_gifts:
                fragment = new HandGiftsFragment();
                break;
            case tech.iosd.gemselections.R.id.nav_hand_spiritual:
                fragment = new HandSpiritualFragment();
                break;
            case tech.iosd.gemselections.R.id.nav_hand_spi_gifts:
                fragment = new HandSpiGiftsFragment();
                break;
            case tech.iosd.gemselections.R.id.nav_hand_black:
                fragment = new HandBlackFragment();
                break;
            case tech.iosd.gemselections.R.id.nav_hand_soap:
                fragment = new HandSoapFragment();
                break;
            case tech.iosd.gemselections.R.id.nav_hand_table:
                fragment = new HandTableFragment();
                break;
        }

        if(fragment!=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(tech.iosd.gemselections.R.id.handicraft_container, fragment);
            fragmentTransaction.addToBackStack("Hand");
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(tech.iosd.gemselections.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }
}
