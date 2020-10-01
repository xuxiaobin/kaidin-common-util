package com.kaidin.common.util;

import com.kaidin.common.util.constant.ConstType;
import org.junit.Assert;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author xiaobin
 * @date 2020-08-19 17:12
 */
public class DateTimeUtilTest {
    private String pattern = "yyyy-MM-dd HH:mm";
    private Date date = new Date(2020 - 1900, 7, 19, 18, 23);
    private String dateStr = "2020-08-19 18:23";
    private String fullDateStr = "2020-08-19 18:23:00";

    @Test
    public void testGetStringToDateWithPattern() throws ParseException {
        Assert.assertNull(DateTimeUtil.getStringToDate(null, pattern));
        Assert.assertEquals(date, DateTimeUtil.getStringToDate(dateStr, pattern));
    }

    @Test
    public void testGetStringToDate() throws ParseException {
        Assert.assertNull(DateTimeUtil.getStringToDate(null));
        Assert.assertEquals(date, DateTimeUtil.getStringToDate(fullDateStr));
    }

    @Test
    public void testGetDateToStringWithPattern() {
        Assert.assertNull(DateTimeUtil.getDateToString(null, pattern));
        Assert.assertEquals(dateStr, DateTimeUtil.getDateToString(date, pattern));
        Assert.assertEquals(DateTimeUtil.getDateToString(new Date(), "yyyy-MM-dd HH:mm:ss"), DateTimeUtil.getDateToString());
    }

    @Test
    public void testGetDateToString() {
        Assert.assertNull(DateTimeUtil.getDateToString(null));
        Assert.assertEquals(fullDateStr, DateTimeUtil.getDateToString(date));
        Assert.assertEquals(DateTimeUtil.getDateToString(new Date()), DateTimeUtil.getDateToString());
    }

    @Test
    public void testConvertTimesToStringWithDecimalism() {
        String[] UNIT_ARRAY = new String[]{"毫秒", "秒", "分", "小时", "天"};
        long[] DECIMALISM_ARRAY = new long[]{1000, 60, 60, 24, Long.MAX_VALUE};
        Assert.assertNull(DateTimeUtil.convertTimesToString(null, UNIT_ARRAY, DECIMALISM_ARRAY));
        Assert.assertEquals("10毫秒", DateTimeUtil.convertTimesToString(10L, UNIT_ARRAY, DECIMALISM_ARRAY));
        Assert.assertEquals("1天10小时17分36秒789毫秒", DateTimeUtil.convertTimesToString(123456789L, UNIT_ARRAY, DECIMALISM_ARRAY));
    }

    @Test
    public void testConvertTimesToString() {
        Assert.assertNull(DateTimeUtil.convertTimesToString(null));
        Assert.assertEquals("10秒", DateTimeUtil.convertTimesToString(ConstType.time.MS_OF_SECOND * 10));

        Long times = ConstType.time.MS_OF_WEEK * 1;
        times += ConstType.time.MS_OF_DAY * 2;
        times += ConstType.time.MS_OF_HOUR * 3;
        times += ConstType.time.MS_OF_MINUTE * 3;
        times += ConstType.time.MS_OF_SECOND * 4;
        Assert.assertEquals("9天3小时3分4秒", DateTimeUtil.convertTimesToString(times));
        Assert.assertEquals("1天10小时17分36秒", DateTimeUtil.convertTimesToString(123456000L));
        Assert.assertEquals("1天10小时17分20秒", DateTimeUtil.convertTimesToString(123440000L));
        Assert.assertEquals("1天10小时17分0秒", DateTimeUtil.convertTimesToString(123420000L));
    }

    @Test
    public void testAddHours() {
        Date now = new Date();
        Date expectedDate = new Date(now.getTime());

        expectedDate.setHours(now.getHours() + 1);
        Assert.assertEquals(DateTimeUtil.getDateToString(expectedDate), DateTimeUtil.getDateToString(DateTimeUtil.addHours(null, 1)));
        Assert.assertEquals(expectedDate, DateTimeUtil.addHours(now, 1));

        expectedDate = new Date(now.getTime());
        expectedDate.setHours(now.getHours() - 2);
        Assert.assertEquals(expectedDate, DateTimeUtil.addHours(now, -2));

        expectedDate.setHours(now.getHours() + 0);
        Assert.assertEquals(expectedDate, DateTimeUtil.addHours(now, 0));
    }

    @Test
    public void testAddDays() {
        Date now = new Date();
        Date expectedDate = new Date(now.getTime());

        expectedDate.setDate(now.getDate() + 1);
        Assert.assertEquals(DateTimeUtil.getDateToString(expectedDate), DateTimeUtil.getDateToString(DateTimeUtil.addDays(null, 1)));
        Assert.assertEquals(expectedDate, DateTimeUtil.addDays(now, 1));

        expectedDate.setDate(now.getDate() - 2);
        Assert.assertEquals(expectedDate, DateTimeUtil.addDays(now, -2));

        expectedDate.setDate(now.getDate() + 0);
        Assert.assertEquals(expectedDate, DateTimeUtil.addDays(now, 0));
    }

    @Test
    public void addMonths() {
        Date now = new Date();
        Date expectedDate = new Date(now.getTime());

        expectedDate.setMonth(now.getMonth() + 1);
        Assert.assertEquals(DateTimeUtil.getDateToString(expectedDate), DateTimeUtil.getDateToString(DateTimeUtil.addMonths(null, 1)));
        Assert.assertEquals(expectedDate, DateTimeUtil.addMonths(now, 1));

        expectedDate.setMonth(now.getMonth() - 2);
        Assert.assertEquals(expectedDate, DateTimeUtil.addMonths(now, -2));

        expectedDate.setMonth(now.getMonth() + 0);
        Assert.assertEquals(expectedDate, DateTimeUtil.addMonths(now, 0));
    }

    @Test
    public void testGetThisHourBeginTime() {
        Date now = new Date();
        Date expectedDate = new Date(now.getYear(), now.getMonth(), now.getDate(), now.getHours(), 0, 0);
        Assert.assertEquals(expectedDate, DateTimeUtil.getThisHourBeginTime(null));
        Assert.assertEquals(expectedDate, DateTimeUtil.getThisHourBeginTime(now));
    }

    @Test
    public void testGetThisDayBeginTime() {
        Date now = new Date();
        Date expectedDate = new Date(now.getYear(), now.getMonth(), now.getDate(), 0, 0, 0);
        Assert.assertEquals(expectedDate, DateTimeUtil.getThisDayBeginTime(null));
        Assert.assertEquals(expectedDate, DateTimeUtil.getThisDayBeginTime(now));
    }

    @Test
    public void testGetThisWeekBeginTime() {
        Date expectedDate = new Date(date.getYear(), date.getMonth(), 17, 0, 0, 0);
//        Assert.assertEquals(expectedDate, DateTimeUtil.getThisWeekBeginTime(null));
//        Assert.assertEquals(expectedDate, DateTimeUtil.getThisWeekBeginTime(date));
    }

    @Test
    public void testGetThisMonthBeginTime() {
        Date now = new Date();
        Date expectedDate = new Date(now.getYear(), now.getMonth(), 1, 0, 0, 0);
        Assert.assertEquals(expectedDate, DateTimeUtil.getThisMonthBeginTime(null));
        Assert.assertEquals(expectedDate, DateTimeUtil.getThisMonthBeginTime(now));
    }

    @Test
    public void testGetLastHourBeginTime() {
        Date now = new Date();
        Date expectedDate = new Date(now.getYear(), now.getMonth(), now.getDate(), now.getHours() - 1, 0, 0);
        Assert.assertEquals(expectedDate, DateTimeUtil.getLastHourBeginTime(null));
        Assert.assertEquals(expectedDate, DateTimeUtil.getLastHourBeginTime(now));
    }

    @Test
    public void testGetLastDayBeginTime() {
        Date now = new Date();
        Date expectedDate = new Date(now.getYear(), now.getMonth(), now.getDate() - 1, 0, 0, 0);
        Assert.assertEquals(expectedDate, DateTimeUtil.getLastDayBeginTime(null));
        Assert.assertEquals(expectedDate, DateTimeUtil.getLastDayBeginTime(now));
    }

    @Test
    public void testGetLastWeekBeginTime() {
        Date expectedDate = new Date(2020 - 1900, 8, 10, 0, 0, 0);
//        Assert.assertEquals(expectedDate, DateTimeUtil.getLastWeekBeginTime(null));
//        Assert.assertEquals(expectedDate, DateTimeUtil.getLastWeekBeginTime(date));
    }

    @Test
    public void testLastMonthBeginTime() {
        Date now = new Date();
        Date expectedDate = new Date(now.getYear(), now.getMonth() - 1, 1);
        Assert.assertEquals(expectedDate, DateTimeUtil.getLastMonthBeginTime(null));
        Assert.assertEquals(expectedDate, DateTimeUtil.getLastMonthBeginTime(now));
    }

    @Test
    public void testGetNextHourBeginTime() {
        Date now = new Date();
        Date expectedDate = new Date(now.getYear(), now.getMonth(), now.getDate(), now.getHours() + 1, 0);
        Assert.assertEquals(expectedDate, DateTimeUtil.getNextHourBeginTime(null));
        Assert.assertEquals(expectedDate, DateTimeUtil.getNextHourBeginTime(now));
    }

    @Test
    public void testGetNextDayBeginTime() {
        Date now = new Date();
        Date expectedDate = new Date(now.getYear(), now.getMonth(), now.getDate() + 1);
        Assert.assertEquals(expectedDate, DateTimeUtil.getNextDayBeginTime(null));
        Assert.assertEquals(expectedDate, DateTimeUtil.getNextDayBeginTime(now));
    }

    @Test
    public void testGetNextWeekBeginTime() {
        Date expectedDate = new Date(date.getYear(), date.getMonth(), 24);
        Assert.assertEquals(expectedDate, DateTimeUtil.getNextWeekBeginTime(date));
    }

    @Test
    public void testGetNextMonthBeginTime() {
        Date now = new Date();
        Date expectedDate = new Date(now.getYear(), now.getMonth() + 1, 1);
        Assert.assertEquals(expectedDate, DateTimeUtil.getNextMonthBeginTime(null));
        Assert.assertEquals(expectedDate, DateTimeUtil.getNextMonthBeginTime(now));
    }

    @Test
    public void testGetDayNumOfMonth() {
        Assert.assertEquals(31, DateTimeUtil.getDayNumOfMonth(date));
    }

    @Test
    public void testGetDayNumOfYear() {
        Assert.assertEquals(366, DateTimeUtil.getDayNumOfYear(date));
    }
}