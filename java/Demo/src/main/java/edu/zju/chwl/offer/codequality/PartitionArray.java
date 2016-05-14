package edu.zju.chwl.offer.codequality;

import junit.framework.Assert;

import org.junit.Test;

/**
 * http://www.lintcode.com/en/problem/partition-array-by-odd-and-even/
 * 
 * 通过换位置实现
 * 从后往前遍历
 * 
 * @author a590450
 * @date 21 Mar 2016 14:41:37
 */
public class PartitionArray {

    public void partitionArray(int[] nums) {
        if(nums==null||nums.length==0){
        	return;
        }
        int count = 0;
        int len=nums.length;
        for(int i=len-1;i>=0;i--){
        	if((nums[i]&1)==1){
        		count++;
        	}else{
        		if(count!=0){
        			int tmp = nums[i];
            		for(int j=i+1;j<i+1+count;j++){
            			nums[j-1]=nums[j];
            		}
            		nums[i+count]=tmp;
        		}
        	}
        }
    }
    
    @Test
    public void partition(){
    	int[] nums = new int[]{1,2,3,4,5,6,7,8};
    	partitionArray(nums);
    	Assert.assertEquals("13572468",arrayToString(nums) );
    }
    
    @Test
    public void partitionOdd(){
    	int[] nums = new int[]{1,3,5,7};
    	partitionArray(nums);
    	Assert.assertEquals("1357",arrayToString(nums) );
    }
    
    @Test
    public void partitionEven(){
    	int[] nums = new int[]{2,4,6,8};
    	partitionArray(nums);
    	Assert.assertEquals("2468",arrayToString(nums) );
    }
    
    @Test
    public void partitionEmpty(){
    	int[] nums = new int[]{};
    	partitionArray(nums);
    	Assert.assertEquals("",arrayToString(nums) );
    }
    
    @Test
    public void partitionNull(){
    	int[] nums = null;
    	partitionArray(nums);
    	Assert.assertEquals("",arrayToString(nums) );
    }
        
    
    public String arrayToString(int[] nums){
    	if(nums==null){
    		return "";
    	}
    	StringBuilder result = new StringBuilder();
    	for(int i:nums){
    		result.append(i);
    	}
    	return result.toString();
    }
}
