package com.gh.ghstudy.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gh.ghstudy.R;
import com.gh.ghstudy.base.BaseActivity;
import com.gh.ghstudy.demo.keyboard.KeyboardActivity;
import com.gh.ghstudy.demo.shape.ShapeActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author: gh
 * @description:
 * @date: 2018/6/27.
 * @from: 项目主页
 */
public class HomeActivity extends BaseActivity {

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.id_btn_shape, R.id.id_btn_keyboard})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.id_btn_shape:
                ShapeActivity.actionStart(mContext);
                break;
            case R.id.id_btn_keyboard:
                KeyboardActivity.actionStart(mContext);
                break;
        }
    }
}
