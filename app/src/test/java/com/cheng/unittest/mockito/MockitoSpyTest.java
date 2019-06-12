package com.cheng.unittest.mockito;

import com.cheng.unittest.bean.Home;
import com.cheng.unittest.bean.Person;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertNotNull;

/**
 * Spy示例
 *
 * @author : chengyue
 * @date : 2019/6/12 13:59
 */
public class MockitoSpyTest {

    @Spy
    Person mPerson;

    @InjectMocks
    Home mHome;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testIsNotNull() {
        assertNotNull(mPerson);
    }

    @Test
    public void testPersonSpy() {
        //输出11
        System.out.println(mPerson.getAge());
    }

    @Test
    public void testHomeInjectMocks() {
        Mockito.when(mPerson.getName()).thenReturn("weilu");
        System.out.println(mHome.getMaster());
    }
}
