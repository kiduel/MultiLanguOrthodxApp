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
 * Created by kidus11 on 12/11/17.
 */

public class YeEletuFragment extends Fragment {
    @BindView(R.id.elet_frag_prayer_tv)
    TextView elet_frag_prayer_tv;

    @BindView(R.id.elet_frag_prayer_eng_tv)
    TextView elet_frag_prayer_eng_tv;

    private String passed_day;
    private String prayer;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.elet_fragment, container, false);
        Context context = getContext();
        ButterKnife.bind(this, view);

        if (getArguments() != null) {
            passed_day = getArguments().getString(PASSED_TO_FRAG);
        }
        int language = Utility.setLanguage(passed_day, context);
        prayer = Utility.PrayerWithLanaguage(language, passed_day, context);

        if (language == Utility.ENGLISH) {
            makePrayerEnglish();
        } else makePrayerNotEnglish();


        if (language == AMHARIC || language == TIGRIGNA || language == GEEZ){
            elet_frag_prayer_tv.setText(Html.fromHtml(prayer));
        } else elet_frag_prayer_tv.setText(prayer);

        return view;
    }

    private void makePrayerEnglish(){
        elet_frag_prayer_tv.setVisibility(View.INVISIBLE);
        elet_frag_prayer_eng_tv.setVisibility(View.VISIBLE);
        elet_frag_prayer_eng_tv.setText(Html.fromHtml(prayer));
    }

    private void makePrayerNotEnglish(){
        elet_frag_prayer_tv.setVisibility(View.VISIBLE);
        elet_frag_prayer_eng_tv.setVisibility(View.INVISIBLE);
    }
}
