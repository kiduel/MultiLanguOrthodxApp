package com.example.kidus11.amhtiggeeeng.Adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kidus11 on 12/11/17.
 */

public class FragAdapter extends FragmentPagerAdapter {

    private final List <Fragment> fragmentsList = new ArrayList<>();
    private final List <String> fragmentsTitle = new ArrayList<>();

    public void addFragment(Fragment fragment, String title) {
        fragmentsList.add(fragment);
        fragmentsTitle.add(title);
    }

    public FragAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentsTitle.get(position);
    }

}