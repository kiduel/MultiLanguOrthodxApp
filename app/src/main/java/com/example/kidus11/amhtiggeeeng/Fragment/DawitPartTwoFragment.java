package com.example.kidus11.amhtiggeeeng.Fragment;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
 * Created by kidus11 on 12/21/17.
 */

public class DawitPartTwoFragment extends Fragment {
    @BindView(R.id.mez_dawit_part_two_tv)
    TextView mez_dawit_part_two_tv_tv;

    @BindView(R.id.eng_text_daw_2)
    TextView mez_dawit_part_two_eng_tv;

    private String passed_day;
    private String prayer;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dawit_two_fragment, container, false);
        Context context = getContext();
        ButterKnife.bind(this, view);

        if (getArguments() != null) {
            passed_day = getArguments().getString(PASSED_TO_FRAG);
        }
        int language = Utility.setLanguage(passed_day, context);

        String mez_dawit [] = Utility.forMezDawit(language, passed_day, context);
        prayer = mez_dawit[1];

        if (language == Utility.ENGLISH) {
            makePrayerEnglish();
        } else makePrayerNotEnglish();

        if (language == AMHARIC || language == TIGRIGNA || language == GEEZ){
            mez_dawit_part_two_tv_tv.setText(Html.fromHtml(prayer));
        } else mez_dawit_part_two_tv_tv.setText(prayer);



        return view;
    }

    private void makePrayerEnglish(){
        mez_dawit_part_two_tv_tv.setVisibility(View.GONE);
        mez_dawit_part_two_eng_tv.setVisibility(View.VISIBLE);
        mez_dawit_part_two_eng_tv.setText(Html.fromHtml(prayer));
    }

    private void makePrayerNotEnglish(){
        mez_dawit_part_two_tv_tv.setVisibility(View.VISIBLE);
        mez_dawit_part_two_eng_tv.setVisibility(View.GONE);
    }
}
