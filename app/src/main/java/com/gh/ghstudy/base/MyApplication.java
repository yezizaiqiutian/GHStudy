package com.gh.ghstudy.base;

import android.app.Application;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: gh
 * @description:
 * @date: 2018/6/15.
 * @from:
 */
public class MyApplication extends Application {

    //进程是否存在
    public boolean isServer;
    private static MyApplication instance;
    private Map<Object, Object> innerMap = new HashMap<Object, Object>();

    @Override
    public void onCreate() {
        super.onCreate();
        instance = (MyApplication) getApplicationContext();
    }

    public static MyApplication getInstance() {
        return instance;
    }

    public void addParam(Object key, Object value) {
        innerMap.put(key, value);
    }

    public Object getParam(Object key) {
        return innerMap.get(key);
    }

    public void reMoveParam(Object key) {
        innerMap.remove(key);
    }
}