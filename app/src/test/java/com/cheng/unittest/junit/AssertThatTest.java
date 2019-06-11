package com.cheng.unittest.junit;

import org.hamcrest.core.Is;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.core.IsNull.nullValue;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.matchers.JUnitMatchers.both;


/**
 * @author : chengyue
 * @date : 2019/6/12 00:36
 */
public class AssertThatTest {

    @Rule
    public MyRule rule = new MyRule();

    @Test
    public void testMobilePhone() {
        assertThat("13588888888", new IsMobilePhoneMatcher());
    }

    @Test
    public void testAssertThat1() {
        assertThat(6, Is.is(6));
    }

    @Test
    public void testAssertThat2() {
        assertThat(null, nullValue());
    }

    @Test
    public void testAssertThat3() {
        assertThat("Hello UT", both(startsWith("Hello")).and(endsWith("UT")));
    }
}
