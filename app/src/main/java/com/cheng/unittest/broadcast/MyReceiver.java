package com.cheng.unittest.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * 自定义广播接收器
 *
 * @author : chengyue
 * @date : 2019/6/12 00:42
 */
public class MyReceiver extends BroadcastReceiver {


    public static final String NAME = "name";
    public final static String ACTION = "com.cheng.androidutest";

    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        String name = intent.getStringExtra(NAME);
        editor.putString(NAME, name);
        editor.apply();
    }
}