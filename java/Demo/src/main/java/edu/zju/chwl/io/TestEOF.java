package edu.zju.chwl.io;

import java.io.*;

public class TestEOF {

	public static void main(String[] args) throws IOException {
		DataInputStream in=new DataInputStream(new ByteArrayInputStream(BufferedInputFile
				.read("src//main//java//edu//zju//chwl//io//TestEOF.java")
				.getBytes()));
		while(in.available()!=0){
			System.out.print((char)in.readByte());
		}
	}

}
