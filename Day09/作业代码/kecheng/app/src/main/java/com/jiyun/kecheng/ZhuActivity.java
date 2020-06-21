package com.jiyun.kecheng;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ZhuActivity extends AppCompatActivity {

    private ViewPager mVapger;
    private TabLayout mTab;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        initView();
        initTab();
        initFragment();
    }

    private void initFragment() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ShouFra());
        fragments.add(new KeChengFra());
        fragments.add(new YueKeFra());
        fragments.add(new GeRenFra());
        FraPagerAdapter fraPagerAdapter = new FraPagerAdapter(getSupportFragmentManager(), strings, fragments);
        mVapger.setAdapter(fraPagerAdapter);
        mTab.setupWithViewPager(mVapger);
    }

    private void initTab() {
        strings = new ArrayList<>();
        strings.add("首页");
        strings.add("课程");
        strings.add("约课记录");
        strings.add("个人");
    }

    private void initView() {
        mVapger = (ViewPager) findViewById(R.id.vapger);
        mTab = (TabLayout) findViewById(R.id.tab);
    }
}
