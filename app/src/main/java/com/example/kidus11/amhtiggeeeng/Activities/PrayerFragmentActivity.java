package com.example.kidus11.amhtiggeeeng.Activities;

import android.content.Context;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.kidus11.amhtiggeeeng.Adapters.FragAdapter;
import com.example.kidus11.amhtiggeeeng.Fragment.AnkeseBrhanFragment;
import com.example.kidus11.amhtiggeeeng.Fragment.DawitPartOneFragment;
import com.example.kidus11.amhtiggeeeng.Fragment.DawitPartThreeFragment;
import com.example.kidus11.amhtiggeeeng.Fragment.DawitPartTwoFragment;
import com.example.kidus11.amhtiggeeeng.Fragment.YeEletuFragment;
import com.example.kidus11.amhtiggeeeng.Fragment.YeZewetrFragment;
import com.example.kidus11.amhtiggeeeng.Fragment.YwedswaFragment;
import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.kidus11.amhtiggeeeng.Utility.AMHARIC;
import static com.example.kidus11.amhtiggeeeng.Utility.ENGLISH;
import static com.example.kidus11.amhtiggeeeng.Utility.GEEZ;
import static com.example.kidus11.amhtiggeeeng.Utility.TIGRIGNA;

public class PrayerFragmentActivity extends AppCompatActivity {
    @BindView(R.id.pager)
    ViewPager pager;

    private Context context;
    private String passed_date;
    public final static String PASSED_TO_FRAG = "Passed_to_frag";
    private String [] FragmentTitlePageOne = {"1 - 10","31 - 40","61 - 70", "91 - 100", "121 - 130"};
    private String [] FragmentTitlePageTwo = {"11 - 20","41 - 50","71 - 80", "101 - 110", "131 - 140"};
    private String [] FragmentTitlePageThree = {"21 - 30","51 - 60","81 - 90", "111 - 120", "141 - 150"};
    private String TitleOfFrag_intro_eng;
    private String TitleOfFragP1 = "Hi";
    private String TitleOfFragP2 = "Hi";
    private String TitleOfFragP3 = "Hi";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //provide back button on the actionBar
        androidx.appcompat.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prayer_fragment);
        ButterKnife.bind(this);

        TitleOfFrag_intro_eng = getResources().getString(R.string.eng_intro_prayer_tite);
        String TitleOfFrag_intro_eng =  getResources().getString(R.string.tig_intro_prayer_tite);
        context = this;

        passed_date = getIntent().getStringExtra("day");


        setTitle(passed_date);

        FragAdapter fragAdapter = new FragAdapter(getSupportFragmentManager());
        pager.setAdapter(fragAdapter);
        setupViewPager(pager);


        //Locating the tablayout
        TabLayout tablayout = findViewById(R.id.tabs);
        //setting the layout
        tablayout.setupWithViewPager(pager);


    }
    private void setupViewPager(ViewPager viewPager) {
        FragAdapter adapter = new FragAdapter(getSupportFragmentManager());

        Bundle bundle = new Bundle();
        bundle.putString(PASSED_TO_FRAG, passed_date);


        setTitleOfFragments(passed_date);


        if (    passed_date.equals(getResources().getString(R.string.daw_eng_1st))||
                passed_date.equals(getResources().getString(R.string.daw_eng_2nd)) ||
                passed_date.equals(getResources().getString(R.string.daw_eng_3rd)) ||
                passed_date.equals(getResources().getString(R.string.daw_eng_4th)) ||
                passed_date.equals(getResources().getString(R.string.daw_eng_5th)) ||
                passed_date.equals(getResources().getString(R.string.daw_eng_6th)) ||
                passed_date.equals(getResources().getString(R.string.daw_eng_7th)) ||
                passed_date.equals(getResources().getString(R.string.daw_eng_8th)) ||
                passed_date.equals(getResources().getString(R.string.daw_geez_1st)) ||
                passed_date.equals(getResources().getString(R.string.daw_geez_2nd)) ||
                passed_date.equals(getResources().getString(R.string.daw_geez_3rd)) ||
                passed_date.equals(getResources().getString(R.string.daw_geez_4th)) ||
                passed_date.equals(getResources().getString(R.string.daw_geez_5th)) ||
                passed_date.equals(getResources().getString(R.string.daw_amh_1st)) ||
                passed_date.equals(getResources().getString(R.string.daw_amh_2nd)) ||
                passed_date.equals(getResources().getString(R.string.daw_amh_3rd)) ||
                passed_date.equals(getResources().getString(R.string.daw_amh_4th)) ||
                passed_date.equals(getResources().getString(R.string.daw_amh_5th)) ||
                passed_date.equals(getResources().getString(R.string.daw_tig_1st)) ||
                passed_date.equals(getResources().getString(R.string.daw_tig_2nd)) ||
                passed_date.equals(getResources().getString(R.string.daw_tig_3rd)) ||
                passed_date.equals(getResources().getString(R.string.daw_tig_5th)) ||
                passed_date.equals(getResources().getString(R.string.daw_tig_6th)) ||
                passed_date.equals(getResources().getString(R.string.daw_tig_7th)) ||
                passed_date.equals(getResources().getString(R.string.daw_tig_4th))) {
            {
                setTitle(passed_date);
                // set Fragmentclass Arguments
                DawitPartOneFragment dawitPartOneFragment = new DawitPartOneFragment();
                dawitPartOneFragment.setArguments(bundle);
                adapter.addFragment(dawitPartOneFragment, TitleOfFragP1);


                DawitPartTwoFragment dawitPartTwoFragment = new DawitPartTwoFragment();
                dawitPartTwoFragment.setArguments(bundle);
                adapter.addFragment(dawitPartTwoFragment, TitleOfFragP2);

                DawitPartThreeFragment dawitPartThreeFragment = new DawitPartThreeFragment();
                dawitPartThreeFragment.setArguments(bundle);
                adapter.addFragment(dawitPartThreeFragment, TitleOfFragP3);

                viewPager.setAdapter(adapter);
                return;
            }}

        String frag_title_zewetr = "";
        String frag_title_ankese = "";
        String frag_title_ywedswa = "";
        String frag_title_prayer = passed_date;

        int language = Utility.setLanguage(passed_date, context);

        switch (language) {
            case GEEZ:
                frag_title_zewetr = getResources().getString(R.string.zewetr_tg);
                frag_title_ankese = getResources().getString(R.string.ankese_geez);
                frag_title_ywedswa = getResources().getString(R.string.ywedswa_geez);
                break;
            case AMHARIC:
                frag_title_zewetr = getResources().getString(R.string.zewetr_amh);
                frag_title_ankese = getResources().getString(R.string.ankese_amh);
                frag_title_ywedswa = getResources().getString(R.string.ywedswa_amh);
                frag_title_prayer = "የ" + passed_date + " ውዳሴ ማርያም";

                break;
            case TIGRIGNA:
                frag_title_zewetr = getResources().getString(R.string.zewetr_tg);
                frag_title_ankese = getResources().getString(R.string.ankese_tg);
                frag_title_ywedswa = getResources().getString(R.string.ywedswa_tg);

                break;
            case ENGLISH:
                frag_title_zewetr = getResources().getString(R.string.zewetr_eng);
                frag_title_ywedswa = getResources().getString(R.string.ywedswa_eng);
                break;
        }


        if (language == GEEZ || language == AMHARIC || language == TIGRIGNA ) {
            YeZewetrFragment yeZewetrFramgent = new YeZewetrFragment();
            yeZewetrFramgent.setArguments(bundle);
            adapter.addFragment(yeZewetrFramgent, frag_title_zewetr);

            YeEletuFragment yeEletFramgent = new YeEletuFragment();
            yeEletFramgent.setArguments(bundle);
            adapter.addFragment(yeEletFramgent, frag_title_prayer);

            AnkeseBrhanFragment yeAnkeseBrhan = new AnkeseBrhanFragment();
            yeAnkeseBrhan.setArguments(bundle);
            adapter.addFragment(yeAnkeseBrhan, frag_title_ankese);

            YwedswaFragment yeYwedwaFragment = new YwedswaFragment();
            yeYwedwaFragment.setArguments(bundle);
            adapter.addFragment(yeYwedwaFragment, frag_title_ywedswa);

            viewPager.setAdapter(adapter);
        } else if ( language == ENGLISH)   //we are not going to have ankese brhan for english
            {
            YeZewetrFragment yeZewetrFramgent = new YeZewetrFragment();
            yeZewetrFramgent.setArguments(bundle);
            adapter.addFragment(yeZewetrFramgent, frag_title_zewetr);

            YeEletuFragment yeEletFramgent = new YeEletuFragment();
            yeEletFramgent.setArguments(bundle);
            adapter.addFragment(yeEletFramgent, frag_title_prayer);

            YwedswaFragment yeYwedwaFragment = new YwedswaFragment();
            yeYwedwaFragment.setArguments(bundle);
            adapter.addFragment(yeYwedwaFragment, frag_title_ywedswa);

            viewPager.setAdapter(adapter);
        }
        // set Fragmentclass Arguments
//        YeZewetrFragment yeZewetrFramgent = new YeZewetrFragment();
//        yeZewetrFramgent.setArguments(bundle);
//        adapter.addFragment(yeZewetrFramgent, frag_title_zewetr);
//
//        YeEletuFragment yeEletFramgent = new YeEletuFragment();
//        yeEletFramgent.setArguments(bundle);
//        adapter.addFragment(yeEletFramgent, frag_title_prayer);
//
//        AnkeseBrhanFragment yeAnkeseBrhan = new AnkeseBrhanFragment();
//        yeAnkeseBrhan.setArguments(bundle);
//        adapter.addFragment(yeAnkeseBrhan, frag_title_ankese);
//
//        YwedswaFragment yeYwedwaFragment = new YwedswaFragment();
//        yeYwedwaFragment.setArguments(bundle);
//        adapter.addFragment(yeYwedwaFragment, frag_title_ywedswa);
//
//        viewPager.setAdapter(adapter);
    }

    private void setTitleOfFragments(String passed_date) {

        String partTwo = "Part Two";
        if(passed_date.equals(getResources().getString(R.string.daw_eng_1st)))
        {
            TitleOfFragP1 =  TitleOfFrag_intro_eng;
            TitleOfFragP2 = partTwo;
            TitleOfFragP3 = partTwo;
        }
        if(passed_date.equals(getResources().getString(R.string.daw_eng_2nd)))
        {
            TitleOfFragP1 = TitleOfFrag_intro_eng;
            TitleOfFragP2 = getResources().getString(R.string.chapter_eng)  + " " +  FragmentTitlePageTwo[1];
            TitleOfFragP3 = getResources().getString(R.string.chapter_eng)  + " " +  FragmentTitlePageThree[1];
        }
        String partThree = "Part Three";
        if(passed_date.equals(getResources().getString(R.string.daw_eng_3rd)))
        {
            TitleOfFragP1 = TitleOfFrag_intro_eng;
            TitleOfFragP2 = partTwo;
            TitleOfFragP3 = partThree;
        }
        if(passed_date.equals(getResources().getString(R.string.daw_eng_4th)))
        {
            TitleOfFragP1 = TitleOfFrag_intro_eng;
            TitleOfFragP2 = partTwo;
            TitleOfFragP3 = partThree;
        }
        if(passed_date.equals(getResources().getString(R.string.daw_eng_5th)))
        {
            TitleOfFragP1 =  TitleOfFrag_intro_eng;
            TitleOfFragP2 = partTwo;
            TitleOfFragP3 = partThree;
        }
        if(passed_date.equals(getResources().getString(R.string.daw_eng_6th)))
        {
            TitleOfFragP1 =  TitleOfFrag_intro_eng;
            TitleOfFragP2 = partTwo;
            TitleOfFragP3 = partThree;
        }
        if(passed_date.equals(getResources().getString(R.string.daw_eng_7th)))
        {
            TitleOfFragP1 =  TitleOfFrag_intro_eng;
            TitleOfFragP2 = partTwo;
            TitleOfFragP3 = partThree;
        }
        if(passed_date.equals(getResources().getString(R.string.daw_eng_8th)))
        {
            TitleOfFragP1 =  TitleOfFrag_intro_eng;
            TitleOfFragP2 = partTwo;
            TitleOfFragP3 = partThree;
        }


        if(passed_date.equals(getResources().getString(R.string.daw_amh_1st)))
        {
            TitleOfFragP1 =  getResources().getString(R.string.chapter_amh)  + " " + FragmentTitlePageOne[0];
            TitleOfFragP2 =  getResources().getString(R.string.chapter_amh) + " " + FragmentTitlePageTwo[0];
            TitleOfFragP3 =  getResources().getString(R.string.chapter_amh) + " " + FragmentTitlePageThree[0];
        }
        if(passed_date.equals(getResources().getString(R.string.daw_amh_2nd)))
        {
            TitleOfFragP1 = getResources().getString(R.string.chapter_amh) + " " + FragmentTitlePageOne[1];
            TitleOfFragP2 = getResources().getString(R.string.chapter_amh) + " " + FragmentTitlePageTwo[1];
            TitleOfFragP3 = getResources().getString(R.string.chapter_amh) + " "  + FragmentTitlePageThree[1];
        }
        if(passed_date.equals(getResources().getString(R.string.daw_amh_3rd)))
        {
            TitleOfFragP1 = getResources().getString(R.string.chapter_amh) + " " + FragmentTitlePageOne[2];
            TitleOfFragP2 = getResources().getString(R.string.chapter_amh) + " " + FragmentTitlePageTwo[2];
            TitleOfFragP3 = getResources().getString(R.string.chapter_amh) + " "  + FragmentTitlePageThree[2];
        }
        if(passed_date.equals(getResources().getString(R.string.daw_amh_4th)))
        {
            TitleOfFragP1 = getResources().getString(R.string.chapter_amh) + " " + FragmentTitlePageOne[3];
            TitleOfFragP2 = getResources().getString(R.string.chapter_amh) + " " + FragmentTitlePageTwo[3];
            TitleOfFragP3 = getResources().getString(R.string.chapter_amh) + " " + FragmentTitlePageThree[3];
        }
        if(passed_date.equals(getResources().getString(R.string.daw_amh_5th)))
        {
            TitleOfFragP1 = getResources().getString(R.string.chapter_amh) + " " + FragmentTitlePageOne[4];
            TitleOfFragP2 = getResources().getString(R.string.chapter_amh) + " " +  FragmentTitlePageTwo[4];
            TitleOfFragP3 = getResources().getString(R.string.chapter_amh) + " " + FragmentTitlePageThree[4];
        }


        if(passed_date.equals(getResources().getString(R.string.daw_tig_1st)))
        {
            TitleOfFragP1 = TitleOfFrag_intro_eng;
            TitleOfFragP2 = partTwo;
            TitleOfFragP3 = partThree;
        }
        if(passed_date.equals(getResources().getString(R.string.daw_tig_2nd)))
        {
            TitleOfFragP1 = TitleOfFrag_intro_eng;
            TitleOfFragP2 = partTwo;
            TitleOfFragP3 = partThree;
        }
        if(passed_date.equals(getResources().getString(R.string.daw_tig_3rd)))
        {
            TitleOfFragP1 = TitleOfFrag_intro_eng;
            TitleOfFragP2 = partTwo;
            TitleOfFragP3 = partThree;
        }
        if(passed_date.equals(getResources().getString(R.string.daw_tig_4th)))
        {
            TitleOfFragP1 = TitleOfFrag_intro_eng;
            TitleOfFragP2 = partTwo;
            TitleOfFragP3 = partThree;
        }
        if(passed_date.equals(getResources().getString(R.string.daw_tig_5th)))
        {
            TitleOfFragP1 = TitleOfFrag_intro_eng;
            TitleOfFragP2 = partTwo;
            TitleOfFragP3 = partThree;
        }
        if(passed_date.equals(getResources().getString(R.string.daw_tig_6th)))
        {
            TitleOfFragP1 = TitleOfFrag_intro_eng;
            TitleOfFragP2 = partTwo;
            TitleOfFragP3 = partThree;
        }
        if(passed_date.equals(getResources().getString(R.string.daw_tig_7th)))
        {
            TitleOfFragP1 = TitleOfFrag_intro_eng;
            TitleOfFragP2 = partTwo;
            TitleOfFragP3 = partThree;
        }

        if(passed_date.equals(getResources().getString(R.string.daw_geez_1st)))
        {
            TitleOfFragP1 = getResources().getString(R.string.chapter_geez) + " " + FragmentTitlePageOne[0];
            TitleOfFragP2 = getResources().getString(R.string.chapter_geez) + " " +  FragmentTitlePageTwo[0];
            TitleOfFragP3 = getResources().getString(R.string.chapter_geez) + " " +  FragmentTitlePageThree[0];
        }
        if(passed_date.equals(getResources().getString(R.string.daw_geez_2nd)))
        {
            TitleOfFragP1 = getResources().getString(R.string.chapter_geez) + " " + FragmentTitlePageOne[1];
            TitleOfFragP2 = getResources().getString(R.string.chapter_geez) + " " + FragmentTitlePageTwo[1];
            TitleOfFragP3 = getResources().getString(R.string.chapter_geez) + " " + FragmentTitlePageThree[1];
        }
        if(passed_date.equals(getResources().getString(R.string.daw_geez_3rd)))
        {
            TitleOfFragP1 = getResources().getString(R.string.chapter_geez) + " " +  FragmentTitlePageOne[2];
            TitleOfFragP2 = getResources().getString(R.string.chapter_geez) + " " +  FragmentTitlePageTwo[2];
            TitleOfFragP3 = getResources().getString(R.string.chapter_geez) + " " +  FragmentTitlePageThree[2];
        }
        if(passed_date.equals(getResources().getString(R.string.daw_geez_4th)))
        {
            TitleOfFragP1 = getResources().getString(R.string.chapter_geez) + " " +  FragmentTitlePageOne[3];
            TitleOfFragP2 = getResources().getString(R.string.chapter_geez) + " " +  FragmentTitlePageTwo[3];
            TitleOfFragP3 = getResources().getString(R.string.chapter_geez) + " " + FragmentTitlePageThree[3];
        }
        if(passed_date.equals(getResources().getString(R.string.daw_geez_5th)))
        {
            TitleOfFragP1 = getResources().getString(R.string.chapter_geez) + " " +  FragmentTitlePageOne[4];
            TitleOfFragP2 = getResources().getString(R.string.chapter_geez) + " " + FragmentTitlePageTwo[4];
            TitleOfFragP3 = getResources().getString(R.string.chapter_geez) + " " + FragmentTitlePageThree[4];
        }

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


