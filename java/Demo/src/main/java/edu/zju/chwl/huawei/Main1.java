package edu.zju.chwl.huawei;

import java.util.*;

public class Main1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int num=in.nextInt();
			if(num==0){
				break;
			}
			System.out.println(num/2);
		}

	}

}
