package com.cheng.unittest;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertThat;

/**
 * 简单调用Android api
 *
 * @author : chengyue
 * @created : at 2018/5/29 17:12
 * @history : change on 2018/5/29 17:12 by chengyue
 * @since : v
 */
@RunWith(AndroidJUnit4.class)
public class SharedPreferencesTest {

    /**
     * 上下文
     */
    private Context mContext;

    @Before
    public void setUp() throws Exception {
        //获取application的context
        mContext = InstrumentationRegistry.getTargetContext();
        //实例化SharedPreferences
    }

    /**
     * 测试保存数据是否成功
     */
    @Test
    public void getSp() throws Exception {
        boolean result = PreferencesUtils.getBoolean(mContext, "login");
        assertThat(result, Is.is(true));
    }

    /**
     * 测试保存数据，然后获取数据是否成功
     */
    @Test
    public void putSp() throws Exception {
        Assert.assertTrue(PreferencesUtils.putBoolean(mContext, "login", false));
    }
}
