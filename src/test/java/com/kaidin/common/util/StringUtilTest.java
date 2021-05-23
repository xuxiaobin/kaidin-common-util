/**
 * Kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testIsEmpty() {
		Assert.assertTrue(StringUtil.isEmpty(null));
		Assert.assertTrue(StringUtil.isEmpty(StringUtil.EMPTY_STR));
		Assert.assertFalse(StringUtil.isEmpty("a"));
	}

	@Test
	public void testIsNotEmpty() {
		Assert.assertFalse(StringUtil.isNotEmpty(null));
		Assert.assertFalse(StringUtil.isNotEmpty(StringUtil.EMPTY_STR));
		Assert.assertTrue(StringUtil.isNotEmpty("a"));
	}

	@Test
	public void testIsBlank() {
		Assert.assertTrue(StringUtil.isBlank(null));
		Assert.assertTrue(StringUtil.isBlank(StringUtil.EMPTY_STR));
		Assert.assertTrue(StringUtil.isBlank(" "));
		Assert.assertTrue(StringUtil.isBlank(" 	 	"));
		Assert.assertFalse(StringUtil.isBlank(" 1	 	"));
	}
	@Test
	public void testContains() {
		Assert.assertTrue(StringUtil.contains("12345@abcxxx", "123"));
		Assert.assertTrue(StringUtil.contains("12345@abcxxx", "xx"));
		Assert.assertFalse(StringUtil.contains("12345@abcxxx", "xxxx"));
		Assert.assertFalse(StringUtil.contains(null, "xx"));
	}


	@Test
	public void testContainsWhitespace() {
		Assert.assertFalse(StringUtil.containsWhitespace(null));
		Assert.assertFalse(StringUtil.containsWhitespace(StringUtil.EMPTY_STR));
		Assert.assertTrue(StringUtil.containsWhitespace(" "));
		Assert.assertTrue(StringUtil.containsWhitespace("	"));
		Assert.assertTrue(StringUtil.containsWhitespace("123 456"));
		Assert.assertFalse(StringUtil.containsWhitespace("123456"));
	}

	@Test
	public void testIsNotBlank() {
		Assert.assertFalse(StringUtil.isNotBlank(null));
		Assert.assertFalse(StringUtil.isNotBlank(StringUtil.EMPTY_STR));
		Assert.assertFalse(StringUtil.isNotBlank(" "));
		Assert.assertFalse(StringUtil.isNotBlank(" 	 	"));
		Assert.assertTrue(StringUtil.isNotBlank(" 1	 	"));
	}

	@Test
	public void testEquals() {
		Assert.assertTrue(StringUtil.equals(null, null));
		Assert.assertFalse(StringUtil.equals(null, "12345"));
		Assert.assertFalse(StringUtil.equals("12345abc", null));
		Assert.assertTrue(StringUtil.equals("12345abc", 12345 + "abc"));
		Assert.assertFalse(StringUtil.equals("12345abC", 12345 + "abc"));
	}

	@Test
	public void testEqualsIgnoreCase() {
		Assert.assertTrue(StringUtil.equalsIgnoreCase(null, null));
		Assert.assertFalse(StringUtil.equalsIgnoreCase(null, "12345"));
		Assert.assertFalse(StringUtil.equalsIgnoreCase("12345abc", null));
		Assert.assertTrue(StringUtil.equalsIgnoreCase("12345abc", 12345 + "abc"));
		Assert.assertTrue(StringUtil.equalsIgnoreCase("12345abC", 12345 + "abc"));
	}

	@Test
	public void testStartWith() {
		Assert.assertFalse(StringUtil.startsWith(null, null));
		Assert.assertFalse(StringUtil.startsWith(null, "abc"));
		Assert.assertFalse(StringUtil.startsWith("abc", null));
		Assert.assertTrue(StringUtil.startsWith("abcd", "abc"));
		Assert.assertFalse(StringUtil.startsWith("abcd", "Abc"));
		Assert.assertFalse(StringUtil.startsWith("abcd", "abcc"));
		Assert.assertTrue(StringUtil.startsWith(" abcd", " abc"));
	}

	@Test
	public void testStartWithIgnoreCase() {
		Assert.assertFalse(StringUtil.startsWithIgnoreCase(null, null));
		Assert.assertFalse(StringUtil.startsWithIgnoreCase(null, "abc"));
		Assert.assertFalse(StringUtil.startsWithIgnoreCase("abc", null));
		Assert.assertTrue(StringUtil.startsWithIgnoreCase("abcd", "abc"));
		Assert.assertTrue(StringUtil.startsWithIgnoreCase("abcd", "Abc"));
		Assert.assertFalse(StringUtil.startsWithIgnoreCase("abcd", "abcc"));
		Assert.assertTrue(StringUtil.startsWithIgnoreCase(" abcd", " ABC"));
		Assert.assertFalse(StringUtil.startsWithIgnoreCase("abcd", "abccxxx"));
	}

	@Test
	public void testEndWith() {
		Assert.assertFalse(StringUtil.endWith(null, null));
		Assert.assertFalse(StringUtil.endWith(null, "abc"));
		Assert.assertFalse(StringUtil.endWith("abc", null));
		Assert.assertTrue(StringUtil.endWith("abcd", "bcd"));
		Assert.assertFalse(StringUtil.endWith("abcd", "bCd"));
		Assert.assertFalse(StringUtil.endWith("abcd", "abcc"));
		Assert.assertTrue(StringUtil.endWith(" abcd ", "bcd "));
	}

	@Test
	public void testEndWithIgnoreCase() {
		Assert.assertFalse(StringUtil.endWithIgnoreCase(null, null));
		Assert.assertFalse(StringUtil.endWithIgnoreCase(null, "abc"));
		Assert.assertFalse(StringUtil.endWithIgnoreCase("abc", null));
		Assert.assertTrue(StringUtil.endWithIgnoreCase("abcd", "bcd"));
		Assert.assertTrue(StringUtil.endWithIgnoreCase("abcd", "bCd"));
		Assert.assertFalse(StringUtil.endWithIgnoreCase("abcd", "abcc"));
		Assert.assertTrue(StringUtil.endWithIgnoreCase("abcd ", "Bcd "));
		Assert.assertFalse(StringUtil.endWithIgnoreCase("abc", "abcc"));
	}

	@Test
	public void testToUpperCase() {
		Assert.assertNull(StringUtil.toUpperCase(null));
		Assert.assertEquals(StringUtil.EMPTY_STR, StringUtil.toUpperCase(StringUtil.EMPTY_STR));
		Assert.assertEquals(" A 23C", StringUtil.toUpperCase(" a 23c"));
	}

	@Test
	public void testToUpperCaseAtFirst() {
		Assert.assertNull(StringUtil.toUpperCaseAtFirst(null));
		Assert.assertEquals("Config.properties", StringUtil.toUpperCaseAtFirst("config.properties"));
		Assert.assertEquals("12345", StringUtil.toUpperCaseAtFirst("12345"));
	}

	@Test
	public void testToLowerCase() {
		Assert.assertNull(StringUtil.toLowerCase(null));
		Assert.assertEquals(StringUtil.EMPTY_STR, StringUtil.toLowerCase(StringUtil.EMPTY_STR));
		Assert.assertEquals(" a 23c", StringUtil.toLowerCase(" A 23c"));
	}

	@Test
	public void testUpperCase2Underline() {
		Assert.assertNull(StringUtil.upperCase2Underline(null));
		Assert.assertEquals(StringUtil.EMPTY_STR, StringUtil.upperCase2Underline(StringUtil.EMPTY_STR));
		Assert.assertEquals("123456", StringUtil.upperCase2Underline("123456"));
		Assert.assertEquals("12_a345_b_c6_z", StringUtil.upperCase2Underline("12A345BC6Z"));
		Assert.assertEquals("s_d_x12_a345_b_c_d6_z", StringUtil.upperCase2Underline("SDX12A345BCD6Z"));
	}

	@Test
	public void testUnderline2UpperCase() {
		Assert.assertNull(StringUtil.underline2UpperCase(null));
		Assert.assertEquals(StringUtil.EMPTY_STR, StringUtil.underline2UpperCase(StringUtil.EMPTY_STR));
		Assert.assertEquals("123456", StringUtil.underline2UpperCase("123456"));
		Assert.assertEquals("_12_3456", StringUtil.underline2UpperCase("_12____3456_"));
		Assert.assertEquals("_12A345BC6Z", StringUtil.underline2UpperCase("___12_a345_b_c6_z___"));
		Assert.assertEquals("sDX12A345BCD6Z", StringUtil.underline2UpperCase("s_d_x12__a345_b_c_d6_z"));
		Assert.assertEquals("sDX12A345BCD6Z", StringUtil.underline2UpperCase("_s_d_x12__a345_b_c_d6_z"));
	}

	@Test
	public void testSubstring() {
		Assert.assertNull(StringUtil.subString(null, 1, 2));
		Assert.assertEquals(StringUtil.EMPTY_STR, StringUtil.subString(StringUtil.EMPTY_STR, 1, 2));
		Assert.assertEquals("12", StringUtil.subString("123456", 0, 2));
		Assert.assertEquals(StringUtil.EMPTY_STR, StringUtil.subString("123456", 2, 0));
		Assert.assertEquals("3456", StringUtil.subString("123456", 2, 10));
		Assert.assertEquals(StringUtil.EMPTY_STR, StringUtil.subString("123456", 9, 10));
		Assert.assertEquals(StringUtil.EMPTY_STR, StringUtil.subString("123456", 2, 2));
		Assert.assertEquals("34", StringUtil.subString("123456", -4, -2));
		Assert.assertEquals("2345", StringUtil.subString("123456", -5, 5));
	}

	@Test
	public void testFormat() {
		Assert.assertEquals("12345", StringUtil.format("12{0}45", 3));
		Assert.assertEquals("12345xx", StringUtil.format("12{0}45{1}", 3, "xx"));
		Assert.assertEquals("12345xxnull", StringUtil.format("12{0}45{1}{2}", 3, "xx", null));

		Assert.assertNull(StringUtil.format(null, 3, "xx"));
		Assert.assertEquals("12{0}45{1}", StringUtil.format("12{0}45{1}", null));
	}

}
