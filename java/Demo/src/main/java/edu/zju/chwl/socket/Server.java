package edu.zju.chwl.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
	public static void main(String[] args) throws UnknownHostException, IOException{
		ServerSocket serverSocket=new ServerSocket(10002);
		Socket socket=serverSocket.accept();
		
		BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
		String str;
		while((str=in.readLine())!=null){
			if ("over".equals(str)) {
				break;
			}
			System.out.println(str);
			out.println(str.toUpperCase());
		}
		socket.close();
		serverSocket.close();
	}
}
