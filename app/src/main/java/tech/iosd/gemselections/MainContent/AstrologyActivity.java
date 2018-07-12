package tech.iosd.gemselections.MainContent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tech.iosd.gemselections.Adapters.AstrologyAdapter;
import tech.iosd.gemselections.R;
import tech.iosd.gemselections.Utils.Banner;

public class AstrologyActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<Banner> typesList;
    private AstrologyAdapter adapater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_astrology);

        recyclerView = findViewById(R.id.astrology_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setData();
    }

    private void setData() {

        typesList = new ArrayList<>();

        /*for(int i=0; i<types.length; ++i){
            data = new JewelTypes(types[i], url[i]);
            typesList.add(data);
        }*/

        typesList.add(new Banner(getResources().getDrawable(R.drawable.match_making_background), "Match Making"));
        typesList.add(new Banner(getResources().getDrawable(R.drawable.western_astrology_background), "Western Astrology"));
        typesList.add(new Banner(getResources().getDrawable(R.drawable.daily_horoscopes_background), "Daily Horoscopes"));
        typesList.add(new Banner(getResources().getDrawable(R.drawable.indian_astrology_background), "Indian Astrology"));
//        typesList.add(new Banner(getResources().getDrawable(R.drawable.category_gem_studded_jewellery), "PDF Horoscope"));

        adapater = new AstrologyAdapter(this, typesList);
        recyclerView.setAdapter(adapater);

    }
}
