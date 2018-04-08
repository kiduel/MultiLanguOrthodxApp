package com.example.kidus11.amhtiggeeeng.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.kidus11.amhtiggeeeng.Adapters.AudioAdapter;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.Utility;
import com.example.kidus11.amhtiggeeeng.data.Audio;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kidus11 on 1/4/18.
 */

public class KdaseActivity extends AppCompatActivity{
    @BindView(R.id.rv_kdase)
     RecyclerView rv_kdase;
    @BindView(R.id.adView)
    AdView banner_ad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kdase);
        ButterKnife.bind(this);
        setTitle("ቅዳሴ");

        //provide back button on the actionBar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        //To request and load Ads that is already in the layout
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("0DEEF21400DD4AF964C51630FE5112C7")
                .build();
        banner_ad.loadAd(adRequest);

        //notify users that they are not connected to the internet
        if (!Utility.isOnline(this)){
            Toast.makeText(this, "Please connect to the internet", Toast.LENGTH_LONG).show();
        }
        String prayerLanguage = getIntent().getStringExtra("audio_passed");

        ArrayList<Audio> kidaseOptions = new ArrayList<>();
        kidaseOptions.add(new Audio(getResources().getString(R.string.card_title_Amharic),"https://i.pinimg.com/736x/b3/fc/78/b3fc782c37bdb1d2561564fc28a07e4d--white-background-wallpaper.jpg"));
        kidaseOptions.add(new Audio(getResources().getString(R.string.card_title_Tig),"https://i.pinimg.com/736x/b3/fc/78/b3fc782c37bdb1d2561564fc28a07e4d--white-background-wallpaper.jpg"));

        AudioAdapter kdaseLan = new AudioAdapter(this, kidaseOptions);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rv_kdase.setLayoutManager(staggeredGridLayoutManager);
        rv_kdase.setAdapter(kdaseLan);
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


