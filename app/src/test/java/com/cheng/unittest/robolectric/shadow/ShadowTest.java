package com.cheng.unittest.robolectric.shadow;

import android.util.Log;

import com.cheng.unittest.bean.Person;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadow.api.Shadow;
import org.robolectric.shadows.ShadowLog;

import static org.junit.Assert.assertEquals;

/**
 * 自定义Shadow测试
 *
 * @author : chengyue
 * @date : 2019/6/12 00:40
 */

@RunWith(RobolectricTestRunner.class)
@Config(sdk = {23}, shadows = {ShadowPerson.class})
public class ShadowTest {

    @Before
    public void setUp() {
        ShadowLog.stream = System.out;
    }

    @Test
    public void testShadowShadow() {
        Person person = new Person();
        //实际上调用的是ShadowPerson的方法
        Log.d("test", person.getName());
        Log.d("test", String.valueOf(person.getAge()));
        Log.d("test", String.valueOf(person.getSex()));

        //获取Person对象对应的Shadow对象
        ShadowPerson shadowPerson = Shadow.extract(person);
        assertEquals("AndroidUT", shadowPerson.getName());
        assertEquals(18, shadowPerson.getAge());
        assertEquals(0, shadowPerson.getSex());
    }
}
