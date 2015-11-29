package edu.zju.chwl.socket;

import java.io.*;
import java.net.*;

public class HttpRequest {
	public static void main(String[] args) throws IOException{
		String urlStr="http://toupiao.v0580.com/e/enews/index.php";
		URL url=new URL(urlStr);
		BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));
		String text=null;
		while((text=br.readLine())!=null){
			System.out.println(text);
		}				
	}
}
