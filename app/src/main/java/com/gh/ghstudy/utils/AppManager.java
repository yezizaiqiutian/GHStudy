package com.gh.ghstudy.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.util.Log;

import java.util.Stack;

/**
 * @author: gh
 * @description:
 * @date: 2018/6/15.
 * @from:
 */
public class AppManager {
    private static final String TAG = AppManager.class.getSimpleName();

    private static Stack<Activity> activityStack;
    private static AppManager instance;

    private AppManager() {
    }

    /**
     * 单一实例
     */
    public static AppManager getAppManager() {
        if (instance == null) {
            synchronized (AppManager.class) {
                if (instance == null) {
                    instance = new AppManager();
                }
            }
        }
        return instance;
    }

    /**
     * 添加Activity到堆栈
     */
    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
        Log.w("AppManager", "AppManager--->>" + activity.toString() + "...size==" + activityStack.size());
    }

    /**
     * 获取当前Activity（堆栈中最后一个压入的）
     */
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    /**
     * 结束当前Activity（堆栈中最后一个压入的）
     */
    public void finishActivity() {
        Activity activity = activityStack.lastElement();
        finishActivity(activity);
    }

    public void removeActivity(Activity activity) {
        if (activity != null && activityStack.contains(activity)) {
            activityStack.remove(activity);
        }
    }

    /**
     * 结束指定的Activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null && activityStack.contains(activity)) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity
     */
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }

    /**
     * 退出应用程序
     */
    public void appExit(Context context) {
        try {
            clearData();
            finishAllActivity();
            ActivityManager activityMgr =
                    (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
        }
    }

    /**
     * 注销登录,进入Loginning页面
     */
    public void cancleLogin(Context context,OnCancelLogin onCancelLogin) {
        if (onCancelLogin != null) {
            onCancelLogin.clearData();
        }
        try {
            clearData();
            finishAllActivity();
            ActivityManager activityMgr =
                    (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityMgr.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
        }finally {
            if (onCancelLogin != null) {
                onCancelLogin.toLoginActivity();
            }
        }
    }

    /**
     * 清除登录账号信息
     */
    public void clearData() {

    }

    public boolean isAppExit() {
        return activityStack == null || activityStack.isEmpty();
    }

    public void startKeepLiveActivity() {

    }

    public interface OnCancelLogin{
        //到注册页面
        void toLoginActivity();
        //清除信息
        void clearData();
    }
}
