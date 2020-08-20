package com.kaidin.common.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author xiaobin
 * @date 2020-08-20 17:35
 */
public class DataTypeUtilTest {

    @Test
    public void testAsByte() {
        Assert.assertNull(DataTypeUtil.asByte(null));
        Assert.assertNull(DataTypeUtil.asByte("null"));
        Assert.assertEquals(Byte.valueOf("10"), DataTypeUtil.asByte(10));
        Assert.assertEquals(Byte.valueOf("10"), DataTypeUtil.asByte("10"));
    }

    @Test
    public void testAsShort() {
        Assert.assertNull(DataTypeUtil.asShort(null));
        Assert.assertNull(DataTypeUtil.asShort("null"));
        Assert.assertEquals(Short.valueOf("10"), DataTypeUtil.asShort(10));
        Assert.assertEquals(Short.valueOf("10"), DataTypeUtil.asShort("10"));
    }

    @Test
    public void testAsInteger() {
        Assert.assertNull(DataTypeUtil.asInteger(null));
        Assert.assertNull(DataTypeUtil.asInteger("null"));
        Assert.assertEquals(Integer.valueOf("10"), DataTypeUtil.asInteger(10));
        Assert.assertEquals(Integer.valueOf("10"), DataTypeUtil.asInteger("10"));
    }

    @Test
    public void testAsLong() {
        Assert.assertNull(DataTypeUtil.asLong(null));
        Assert.assertNull(DataTypeUtil.asLong("null"));
        Assert.assertEquals(Long.valueOf("10"), DataTypeUtil.asLong(10));
        Assert.assertEquals(Long.valueOf("10"), DataTypeUtil.asLong("10"));
    }

    @Test
    public void asFloat() {
        Assert.assertNull(DataTypeUtil.asFloat(null));
        Assert.assertNull(DataTypeUtil.asFloat("null"));
    }

    @Test
    public void asDouble() {
        Assert.assertNull(DataTypeUtil.asDouble(null));
        Assert.assertNull(DataTypeUtil.asDouble("null"));
    }

    @Test
    public void asBigDecimal() {
        Assert.assertNull(DataTypeUtil.asBigDecimal(null));
        Assert.assertNull(DataTypeUtil.asBigDecimal("null"));
    }

    @Test
    public void asBoolean() {
        Assert.assertNull(DataTypeUtil.asBoolean(null));
        Assert.assertNull(DataTypeUtil.asBoolean("null"));
    }

    @Test
    public void asCharacter() {
        Assert.assertNull(DataTypeUtil.asCharacter(null));
        Assert.assertNull(DataTypeUtil.asCharacter("null"));
    }

    @Test
    public void asString() {
        Assert.assertNull(DataTypeUtil.asString(null));
        Assert.assertEquals(StringUtil.NULL_STR, DataTypeUtil.asString("null"));
        Assert.assertEquals("123", DataTypeUtil.asString(123));
    }

    @Test
    public void asDate() {
        Assert.assertNull(DataTypeUtil.asDate(null));
        Date date = new Date(2020 - 1900, 7, 19, 18, 23);
        String fullDateStr = "2020-08-19 18:23:00";
        Assert.assertEquals(date, DataTypeUtil.asDate(date));
        Assert.assertEquals(date, DataTypeUtil.asDate(date.getTime()));
        Assert.assertEquals(date, DataTypeUtil.asDate(fullDateStr));

        try {
            DataTypeUtil.asDate("xxxx");
        } catch (RuntimeException e) {
            Assert.assertEquals("dataType 'Date' transform error:xxxx", e.getMessage());
        }
        try {
            DataTypeUtil.asDate(new ArrayList<>());
        } catch (RuntimeException e) {
            Assert.assertEquals("dataType 'Date' transform error:[]", e.getMessage());
        }
    }
}