/**
 * kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util.regex;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RegexUtilTest {

	@Test
	public void testContainNumber() {
		assertFalse(RegexUtil.containNumber(null));
		assertFalse(RegexUtil.containNumber(""));
		assertTrue(RegexUtil.containNumber("1234"));
		assertFalse(RegexUtil.containNumber("aaabbb"));
		assertTrue(RegexUtil.containNumber("aaa1bbb"));
	}

	@Test
	public void testIsAllNumbers() {
		assertFalse(RegexUtil.isAllNumbers(null));
		assertFalse(RegexUtil.isAllNumbers(""));
		assertTrue(RegexUtil.isAllNumbers("1234"));
		assertFalse(RegexUtil.isAllNumbers("1a234"));
	}

	@Test
	public void testContainLetter() {
		assertFalse(RegexUtil.containLetter(null));
		assertFalse(RegexUtil.containLetter(""));
		assertFalse(RegexUtil.containLetter("1234"));
		assertTrue(RegexUtil.containLetter("12a34"));
		assertTrue(RegexUtil.containLetter("aaaa"));
	}

	@Test
	public void testIsAllLetters() {
		assertFalse(RegexUtil.isAllLetters(null));
		assertFalse(RegexUtil.isAllLetters(""));
		assertFalse(RegexUtil.isAllLetters("1234"));
		assertFalse(RegexUtil.isAllLetters("12a34"));
		assertTrue(RegexUtil.isAllLetters("aaaa"));
	}

	@Test
	public void testIsMailAddr() {
		assertFalse(RegexUtil.isMailAddr(null));
		assertFalse(RegexUtil.isMailAddr(" "));
		assertFalse(RegexUtil.isMailAddr("1234"));
		assertTrue(RegexUtil.isMailAddr("xiaobing953326@21cn.com"));
	}

	@Test
	public void testIsIpAddr() {
		assertFalse(RegexUtil.isIpAddr(null));
		assertFalse(RegexUtil.isIpAddr(" "));
		assertFalse(RegexUtil.isIpAddr("xiaobing953326@21cn.com"));
		assertFalse(RegexUtil.isIpAddr("255.256.255.255"));
		assertTrue(RegexUtil.isIpAddr("localhost"));
		assertTrue(RegexUtil.isIpAddr("1.2.3.4"));
		assertTrue(RegexUtil.isIpAddr("255.255.255.255"));
	}
}
