package edu.zju.chwl.coder.c7;

import org.junit.Test;

public class KthNumber {
    public int findKth(int k) {
    	if(k==1) return 3;
    	int[] nums=new int[k+1];
    	nums[0]=1;
    	int n3=0,n5=0,n7=0;
        for(int i=1;i<=k;i++){
        	int min=Math.min(3*nums[n3],Math.min(5*nums[n5],7*nums[n7]));
        	if(min/3==nums[n3]) n3++;
        	if(min/5==nums[n5]) n5++;
        	if(min/7==nums[n7]) n7++;
        	nums[i]=min;
        }
        return nums[k];
    }
    
    @Test
    public void test(){
    	for(int i=1;i<17;i++)
    		System.out.println(findKth(i));
    }
}
