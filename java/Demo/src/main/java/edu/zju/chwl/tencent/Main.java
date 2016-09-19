package edu.zju.chwl.tencent;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int[][] nums = new int[n][n];
			int start = 1;
			for(int i=0;i<=(n-1)/2;i++){
				start = fillArr(nums,i,n-(2*i),start);
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(i==0&&j==0)
						System.out.print(nums[i][j]);
					else
						System.out.print(" "+nums[i][j]);
				}
			}
		}
		in.close();
	}

	private static int fillArr(int[][] nums, int index, int n, int start) {
		for(int i = 0;i<n;i++){
			nums[index][i+index]=start++;
		}
		for(int i =1;i<n;i++){
			nums[i+index][index+n-1]=start++;
		}
		for(int i = n-2;i>=0;i--){
			nums[index+n-1][i+index]=start++;
		}
		for(int i= n-2;i>0;i--){
			nums[i+index][index]=start++;
		}
		return start;
	}
}
