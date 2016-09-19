package edu.zju.chwl.huawei;

import java.util.*;

public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			String str=in.next();
			Integer num = Integer.parseInt(str.substring(2), 16);
			System.out.println(num);
		}

	}

}
