package edu.zju.chwl.huawei;

import java.util.*;

public class Main4 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n=in.nextInt();
			int[] nums=new int[n];
			for(int i=0;i<n;i++){
				nums[i]=i;
			}
			int[] hash=new int[n];
			int count=0;
			int pos=0;
			while(count<n-1){
				int i=0;
				while(i<2){
					if(hash[pos]==0){
						i++;
					}
					pos=(pos+1)%n;
				}
				while(hash[pos]==1){
					pos=(pos+1)%n;
				}
				hash[pos]=1;
				count++;
			}
			while(hash[pos]==1){
				pos=(pos+1)%n;
			}
			System.out.println(nums[pos]);
		}

	}

}
