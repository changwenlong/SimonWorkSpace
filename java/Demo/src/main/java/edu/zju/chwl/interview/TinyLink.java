package edu.zju.chwl.interview;

import java.util.HashMap;
import java.util.Scanner;

import edu.zju.chwl.util.Tools;

public class TinyLink {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		HashMap<String,String> matchMap=new HashMap<String,String>();
		while(reader.hasNext()){
			String url=reader.nextLine();
			if(matchMap.get(url)!=null){
				Tools.print(matchMap.get(url));
			}else{
				tinyLink=getTinyLink();
				matchMap.put(url, tinyLink);
				Tools.print(tinyLink);
			}
		}
	}
	
	public static final String signal="qVTM0IwerYHN1Utyu2DCRFiof3GBJ4ghjk5XEKOl7zxcvbnm9QAZ6Wpasd8SLP";
	
	public static final char[] signalArr=signal.toCharArray();
	
	public static String tinyLink="qVTM0I";
	
	public static final int len=signalArr.length;
	
	private static String getTinyLink() {
		char[] linkArr=tinyLink.toCharArray();
		int index=0;
		while(signalArr[len-1]==linkArr[index]){
			linkArr[index]=signalArr[0];
			index++;
		}
		linkArr[index]=signalArr[signal.indexOf(linkArr[index])+1];
		return new String(linkArr);
		
	}

}
