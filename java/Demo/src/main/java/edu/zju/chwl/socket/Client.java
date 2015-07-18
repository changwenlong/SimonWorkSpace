package edu.zju.chwl.socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) throws UnknownHostException,
			IOException {
		Socket socket = new Socket("127.0.0.1", 10002);
		BufferedReader in = new BufferedReader(new InputStreamReader(
				socket.getInputStream()));
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

		BufferedReader input = new BufferedReader(new InputStreamReader(
				System.in));

		String str;
		while ((str = input.readLine()) != null) {
			out.println(str);
			if ("over".equals(str)) {
				break;
			}
			System.out.println(in.readLine());
		}
		socket.close();
	}

}
