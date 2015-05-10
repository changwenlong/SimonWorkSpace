package edu.zju.chwl.io;

import java.io.*;
import java.util.*;

import org.junit.Test;

public class IoTest {
	@Test
	public void test() throws IOException {
		BufferedReader br=new BufferedReader(new FileReader("2.txt"));
		String str;
		Map<String,Integer> wordCount=new HashMap<String,Integer>();
		while((str=br.readLine())!=null){
			for(String item:str.split(" ")){
				Integer count=wordCount.get(item);
				if(count==null){
					wordCount.put(item,1);
				}else{
					wordCount.put(item, count+1);
				}
			}
		}
		System.out.println(wordCount);
	}
}
