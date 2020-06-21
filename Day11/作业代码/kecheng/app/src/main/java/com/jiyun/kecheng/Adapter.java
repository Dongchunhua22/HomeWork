package com.jiyun.kecheng;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Adapter extends FragmentPagerAdapter {
    private ArrayList<String>strings;
    private ArrayList<Fragment>fragments;

    public Adapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    public Adapter(FragmentManager fragmentManager, ArrayList<Fragment> fragments, ArrayList<String> strings) {
        super(fragmentManager, fragments, strings);
        this.fragments=fragments;
        this.strings=strings;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
