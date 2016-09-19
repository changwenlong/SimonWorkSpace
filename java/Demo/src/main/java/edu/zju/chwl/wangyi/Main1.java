package edu.zju.chwl.wangyi;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n =in.nextInt();
			int a = in.nextInt();
			for(int i=0;i<n;i++){
				int num = in.nextInt();
				if(a>=num){
					a+=num;
				}else{
					a=a+acd(a,num);
				}
			}
			System.out.println(a);
		}

	}

	private static int acd(int a, int b) {
		return b==0?a:acd(b,a%b);
	}
}
