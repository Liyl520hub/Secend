package com.bwei.day_test.view.myappliction;

import android.app.Application;

import org.xutils.BuildConfig;
import org.xutils.x;

/**
 * 作者：李亚雷
 * 时间：2017/5/19
 * 类用途：
 * 思路：
 */

public class MyAppliction extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);

    }
}
