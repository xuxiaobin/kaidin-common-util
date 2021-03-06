/**
 * kaidin.com Inc.
 * Copyright (c) 2008-2018 All Rights Reserved.
 */
package com.kaidin.common.util.net;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

import com.kaidin.common.util.constant.ConstType;
import com.kaidin.common.util.collection.CollectionUtil;

/**
 * 一个连接ftp的工具类，需要导入commons-net-3.2.jar包
 * 使用时请先打开服务openServer()
 * 中间写你需要的代码
 * 最后记得closeServer()
 * 
 * @version 1.0
 * @author kaidin@foxmail.com
 * @date 2015-6-23下午01:51:48
 */
public class FtpUtil {
	/** ftp服务器地址 */
	private String    hostname;
	/** 默认端口21 */
	private int       port             = 21;
	/** 默认是匿名用户 */
	private String    userName         = "anonymous";
	/** 默认的匿名用户的密码 */
	private String    password         = "anonymous";
	/** ftp客户端 */
	private FTPClient ftpClient;
	/** 默认的超时时间 10s */
	private int       connTimeoutTimes = Long.valueOf(ConstType.time.MS_OF_SECOND * 10).intValue();

	public FtpUtil() {
	}

	public FtpUtil(String hostname, String userName, String pwd) {
		this.hostname = hostname;
		this.userName = userName;
		this.password = pwd;
	}

	public FtpUtil(String hostname, int port, String userName, String pwd) {
		this(hostname, userName, pwd);
		this.port = port;
	}

	/**
	 * 连接到ftp服务器
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean openServer() throws IOException {
		boolean isSuccess;

		ftpClient = new FTPClient();
		ftpClient.connect(hostname, port);
		ftpClient.setConnectTimeout(connTimeoutTimes);
		ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
		isSuccess = ftpClient.login(userName, password);
		System.out.println("已登录到" + hostname);

		return isSuccess;
	}

	/**
	 * 断开与ftp服务器连接
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean closeServer() throws IOException {
		if (null == ftpClient) {
			return true;
		}
		boolean isSuccess = ftpClient.logout();
		ftpClient.disconnect();
		ftpClient = null;

		return isSuccess;
	}

	/**
	 * Description: 向FTP服务器上传文件
	 * 
	 * @param remotePath
	 * @param remoteFileName
	 * @param localFileName 本地文件名称
	 * @return 成功返回true，否则返回false
	 */
	public boolean uploadFile(String remotePath, String remoteFileName, String localFileName) throws IOException {
		try (FileInputStream input = new FileInputStream(localFileName)) {
			if (remotePath != null) {
				ftpClient.changeWorkingDirectory(remotePath);
			}
			return ftpClient.storeFile(remoteFileName, input);
		}
	}

	/**
	 * 下载文件
	 * 
	 * @param remotePath
	 * @param remoteFileName
	 * @param localFileName
	 * @return
	 * @throws IOException
	 */
	public boolean downloadFile(String remotePath, String remoteFileName, String localFileName) throws IOException {
		try (FileOutputStream output = new FileOutputStream(localFileName)) {
			ftpClient.changeWorkingDirectory(remotePath);
			if (remotePath != null) {
				if (!remotePath.endsWith(File.separator)) {
					remotePath += File.separator;
				}
				remoteFileName = remotePath + remoteFileName;
			}
			return ftpClient.retrieveFile(remoteFileName, output);
		}
	}

	/**
	 * 下载文件
	 * 
	 * @param remotePath
	 * @param remoteFileName
	 * @return
	 * @throws IOException
	 */
	public boolean deleteFile(String remotePath, String remoteFileName) throws IOException {
		ftpClient.changeWorkingDirectory(remotePath);
		return ftpClient.deleteFile(remoteFileName);
	}

	/**
	 * 取得相对于当前连接目录的某个目录下所有文件名列表
	 * 
	 * @param remotePath
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String> getFileNameList(String remotePath) throws IOException {
		ArrayList<String> result = new ArrayList<>();

		FTPFile[] fileArray = ftpClient.listFiles(remotePath);
		if (CollectionUtil.isEmpty(fileArray)) {
			return result;
		}
		for (FTPFile file : fileArray) {
			if (FTPFile.FILE_TYPE == file.getType()) {
				result.add(file.getName());
			}
		}

		return result;
	}

	/**
	 * 取得相对于当前连接目录的某个目录下所有文件名列表
	 * 
	 * @param remotePath
	 * @return
	 * @throws IOException
	 */
	public ArrayList<String> getDirectoryNameList(String remotePath) throws IOException {
		ArrayList<String> result = new ArrayList<>();

		FTPFile[] fileArray = ftpClient.listFiles(remotePath);
		if (CollectionUtil.isEmpty(fileArray)) {
			return result;
		}
		for (FTPFile file : fileArray) {
			if (FTPFile.DIRECTORY_TYPE == file.getType()) {
				result.add(file.getName());
			}
		}

		return result;
	}

	/**
	 * 取得相对于当前连接目录的某个目录下所有文件列表
	 * 
	 * @param remotePath
	 * @return
	 * @throws IOException
	 */
	public ArrayList<FTPFile> getFileList(String remotePath) throws IOException {
		ArrayList<FTPFile> result = new ArrayList<>();

		FTPFile[] fileArray = ftpClient.listFiles(remotePath);
		if (CollectionUtil.isEmpty(fileArray)) {
			return result;
		}
		for (FTPFile file : fileArray) {
			result.add(file);
		}

		return result;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public FTPClient getFtpClient() {
		return ftpClient;
	}

	public void setFtpClient(FTPClient ftpClient) {
		this.ftpClient = ftpClient;
	}

	public int getConnTimeoutTimes() {
		return connTimeoutTimes;
	}

	public void setConnTimeoutTimes(int connTimeoutTimes) {
		this.connTimeoutTimes = connTimeoutTimes;
	}

}
