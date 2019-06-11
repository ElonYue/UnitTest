package com.cheng.unittest.junit;

import com.cheng.unittest.utils.DateUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author : chengyue
 * @date : 2019/6/12 00:36
 */
@RunWith(Parameterized.class)
public class DateFormatTest {
    String time;

    public DateFormatTest(String time) {
        this.time = time;
    }

    /**
     * 期望出现异常的测试 (抛出异常则通过)
     * @throws ParseException
     */
    @Test(expected = ParseException.class)
    public void dateToStampTest1() throws ParseException {
        DateUtil.dateToStamp(time);
    }

    @Parameterized.Parameters
    public static Collection<String> primeNumbers() {
        return Arrays.asList("2017-10-15",
                 "2017-10-15 16:00:02", // 抛出异常
                "2017年10月15日 16时00分02秒");
    }
}
