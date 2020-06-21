package com.jiyun.kecheng;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class KeChengFra extends Fragment implements View.OnClickListener {
    private TextView mSchoolSmall;
    private TextView mSearchTop;
    private ImageView mImg;
    private TextView mKonwledge;
    private TextView mModel;
    private TextView mShai;
    private TabLayout mTabXuanke;
    private ViewPager mPageXuanke;
    private boolean model_IsDown = true;
    private boolean know_isdown = true;

    private PopupWindow m_pop1;
    private ConstraintLayout mLine;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kecheng_fra, null);
        return view;
    }

    private void initView(@NonNull final View itemView) {
        mSchoolSmall = (TextView) itemView.findViewById(R.id.small_school);
        mSearchTop = (TextView) itemView.findViewById(R.id.top_search);
        mImg = (ImageView) itemView.findViewById(R.id.img);
        mKonwledge = (TextView) itemView.findViewById(R.id.konwledge);
        // mKonwledge.setOnClickListener(this);
        mModel = (TextView) itemView.findViewById(R.id.model);
        //  mModel.setOnClickListener(this);
        mShai = (TextView) itemView.findViewById(R.id.shai);
        // mShai.setOnClickListener(this);
        mTabXuanke = (TabLayout) itemView.findViewById(R.id.xuanke_tab);
        mPageXuanke = (ViewPager) itemView.findViewById(R.id.xuanke_page);
        mModel.setClickable(true);
        mKonwledge.setClickable(true);
        mKonwledge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("1111", "onClick: ");
                fenleiclick();
            }
        });
        mLine = (ConstraintLayout) itemView.findViewById(R.id.line);
    }

    /*  @Override
      public void onClick(View v) {
          switch (v.getId()) {
              case R.id.konwledge:
                  // TODO 20/06/10
                  fenleiclick();
                  break;
              case R.id.model:
                  // TODO 20/06/10
                  break;
              case R.id.shai:
                  // TODO 20/06/10
                  break;
              default:
                  break;
          }
      }
  */
    private void fenleiclick() {
        Log.e("2222", "fenleiclick: ");
        if (model_IsDown) {
            showpop();
            if (m_pop1 != null && m_pop1.isShowing()) {
                m_pop1.dismiss();
                know_isdown = true;
            }
        } else {
            m_pop1.dismiss();
        }
    }

    private void showpop() {
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.pop, null);
        m_pop1 = new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //  m_pop1.showAsDropDown(mKonwledge,0,0);

        m_pop1.setBackgroundDrawable(new BitmapDrawable());
        m_pop1.showAtLocation(mLine, Gravity.BOTTOM, 0, 0);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.konwledge:
                // TODO 20/06/10
                fenleiclick();
                break;
            case R.id.model:
                // TODO 20/06/10
                Toast.makeText(getActivity(),"真好",Toast.LENGTH_SHORT).show();
                break;
            case R.id.shai:
                // TODO 20/06/10
                break;
            default:
                break;
        }
    }
}
