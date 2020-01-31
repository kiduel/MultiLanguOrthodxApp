package com.example.kidus11.amhtiggeeeng.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
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
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        //To request and load Ads that is already in the layout
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("0DEEF21400DD4AF964C51630FE5112C7")
                .build();
        banner_ad.loadAd(adRequest);

        //notify users that they are not connected to the internet
        if (!Utility.isOnline(this)){
            try {
                AlertDialog alertDialog = new AlertDialog.Builder(this).create();

                alertDialog.setTitle("Info");
                alertDialog.setMessage(this.getString(R.string.no_internet));
                alertDialog.setIcon(android.R.drawable.ic_dialog_alert);
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();

                    }
                });

                alertDialog.show();
            } catch (Exception e) {

            }        }
        String prayerLanguage = getIntent().getStringExtra("audio_passed");

        ArrayList<Audio> kidaseOptions = new ArrayList<>();
        kidaseOptions.add(new Audio(getResources().getString(R.string.card_title_Amharic),R.drawable.maryam_image));
        kidaseOptions.add(new Audio(getResources().getString(R.string.card_title_Tig),R.drawable.maryam_image));

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


