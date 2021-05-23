/**
 * kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util.image;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.kaidin.common.util.TestCfg;
import org.junit.Test;

/**
 * 验证码生成测试
 * @version	1.0
 * @author	kaidin@foxmail.com
 * @date	2015-6-27下午06:16:46
 */
public class CaptchaTest {
	/**
	 * 默认的随机验证码
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void testCreateDefaultImage() throws FileNotFoundException, IOException {
		File outputFile = new File(TestCfg.OUTPUT_PATH + "/image/defaultCode.png");
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}

		Captcha codeBuilder = new Captcha();
		char[] codeArray = codeBuilder.createImage(new FileOutputStream(outputFile));
		System.out.println(codeArray);
	}

	/**
	 * 指定字符的验证码
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	@Test
	public void testCreateImage() throws FileNotFoundException, IOException {
		char[] codeArray = new char[] { 'M', 'M', 'M', 'M', 'M', 'M', 'M', 'M' };

		File outputFile = new File(TestCfg.OUTPUT_PATH + "/image/MMMMMMMM.png");
		if (!outputFile.exists()) {
			outputFile.createNewFile();
		}

		Captcha codeBuilder = new Captcha();
		codeBuilder.createImage(codeArray, new FileOutputStream(outputFile));
		System.out.println(codeArray);
	}
}
