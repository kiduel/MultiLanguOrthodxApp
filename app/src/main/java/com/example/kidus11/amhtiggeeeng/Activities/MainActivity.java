package com.example.kidus11.amhtiggeeeng.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.kidus11.amhtiggeeeng.Adapters.MainRVPageAdapter;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.data.PrayersMain;
import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rv_main)
     RecyclerView rv_main;
    private FirebaseAnalytics mFirebaseAnalytics;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        ButterKnife.bind(this);
        //rv = (RecyclerView) findViewById(R.id.rv_main);
        ArrayList <PrayersMain> menuOptions = new ArrayList<>();
        menuOptions.add(new PrayersMain(getResources().getString(R.string.prayer_menu),"ግዕዝ፣ አማርኛ፣ ትግርኛ or English", R.drawable.prayer));
        menuOptions.add(new PrayersMain(getResources().getString(R.string.hymn_menu),"ውዳሴ ማርያም እና ሰዓታት", R.drawable.zema));
        menuOptions.add(new PrayersMain(getResources().getString(R.string.litrugy_menu),"ቅዳሴ በአማርኛ እና በትግርኛ",R.drawable.priests));

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "kidus");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
        Log.i("Firebase", "Item logged");


        // Lookup the recyclerview in activity layout
        MainRVPageAdapter mAdapter = new MainRVPageAdapter(this, menuOptions);
       // RecyclerView rv_religious_main_page = (RecyclerView) findViewById(R.id.rv_main);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        rv_main.setLayoutManager(layoutManager);
        rv_main.setAdapter(mAdapter);


    }

}

