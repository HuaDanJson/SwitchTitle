package com.example.jason.switchonepanimation;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.iv_switch_onep) ImageView ivSwitchOnep;
    @BindView(R.id.iv_switch_twop) ImageView ivSwitchTwop;
    @BindView(R.id.ll_switch_one_or_two_p) LinearLayout llSwitchOneOrTwoP;
    @BindView(R.id.fl_main_activity) FrameLayout flMainActivity;

    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Fragment1 fragment1;
    private Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        initOneP();
    }

    @OnClick(R.id.iv_switch_onep)
    public void onOnePClick(View view) {
        initOneP();
    }

    @OnClick(R.id.iv_switch_twop)
    public void onTwoPClick(View view) {
        initTwoP();
    }

    public void initOneP() {
        ivSwitchOnep.setSelected(true);
        ivSwitchTwop.setSelected(false);
        setImageViewLayoutParams(ivSwitchOnep, 48, 30);
        setImageViewLayoutParams(ivSwitchTwop, 34, 22);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_main_activity, fragment1);
        fragmentTransaction.commit();
    }

    public void initTwoP() {
        ivSwitchOnep.setSelected(false);
        ivSwitchTwop.setSelected(true);
        setImageViewLayoutParams(ivSwitchOnep, 34, 22);
        setImageViewLayoutParams(ivSwitchTwop, 48, 30);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_main_activity, fragment2);
        fragmentTransaction.commit();
    }

    public void setImageViewLayoutParams(ImageView imageView, int width, int height) {
        ViewGroup.LayoutParams params = imageView.getLayoutParams();
        params.width = DensityUtil.dip2px(width);
        params.height = DensityUtil.dip2px(height);
        imageView.setLayoutParams(params);
    }
}
