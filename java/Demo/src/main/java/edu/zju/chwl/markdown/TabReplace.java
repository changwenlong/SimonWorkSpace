package edu.zju.chwl.markdown;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


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
					//若连续的后#无空格，gitpage解析h会失败，故在连续的#后面加空格
					Pattern pattern = Pattern.compile("(^#+)[\\S&&[^#]]");
					Matcher matcher = pattern.matcher(line);
					while(matcher.find()){
						String matchStr = matcher.group(1);
						line = line.replaceAll(matchStr, matchStr+" ");
					}
					//调整代码格式，将制表符\t用四个空格代替
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
