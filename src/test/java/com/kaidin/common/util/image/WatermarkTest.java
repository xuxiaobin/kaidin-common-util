/**
 * Kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util.image;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;

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
	private static final String INPUT_PATH       = "src/test/resources/input/image/";
	private static final String OUTPUT_PATH       = "src/test/resources/output/image/";
	private static final String SOURCE_IMAGE_NAME = INPUT_PATH + "cat.jpg";

	/**
	 * 水印是一个图片
	 * @throws IOException
	 */
	@Test
	public void testPressImage() throws IOException {
		String watermarkImage = INPUT_PATH + "head.jpg";

		String outputImageFile = OUTPUT_PATH + "left-top.jpg";
		FileUtil.deleteFiles(outputImageFile);
		FileUtil.copyFiles(SOURCE_IMAGE_NAME, outputImageFile);
		Watermark.pressImage(outputImageFile, watermarkImage, "left-top", 45F);

		outputImageFile = OUTPUT_PATH + "right-top.jpg";
		FileUtil.deleteFiles(outputImageFile);
		FileUtil.copyFiles(SOURCE_IMAGE_NAME, outputImageFile);
		Watermark.pressImage(outputImageFile, watermarkImage, "right-top", 90F);

		outputImageFile = OUTPUT_PATH + "left-bottom.jpg";
		FileUtil.deleteFiles(outputImageFile);
		FileUtil.copyFiles(SOURCE_IMAGE_NAME, outputImageFile);
		Watermark.pressImage(outputImageFile, watermarkImage, "left-bottom", 135F);

		outputImageFile = OUTPUT_PATH + "right-bottom.jpg";
		FileUtil.deleteFiles(outputImageFile);
		FileUtil.copyFiles(SOURCE_IMAGE_NAME, outputImageFile);
		Watermark.pressImage(outputImageFile, watermarkImage, "right-bottom", 180F);

		outputImageFile = OUTPUT_PATH + "middle.jpg";
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
		String imageFileName = OUTPUT_PATH + "pressText.jpg";
		FileUtil.deleteFiles(imageFileName);
		FileUtil.copyFiles(INPUT_PATH + "cat.jpg", imageFileName);

		Watermark watermark = new Watermark();
		watermark.setFont(new Font("黑体", Font.BOLD, 10));
		watermark.setFontColor(Color.WHITE);
		watermark.setDiaphaneity(0.23F);
		watermark.pressText(imageFileName, "该文件只给kaidin公司使用");
	}
}
