package com.kaidin.common.util;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
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
    public void testAsFloat() {
        Assert.assertNull(DataTypeUtil.asFloat(null));
        Assert.assertNull(DataTypeUtil.asFloat(""));
        Assert.assertNull(DataTypeUtil.asFloat("null"));
        Assert.assertEquals(Float.valueOf("1.1"), DataTypeUtil.asFloat(1.1));
        Assert.assertEquals(Float.valueOf("1.1"), DataTypeUtil.asFloat("1.1"));
    }

    @Test
    public void testAsDouble() {
        Assert.assertNull(DataTypeUtil.asDouble(null));
        Assert.assertNull(DataTypeUtil.asDouble(""));
        Assert.assertNull(DataTypeUtil.asDouble("null"));
        Assert.assertEquals(Double.valueOf("1.1"), DataTypeUtil.asDouble(1.1));
        Assert.assertEquals(Double.valueOf("1.1"), DataTypeUtil.asDouble("1.1"));
    }

    @Test
    public void testAsBigDecimal() {
        Assert.assertNull(DataTypeUtil.asBigDecimal(null));
        Assert.assertNull(DataTypeUtil.asBigDecimal(""));
        Assert.assertNull(DataTypeUtil.asBigDecimal("null"));
        Assert.assertEquals(BigDecimal.ONE, DataTypeUtil.asBigDecimal(BigDecimal.ONE));
        Assert.assertEquals(BigDecimal.ONE, DataTypeUtil.asBigDecimal(1));
        Assert.assertEquals(BigDecimal.ONE, DataTypeUtil.asBigDecimal("1"));
    }

    @Test
    public void testAsBoolean() {
        Assert.assertNull(DataTypeUtil.asBoolean(null));
        Assert.assertTrue(DataTypeUtil.asBoolean(true));
        Assert.assertFalse(DataTypeUtil.asBoolean(false));
        Assert.assertTrue(DataTypeUtil.asBoolean('T'));
        Assert.assertTrue(DataTypeUtil.asBoolean('t'));
        Assert.assertFalse(DataTypeUtil.asBoolean('a'));
        Assert.assertFalse(DataTypeUtil.asBoolean(' '));
        Assert.assertTrue(DataTypeUtil.asBoolean(1));
        Assert.assertFalse(DataTypeUtil.asBoolean(0));
        Assert.assertFalse(DataTypeUtil.asBoolean("123"));
        Assert.assertTrue(DataTypeUtil.asBoolean("true"));
        Assert.assertTrue(DataTypeUtil.asBoolean("y"));
        Assert.assertTrue(DataTypeUtil.asBoolean("yes"));
        try {
            DataTypeUtil.asBoolean(new ArrayList<>());
        } catch (RuntimeException e) {
            Assert.assertEquals("dataType 'Boolean' transform error:[]", e.getMessage());
        }
    }

    @Test
    public void testAsCharacter() {
        Assert.assertNull(DataTypeUtil.asCharacter(null));
        Assert.assertNull(DataTypeUtil.asCharacter(""));
        Assert.assertEquals(Character.valueOf('A'), DataTypeUtil.asCharacter('A'));
        Assert.assertEquals(Character.valueOf(' '), DataTypeUtil.asCharacter("   "));
        Assert.assertEquals(Character.valueOf('n'), DataTypeUtil.asCharacter("null"));
        Assert.assertEquals(Character.valueOf('A'), DataTypeUtil.asCharacter("ABC"));
        Assert.assertEquals(Character.valueOf('T'), DataTypeUtil.asCharacter(true));
        Assert.assertEquals(Character.valueOf('F'), DataTypeUtil.asCharacter(false));
    }

    @Test
    public void testAsString() {
        Assert.assertNull(DataTypeUtil.asString(null));
        Assert.assertEquals(StringUtil.NULL_STR, DataTypeUtil.asString("null"));
        Assert.assertEquals("123", DataTypeUtil.asString(123));
    }

    @Test
    public void testAsDate() {
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