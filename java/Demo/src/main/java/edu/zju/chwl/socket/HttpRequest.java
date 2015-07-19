package edu.zju.chwl.socket;

import java.io.*;
import java.net.*;

public class HttpRequest {
	public static void main(String[] args) throws IOException{
		String urlStr="http://localhost:8080";
		URL url=new URL(urlStr);
		BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));
		String text=null;
		while((text=br.readLine())!=null){
			System.out.println(text);
		}				
	}
}
