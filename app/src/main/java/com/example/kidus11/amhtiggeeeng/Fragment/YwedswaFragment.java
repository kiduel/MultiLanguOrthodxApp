package com.example.kidus11.amhtiggeeeng.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

public class YwedswaFragment extends Fragment {
    @BindView(R.id.ywedswa_frag_prayer_tv)
    TextView frag_tv_prayer_yw;

    private static final String TAG = YwedswaFragment.class.getName();
    public int Language;
    private String passed_day;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ywedswa_fragment, container, false);
        Context context = getContext();
        ButterKnife.bind(this, view);
        //TextView frag_tv_prayer = (TextView) view.findViewById(R.id.zewetr_frag_prayer_tv);

        if (getArguments() != null) {
            passed_day = getArguments().getString(PASSED_TO_FRAG);
        }

        Language = Utility.setLanguage(passed_day, context);

        switch (Language) {
            case GEEZ:
                frag_tv_prayer_yw.setText(getResources().getString(R.string.ywedswa_geez_prayer));
                break;
            case AMHARIC:
                frag_tv_prayer_yw.setText(getResources().getString(R.string.ywedswa_amh_prayer));
                break;
            case ENGLISH:
                frag_tv_prayer_yw.setText(getResources().getString(R.string.ywedswa_eng_prayer));
                break;
            case TIGRIGNA:
                frag_tv_prayer_yw.setText(getResources().getString(R.string.ywedswa_tig_prayer));
                break;
        }

        return view;
    }
}

