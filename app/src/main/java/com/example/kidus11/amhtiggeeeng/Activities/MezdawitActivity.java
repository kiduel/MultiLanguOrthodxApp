package com.example.kidus11.amhtiggeeeng.Activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kidus11.amhtiggeeeng.Adapters.DateRVAdapter;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.data.Day;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MezdawitActivity extends AppCompatActivity {
    @BindView(R.id.rv_dawit)
     RecyclerView rv_dawit;
    @BindView(R.id.adView)
    AdView banner_ad;

    private DateRVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mezdawit);
        String dawitLang = getIntent().getStringExtra("mez_language");
        ButterKnife.bind(this);
        setTitle(dawitLang);

        //To request and load Ads that is already in the layout
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("0DEEF21400DD4AF964C51630FE5112C7")
                .build();
        banner_ad.loadAd(adRequest);


        ArrayList<Object> dawitInEnglish = new ArrayList<>();
        dawitInEnglish.add(new Day(getResources().getString(R.string.daw_eng_1st), getResources().getString(R.string.daw_eng_1st_des)));
        dawitInEnglish.add(new Day(getResources().getString(R.string.daw_eng_2nd), getResources().getString(R.string.daw_eng_2nd_des)));
        dawitInEnglish.add(new Day(getResources().getString(R.string.daw_eng_3rd), getResources().getString(R.string.daw_eng_3rd_des)));
        dawitInEnglish.add(new Day(getResources().getString(R.string.daw_eng_4th), getResources().getString(R.string.daw_eng_4th_des)));
        dawitInEnglish.add(new Day(getResources().getString(R.string.daw_eng_5th), getResources().getString(R.string.daw_eng_5th_des)));
        dawitInEnglish.add(new Day(getResources().getString(R.string.daw_eng_6th), getResources().getString(R.string.daw_eng_6th_des)));
        dawitInEnglish.add(new Day(getResources().getString(R.string.daw_eng_7th), getResources().getString(R.string.daw_eng_7th_des)));
        dawitInEnglish.add(new Day(getResources().getString(R.string.daw_eng_8th), getResources().getString(R.string.daw_eng_8th_des)));

        ArrayList<Object> dawitInTig = new ArrayList<>();
        dawitInTig.add(new Day(getResources().getString(R.string.daw_tig_1st), getResources().getString(R.string.daw_tig_1st_des)));
        dawitInTig.add(new Day(getResources().getString(R.string.daw_tig_2nd), getResources().getString(R.string.daw_tig_2nd_des)));
        dawitInTig.add(new Day(getResources().getString(R.string.daw_tig_3rd), getResources().getString(R.string.daw_tig_3rd_des)));
        dawitInTig.add(new Day(getResources().getString(R.string.daw_tig_4th), getResources().getString(R.string.daw_tig_4th_des)));
        dawitInTig.add(new Day(getResources().getString(R.string.daw_tig_5th), getResources().getString(R.string.daw_tig_5th_des)));
        dawitInTig.add(new Day(getResources().getString(R.string.daw_tig_6th), getResources().getString(R.string.daw_tig_6th_des)));
        dawitInTig.add(new Day(getResources().getString(R.string.daw_tig_7th), getResources().getString(R.string.daw_tig_7th_des)));


        ArrayList<Object> dawitInAmh = new ArrayList<>();
        dawitInAmh.add(new Day(getResources().getString(R.string.daw_amh_1st), getResources().getString(R.string.daw_amh_1st_des)));
        dawitInAmh.add(new Day(getResources().getString(R.string.daw_amh_2nd), getResources().getString(R.string.daw_amh_2nd_des)));
        dawitInAmh.add(new Day(getResources().getString(R.string.daw_amh_3rd), getResources().getString(R.string.daw_amh_3rd_des)));
        dawitInAmh.add(new Day(getResources().getString(R.string.daw_amh_4th), getResources().getString(R.string.daw_amh_4th_des)));
        dawitInAmh.add(new Day(getResources().getString(R.string.daw_amh_5th), getResources().getString(R.string.daw_amh_5th_des)));

        ArrayList<Object> dawitInGeez = new ArrayList<>();
        dawitInGeez.add(new Day(getResources().getString(R.string.daw_geez_1st), getResources().getString(R.string.daw_geez_1st_des)));
        dawitInGeez.add(new Day(getResources().getString(R.string.daw_geez_2nd), getResources().getString(R.string.daw_geez_2nd_des)));
        dawitInGeez.add(new Day(getResources().getString(R.string.daw_geez_3rd), getResources().getString(R.string.daw_geez_3rd_des)));
        dawitInGeez.add(new Day(getResources().getString(R.string.daw_geez_4th), getResources().getString(R.string.daw_geez_4th_des)));
        dawitInGeez.add(new Day(getResources().getString(R.string.daw_geez_5th), getResources().getString(R.string.daw_geez_5th_des)));


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
