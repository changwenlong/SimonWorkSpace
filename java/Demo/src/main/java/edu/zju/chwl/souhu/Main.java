package edu.zju.chwl.souhu;

import java.util.*;

public class Main {
	
public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int[] nums = new int[n];
			for(int i=0;i<n;i++){
				nums[i]=in.nextInt();
			}
			int[] dp1=new int[n];
			dp1[0]=1;
			for(int i=1;i<n;i++){
				if(nums[i]>nums[i-1]){
					dp1[i]=dp1[i-1]+1;
				}else{
					dp1[i]=1;
				}
			}
			int[] dp2=new int[n];
			dp2[n-1]=1;
			for(int i=n-2;i>=0;i--){
				if(nums[i]>nums[i+1]){
					dp2[i]=dp2[i+1]+1;
				}else{
					dp2[i]=1;
				}
			}
			int sum=0;
			for(int i=0;i<n;i++){
				int temp=Math.max(dp1[i], dp2[i]);
				sum+=temp;
			}
			System.out.println(sum);
		}

	}	
}
