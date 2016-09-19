package edu.zju.chwl.huawei;

import java.util.*;

public class Main5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str=in.next();
			boolean[] hash=new boolean[256];
			Arrays.fill(hash, false);
			for(int i=0;i<str.length();i++){
				char ch = str.charAt(i);
				if(!hash[ch]){
					hash[ch]=true;
					System.out.print(ch);
				}
			}
			System.out.println();
		}

	}

}
