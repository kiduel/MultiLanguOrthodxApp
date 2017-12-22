package com.example.kidus11.amhtiggeeeng.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.kidus11.amhtiggeeeng.Adapters.LanguageRVAdapter;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.data.Language;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LangaugeActivity extends AppCompatActivity {
    @BindView(R.id.rv_language)
    RecyclerView rv_language;
    LanguageRVAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_langauge);
        ButterKnife.bind(this);

        ArrayList<Language> languageOptions = new ArrayList<>();
        languageOptions.add(new Language(getResources().getString(R.string.card_title_Geez), getResources().getString(R.string.geez_card_infro)));
        languageOptions.add(new Language(getResources().getString(R.string.card_title_Amharic), getResources().getString(R.string.amharic_card_infro)));
        languageOptions.add(new Language(getResources().getString(R.string.card_title_Tig), getResources().getString(R.string.tig_card_infro)));
        languageOptions.add(new Language(getResources().getString(R.string.card_title_Eng), getResources().getString(R.string.eng_card_infro)));

        // Lookup the recyclerview in activity layout
        adapter = new LanguageRVAdapter(this, languageOptions);
        // RecyclerView rv_religious_main_page = (RecyclerView) findViewById(R.id.rv_main);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv_language.setLayoutManager(layoutManager);
        rv_language.setAdapter(adapter);
    }


}
