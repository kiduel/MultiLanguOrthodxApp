package com.example.kidus11.amhtiggeeeng.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kidus11.amhtiggeeeng.Adapters.DateRVAdapter;
import com.example.kidus11.amhtiggeeeng.Fragment.YeEletuFragment;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.data.Day;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DaysActivity extends AppCompatActivity {

    @BindView(R.id.rv_days) RecyclerView rv_days;

    DateRVAdapter adapter;
    String prayerLanguage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days);
        ButterKnife.bind(this);
        prayerLanguage = getIntent().getStringExtra("Prayer_ID");
        //Toast.makeText(this, prayerLanguage, Toast.LENGTH_SHORT).show();

        Bundle bundle = new Bundle();
        bundle.putString("hellow", "From Activity");
        // set Fragmentclass Arguments
        YeEletuFragment fragmentObject = new YeEletuFragment();
        fragmentObject.setArguments(bundle);

        ArrayList <Day> Amh_days = new ArrayList<>();
        Amh_days.add(new Day(getResources().getString(R.string.day_monday_amharic),getResources().getString(R.string.day_monday_amharic_desc)));
        Amh_days.add(new Day(getResources().getString(R.string.day_tuesday_amharic),getResources().getString(R.string.day_tuesday_amharic_desc)));
        Amh_days.add(new Day(getResources().getString(R.string.day_wednesday_amharic),getResources().getString(R.string.day_wednesday_amharic_desc)));
        Amh_days.add(new Day(getResources().getString(R.string.day_thursday_amharic),getResources().getString(R.string.day_thursday_amharic_desc)));
        Amh_days.add(new Day(getResources().getString(R.string.day_friday_amharic),getResources().getString(R.string.day_friday_amharic_desc)));
        Amh_days.add(new Day(getResources().getString(R.string.day_saturday_amharic),getResources().getString(R.string.day_saturday_amharic_desc)));
        Amh_days.add(new Day(getResources().getString(R.string.day_sunday_amharic),getResources().getString(R.string.day_sunday_amharic_desc)));
        Amh_days.add(new Day(getResources().getString(R.string.mez_amh_title)));

        ArrayList <Day> Eng_days = new ArrayList<>();
        Eng_days.add(new Day(getResources().getString(R.string.day_monday_english),getResources().getString(R.string.day_monday_english_desc)));
        Eng_days.add(new Day(getResources().getString(R.string.day_tuesday_english),getResources().getString(R.string.day_tuesday_english_desc)));
        Eng_days.add(new Day(getResources().getString(R.string.day_wednesday_english),getResources().getString(R.string.day_wednesday_english_desc)));
        Eng_days.add(new Day(getResources().getString(R.string.day_thursday_english),getResources().getString(R.string.day_thursday_english_desc)));
        Eng_days.add(new Day(getResources().getString(R.string.day_friday_english),getResources().getString(R.string.day_friday_english_desc)));
        Eng_days.add(new Day(getResources().getString(R.string.day_saturday_english),getResources().getString(R.string.day_saturday_english_desc)));
        Eng_days.add(new Day(getResources().getString(R.string.day_sunday_english),getResources().getString(R.string.day_sunday_english_desc)));
        Eng_days.add(new Day(getResources().getString(R.string.mez_eng_title)));

        ArrayList <Day> Geez_days = new ArrayList<>();
        Geez_days.add(new Day(getResources().getString(R.string.day_monday_geez),getResources().getString(R.string.day_monday_geez_desc)));
        Geez_days.add(new Day(getResources().getString(R.string.day_tuesday_geez),getResources().getString(R.string.day_tuesday_geez_desc)));
        Geez_days.add(new Day(getResources().getString(R.string.day_wednesday_geez),getResources().getString(R.string.day_wednesday_geez_desc)));
        Geez_days.add(new Day(getResources().getString(R.string.day_thursday_geez),getResources().getString(R.string.day_thursday_geez_desc)));
        Geez_days.add(new Day(getResources().getString(R.string.day_friday_geez),getResources().getString(R.string.day_friday_geez_desc)));
        Geez_days.add(new Day(getResources().getString(R.string.day_saturday_geez),getResources().getString(R.string.day_saturday_geez_desc)));
        Geez_days.add(new Day(getResources().getString(R.string.day_sunday_geez),getResources().getString(R.string.day_sunday_geez_desc)));
        Geez_days.add(new Day(getResources().getString(R.string.mez_geez_title)));

        ArrayList <Day> Tig_days = new ArrayList<>();
        Tig_days.add(new Day(getResources().getString(R.string.day_monday_tig),getResources().getString(R.string.day_monday_tig_desc)));
        Tig_days.add(new Day(getResources().getString(R.string.day_tuesday_tig),getResources().getString(R.string.day_tuesday_tig_desc)));
        Tig_days.add(new Day(getResources().getString(R.string.day_wednesday_tig),getResources().getString(R.string.day_wednesday_tig_desc)));
        Tig_days.add(new Day(getResources().getString(R.string.day_thursday_tig),getResources().getString(R.string.day_thursday_tig_desc)));
        Tig_days.add(new Day(getResources().getString(R.string.day_friday_tig),getResources().getString(R.string.day_friday_tig_desc)));
        Tig_days.add(new Day(getResources().getString(R.string.day_saturday_tig),getResources().getString(R.string.day_saturday_tig_desc)));
        Tig_days.add(new Day(getResources().getString(R.string.day_sunday_tig),getResources().getString(R.string.day_sunday_tig_desc)));
        Tig_days.add(new Day(getResources().getString(R.string.mez_tig_title)));

        if (prayerLanguage.equals(getResources().getString(R.string.card_title_Amharic))){
           adapter = new DateRVAdapter(this, Amh_days);
       } else if (prayerLanguage.equals(getResources().getString(R.string.card_title_Eng))) {
           adapter = new DateRVAdapter(this, Eng_days);

        } else if (prayerLanguage.equals(getResources().getString(R.string.card_title_Geez))){
           adapter = new DateRVAdapter(this, Geez_days);

        } else if (prayerLanguage.equals(getResources().getString(R.string.card_title_Tig))){
          adapter = new DateRVAdapter(this, Tig_days);

        }
           RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
           rv_days.setLayoutManager(layoutManager);
           rv_days.setAdapter(adapter);
       }

}
