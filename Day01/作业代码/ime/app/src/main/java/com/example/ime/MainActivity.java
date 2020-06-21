package com.example.ime;

import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.base.BaseActivity;
import com.example.maincontract.MainContract;
import com.example.prenster.MainPrenster;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends BaseActivity<MainPrenster> implements MainContract.IMainView, View.OnClickListener {
    private NavigationView mNv;
    private TabLayout mTab;
    private ArrayList<Fragment> fragments;
    private ViewPager mVp;
    private ArrayList<String> strings;
    private ImageView mTitleBarBack;
    private TextView mTitleBarTitle;
    private ImageView mTitleOptionsImg;
    private TextView mTitleOptionsTv;
    private LinearLayout mLine;

    @Override
    protected MainPrenster initPresenter() {
        return new MainPrenster();
    }

    @Override
    public void initView() {
        mNv = (NavigationView) findViewById(R.id.nv);
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        mTitleBarBack = findViewById(R.id.title_bar_back);
        mTitleBarTitle = findViewById(R.id.title_bar_title);
        mTitleOptionsImg = findViewById(R.id.title_options_img);
        mTitleOptionsTv = findViewById(R.id.title_options_tv);


        mLine = (LinearLayout) findViewById(R.id.line);
    }
  /* public  void  onclick(){
       mTitleBarBack.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(MainActivity.this,"ddddd",Toast.LENGTH_SHORT).show();
           }
       });
   }*/

    @Override
    public void initData() {
        strings = new ArrayList<>();
        strings.add("消息");
        strings.add("联系");
        strings.add("动态");

        fragments = new ArrayList<>();
        fragments.add(new DongTaiFra());
        fragments.add(new LianXiFra());
        fragments.add(new DongTaiFra());

        VpAdapter vpAdapter = new VpAdapter(getSupportFragmentManager(), fragments, strings);
        mVp.setAdapter(vpAdapter);
        mTab.setupWithViewPager(mVp);

    }

    @Override
    public void initListener() {
        mTab.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab position) {
                titleChange(position);
                //  mVp.setCurrentItem(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void titleChange(TabLayout.Tab tab) {
        switch (tab.getPosition()) {
            case 0:
                mTitleBarTitle.setText("消息");
                mTitleOptionsImg.setVisibility(View.VISIBLE);
                mTitleOptionsTv.setVisibility(View.GONE);
                break;
            case 1:
                mTitleBarTitle.setText("联系人");
                mTitleOptionsImg.setVisibility(View.GONE);
                mTitleOptionsTv.setVisibility(View.VISIBLE);
                mTitleOptionsTv.setText("添加");
                break;
            case 2:
                mTitleBarTitle.setText("动态");
                mTitleOptionsImg.setVisibility(View.GONE);
                mTitleOptionsTv.setVisibility(View.VISIBLE);
                mTitleOptionsTv.setText("更多");
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_bar_back:
                Toast.makeText(this, "ddddd", Toast.LENGTH_SHORT).show();
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.dl);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
                break;
            case R.id.title_options_img:
                View view = View.inflate(this, R.layout.pop, null);

                PopupWindow pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                pop.setFocusable(true);
                pop.setOutsideTouchable(true);
                pop.setBackgroundDrawable(new BitmapDrawable());
                pop.showAtLocation(mLine, Gravity.BOTTOM, 0, 0);
                break;


            case R.id.title_options_tv:

                Toast.makeText(this, "ddddd", Toast.LENGTH_SHORT).show();
                break;

        }
    }


    /*  @OnClick({R.id.title_bar_back, R.id.title_options_img, R.id.title_options_tv})
      public void onViewClicked(View view) {
          switch (view.getId()) {
              case R.id.title_bar_back:
                  DrawerLayout drawer = (DrawerLayout) findViewById(R.id.side_main);
                  if (drawer.isDrawerOpen(GravityCompat.START)) {
                      drawer.closeDrawer(GravityCompat.START);
                  } else {
                      drawer.openDrawer(GravityCompat.START);
                  }
                  break;
              case R.id.title_options_img:
                  MyAlertDialog dialog = new MyAlertDialog(
                          MainActivity.this, new String[]{"创建群组", "添加好友／群"},

                  dialog.initDialog(Gravity.RIGHT | Gravity.TOP);
                  dialog.dialogSize(200, 0, 0, 55);
                  break;
              case R.id.title_options_tv:
                  MyAlertDialog dialog1 = new MyAlertDialog(
                          MainActivity.this, new String[]{"创建群组", "添加好友／群"},

                  dialog1.initDialog(Gravity.TOP | Gravity.RIGHT);
                  dialog1.dialogSize(200, 0, 0, 55);
                  break;
          }
      }

  */
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


}
