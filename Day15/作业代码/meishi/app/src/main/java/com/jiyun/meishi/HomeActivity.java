package com.jiyun.meishi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jiyun.adapter.FraPagerAdapter;
import com.jiyun.fragment.GeRenFra;
import com.jiyun.fragment.KeChengFra;
import com.jiyun.fragment.ShouFra;
import com.jiyun.fragment.YueKeFra;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<Integer> images;
    private  ArrayList<String>strings;
    private ArrayList<Fragment> fragments;
    private ViewPager mVapger;
    private TabLayout mTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initTab();
        initFragment();
        FraPagerAdapter fraPagerAdapter = new FraPagerAdapter(getSupportFragmentManager(), strings, fragments);
        mVapger.setAdapter(fraPagerAdapter);
        mTab.setupWithViewPager(mVapger);

    }

    private void initView() {
        mVapger = (ViewPager) findViewById(R.id.vapger);
        mTab = (TabLayout) findViewById(R.id.tab);
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        fragments.add(new ShouFra());
        fragments.add(new KeChengFra());
        fragments.add(new YueKeFra());
        fragments.add(new GeRenFra());

    }

    private void initTab() {
        strings = new ArrayList<>();
        strings.add("首页");
        strings.add("课程");
        strings.add("约课记录");
        strings.add("个人");
    }
}
