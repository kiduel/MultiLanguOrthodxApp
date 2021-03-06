package com.example.kidus11.amhtiggeeeng.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
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
import static com.example.kidus11.amhtiggeeeng.Utility.GEEZ;
import static com.example.kidus11.amhtiggeeeng.Utility.TIGRIGNA;

/**
 * Created by kidus11 on 12/11/17.
 */

public class AnkeseBrhanFragment extends Fragment {
    @BindView(R.id.ankese_frag_prayer_tv)
    TextView frag_tv_prayer_ank;

    private String passed_day;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ankese_fragment, container, false);
        Context context = getContext();
        ButterKnife.bind(this, view);
        //TextView frag_tv_prayer = (TextView) view.findViewById(R.id.zewetr_frag_prayer_tv);

        if (getArguments() != null) {
            passed_day = getArguments().getString(PASSED_TO_FRAG);
        }

        int language = Utility.setLanguage(passed_day, context);

        switch (language) {
            case GEEZ:
                frag_tv_prayer_ank.setText(Html.fromHtml(getResources().getString(R.string.ank_geez_prayer)));
                break;
            case AMHARIC:
                frag_tv_prayer_ank.setText(Html.fromHtml(getResources().getString(R.string.ank_amh_prayer)));
                break;
            case TIGRIGNA:
                frag_tv_prayer_ank.setText(Html.fromHtml(getResources().getString(R.string.ank_tig_prayer)));
                break;
        }

        return view;
    }
}