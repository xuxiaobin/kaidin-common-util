package com.kaidin.common.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author xiaobin
 * @date 2020-08-21 10:12
 */
public class NumberUtilTest {

    @Test
    public void testDivided() {
        Assert.assertNull(NumberUtil.divided(null, null));
        Assert.assertNull(NumberUtil.divided(1, 0));
        Assert.assertEquals(Double.valueOf(0.5), NumberUtil.divided(1, 2));
    }

    @Test
    public void testFormat2Decimal() {
        Assert.assertNull(NumberUtil.format2Decimal(null));
        Assert.assertEquals("123.00", NumberUtil.format2Decimal(123));

        Assert.assertEquals("123.46", NumberUtil.format2Decimal(123.45678));
        Assert.assertEquals("123.45", NumberUtil.format2Decimal(123.45478));
    }

    @Test
    public void testFormat4Decimal() {
        Assert.assertNull(NumberUtil.format4Decimal(null));
        Assert.assertEquals("123.0000", NumberUtil.format4Decimal(123));

        Assert.assertEquals("123.4568", NumberUtil.format4Decimal(123.45678));
        Assert.assertEquals("123.4567", NumberUtil.format4Decimal(123.45674));
    }

    @Test
    public void testFormatPercent() {
        Assert.assertNull(NumberUtil.formatPercent(null));
        Assert.assertEquals("12.35%", NumberUtil.formatPercent(0.123456));
        Assert.assertEquals("112.34%", NumberUtil.formatPercent(1.123446));
    }

    @Test
    public void testFormatEndOf0() {
        Assert.assertNull(NumberUtil.formatEndOf0(null));
        Assert.assertEquals("123", NumberUtil.formatEndOf0(123.0000));
    }

    @Test
    public void formatWithoutComma() {
        Assert.assertNull(NumberUtil.formatWithoutComma(null));
        Assert.assertEquals("1234567", NumberUtil.formatWithoutComma(1234567));
        Assert.assertEquals("1234567.123", NumberUtil.formatWithoutComma(1234567.1230));
    }
}