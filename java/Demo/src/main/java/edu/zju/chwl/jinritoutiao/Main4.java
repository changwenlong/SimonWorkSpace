package edu.zju.chwl.jinritoutiao;

import java.util.*;

//可以使用 Integer.toBinaryString(x);
public class Main4 {

	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x=in.nextInt();
        int k=in.nextInt();      
        int[] nums=getArray(x);
        System.out.println(getNum(nums,k));
	}	
	
	private static int[] getArray(int x) {
		int[] arr=new int[34];
		int count=0;
		int i=-1;
		while(x!=0){
			i++;
			if(x%2==0){
				arr[count++]=i;
			}
			x=x>>1;
		}
		arr[count++]=i+1;
		return Arrays.copyOf(arr, count);
	}

	public static long getNum(int[] nums,int k){
		long sum=0;
		int i=-1;
		int factor=0;
		while(k!=0){
			i++;
			if(i>=nums.length){
				factor++;
			}else{
				factor=nums[i];
			}
			if(k%2==1){
				sum+=((long)1)<<factor;//防止溢出			
			}
			k=k>>1;
		}
		return sum;
	}
}
