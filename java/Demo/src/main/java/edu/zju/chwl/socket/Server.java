package edu.zju.chwl.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class Server {
	public static void main(String[] args) {
		BufferedReader br = null;
		PrintWriter pw = null;
		try{
			ServerSocket server=new ServerSocket(2000);
			Socket socket=server.accept();
			//获取输入流
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//获取输出流
			pw=new PrintWriter(socket.getOutputStream(),true);
			String s=br.readLine();
			System.out.println("client says:"+s);
			Scanner scanner=new Scanner(System.in);
			String message=scanner.next();
			scanner.close();
			pw.println(message);
			server.close();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				br.close();
				pw.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}
