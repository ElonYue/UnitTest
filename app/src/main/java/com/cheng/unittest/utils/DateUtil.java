package com.cheng.unittest.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 日期操作工具类
 * @author  : chengyue
 * @date    : 2019/6/12 00:46
 *
 */
public class DateUtil {

    /**
     * 英文全称  如：2017-11-01 22:11:00
     */
    static String FORMAT_YMDHMS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 掉此方法输入所要转换的时间输入例如（"2017-11-01 22:11:00"）返回时间戳
     *
     * @param time
     * @return 时间戳
     */
    public static long dateToStamp(String time) throws ParseException {
        SimpleDateFormat sdr = new SimpleDateFormat(FORMAT_YMDHMS, Locale.CHINA);
        Date date = sdr.parse(time);
        return date.getTime();
    }

    /**
     * 将时间戳转换为时间
     */
    public static String stampToDate(Long lt) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YMDHMS, Locale.CHINA);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

}