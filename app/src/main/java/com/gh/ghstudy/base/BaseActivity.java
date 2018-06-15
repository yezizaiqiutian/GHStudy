package com.gh.ghstudy.base;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gh.ghstudy.utils.AppManager;
import com.gh.ghstudy.utils.status.StatusBarUtil;

/**
 * @author: gh
 * @description:
 * @date: 2018/6/15.
 * @from:
 */
public class BaseActivity extends AppCompatActivity {

    protected Context mContext = null;
    protected BaseActivity mActivity = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mActivity = this;

        //记住每个Activity,用于退出登录
        AppManager.getAppManager().addActivity(this);
        //禁止横屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        setStatusBar();
    }

    /**
     * 当Activity彻底运行起来之后回调onPostCreate方法
     *
     * @param savedInstanceState
     */
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initBundle();
        initTitle();
        initView();
        initData();
        initListener();
        initLoad();
    }

    @Override
    protected void onResume() {
        super.onResume();

        //如果程序被杀死.关闭应用后重新开启
        if (MyApplication.getInstance().isServer == false) {
            AppManager.getAppManager().appExit(mContext);
//            SplashActivity.actionStart(mContext);
        }

    }

    /**
     * 设置状态栏颜色,需要在初始化View后调用
     */
    protected void setStatusBar() {
        StatusBarUtil.setTranslucentForImageView(mActivity, 0, null);
//        StatusBarUtil.setColor(mActivity, getResources().getColor(R.color.color_999999));
    }

    /**
     * 获取上个界面传输的intent
     */
    protected void initBundle() {
    }

    /**
     * Title
     */
    protected void initTitle() {
    }

    /**
     * 加载布局
     */
    protected void initView() {
    }

    /**
     * 加载数据
     */
    protected void initData() {
    }

    /**
     * 加载监听
     */
    protected void initListener() {
    }

    /**
     * 加载url
     */
    protected void initLoad() {
    }

}
