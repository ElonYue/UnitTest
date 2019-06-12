package com.cheng.unittest.mockito;

import com.cheng.unittest.bean.Person;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * @Description: 常用验证方法示例
 * @Author: weilu
 * @Time: 2017/11/4 11:51.
 */

public class MockitoVerifyTest {

    @Mock
    Person mPerson;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testPersonVerifyAfter() {
        Mockito.when(mPerson.getAge()).thenReturn(18);
        //延时1s验证
        System.out.println(mPerson.getAge());
        System.out.println(System.currentTimeMillis());
        Mockito.verify(mPerson, Mockito.after(1000)).getAge();
        System.out.println(System.currentTimeMillis());
        // 抛出异常
        // verify(mPerson, atLeast(2)).age
    }

    @Test
    public void testPersonVerifyAtLeast() {
        mPerson.getAge();
        mPerson.getAge();
        //至少验证2次
        Mockito.verify(mPerson, Mockito.atLeast(2)).getAge();
    }

    @Test
    public void testPersonVerifyAtMost() {
        mPerson.getAge();
        //至多验证2次
        Mockito.verify(mPerson, Mockito.atMost(2)).getAge();
    }

    @Test
    public void testPersonVerifyTimes() {
        mPerson.getAge();
        mPerson.getAge();
        //验证方法在100ms超时前调用2次
        Mockito.verify(mPerson, Mockito.timeout(100).times(2)).getAge();
        Mockito.reset(mPerson);
    }

}
