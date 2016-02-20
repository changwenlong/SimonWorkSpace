package edu.zju.chwl.socket;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class FtpUpload {
	
	public static void main(String[] args) {
		//将本地文件E:/Work/file.zip 上传到 ftp服务器中 ftp://username:password@www.myserver.com/folder/file.zip;type=i
        String localFile = "E:/Work/file.zip";
        String ftpUrl="ftp://username:password@www.myserver.com/folder/file.zip;type=i";
        uploadFile(localFile,ftpUrl);
	}

	public static void uploadFile(String localFile, String ftpUrl) {
		BufferedOutputStream bos = null;
		BufferedInputStream bis = null;
		try {
			URL url = new URL(ftpUrl);
			URLConnection conn = url.openConnection();
			bos = new BufferedOutputStream(conn.getOutputStream());
			bis = new BufferedInputStream(new FileInputStream(localFile));
			byte[] buffer=new byte[1024];
			int len;
			while((len=bis.read(buffer))!=-1){
				bos.write(buffer, 0, len);
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bos != null) {
					bos.close();
				}
				if (bis != null) {
					bis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
