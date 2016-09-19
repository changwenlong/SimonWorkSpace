package edu.zju.chwl.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class Main5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			while(n!=6174&&n!=0){
				n = printExpre(n);
			}			
		}

	}
	
	private static int printExpre(int n) {
		String str = String.format("%04d", n);
		char[] charArr = str.toCharArray();
		Arrays.sort(charArr);
		String min = new String(charArr);
		char[] big = new char[4];
		for(int i=0;i<4;i++){
			big[i]=charArr[3-i];
		}
		String max = new String(big);
		int res = Integer.parseInt(max)-Integer.parseInt(min);
		System.out.println(String.format("%s - %s = "+"%04d",max,min,res));
		return res;
	}

}
