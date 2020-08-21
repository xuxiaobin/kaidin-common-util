/**
 * Kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

import com.kaidin.common.util.constant.ConstType;
import com.kaidin.common.util.collection.CollectionUtil;

/**
 * 文件操作工具
 * @version 1.0
 * @author kaidin@foxmail.com
 * @date 2016-5-18下午02:51:48
 */
public abstract class FileUtil {
	/** 拷贝文件使用的buffsize 2M */
	private final static long   BUFF_SIZE  = ConstType.fileSize.M_SIZE * 2;
	private final static char[] UNIT_ARRAY = ConstType.fileSize.UNITS.toCharArray();

	/**
	 * 读取文件按行返回
	 * @param fileName
	 * @param startNum
	 * @return
	 */
	public static List<String> readFile(String fileName, int startNum) throws IOException {
		List<String> result = new ArrayList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			String lineContent = reader.readLine();
			for (int i = 0; null != lineContent; i++) {
				if (i >= startNum) {
					result.add(lineContent);
				}
				lineContent = reader.readLine();
			}
		}

		return result;
	}

	/**
	 * 添加文件
	 * @param fileName
	 * @param countet
	 */
	public static synchronized void write(String fileName, String countet, boolean append) throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, append))) {
			writer.append(countet);
			writer.flush();
		}
	}

	/**
	 * 添加文件
	 * @param fileName
	 * @param countet
	 */
	public static synchronized void writeAppend(String fileName, String countet) throws IOException {
		write(fileName, countet, true);
	}

	public static void downloadFile(String urlStr, String absFileName) throws IOException {
		try (InputStream inputStream = new DataInputStream(new URL(urlStr).openStream());
		        OutputStream outputStream = new FileOutputStream(new File(absFileName))) {
			byte[] buffer = new byte[(int) ConstType.fileSize.K_SIZE];
			int length;
			while ((length = inputStream.read(buffer)) > 0) {
				outputStream.write(buffer, 0, length);
			}
		}
	}

	/**
	 * 拷贝文件
	 * @param srcFile
	 * @param targetFile
	 * @return
	 * @throws IOException
	 */
	@SuppressWarnings("resource")
	private static boolean copyFile(File srcFile, File targetFile) throws IOException {
		if (targetFile.exists()) {
			throw new IOException("target file " + targetFile.getName() + " in " + targetFile.getAbsolutePath() + " is exists.");
		}
		new File(targetFile.getParent()).mkdirs();
		targetFile.createNewFile();
		try (FileChannel inChannel = new FileInputStream(srcFile).getChannel();
		        FileChannel outChannel = new FileOutputStream(targetFile).getChannel()) {
			long fileSize = inChannel.size();
			long buffSize = BUFF_SIZE;
			for (long position = 0; position < fileSize; position += buffSize) {
				long restSize = fileSize - position;
				if (BUFF_SIZE > restSize) {
					buffSize = restSize;
				}
				inChannel.transferTo(position, buffSize, outChannel);
			}
			return true;
		}
	}

	/**
	 * 拷贝文件或者递归拷贝目录
	 * @param srcFileName
	 * @param targetFileName
	 * @return
	 * @throws IOException
	 */
	public static boolean copyFiles(String srcFileName, String targetFileName) throws IOException {
		File srcFile = new File(srcFileName);
		if (!srcFile.isDirectory()) {
			return copyFile(srcFile, new File(targetFileName));
		}

		File[] subFileArry = srcFile.listFiles();
		if (CollectionUtil.isEmpty(subFileArry)) {
			return new File(targetFileName).mkdirs();
		}
		for (File subFile : subFileArry) {
			String subTargetFileName = targetFileName + File.separator + subFile.getName();
			if (!copyFiles(subFile.getAbsolutePath(), subTargetFileName)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 删除文件或者目录
	 * @param fileName
	 * @return
	 */
	public static boolean deleteFiles(String fileName) {
		File srcFile = new File(fileName);
		if (!srcFile.exists()) {
			return true;
		}

		if (srcFile.isDirectory()) {
			File[] subFileArry = srcFile.listFiles();
			if (CollectionUtil.isNotEmpty(subFileArry)) {
				for (File subFile : subFileArry) {
					if (!deleteFiles(subFile.getAbsolutePath())) {
						return false;
					}
				}
			}
		}

		return srcFile.delete();
	}

	/**
	 * 获取文件大小，包含子目录大小
	 * @param targetFileName
	 * @return
	 */
	public static long getFileSize(String targetFileName) {
		File targetFile = new File(targetFileName);
		return new ForkJoinPool().invoke(new FileSizeFinder(targetFile));
	}

	@SuppressWarnings("serial")
	public static class FileSizeFinder extends RecursiveTask<Long> {
		private File file;

		public FileSizeFinder(File file) {
			this.file = file;
		}

		@Override
		public Long compute() {
			if (file.isFile()) {
				return file.length();
			}

			File[] subFiles = file.listFiles();
			if (null == subFiles) {
				return 0L;
			}

			long result = 0;
			List<ForkJoinTask<Long>> tasks = new ArrayList<>();
			for (File subFile : subFiles) {
				if (subFile.isFile()) {
					result += subFile.length();
				} else {
					tasks.add(new FileSizeFinder(subFile));
				}
			}
			for (ForkJoinTask<Long> task : invokeAll(tasks)) {
				result += task.join();
			}

			return result;
		}
	}

	/**
	 * 将文件大小转成常见的单位大小，保留两位小数
	 * @param byteSize
	 * @return
	 */
	public static String asDisplaySize(long byteSize) {
		if (ConstType.fileSize.K_SIZE > byteSize) {
			return byteSize + "B";
		}

		int i = 0;
		for (; ConstType.fileSize.M_SIZE <= byteSize; i++) {
			byteSize = byteSize >> 10;
		}

		return NumberUtil.format2Decimal(byteSize / 1024F) + UNIT_ARRAY[i];
	}
}
