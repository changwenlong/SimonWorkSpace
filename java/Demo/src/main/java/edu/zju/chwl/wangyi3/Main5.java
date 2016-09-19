package edu.zju.chwl.wangyi3;

import java.util.*;

public class Main5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String word1 = in.next();
			String word2 = in.next();
			int val=0;
			for(int i=0;i<=word1.length();i++){
				boolean flag = isHuiwen(word1.substring(0, i)+word2+word1.substring(i));
				if(flag)
					val++;
			}
			System.out.println(val);
		}
	}
	
	public static boolean isHuiwen(String str){
		int len = str.length();
		for(int i=0;i<len/2;i++){
			if(str.charAt(i)!=str.charAt(len-i-1)){
				return false;
			}
		}
		return true;
	}
}
/*
aba
b
 */
