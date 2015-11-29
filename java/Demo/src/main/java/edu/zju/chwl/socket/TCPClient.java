package edu.zju.chwl.socket;

import java.io.*;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) {
		BufferedReader br = null;
		PrintWriter pw = null;
		try{
			Socket socket=new Socket("211.149.245.172",80);
			System.out.println("连接服务器成功");
			//获取输入流
			br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//获取输出流
			pw=new PrintWriter(socket.getOutputStream(),true);
			/*String s=br.readLine();
			System.out.println("client says:"+s);
			Scanner scanner=new Scanner(System.in);
			String message=scanner.next();*/
			pw.println("hello");
			String s=br.readLine();
			System.out.println("server says:"+s);
			socket.close();
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
