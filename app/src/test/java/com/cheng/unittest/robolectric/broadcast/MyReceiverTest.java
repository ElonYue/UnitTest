package com.cheng.unittest.robolectric.broadcast;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.cheng.unittest.broadcast.MyReceiver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowApplication;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 广播测试
 *
 * @author : chengyue
 * @date : 2019/6/12 00:38
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = {23})
public class MyReceiverTest {


    @Test
    public void testRegister() {
        ShadowApplication shadowApplication = ShadowApplication.getInstance();
        Intent intent = new Intent(MyReceiver.ACTION);
        // 验证是否注册了相应的Receiver
        assertTrue(shadowApplication.hasReceiverForIntent(intent));
    }

    @Test
    public void testReceive() {
        //发送广播
        Intent intent = new Intent(MyReceiver.ACTION);
        intent.putExtra(MyReceiver.NAME, "AndroidUT");
        MyReceiver myReceiver = new MyReceiver();
        myReceiver.onReceive(RuntimeEnvironment.application, intent);
        //验证广播的处理逻辑是否正确
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(RuntimeEnvironment.application);
        assertEquals("AndroidUT", preferences.getString(MyReceiver.NAME, ""));
    }
}
