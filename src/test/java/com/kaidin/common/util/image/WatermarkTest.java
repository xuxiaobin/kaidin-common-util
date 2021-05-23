/**
 * kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util.image;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import com.kaidin.common.util.TestCfg;
import org.junit.Test;

import com.kaidin.common.util.FileUtil;

/**
 * 图片加水印测试
 * 
 * @version 1.0
 * @author kaidin@foxmail.com
 * @date 2018年7月11日 下午10:13:38
 */
public class WatermarkTest {
	private static final String SOURCE_IMAGE_NAME = TestCfg.INPUT_PATH + File.separator + "image/cat.jpg";

	/**
	 * 水印是一个图片
	 * @throws IOException
	 */
	@Test
	public void testPressImage() throws IOException {
		String watermarkImage = TestCfg.INPUT_PATH + File.separator + "image/head.jpg";

		
		String outputImageFile = TestCfg.OUTPUT_PATH + File.separator + "image/left-top.jpg";
		FileUtil.deleteFiles(outputImageFile);
		FileUtil.copyFiles(SOURCE_IMAGE_NAME, outputImageFile);
		Watermark.pressImage(outputImageFile, watermarkImage, "left-top", 45F);

		outputImageFile = TestCfg.OUTPUT_PATH + File.separator + "/image/right-top.jpg";
		FileUtil.deleteFiles(outputImageFile);
		FileUtil.copyFiles(SOURCE_IMAGE_NAME, outputImageFile);
		Watermark.pressImage(outputImageFile, watermarkImage, "right-top", 90F);

		outputImageFile = TestCfg.OUTPUT_PATH + File.separator + "/image/left-bottom.jpg";
		FileUtil.deleteFiles(outputImageFile);
		FileUtil.copyFiles(SOURCE_IMAGE_NAME, outputImageFile);
		Watermark.pressImage(outputImageFile, watermarkImage, "left-bottom", 135F);

		outputImageFile = TestCfg.OUTPUT_PATH + File.separator + "/image/right-bottom.jpg";
		FileUtil.deleteFiles(outputImageFile);
		FileUtil.copyFiles(SOURCE_IMAGE_NAME, outputImageFile);
		Watermark.pressImage(outputImageFile, watermarkImage, "right-bottom", 180F);

		outputImageFile = TestCfg.OUTPUT_PATH + File.separator + "/image/middle.jpg";
		FileUtil.deleteFiles(outputImageFile);
		FileUtil.copyFiles(SOURCE_IMAGE_NAME, outputImageFile);
		Watermark.pressImage(outputImageFile, watermarkImage, null, -45F);
	}

	/**
	 * 添加文字水印
	 * @throws IOException
	 */
	@Test
	public void testPressText() throws IOException {
		String imageFileName = TestCfg.OUTPUT_PATH + File.separator + "/image/pressText.jpg";
		FileUtil.deleteFiles(imageFileName);
		FileUtil.copyFiles(SOURCE_IMAGE_NAME, imageFileName);

		Watermark watermark = new Watermark();
		watermark.setFont(new Font("黑体", Font.BOLD, 10));
		watermark.setFontColor(Color.WHITE);
		watermark.setDiaphaneity(0.23F);
		watermark.pressText(imageFileName, "该文件只给kaidin公司使用");
	}
}
