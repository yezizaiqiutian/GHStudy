package com.gh.ghstudy.demo.keyboard;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gh.ghstudy.R;
import com.gh.ghstudy.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * @author: gh
 * @description:
 * @date: 2018/6/27.
 * @from:
 */
public class Keyboard2Activity extends BaseActivity {

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, Keyboard2Activity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_keyboard_002);
        ButterKnife.bind(this);

    }

}
