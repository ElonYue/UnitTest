package com.cheng.unittest.mockito;

import com.cheng.unittest.bean.Person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;

/**
 * 运行器Mock (不需要initMocks)
 *
 * @author : chengyue
 * @date : 2019/6/12 12:27
 */
@RunWith(MockitoJUnitRunner.class)
public class MockitoJUnitRunnerTest {
    //使用@Mock注解
    @Mock
    private Person mPerson;

    @Test
    public void testIsNotNull() {
        assertNotNull(mPerson);
    }

}
