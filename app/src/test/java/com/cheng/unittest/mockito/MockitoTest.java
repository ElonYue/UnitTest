package com.cheng.unittest.mockito;

import com.cheng.unittest.bean.Person;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * @Description: 普通方法Mock
 * @Author: weilu
 * @Time: 2017/11/4 10:44.
 */

public class MockitoTest {

    @Test
    public void testIsNotNull() {
        Person mPerson = Mockito.mock(Person.class); //<--使用mock方法

        Assert.assertNotNull(mPerson);
    }
}
