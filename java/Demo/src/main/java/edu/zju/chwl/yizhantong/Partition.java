package edu.zju.chwl.yizhantong;

import java.util.*;

import org.junit.Test;

public class Partition {
    public int[] getPartition(int[][] land, int n, int m) {
        if(land==null){
        	return null;
        }
        int[] nums=new int[n+1];
        nums[n]=0;
        for(int i=n-1;i>=0;i--){
        	int sum=0;
        	for(int j=0;j<m;j++){
        		sum+=land[j][i];
        	}
        	nums[i]=m-sum+nums[i+1];
        }
        int min=nums[0];
        int preValue=min;
        int pos=0;
        for(int i=0;i<n;i++){
        	int aCount=nums[i]-nums[i+1];
        	int bCount=m-aCount;
        	preValue= preValue+bCount-aCount;
        	if(preValue<min){
        		min=preValue;
        		pos=i+1;
        	}
        }
        int[] result=new int[2];
        result[0]=pos;
        result[1]=pos+1;
        return result;
    }
    
	@Test
	public void test(){
		int[][] nums=new int[][]{{1,1,1,1},{0,0,0,0},{1,0,1,1}};
		System.out.println(getPartition(nums,4,3));
	}
}