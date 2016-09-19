package edu.zju.chwl.tencent;

import java.util.*;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str=in.next();
			System.out.println(moveStr(str));
		}

	}

	private static String moveStr(String str) {
		char[] chars = str.toCharArray();
		for(int i=1;i<chars.length;i++){
			int pos=i;
			while(pos>=1&&chars[pos-1]>='A'&&chars[pos-1]<='Z'&&chars[pos]>='a'&&chars[pos-1]<='z'){
				pos = swap(chars,pos-1,pos);
			}
		}
		return new String(chars);
	}

	private static int swap(char[] chars, int i, int j) {
		char temp=chars[i];
		chars[i]=chars[j];
		chars[j]=temp;
		return i;
	}

}
