package edu.zju.chwl.io;

import java.io.*;

public class MemoryInput {

	public static void main(String[] args) throws IOException {
		StringReader in=new StringReader(BufferedInputFile
				.read("src//main//java//edu//zju//chwl//io//MemoryInput.java"));
		int i;
		while((i=in.read())!=-1){
			System.out.print((char)i);
		}
	}

}
