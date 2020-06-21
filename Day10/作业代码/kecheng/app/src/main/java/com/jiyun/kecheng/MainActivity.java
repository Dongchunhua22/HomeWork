package com.jiyun.kecheng;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewPager mVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mVp = (ViewPager) findViewById(R.id.vp);

        ArrayList<View> viewlist = new ArrayList<>();
        View view1 = View.inflate(this, R.layout.v1, null);
        View view2 = View.inflate(this, R.layout.v2, null);
        View view3 = View.inflate(this, R.layout.v3, null);
        Button btn = view3.findViewById(R.id.btn);
        viewlist.add(view1);
        viewlist.add(view2);
        viewlist.add(view3);
        VpAdapter vpAdapter = new VpAdapter(viewlist);
        mVp.setAdapter(vpAdapter);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ZhuActivity.class);
                startActivity(intent);


            }
        });

    }
}
