package com.cheng.unittest.mockito;

import com.cheng.unittest.bean.Person;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;

/**
 * 注解方法Mock
 *
 * @author : chengyue
 * @date : 2019/6/12 12:20
 */
public class MockitoAnnotationsTest {
    //<--使用@Mock注解
    @Mock
    private Person mPerson;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this); //<--初始化
    }

    @Test
    public void testIsNotNull() {
        assertNotNull(mPerson);
    }

}
