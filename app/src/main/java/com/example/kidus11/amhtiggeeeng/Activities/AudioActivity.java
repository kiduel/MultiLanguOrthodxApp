package com.example.kidus11.amhtiggeeeng.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.kidus11.amhtiggeeeng.Adapters.AudioAdapter_two;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.Utility;
import com.example.kidus11.amhtiggeeeng.data.Audio;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AudioActivity extends AppCompatActivity {
    @BindView(R.id.rv_audio_option)
     RecyclerView rv_audio_option;
    @BindView(R.id.adView)
    AdView banner_ad;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String AMAZON_URL_WDASE_MARYAM = "https://s3.amazonaws.com/prayer-audio/";
        String AMAZON_URL_SEATAT = "https://s3.us-east-2.amazonaws.com/seatat-audio/";
        String AMAZON_URL_KIDASE = "https://s3.us-east-2.amazonaws.com/kidase-audio/";
        https://s3.us-east-2.amazonaws.com/kidase-audio/tig+_+ezil.mp3

        //notify users that they are not connected to the internet
        if (!Utility.isOnline(this)){
            Toast.makeText(this, "Please connect to the internet", Toast.LENGTH_LONG).show();
        }


        String IMAGE_URL_SEATAT = "https://i.pinimg.com/236x/ab/d9/2b/abd92be014581bdb6894423557ede73b--haile-selassie-addis-ababa.jpg";
        String IMAGE_URL_WDASE_MARYAM = "http://www.ethiopianorthodox.org/images/icons/st-mary_with-angeles.gif";

        //provide back button on the actionBar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_audio);
        ButterKnife.bind(this);
        String prayerLanguage = getIntent().getStringExtra("audio_passed");
        setTitle("ds");


        //To request and load Ads that is already in the layout
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("0DEEF21400DD4AF964C51630FE5112C7")
                .build();
        banner_ad.loadAd(adRequest);

        ArrayList<Audio> wdaseMaryam = new ArrayList<>();
        wdaseMaryam.add(new Audio(" ሰላም ለኪ","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_WDASE_MARYAM, AMAZON_URL_WDASE_MARYAM+"SELAM+LEKI+2.mp3"));
        wdaseMaryam.add(new Audio(" ዘሰኑይ","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_WDASE_MARYAM, AMAZON_URL_WDASE_MARYAM+"Monday.mp3"));
        wdaseMaryam.add(new Audio(" ዘሠሉስ","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_WDASE_MARYAM, AMAZON_URL_WDASE_MARYAM+"Tuesday.mp3"));
        wdaseMaryam.add(new Audio(" ዘረቡዕ","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_WDASE_MARYAM, AMAZON_URL_WDASE_MARYAM+"Wednesday.mp3"));
        wdaseMaryam.add(new Audio(" ዘኅሙስ","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_WDASE_MARYAM, AMAZON_URL_WDASE_MARYAM+"Thursday.mp3"));
        wdaseMaryam.add(new Audio(" ዘዓርብ","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_WDASE_MARYAM, AMAZON_URL_WDASE_MARYAM+"Firday.mp3"));
        wdaseMaryam.add(new Audio(" ዘቅዳሚት","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_WDASE_MARYAM, AMAZON_URL_WDASE_MARYAM+"Satruday.mp3"));
        wdaseMaryam.add(new Audio(" ዘሰነበተ ክርስቲያን","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_WDASE_MARYAM, AMAZON_URL_WDASE_MARYAM+"Sunday.mp3"));

        ArrayList<Audio> seatat = new ArrayList<>();
        seatat.add(new Audio(" ነሲእየ ማዕተበ - ንሴብሖ","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_SEATAT, AMAZON_URL_SEATAT+"part+1.mp3"));
        seatat.add(new Audio(" ገነይነ ለኪ - ኲሎሙ ርኢክዎ","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_SEATAT,AMAZON_URL_SEATAT+"part+2.mp3"));
        seatat.add(new Audio(" ኲሎሙ ወባቲ - ኲሎሙ ዘቊስቋም","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_SEATAT, AMAZON_URL_SEATAT+"part+3.mp3"));
        seatat.add(new Audio(" ኲሎሙ ዘኪዳነ ምሕረት - አቊርር","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_SEATAT, AMAZON_URL_SEATAT+"part+4.mp3"));
        seatat.add(new Audio(" ሚካኤል  -  ለኖኅ ሐመሩ","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_SEATAT, AMAZON_URL_SEATAT+"part+5.mp3"));
        seatat.add(new Audio(" ስብሐተ ኢየሱስ  - ስብሐተ ፍቁር ዘመላእክት","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_SEATAT, AMAZON_URL_SEATAT+"part+6.mp3"));
        seatat.add(new Audio(" መሐረነ አብ - መል.ውዳሴ ዘአንቀጸ ብርሃን","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_SEATAT, AMAZON_URL_SEATAT+"part+7.mp3"));
        seatat.add(new Audio(" መቅድመ ተአምር - እሴብሕ ጸጋኪ","ቀሲስ ዮሃንስ ነጋሲ",IMAGE_URL_SEATAT, AMAZON_URL_SEATAT+"part+8.mp3"));

        ArrayList<Audio> hmamat = new ArrayList<>();
        hmamat.add(new Audio(" hmamat first","hmamat Wendmu","https://images-na.ssl-images-amazon.com/images/I/517XO7mzVYL._SY300_QL70_.jpg", "https://www.mfiles.co.uk/mp3-downloads/silent-night.mp3"));
        hmamat.add(new Audio(" hmamat Second","hmamat Wendmu","https://images-na.ssl-images-amazon.com/images/I/517XO7mzVYL._SY300_QL70_.jpg", "https://www.mfiles.co.uk/mp3-downloads/silent-night.mp3"));
        hmamat.add(new Audio(" hmamat Third","hmamat Wendmu","https://images-na.ssl-images-amazon.com/images/I/517XO7mzVYL._SY300_QL70_.jpg", "https://www.mfiles.co.uk/mp3-downloads/silent-night.mp3"));
        hmamat.add(new Audio(" hmamat Fourth","hmamat Wendmu","https://images-na.ssl-images-amazon.com/images/I/517XO7mzVYL._SY300_QL70_.jpg", "https://www.mfiles.co.uk/mp3-downloads/silent-night.mp3"));

        ArrayList<Audio> kidase_amharic = new ArrayList<>();
        kidase_amharic.add(new Audio(" Geez","Amharic Geez","http://www.staugustinechico.com/wp-content/uploads/2016/08/icon-of-christ-high-priest-the-holy-eucharist-300x211.jpg", "https://www.mfiles.co.uk/mp3-downloads/jingle-bells-keyboard.mp3"));
        kidase_amharic.add(new Audio(" Ezil","Amharic Ezil","http://www.staugustinechico.com/wp-content/uploads/2016/08/icon-of-christ-high-priest-the-holy-eucharist-300x211.jpg", "https://www.mfiles.co.uk/mp3-downloads/jingle-bells-keyboard.mp3"));
        kidase_amharic.add(new Audio(" Serawite","Amharic Serawite","http://www.staugustinechico.com/wp-content/uploads/2016/08/icon-of-christ-high-priest-the-holy-eucharist-300x211.jpg", "https://www.mfiles.co.uk/mp3-downloads/jingle-bells-keyboard.mp3"));

        ArrayList<Audio> kidase_tig = new ArrayList<>();
        kidase_tig.add(new Audio(" Geez","Tig Geez","http://www.staugustinechico.com/wp-content/uploads/2016/08/icon-of-christ-high-priest-the-holy-eucharist-300x211.jpg", AMAZON_URL_KIDASE+"tig_geez.mp3"));
        kidase_tig.add(new Audio(" Ezil","Tig Ezil","http://www.staugustinechico.com/wp-content/uploads/2016/08/icon-of-christ-high-priest-the-holy-eucharist-300x211.jpg", AMAZON_URL_KIDASE+"tig+_+ezil.mp3"));

        ArrayList<Audio> audio_to_be_passed;

        if (prayerLanguage.equals(getResources().getString(R.string.wdase_maryam))) {
            audio_to_be_passed = wdaseMaryam;
            setTitle(getResources().getString(R.string.wdase_maryam));
        }  else if(prayerLanguage.equals(getResources().getString(R.string.seatat))) {
            audio_to_be_passed = seatat;
            setTitle(getResources().getString(R.string.seatat));
        } else if(prayerLanguage.equals(getResources().getString(R.string.card_title_Tig))) {
            audio_to_be_passed = kidase_tig;
            setTitle(getResources().getString(R.string.card_title_Tig));
        } else if(prayerLanguage.equals(getResources().getString(R.string.card_title_Amharic))) {
            audio_to_be_passed = kidase_amharic;
            setTitle(getResources().getString(R.string.card_title_Amharic));
        }
        else {
            return;
        }

        AudioAdapter_two audioAdapter = new AudioAdapter_two(this, audio_to_be_passed);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL);
        rv_audio_option.setLayoutManager(staggeredGridLayoutManager);
        rv_audio_option.setAdapter(audioAdapter);
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
