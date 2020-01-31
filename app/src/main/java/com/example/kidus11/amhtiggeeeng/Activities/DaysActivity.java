package com.example.kidus11.amhtiggeeeng.Activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MenuItem;

import com.example.kidus11.amhtiggeeeng.Adapters.DateRVAdapter;
import com.example.kidus11.amhtiggeeeng.Fragment.YeEletuFragment;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.Utility;
import com.example.kidus11.amhtiggeeeng.data.Day;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DaysActivity extends AppCompatActivity {

    @BindView(R.id.rv_days)
     RecyclerView rv_days;
    @BindView(R.id.adViewDays)
    AdView banner_ad;

    static public int LANGUAGE = 0;


    private DateRVAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);
        ButterKnife.bind(this);
        String prayerLanguage = getIntent().getStringExtra("Prayer_ID");
        setTitle(prayerLanguage);

        //To request and load Ads that is already in the layout
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("0DEEF21400DD4AF964C51630FE5112C7")
                .build();
        banner_ad.loadAd(adRequest);

        //provide back button on the actionBar
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Bundle bundle = new Bundle();
        bundle.putString("hellow", "From Activity");
        // set Fragmentclass Arguments
        YeEletuFragment fragmentObject = new YeEletuFragment();
        fragmentObject.setArguments(bundle);


        ArrayList<Object> Amh_days = new ArrayList<>();
        Amh_days.add(new Day(getResources().getString(R.string.day_monday_amharic), getResources().getString(R.string.day_monday_amharic_desc)));
        Amh_days.add(new Day(getResources().getString(R.string.day_tuesday_amharic), getResources().getString(R.string.day_tuesday_amharic_desc)));
        Amh_days.add(new Day(getResources().getString(R.string.day_wednesday_amharic), getResources().getString(R.string.day_wednesday_amharic_desc)));
        Amh_days.add(new Day(getResources().getString(R.string.day_thursday_amharic), getResources().getString(R.string.day_thursday_amharic_desc)));
        Amh_days.add(new Day(getResources().getString(R.string.day_friday_amharic), getResources().getString(R.string.day_friday_amharic_desc)));
        Amh_days.add(new Day(getResources().getString(R.string.day_saturday_amharic), getResources().getString(R.string.day_saturday_amharic_desc)));
        Amh_days.add(new Day(getResources().getString(R.string.day_sunday_amharic), getResources().getString(R.string.day_sunday_amharic_desc)));
        Amh_days.add(getResources().getString(R.string.mez_amh_title));



        ArrayList<Object> Eng_days = new ArrayList<>();
        Eng_days.add(new Day(getResources().getString(R.string.day_monday_english), getResources().getString(R.string.day_monday_english_desc)));
        Eng_days.add(new Day(getResources().getString(R.string.day_tuesday_english), getResources().getString(R.string.day_tuesday_english_desc)));
        Eng_days.add(new Day(getResources().getString(R.string.day_wednesday_english), getResources().getString(R.string.day_wednesday_english_desc)));
        Eng_days.add(new Day(getResources().getString(R.string.day_thursday_english), getResources().getString(R.string.day_thursday_english_desc)));
        Eng_days.add(new Day(getResources().getString(R.string.day_friday_english), getResources().getString(R.string.day_friday_english_desc)));
        Eng_days.add(new Day(getResources().getString(R.string.day_saturday_english), getResources().getString(R.string.day_saturday_english_desc)));
        Eng_days.add(new Day(getResources().getString(R.string.day_sunday_english), getResources().getString(R.string.day_sunday_english_desc)));
        Eng_days.add(getResources().getString(R.string.mez_eng_title));

        ArrayList<Object> Geez_days = new ArrayList<>();
        Geez_days.add(new Day(getResources().getString(R.string.day_monday_geez), getResources().getString(R.string.day_monday_geez_desc)));
        Geez_days.add(new Day(getResources().getString(R.string.day_tuesday_geez), getResources().getString(R.string.day_tuesday_geez_desc)));
        Geez_days.add(new Day(getResources().getString(R.string.day_wednesday_geez), getResources().getString(R.string.day_wednesday_geez_desc)));
        Geez_days.add(new Day(getResources().getString(R.string.day_thursday_geez), getResources().getString(R.string.day_thursday_geez_desc)));
        Geez_days.add(new Day(getResources().getString(R.string.day_friday_geez), getResources().getString(R.string.day_friday_geez_desc)));
        Geez_days.add(new Day(getResources().getString(R.string.day_saturday_geez), getResources().getString(R.string.day_saturday_geez_desc)));
        Geez_days.add(new Day(getResources().getString(R.string.day_sunday_geez), getResources().getString(R.string.day_sunday_geez_desc)));
        Geez_days.add(getResources().getString(R.string.mez_geez_title));

        ArrayList<Object> Tig_days = new ArrayList<>();
        Tig_days.add(new Day(getResources().getString(R.string.day_monday_tig), getResources().getString(R.string.day_monday_tig_desc)));
        Tig_days.add(new Day(getResources().getString(R.string.day_tuesday_tig), getResources().getString(R.string.day_tuesday_tig_desc)));
        Tig_days.add(new Day(getResources().getString(R.string.day_wednesday_tig), getResources().getString(R.string.day_wednesday_tig_desc)));
        Tig_days.add(new Day(getResources().getString(R.string.day_thursday_tig), getResources().getString(R.string.day_thursday_tig_desc)));
        Tig_days.add(new Day(getResources().getString(R.string.day_friday_tig), getResources().getString(R.string.day_friday_tig_desc)));
        Tig_days.add(new Day(getResources().getString(R.string.day_saturday_tig), getResources().getString(R.string.day_saturday_tig_desc)));
        Tig_days.add(new Day(getResources().getString(R.string.day_sunday_tig), getResources().getString(R.string.day_sunday_tig_desc)));
        Tig_days.add(getResources().getString(R.string.mez_tig_title));

        if ( prayerLanguage.equals(getResources().getString(R.string.card_title_Amharic)) ) {
            LANGUAGE = Utility.AMHARIC;
            adapter = new DateRVAdapter(this, Amh_days);

        } else if ( prayerLanguage.equals(getResources().getString(R.string.card_title_Eng)) ) {
            LANGUAGE = Utility.ENGLISH;
            adapter = new DateRVAdapter(this, Eng_days);

        } else if ( prayerLanguage.equals(getResources().getString(R.string.card_title_Geez)) ) {
            LANGUAGE = Utility.GEEZ;
            adapter = new DateRVAdapter(this, Geez_days);


        } else if ( prayerLanguage.equals(getResources().getString(R.string.card_title_Tig)) ) {
            LANGUAGE = Utility.TIGRIGNA;
            adapter = new DateRVAdapter(this, Tig_days);
        }
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv_days.setLayoutManager(layoutManager);
        rv_days.setAdapter(adapter);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
