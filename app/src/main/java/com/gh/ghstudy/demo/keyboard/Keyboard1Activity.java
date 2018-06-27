package com.gh.ghstudy.demo.keyboard;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.gh.ghstudy.R;
import com.gh.ghstudy.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author: gh
 * @description:
 * @date: 2018/6/22.
 * @from:https://blog.csdn.net/smileiam/article/details/69055963 使用方法三
 */
public class Keyboard1Activity extends BaseActivity {

    @BindView(R.id.id_tv_name)
    EditText id_tv_name;
    @BindView(R.id.id_tv_pwd)
    EditText id_tv_pwd;
    @BindView(R.id.login_btn)
    Button login_btn;
    @BindView(R.id.id_rootview)
    RelativeLayout id_rootview;

    public static void actionStart(Context context) {
        Intent intent = new Intent(context, Keyboard1Activity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_keyboard_001);
        ButterKnife.bind(this);

    }

    @Override
    protected void initView() {
        addLayoutListener(id_rootview, login_btn);
    }

    /**
     * addLayoutListener方法如下
     *
     * @param main   根布局
     * @param scroll 需要显示的最下方View
     */
    public void addLayoutListener(final View main, final View scroll) {
        main.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                Rect rect = new Rect();
                //1、获取main在窗体的可视区域
                main.getWindowVisibleDisplayFrame(rect);
                //2、获取main在窗体的不可视区域高度，在键盘没有弹起时，main.getRootView().getHeight()调节度应该和rect.bottom高度一样
                int mainInvisibleHeight = main.getRootView().getHeight() - rect.bottom;
                int screenHeight = main.getRootView().getHeight();//屏幕高度
                //3、不可见区域大于屏幕本身高度的1/4：说明键盘弹起了
                if (mainInvisibleHeight > screenHeight / 4) {
                    int[] location = new int[2];
                    scroll.getLocationInWindow(location);
                    // 4､获取Scroll的窗体坐标，算出main需要滚动的高度
                    int srollHeight = (location[1] + scroll.getHeight()) - rect.bottom;
                    //5､让界面整体上移键盘的高度
                    main.scrollTo(0, srollHeight);
                } else {
                    //3、不可见区域小于屏幕高度1/4时,说明键盘隐藏了，把界面下移，移回到原有高度
                    main.scrollTo(0, 0);
                }
            }
        });
    }

}
