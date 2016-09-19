package edu.zju.chwl.wangyi;

import java.util.*;

public class Main7 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		HashSet<String> set = new HashSet<String>();
		while(in.hasNext()){
			String str = in.nextLine();
			for(String s:str.split(" ")){
				set.add(s);
			}			
		}
		System.out.println(set.size());
	}

}
