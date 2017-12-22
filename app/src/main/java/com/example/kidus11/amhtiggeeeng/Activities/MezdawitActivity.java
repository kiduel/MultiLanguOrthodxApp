package com.example.kidus11.amhtiggeeeng.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kidus11.amhtiggeeeng.Adapters.DateRVAdapter;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.data.Day;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MezdawitActivity extends AppCompatActivity {
    @BindView(R.id.rv_dawit)RecyclerView rv_dawit;

    DateRVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mezdawit);
        String dawitLang = getIntent().getStringExtra("mez_language");
        ButterKnife.bind(this);

        ArrayList<Day> dawitInEnglish = new ArrayList<>();
        dawitInEnglish.add(new Day(getResources().getString(R.string.daw_eng_1st), getResources().getString(R.string.daw_eng_1st_des)));
        dawitInEnglish.add(new Day(getResources().getString(R.string.daw_eng_2nd), getResources().getString(R.string.daw_eng_2nd_des)));
        dawitInEnglish.add(new Day(getResources().getString(R.string.daw_eng_3rd), getResources().getString(R.string.daw_eng_3rd_des)));
        dawitInEnglish.add(new Day(getResources().getString(R.string.daw_eng_4th), getResources().getString(R.string.daw_eng_4th_des)));

        ArrayList<Day> dawitInAmh = new ArrayList<>();
        dawitInAmh.add(new Day(getResources().getString(R.string.daw_amh_1st), getResources().getString(R.string.daw_amh_1st_des)));
        dawitInAmh.add(new Day(getResources().getString(R.string.daw_amh_2nd), getResources().getString(R.string.daw_amh_2nd_des)));
        dawitInAmh.add(new Day(getResources().getString(R.string.daw_amh_3rd), getResources().getString(R.string.daw_amh_3rd_des)));
        dawitInAmh.add(new Day(getResources().getString(R.string.daw_amh_4th), getResources().getString(R.string.daw_amh_4th_des)));

        ArrayList<Day> dawitInGeez = new ArrayList<>();
        dawitInGeez.add(new Day(getResources().getString(R.string.daw_geez_1st), getResources().getString(R.string.daw_geez_1st_des)));
        dawitInGeez.add(new Day(getResources().getString(R.string.daw_geez_2nd), getResources().getString(R.string.daw_geez_2nd_des)));
        dawitInGeez.add(new Day(getResources().getString(R.string.daw_geez_3rd), getResources().getString(R.string.daw_geez_3rd_des)));
        dawitInGeez.add(new Day(getResources().getString(R.string.daw_geez_4th), getResources().getString(R.string.daw_geez_4th_des)));

        ArrayList<Day> dawitInTig = new ArrayList<>();
        dawitInTig.add(new Day(getResources().getString(R.string.daw_tig_1st), getResources().getString(R.string.daw_tig_1st_des)));
        dawitInTig.add(new Day(getResources().getString(R.string.daw_tig_2nd), getResources().getString(R.string.daw_tig_2nd_des)));
        dawitInTig.add(new Day(getResources().getString(R.string.daw_tig_3rd), getResources().getString(R.string.daw_tig_3rd_des)));
        dawitInTig.add(new Day(getResources().getString(R.string.daw_tig_4th), getResources().getString(R.string.daw_tig_4th_des)));

        if (dawitLang.equals(getResources().getString(R.string.mez_amh_title))){
            adapter = new DateRVAdapter(this, dawitInAmh);
        } else if (dawitLang.equals(getResources().getString(R.string.mez_eng_title))) {
            adapter = new DateRVAdapter(this,dawitInEnglish );

        } else if (dawitLang.equals(getResources().getString(R.string.mez_tig_title))){
            adapter = new DateRVAdapter(this, dawitInTig);

        } else if (dawitLang.equals(getResources().getString(R.string.mez_geez_title))){
            adapter = new DateRVAdapter(this, dawitInGeez);

        }
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv_dawit.setLayoutManager(layoutManager);
        rv_dawit.setAdapter(adapter);
    }



}
