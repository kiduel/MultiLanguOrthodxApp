package com.example.kidus11.amhtiggeeeng.Fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kidus11.amhtiggeeeng.R;
import com.example.kidus11.amhtiggeeeng.Utility;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.kidus11.amhtiggeeeng.Activities.PrayerFragmentActivity.PASSED_TO_FRAG;
import static com.example.kidus11.amhtiggeeeng.Utility.AMHARIC;
import static com.example.kidus11.amhtiggeeeng.Utility.ENGLISH;
import static com.example.kidus11.amhtiggeeeng.Utility.GEEZ;
import static com.example.kidus11.amhtiggeeeng.Utility.TIGRIGNA;

/**
 * Created by kidus11 on 12/11/17.
 */

public class YeZewetrFragment extends Fragment {
     @BindView(R.id.zewetr_frag_prayer_tv)
     TextView frag_tv_prayer;
    @BindView(R.id.zewetr_frag_prayer_eng_tv)
    TextView frag_tv_prayer_eng;

    private static final String TAG = YeZewetrFragment.class.getName();
    private String passed_day;
    private String prayer;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zewetr_fragment, container, false);
        Context context = getContext();
        ButterKnife.bind(this, view);
        //TextView frag_tv_prayer = (TextView) view.findViewById(R.id.zewetr_frag_prayer_tv);

        if (getArguments() != null) {
            passed_day = getArguments().getString(PASSED_TO_FRAG);
        }
        Log.i(TAG, passed_day);

        int language = Utility.setLanguage(passed_day, context);
        prayer = getResources().getString(R.string.zewetrTselot_eng_prayer);

        switch (language) {
            case GEEZ:
                makePrayerNotEnglish();
                frag_tv_prayer.setText(Html.fromHtml(getResources().getString(R.string.zewetrTselot_geez_prayer)));
                break;
            case AMHARIC:
                makePrayerNotEnglish();
                frag_tv_prayer.setText(Html.fromHtml(getResources().getString(R.string.zewetrTselot_amh_prayer)));
                break;
            case ENGLISH:
                makePrayerEnglish();
                break;
            case TIGRIGNA:
                makePrayerNotEnglish();
                frag_tv_prayer.setText(Html.fromHtml(getResources().getString(R.string.zewetrTselot_tig_prayer)));
                break;
        }

        return view;
    }

    private void makePrayerEnglish(){
        frag_tv_prayer.setVisibility(View.INVISIBLE);
        frag_tv_prayer_eng.setVisibility(View.VISIBLE);
        frag_tv_prayer_eng.setText(Html.fromHtml(prayer));
    }

    private void makePrayerNotEnglish(){
        frag_tv_prayer.setVisibility(View.VISIBLE);
        frag_tv_prayer_eng.setVisibility(View.INVISIBLE);
    }


}
