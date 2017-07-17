package cn.feng.utils;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

public class DateConvertUtils {

    //日期格式
    private static final String DATE_FORMAT_1 = "yyyy-MM-dd HH:mm:ss";
    private static final String DATE_FORMAT_2 = "YYYY/MM/DD HH:MM:SS";
    private static final String DATE_FORMAT_3 = "yyyy-MM-dd";
    private static final String Date_Format_4 = "yyyyMMDD";
    private static final String DATE_FORMAT_5 = "HH:mm:ss";


    /**
     * 将长整形的字符串转化成日期Date,默认格式是"yyyy-MM-dd HH:mm:ss"
     *
     * @param timestamp
     * @return
     * @throws ParseException
     */
    public static Date string2Date(String timestamp) throws ParseException {

        return format2Date(timestamp, null);

    }

    /**
     * 将长整形的字符串转化成日期Date
     *
     * @param timestamp
     * @return
     * @throws ParseException
     */
    public static Date string2Date(String timestamp, String pattern) throws ParseException {

        return format2Date(timestamp, pattern);

    }

    /**
     * 将长整形的字符串转化成日期Date,pattern 为空时候格式yyyy-MM-dd HH:mm:ss
     * * @param timestamp
     *
     * @param pattern 为空时候格式yyyy-MM-dd HH:mm:ss
     * @return
     * @throws ParseException
     */
    private static Date format2Date(String timestamp, String pattern) throws ParseException {
        if (timestamp == null) {
            throw new IllegalArgumentException("输入时间不能为空");
        }
        Long longs;
        if (pattern == null) {
            pattern = DATE_FORMAT_1;
        }

        try {
            longs = Long.parseLong(timestamp);
            String dateString = DateFormatUtils.format(new Date(longs), pattern);
            return DateUtils.parseDate(dateString, new String[]{pattern,

            });
        } catch (NumberFormatException e) {
            throw new NumberFormatException("无法解析: " + timestamp);
        } catch (ParseException e) {
            throw new ParseException("无法解析: " + timestamp, -1);
        }
    }

    /**
     * 将长整形的字符串转化成日期格式 当前日期时间，精确到秒 如:2015-4-15 9:36:38
     *
     * @param timestamp
     * @return 日期字符串:例如 2015-6-30 17:16:14
     */
    public static String string2DateString(String timestamp) {
        return formate(timestamp, DATE_FORMAT_1);

    }

    /**
     * 将时间戳格式转化成日期格式字符串,默认日期格式是"yyyy-MM-dd HH:mm:ss"
     *
     * @param timestamp 输入的时间戳
     * @param pattern   日期格式例如yyyy-MM-dd HH:mm:ss
     * @return 日期格式例如 2015-6-30 17:16:14
     */
    public static String string2DateString(String timestamp, String pattern) {
        return formate(timestamp, pattern);

    }

    private static String formate(String timestamp, String pattern) {
        if (timestamp == null) {
            throw new IllegalArgumentException("输入时间不能为空");
        }
        Long longs;
        if (pattern == null) {
            pattern = DATE_FORMAT_1;
        }
        try {
            longs = Long.parseLong(timestamp);
            return DateFormatUtils.format(new Date(longs), pattern);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("无法解析: " + timestamp);
        }
    }

    /**
     * 日期格式字符串2015-4-15 9:36:38等转换成日期Date
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static Date dateString2Date(String date) throws ParseException {

        return DateUtils.parseDate(date, new String[]{DATE_FORMAT_1});

    }

    @Test
    public void test() throws ParseException {

        // Date long2Date = string2Date("27407000");
        Date long2Date = format2Date("27407000", "yyyy-MM-dd HH:mm:ss");
        System.out.println(long2Date);
        // Date long2Date = stringDate2Date("2015-4-15 9:36:38");
        // System.out.println(long2Date);
    }

}
