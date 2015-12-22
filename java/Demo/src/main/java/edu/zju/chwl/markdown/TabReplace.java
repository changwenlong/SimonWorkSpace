package edu.zju.chwl.markdown;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class TabReplace {

	public static void main(String[] args) {
		File directory = new File("E:\\changwenlong\\changwenlong.github.io\\_posts");
		if(!directory.isDirectory()){
			throw new IllegalArgumentException();
		}
		
		File[] files=directory.listFiles();
		for(File file: files){
			if(!file.isFile()){
				continue;
			}
			StringBuilder sb=new StringBuilder();
			try(BufferedReader br = new BufferedReader(new FileReader(file))) {
				String line;
				while((line=br.readLine())!=null){
					System.out.println(line);
					sb.append(line.replaceAll("\t", "    "));
					sb.append("\n");
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
