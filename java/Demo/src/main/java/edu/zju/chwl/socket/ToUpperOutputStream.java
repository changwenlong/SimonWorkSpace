package edu.zju.chwl.socket;

import java.io.*;

public class ToUpperOutputStream extends OutputStream{
	
	private OutputStream out;
	public ToUpperOutputStream(OutputStream out){
		this.out=out;
	}

	@Override
	public void write(int b) throws IOException {
		// TODO Auto-generated method stub
		out.write(b);
	}
	
	public void writeAndUpper(byte[] b) throws IOException{
		String tmpStr=new String(b,0,b.length).toUpperCase();
		out.write(tmpStr.getBytes());
	}


}
