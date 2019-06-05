package com.cheng.unittest;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

/**
 * 多参数条件测试
 * 1.在测试类上添加@RunWith(Parameterized.class)注解。
 * 2.添加构造方法，并将测试的参数作为其构造参数。
 * 3.添加获取参数集合的static方法，并在该方法上添加@Parameters注解。
 * 4.在需要测试的方法中直接使用成员变量，该变量由JUnit通过构造方法生成。
 *
 * @author : chengyue
 * @created : at 2018/5/29 17:02
 * @since : v1.0
 */
@RunWith(Parameterized.class)
public class CalculatorWithParameterizedTest {

    /**
     * 参数的变量
     */
    private final double num1;
    private final double num2;
    /**
     * 期待值
     */
    private final double mExpectedResult;
    /**
     * 计算类
     */
    private Calculator mCalculator;

    @Parameterized.Parameters
    public static List<Object[]> initData() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0},
                {0, -1, -1},
                {2, 2, 4},
                {8, 8, 16},
                {16, 16, 32},
                {32, 1, 32},
                {64, 64, 128}
        });
    }

    public CalculatorWithParameterizedTest(double num1, double num2, double mExpectedResult) {
        this.num1 = num1;
        this.num2 = num2;
        this.mExpectedResult = mExpectedResult;
    }

    @Before
    public void setUp() {
        mCalculator = new Calculator();
    }

    @Test
    public void addition_isCorrect() {
        double result = mCalculator.add(num1, num2);
        // delta 允许的误差值
//        Assert.assertEquals(mExpectedResult, result, 0);
//        Assert.assertThat(result, IsEqual.equalTo(mExpectedResult));
    }
}
