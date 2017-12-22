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
 * Created by kidus11 on 12/21/17.
 */

public class DawitPartOneFragment extends Fragment {
    @BindView(R.id.mez_dawit_part_one_tv)
    TextView mez_dawit_part_one_tv;

    String passed_day;
    public int language;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dawit_one_fragment, container, false);
        Context context = getContext();
        ButterKnife.bind(this, view);

        if (getArguments() != null) {
            passed_day = getArguments().getString(PASSED_TO_FRAG);
        }

        language = Utility.setLanguage(passed_day, context);
        String mez_dawit [] = Utility.forMezDawit(language, passed_day, context);
        String first_mezmur = mez_dawit[0];
        mez_dawit_part_one_tv.setText(first_mezmur);


        return view;

    }
}
