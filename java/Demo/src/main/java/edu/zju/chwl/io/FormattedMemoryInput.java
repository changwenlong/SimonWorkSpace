package edu.zju.chwl.io;

import java.io.*;

public class FormattedMemoryInput {

	public static void main(String[] args) throws IOException {
		DataInputStream in=new DataInputStream(new ByteArrayInputStream(BufferedInputFile
				.read("src//main//java//edu//zju//chwl//io//FormattedMemoryInput.java")
				.getBytes()));
		while(true){
			try{
				System.out.print((char)in.readByte());
			}catch(EOFException ex){
				System.err.println("end of stream!");
			}
		}
	}

}
