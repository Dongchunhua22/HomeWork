package com.jiyun.kecheng;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ZhuActivity extends AppCompatActivity {

    private ViewPager mVapger;
    private TabLayout mTab;
    private ArrayList<String> strings;
    private ArrayList<Integer> images;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        initView();
        initTab();
        initFragment();
        initImages();
        FraPagerAdapter fraPagerAdapter = new FraPagerAdapter(getSupportFragmentManager(), strings, fragments);
        mVapger.setAdapter(fraPagerAdapter);
        mTab.setupWithViewPager(mVapger);
        for (int i = 0; i < strings.size(); i++) {
            TabLayout.Tab tab = mTab.getTabAt(i);
            tab.setCustomView(getTabView(i));

        }
    }

    @SuppressLint("InflateParams")
    private View getTabView(int position) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.tab, null);
        TextView tv = inflate.findViewById(R.id.tv);
        ImageView iv = inflate.findViewById(R.id.iv);
        tv.setText(strings.get(position));
        iv.setImageResource(images.get(position));



        return inflate;
    }

  /*  private  void  saveTabText(){
        for (int i = 0; i < strings.size(); i++) {
            mTab.getTabAt(i).setText(strings.get(i));

        }
    }*/

    private void initImages() {
        images = new ArrayList<>();
        images.add(R.drawable.ic_launcher_background);
        images.add(R.drawable.ic_launcher_background);
        images.add(R.drawable.ic_launcher_background);
        images.add(R.drawable.ic_launcher_background);

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

    private void initView() {
        mVapger = (ViewPager) findViewById(R.id.vapger);
        mTab = (TabLayout) findViewById(R.id.tab);
    }
}
