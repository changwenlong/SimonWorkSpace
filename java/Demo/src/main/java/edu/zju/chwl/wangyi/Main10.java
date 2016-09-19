package edu.zju.chwl.wangyi;

import java.util.*;

public class Main10 {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String a = in.nextLong()+"";
			String da = in.nextInt()+"";
			String b = in.nextLong()+"";
			String db = in.nextInt()+"";
			String s1 =a.replaceAll(String.format("[^%s]", da), "");
			String s2 =b.replaceAll(String.format("[^%s]", db), "");
			System.out.println(new Long(s1.equals("")?"0":s1)+new Long(s2.equals("")?"0":s2));
		}
	}

}
