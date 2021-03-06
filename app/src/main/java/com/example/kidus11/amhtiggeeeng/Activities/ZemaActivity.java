package com.example.kidus11.amhtiggeeeng.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;

import com.example.kidus11.amhtiggeeeng.Adapters.AudioAdapter;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.data.Audio;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by kidus11 on 12/26/17.
 */

public class ZemaActivity extends AppCompatActivity {
    @BindView(R.id.rv_music)
     RecyclerView rv_music;
    @BindView(R.id.adView)
    AdView banner_ad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zema);
        ButterKnife.bind(this);
        setTitle(getResources().getString(R.string.hymn_menu));

        //To request and load Ads that is already in the layout
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("0DEEF21400DD4AF964C51630FE5112C7")
                .build();
        banner_ad.loadAd(adRequest);

        //provide back button on the actionBar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayList<Audio> zema = new ArrayList<>();

        zema.add(new Audio(getResources().getString(R.string.wdase_maryam),"https://i.pinimg.com/736x/b3/fc/78/b3fc782c37bdb1d2561564fc28a07e4d--white-background-wallpaper.jpg"));
        zema.add(new Audio(getResources().getString(R.string.seatat),"https://i.pinimg.com/736x/b3/fc/78/b3fc782c37bdb1d2561564fc28a07e4d--white-background-wallpaper.jpg"));

        AudioAdapter audioAdapter = new AudioAdapter(this, zema);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rv_music.setLayoutManager(staggeredGridLayoutManager);
        rv_music.setAdapter(audioAdapter);
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
