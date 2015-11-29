package edu.zju.chwl.interview;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import edu.zju.chwl.util.Tools;

/**
 * find the longest word of a text file,and the number of occurrences.
 */
public class IO {
	class ResultType{
		String longWord;
		int count;
		public ResultType(String longWord,int count) {
			this.longWord=longWord;
			this.count=count;
		}
	}
	
	public ResultType findLongestWord(String path) throws IOException{
		BufferedReader reader=new BufferedReader(new FileReader(path));
		StringBuilder sb=new StringBuilder();
		String str;
		while((str=reader.readLine())!=null){
			sb.append(str+"\n");
		}
		String[] wordArr=sb.toString().split("\\W");
		int maxLen=-1;
		String word=null;
		HashMap<String,Integer> wordCountMap=new HashMap<String,Integer>();
		for(String s:wordArr){
			if(s.length()>maxLen){
				maxLen=s.length();
				word=s;
			}
			if(wordCountMap.get(s)==null){
				wordCountMap.put(s, 1);
			}else{
				wordCountMap.put(s, wordCountMap.get(s)+1);
			}
		}
		Tools.print(wordCountMap);
		return new ResultType(word,wordCountMap.get(word));
	}
	
	public static void main(String[] args) throws IOException{
		IO io=new IO();
		ResultType result=io.findLongestWord("C:\\CVS\\Europe\\Cloud\\SSTLWorkspace\\test\\src\\edu\\zju\\chwl\\interview\\IO.java");
		Tools.print(result.longWord+":"+result.count);
	}

}
