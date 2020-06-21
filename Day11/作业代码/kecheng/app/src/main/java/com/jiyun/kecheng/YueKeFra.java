package com.jiyun.kecheng;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class YueKeFra extends Fragment {
    private TabLayout mTab;
    private ViewPager mVa;
    private Fragment1 fragment1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.yueke_fra, null);
        initTab();
        return view;
    }

    private void initTab() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("待上课");
        strings.add("已上课");
        strings.add("已取消");
        for (int i = 0; i < strings.size(); i++) {
            String name = strings.get(i);
            strings.add(name);
            fragment1 = new Fragment1();
            fragments.add(fragment1);



        }
        Adapter adapter = new Adapter( getFragmentManager(),fragments, strings);
        mVa.setAdapter(adapter);
        mTab.setupWithViewPager(mVa);

    }

    private void initView(@NonNull final View itemView) {
        mTab = (TabLayout) itemView.findViewById(R.id.tab);
        mVa = (ViewPager) itemView.findViewById(R.id.va);
    }
}
