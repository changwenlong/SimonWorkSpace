package edu.zju.chwl.io;

import java.io.*;
import java.util.*;

public class BufferedInputFile {

	public static String read(String filename) throws IOException{
		BufferedReader in=new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb=new StringBuilder();
		while((s=in.readLine())!=null){
			sb.append(s+"\n");
		}
		in.close();
		return sb.toString();
	}
	
	//练习7
	public static String reverseRead(String filename) throws IOException{
		List<String> list = readToList(filename);
		return reverseList(list);
	}
	
	//练习9
	public static String upperRead(String filename) throws IOException{
		List<String> list = readToList(filename);
		return upperLine(list);
	}

	//练习10
	public static String readWithWord(String filename,String word) throws IOException{
		List<String> list = readToList(filename);
		return containsWord(list,word);
	}


	private static List<String> readToList(String filename)
			throws FileNotFoundException, IOException {
		BufferedReader in=new BufferedReader(new FileReader(filename));
		String s;
		List<String> list=new LinkedList<String>();
		while((s=in.readLine())!=null){
			list.add(s+"\n");
		}
		in.close();
		return list;
	}

	private static String reverseList(List<String> list) {
		StringBuilder sb=new StringBuilder();
		for(int i=list.size()-1;i>=0;i--){
			sb.append(list.get(i));
		}
		return sb.toString();
	}
	

	private static String upperLine(List<String> list) {
		StringBuilder sb=new StringBuilder();
		for(String item:list){
			sb.append(item.toUpperCase());
		}
		return sb.toString();
	}
	
	private static String containsWord(List<String> list, String word) {
		StringBuilder sb=new StringBuilder();
		for(String item:list){
			sb.append((item.contains(word)?item:"").replaceAll("String", "******"));
		}
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		//System.out.println(upperRead("src//main//java//edu//zju//chwl//io//BufferedInputFile.java"));
		System.out.println(readWithWord("src//main//java//edu//zju//chwl//io//BufferedInputFile.java","String"));
	}

}
