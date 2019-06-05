package com.cheng.unittest;

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
@Suite.SuiteClasses({CalculatorWithParameterizedTest.class, ExampleUnitTest.class})
public class UnitTestSuite {
}
