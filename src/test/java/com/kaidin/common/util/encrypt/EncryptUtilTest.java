/**
 * Kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util.encrypt;

import java.io.File;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import com.kaidin.common.util.StringUtil;

/**
 * @version 1.0
 * @author kaidin@foxmail.com
 * @date 2015-6-23下午01:51:48
 */
public class EncryptUtilTest extends Md5UtilTest {
	private static String STR_12345    = "123456";
	private static String STR_ADMIN123 = "admin123";
	private static String STR_NULL     = null;
	private static File   FILE         = new File(EncryptUtilTest.class.getClassLoader().getResource("input/md5TestFile.txt").getFile());

	@Test
	public void testStrMd5() {
		super.testStrMd5();
	}

	@Test
	public void testByteArryMd5() {
		super.testByteArryMd5();
	}

	@Test
	public void testFileMd5() throws IOException {
		super.testFileMd5();
	}

	@Test
	public void testSha1() {
		Assert.assertEquals("7c4a8d09ca3762af61e59520943dc26494f8941b", EncryptUtil.sha1(STR_12345));
		Assert.assertEquals("f865b53623b121fd34ee5426c792e5c33af8c227", EncryptUtil.sha1(STR_ADMIN123));
		Assert.assertEquals("da39a3ee5e6b4b0d3255bfef95601890afd80709", EncryptUtil.sha1(StringUtil.EMPTY_STR));
		Assert.assertNull(EncryptUtil.md5(STR_NULL));
	}

	@Test
	public void testFileSha1() throws IOException {
		String sha1OfFile = EncryptUtil.sha1(FILE);
		System.out.println("sha1OfFile:" + sha1OfFile);
		Assert.assertEquals("e65986b5b325885044179b468a2bccb30be38c6f", sha1OfFile);
	}
}
