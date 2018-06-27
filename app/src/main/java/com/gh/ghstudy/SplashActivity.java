package com.gh.ghstudy;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gh.ghstudy.base.BaseActivity;
import com.gh.ghstudy.base.MyApplication;
import com.gh.ghstudy.demo.HomeActivity;

/**
 * @author: gh
 * @description:
 * @date: 2018/6/15.
 * @from:
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getInstance().isServer = true;
        setContentView(R.layout.activity_splash);

        HomeActivity.actionStart(mContext);

    }
}
