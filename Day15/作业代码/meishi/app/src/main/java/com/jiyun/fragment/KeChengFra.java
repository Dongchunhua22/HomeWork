package com.jiyun.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.jiyun.meishi.R;
import com.jiyun.meishi.SearchActivity;

public class KeChengFra extends Fragment implements View.OnClickListener {


    private ImageView mSearchCourse;
    private TextView mSortCourse;
    private ImageView mImgCourse;
    private ConstraintLayout mSelItem;
    private TextView mSchoolSmall;
    private ImageView mImg;
    private TextView mKonwledge;
    private TextView mModel;
    private TextView mShai;
    private TabLayout mTabXuanke;
    private ViewPager mPageXuanke;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kecheng_fra, null);
        return view;
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.course_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                // TODO 20/06/18
                break;
            default:
                break;
        }
    }
}
