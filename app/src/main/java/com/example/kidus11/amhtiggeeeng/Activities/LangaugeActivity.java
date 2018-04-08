package com.example.kidus11.amhtiggeeeng.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.kidus11.amhtiggeeeng.Adapters.LanguageRVAdapter;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.data.Language;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LangaugeActivity extends AppCompatActivity {
    @BindView(R.id.rv_language)
    RecyclerView rv_language;
    @BindView(R.id.adView)
    AdView banner_ad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langauge);
        ButterKnife.bind(this);
        setTitle(getResources().getString(R.string.prayer_menu));

        //To request and load Ads that is already in the layout
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .addTestDevice("0DEEF21400DD4AF964C51630FE5112C7")
                .build();
        banner_ad.loadAd(adRequest);

        //provide back button on the actionBar
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        ArrayList<Language> languageOptions = new ArrayList<>();
        languageOptions.add(new Language(getResources().getString(R.string.card_title_Geez), getResources().getString(R.string.geez_card_infro)));
        languageOptions.add(new Language(getResources().getString(R.string.card_title_Amharic), getResources().getString(R.string.amharic_card_infro)));
        languageOptions.add(new Language(getResources().getString(R.string.card_title_Tig), getResources().getString(R.string.tig_card_infro)));
        languageOptions.add(new Language(getResources().getString(R.string.card_title_Eng), getResources().getString(R.string.eng_card_infro)));

        // Lookup the recyclerview in activity layout
        LanguageRVAdapter adapter = new LanguageRVAdapter(this, languageOptions);
        // RecyclerView rv_religious_main_page = (RecyclerView) findViewById(R.id.rv_main);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv_language.setLayoutManager(layoutManager);
        rv_language.setAdapter(adapter);
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
