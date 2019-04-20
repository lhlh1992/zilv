package com.liu.ftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.ftp.FTPClient;

public class ftpUtils {
			
			
	/**
	* ftp上传单个文件
	* @param ftpUrl ftp地址
	* @param userName ftp的用户名
	* @param password ftp的密码
	* @param directory 上传至ftp的路径名不包括ftp地址
	* @param srcFileName 要上传的文件全路径名
	* @param destName 上传至ftp后存储的文件名
	* @throws IOException 
	*/
	public static boolean upload(String ftpUrl,String userName,int port,
	String password,String directory,String srcFileName,String destName) throws IOException {
			FTPClient ftpClient = new FTPClient();
			FileInputStream fis = null;
			boolean result = false;
			try {
			ftpClient.connect(ftpUrl,port);
			ftpClient.login(userName, password);
			ftpClient.enterLocalPassiveMode();
			File srcFile = new File(srcFileName);
			fis = new FileInputStream(srcFile);
			// 设置上传目录
			ftpClient.changeWorkingDirectory(directory);
			ftpClient.setBufferSize(1024);
			ftpClient.setControlEncoding("gbk");
			// 设置文件类型（二进制）
			ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
			result = ftpClient.storeFile(destName, fis);
			return result;
			} catch(NumberFormatException e){
			System.out.println("FTP端口配置错误:不是数字:" );
			throw e;
			} catch(FileNotFoundException e){
			throw new FileNotFoundException();
			} catch (IOException e) {
			throw new IOException(e);
			} finally {
			IOUtils.closeQuietly(fis);
			try {
			ftpClient.disconnect();
			} catch (IOException e) {
			throw new RuntimeException("关闭FTP连接发生异常！", e);
			}
			}
	}
	
	public static void main(String[] args) {
			String ftpUrl="192.168.0.105";
			String userName="liu";
			String password="zaqxswjjis";
			int port=21;
			String directory = "/home/liu";
			String srcFileName="G:\\qqq.txt";
			String destName ="aaa.txt";
			try {
				upload(ftpUrl,userName,port,password,directory,srcFileName,destName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
