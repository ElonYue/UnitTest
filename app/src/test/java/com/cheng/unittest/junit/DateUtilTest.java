package com.cheng.unittest.junit;

import com.cheng.unittest.utils.DateUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static java.sql.DriverManager.println;
import static org.junit.Assert.assertNotEquals;

/**
 * @author : chengyue
 * @date : 2019/6/12 00:36
 */
public class DateUtilTest {

    private String time = "2017-10-15 16:00:02";

    private long timeStamp = 1508054402000L;

    private Date mDate;

    @Before
    public void setUp() {
        System.out.println("测试开始！");
        mDate = new Date();
        mDate.setTime(timeStamp);
    }

    @After
    public void tearDown() {
        System.out.println("测试结束！");
    }

    @Test
    public void stampToDateTest() {
        Assert.assertEquals(time, DateUtil.stampToDate(timeStamp));
    }

    @Test
    public void dateToStampTest() throws ParseException {
        assertNotEquals(4, DateUtil.dateToStamp(time));
    }

    @Test(expected = ParseException.class)
    public void dateToStampTest1() throws ParseException {
        DateUtil.dateToStamp("2017-10-15");
    }

    @Test
    @Ignore("test方法不执行\n")
    public void test() {
        println("-----");
    }
}