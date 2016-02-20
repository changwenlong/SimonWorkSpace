package edu.zju.chwl.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DeleteComment {

	public static void main(String[] args) {
		File directory = new File("c:\\temp");
		if(!directory.isDirectory()){
			throw new IllegalArgumentException();
		}
		
		File[] files=directory.listFiles();
		boolean isComment=false;
		for(File file: files){
			if(!file.isFile()){
				continue;
			}
			StringBuilder sb=new StringBuilder();
			try(BufferedReader br = new BufferedReader(new FileReader(file))) {
				String line;
				while((line=br.readLine())!=null){
					if(line.trim().startsWith("/*")){
						isComment=true;
					}
					if(line.trim().endsWith("*/")){
						isComment=false;
						continue;
					}
					if(!line.trim().startsWith("//")&&!isComment){
						sb.append(line);
						sb.append("\n");
					}
					
				}
				try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
					bw.write(sb.toString());
					bw.flush();
				}
			} catch (FileNotFoundException e) {
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally{
				
			}
		}
	}

}
