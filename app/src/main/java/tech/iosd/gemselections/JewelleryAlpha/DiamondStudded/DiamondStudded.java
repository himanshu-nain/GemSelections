package tech.iosd.gemselections.JewelleryAlpha.DiamondStudded;

import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toolbar;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import tech.iosd.gemselections.Adapters.DiamondStuddedAdapter;
import tech.iosd.gemselections.Adapters.VictorianAdapter;
import tech.iosd.gemselections.DataProviders.DiamondStuddeddProvider;
import tech.iosd.gemselections.DataProviders.Victorian;
import tech.iosd.gemselections.JewelleryAlpha.Victorian.VictorianActivity;
import tech.iosd.gemselections.R;

public class DiamondStudded extends YouTubeBaseActivity {
    private RecyclerView recyclerView;
    private DiamondStuddedAdapter adapter;
    private List<DiamondStuddeddProvider> victorianList;

    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diamond_studded);

        toolbar = (Toolbar)findViewById(R.id.diamond_studded_toolbar);
        setActionBar(toolbar);
        getActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    //    getSupportActionBar().setHomeButtonEnabled(true);

        recyclerView = (RecyclerView)findViewById(R.id.diamond_studded_items);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(DiamondStudded.this));


        set_data();

    }

    private void set_data() {

//        String temp = "VJ 9346";
        int temp= 47458900;
        StorageReference mStorageRef= FirebaseStorage.getInstance()
                .getReference("jewellery-images/diamond studded/");

        String[] product_code = new String[13];


        for(int i=0;i<=12;i++){
            product_code[i] = "DSAG " + String.valueOf(temp + (i+1));
        }

        victorianList = new ArrayList<>();

        for (int i=0; i<12;i+=3){
            DiamondStuddeddProvider vic = new DiamondStuddeddProvider("","","",product_code[i],product_code[i+1],product_code[i+2]);
            Log.d("DSAG 47458909",product_code[i]);

            victorianList.add(vic);
        }
        adapter = new DiamondStuddedAdapter(DiamondStudded.this, victorianList,mStorageRef);

        recyclerView.setAdapter(adapter);

    }
}
