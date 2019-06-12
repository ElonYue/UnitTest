package com.cheng.unittest.mockito;

import com.cheng.unittest.bean.Person;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertNotNull;

/**
 * MockitoRule方式Mock
 *
 * @author : chengyue
 * @date : 2019/6/12 12:39
 */
public class MockitoRuleTest {

    @Mock
    Person mPerson;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testIsNotNull() {
        assertNotNull(mPerson);
    }

}
