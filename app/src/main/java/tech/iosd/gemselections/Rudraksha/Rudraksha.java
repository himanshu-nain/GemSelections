package tech.iosd.gemselections.Rudraksha;

import android.app.Dialog;
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
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import tech.iosd.gemselections.MainContent.MainActivity;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.WebViewActivity;

public class Rudraksha extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private boolean ISHOMESHOWN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(tech.iosd.gemselections.R.layout.activity_rudraksha);
        Toolbar toolbar = (Toolbar) findViewById(tech.iosd.gemselections.R.id.toolbar);
      //  toolbar.setTitle("");
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(tech.iosd.gemselections.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, tech.iosd.gemselections.R.string.navigation_drawer_open, tech.iosd.gemselections.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(tech.iosd.gemselections.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        display_selected_item(tech.iosd.gemselections.R.id.nav_rud_home);
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
                            new Intent(Rudraksha.this, MainActivity.class)
                    );
                    finish();
                } else {
                    display_selected_item(tech.iosd.gemselections.R.id.nav_rud_home);
                }
            }else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(tech.iosd.gemselections.R.menu.rudraksha, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == tech.iosd.gemselections.R.id.ac_rud_buy) {
            startActivity(
                    new Intent(Rudraksha.this, WebViewActivity.class)
                        .putExtra("URL","http://khannagems.com/index.php/rudraksha.html")
                        .putExtra("parent","Rudraksha")
            );
            return true;
        }

        if(id == R.id.ac_rud_home){
            startActivity(
                    new Intent(Rudraksha.this, MainActivity.class)
            );
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        display_selected_item(id);

        return true;
    }

    private void display_selected_item(int id) {

        Fragment fragment = null;

        ISHOMESHOWN = id == tech.iosd.gemselections.R.id.nav_rud_home;

        switch (id) {

            case tech.iosd.gemselections.R.id.nav_rud_home:
                    fragment = new RudHomeFragment();
                break;
            case tech.iosd.gemselections.R.id.nav_rud_bead:
                    fragment = new RudBeadFragment();
                break;
            case tech.iosd.gemselections.R.id.nav_rud_mala:
                    fragment = new RudMalaFragment();
                break;
            case tech.iosd.gemselections.R.id.nav_rud_bracelet:
                    fragment = new RudBraceletFragment();
                break;
            case tech.iosd.gemselections.R.id.nav_rud_yugal:
                    fragment = new RudYugalFragment();
                break;
            case tech.iosd.gemselections.R.id.nav_rud_mantra:
                    show_dialog("RUDRAKSHA MANTRAS", tech.iosd.gemselections.R.layout.dialog_rudraksha_mantra);
                break;
            case tech.iosd.gemselections.R.id.nav_rud_how:
                    show_dialog("WEARING A RUDRAKSHA", tech.iosd.gemselections.R.layout.dialog_rudraksha_how);
                break;
            case tech.iosd.gemselections.R.id.nav_rud_authenticity:
                    show_dialog("AUTHENTICITY", tech.iosd.gemselections.R.layout.dialog_rudraksha_auth);
                break;
            case tech.iosd.gemselections.R.id.nav_rud_faq:
                    fragment = new RudFAQ();
                break;
        }

        if(fragment!=null){
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(tech.iosd.gemselections.R.id.rudraksha_container, fragment);
            fragmentTransaction.addToBackStack("Rudra");
            fragmentTransaction.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(tech.iosd.gemselections.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    private void show_dialog(String title, int layout) {

        Dialog dialog = new Dialog(Rudraksha.this);
        dialog.setTitle(title);
        dialog.setContentView(layout);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());

        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;

        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }
}
