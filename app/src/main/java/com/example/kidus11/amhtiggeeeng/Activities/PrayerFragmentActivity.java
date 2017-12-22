package com.example.kidus11.amhtiggeeeng.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.kidus11.amhtiggeeeng.Adapters.FragAdapter;
import com.example.kidus11.amhtiggeeeng.Fragment.AnkeseBrhanFragment;
import com.example.kidus11.amhtiggeeeng.Fragment.DawitPartOneFragment;
import com.example.kidus11.amhtiggeeeng.Fragment.DawitPartThreeFragment;
import com.example.kidus11.amhtiggeeeng.Fragment.DawitPartTwoFragment;
import com.example.kidus11.amhtiggeeeng.Fragment.YeEletuFragment;
import com.example.kidus11.amhtiggeeeng.Fragment.YeZewetrFragment;
import com.example.kidus11.amhtiggeeeng.Fragment.YwedswaFragment;
import com.example.kidus11.amhtiggeeeng.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PrayerFragmentActivity extends AppCompatActivity {
    @BindView(R.id.pager)
    ViewPager pager;
    FragAdapter fragAdapter;
    String passed_date;
    public final static String PASSED_TO_FRAG = "Passed_to_frag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_fragment);
        ButterKnife.bind(this);
        passed_date = getIntent().getStringExtra("day");
        setTitle(passed_date);

        fragAdapter = new FragAdapter(getSupportFragmentManager());
        pager.setAdapter(fragAdapter);
        setupViewPager(pager);


        //Locating the tablayout
        TabLayout tablayout = (TabLayout) findViewById(R.id.tabs);
        //setting the layout
        tablayout.setupWithViewPager(pager);


    }
    private void setupViewPager(ViewPager viewPager) {
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager());

        Bundle bundle = new Bundle();
        bundle.putString(PASSED_TO_FRAG, passed_date);


        if (passed_date.equals(getResources().getString(R.string.daw_eng_1st)) ||
                passed_date.equals(getResources().getString(R.string.daw_eng_2nd)) ||
                passed_date.equals(getResources().getString(R.string.daw_eng_3rd)) ||
                passed_date.equals(getResources().getString(R.string.daw_eng_4th)) ||
                passed_date.equals(getResources().getString(R.string.daw_geez_1st)) ||
                passed_date.equals(getResources().getString(R.string.daw_geez_2nd)) ||
                passed_date.equals(getResources().getString(R.string.daw_geez_3rd)) ||
                passed_date.equals(getResources().getString(R.string.daw_geez_4th)) ||
                passed_date.equals(getResources().getString(R.string.daw_amh_1st)) ||
                passed_date.equals(getResources().getString(R.string.daw_amh_2nd)) ||
                passed_date.equals(getResources().getString(R.string.daw_amh_3rd)) ||
                passed_date.equals(getResources().getString(R.string.daw_amh_4th)) ||
                passed_date.equals(getResources().getString(R.string.daw_tig_1st)) ||
                passed_date.equals(getResources().getString(R.string.daw_tig_2nd)) ||
                passed_date.equals(getResources().getString(R.string.daw_tig_3rd)) ||
                passed_date.equals(getResources().getString(R.string.daw_tig_4th))) {
            {
                setTitle(passed_date);
                // set Fragmentclass Arguments
                DawitPartOneFragment dawitPartOneFragment = new DawitPartOneFragment();
                dawitPartOneFragment.setArguments(bundle);
                adapter.addFragment(dawitPartOneFragment, "Part One Dawit");


                DawitPartTwoFragment dawitPartTwoFragment = new DawitPartTwoFragment();
                dawitPartTwoFragment.setArguments(bundle);
                adapter.addFragment(dawitPartTwoFragment, "Part Three Dawit");

                DawitPartThreeFragment dawitPartThreeFragment = new DawitPartThreeFragment();
                dawitPartThreeFragment.setArguments(bundle);
                adapter.addFragment(dawitPartThreeFragment, "Part Three Dawit");

                viewPager.setAdapter(adapter);
                return;
            }}
        // set Fragmentclass Arguments
        YeZewetrFragment yeZewetrFramgent = new YeZewetrFragment();
        yeZewetrFramgent.setArguments(bundle);
        adapter.addFragment(yeZewetrFramgent, "ZewetrTselot");

        YeEletuFragment yeEletFramgent = new YeEletuFragment();
        yeEletFramgent.setArguments(bundle);
        adapter.addFragment(yeEletFramgent, "Elet");

        AnkeseBrhanFragment yeAnkeseBrhan = new AnkeseBrhanFragment();
        yeAnkeseBrhan.setArguments(bundle);
        adapter.addFragment(yeAnkeseBrhan, getResources().getString(R.string.ankese_brhan_frag_title));


        YwedswaFragment yeYwedwaFragment = new YwedswaFragment();
        yeYwedwaFragment.setArguments(bundle);
        adapter.addFragment(yeYwedwaFragment, getResources().getString(R.string.ywedswa_frag_title));



        viewPager.setAdapter(adapter);
    }
}


