package edu.zju.chwl.hiho21;

import java.util.Scanner;

public class Main1 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			in.nextLine();
			int sum = 0;
			int min = Integer.MAX_VALUE;
			for(int i=0;i<n;i++){
				String str = in.nextLine();
				if(str==null||str.isEmpty()||!str.contains("o")){
					min = 0;
					continue;
				}
				int index = str.indexOf('o');
				int length = str.length();
				int num = length-index;
				sum+=num;
				if(min!=0){
					min = getMin(str,index,min);
				}				
			}
			sum+=min;
			System.out.println(sum);
		}

	}

	public static int getMin(String str, int index, int min) {
		int tmp=0;
		int len = str.length();
		for(int i=index;i<len;i++){
			if('o'==str.charAt(i)){
				tmp++;
			}
		}
		int count = len-index-tmp;
		return min<count?min:count;
	}

}
