package edu.zju.chwl.wangyi3;

import java.util.*;

public class Main4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			int n = in.nextInt();
			int min=Integer.MAX_VALUE;
			int[] nums = new int[n];
			for(int i=0;i<n;i++){
				nums[i] = in.nextInt();
			}
			for(int i=0;i<n;i++){
				min=Math.min(in.nextInt()+nums[i]-2, min);
			}
			System.out.println(min);
		}
	}
}
/*
3
4 6 8
1 2 1
 */
