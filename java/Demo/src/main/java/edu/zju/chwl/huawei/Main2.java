package edu.zju.chwl.huawei;

import java.util.*;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n=in.nextInt();
			TreeSet<Integer> set = new TreeSet<Integer>();
			for(int i=0;i<n;i++){
				set.add(in.nextInt());
			}
			for(Integer num:set)
				System.out.println(num);
		}

	}

}
