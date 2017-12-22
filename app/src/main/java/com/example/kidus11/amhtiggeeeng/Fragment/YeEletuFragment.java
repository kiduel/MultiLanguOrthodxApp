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

/**
 * Created by kidus11 on 12/11/17.
 */

public class YeEletuFragment extends Fragment {
    @BindView(R.id.elet_frag_prayer_tv)
    TextView elet_frag_prayer_tv;

    String passed_day;
    public int language;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.elet_fragment, container, false);
        Context context = getContext();
        ButterKnife.bind(this, view);


        String prayer_of_the_day;
        if (getArguments() != null) {
            passed_day = getArguments().getString(PASSED_TO_FRAG);
        }
        language = Utility.setLanguage(passed_day, context);

        prayer_of_the_day = Utility.PrayerWithLanaguage(language, passed_day, context);
        elet_frag_prayer_tv.setText(prayer_of_the_day);

        return view;
    }
}
