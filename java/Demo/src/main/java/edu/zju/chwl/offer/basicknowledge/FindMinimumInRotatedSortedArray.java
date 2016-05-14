package edu.zju.chwl.offer.basicknowledge;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * 二分查找
 * @author a590450
 * @date 17 Mar 2016 13:56:04
 */
public class FindMinimumInRotatedSortedArray {
	
    public int findMin(int[] nums) {
    	if(nums==null||nums.length==0){
    		return 0;
    	}
    	int start=0,end=nums.length-1;
    	int mid = (end-start)/2+start;
    	if(nums[mid]==nums[start]&&nums[mid]==nums[end]){
    		return getMin(nums);
    	}
    	while(start<end){
    		mid = (end-start)/2+start;
    		if(nums[mid]>nums[end]){
    			start=mid+1;
    		}else{
    			end = mid;
    		}
    	}
    	return nums[start];
    }
    
    private int getMin(int[] nums) {
		int min = Integer.MAX_VALUE;
		for(int item:nums){
			min=min<item?min:item;
		}
		return min;
	}

	@Test
    public void leftFindMid(){
    	assertEquals(1,findMin(new int[]{5,6,1,2,3,4}));
    }
    
    @Test
    public void rightFindMid(){
    	assertEquals(1,findMin(new int[]{3,4,5,6,1,2}));
    }
    
    @Test
    public void testfindMid(){
    	assertEquals(1,findMin(new int[]{1,2,3,4,5,6}));
    }
    
    @Test
    public void specialFindMid(){
    	assertEquals(1,findMin(new int[]{1}));
    }
    
    @Test
    public void nullFindMid(){
    	assertEquals(0,findMin(null));
    }
    
    @Test
    public void binarySearch(){
    	assertEquals(2,binarySearch(new int[]{1,3,4,6,8},4));
    }
    
    //查找target在排序数组nums中的位置，找不到返回-1
    public int binarySearch(int[] nums,int target){
    	if(nums==null||nums.length==0){
    		return -1;
    	}
    	int low = 0;
    	int high = nums.length-1;
    	while(low<high){
    		int mid=(high-low)/2+low;
    		if(nums[mid]==target){
    			return mid;
    		}else if(nums[mid]>target){
    			high = mid-1;
    		}else{
    			low=mid+1;
    		}
    	}
    	if(nums[low]==target){
    		return low;
    	}
    	return -1;
    }
}
