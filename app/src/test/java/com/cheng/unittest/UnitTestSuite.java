package com.cheng.unittest;

import com.cheng.unittest.junit.CalculatorWithParameterizedTest;
import com.cheng.unittest.junit.DateFormatTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * 多个Test类
 *
 * @author : chengyue
 * @created : at 2018/5/29 17:09
 * @since : v1.0
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({CalculatorWithParameterizedTest.class, DateFormatTest.class})
public class UnitTestSuite {
}
