package edu.zju.chwl.offer.basicknowledge;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * 二分查找
 * @author a590450
 * @date 17 Mar 2016 13:56:04
 */
public class FindMinimumInRotatedSortedArrayII {
	
    public int findMin(int[] nums) {
    	if(nums==null||nums.length==0){
    		return 0;
    	}
    	int start=0,end=nums.length-1;
    	while(start<end){
    		int mid = (end-start)/2+start;
    		if(nums[mid]>nums[end]){
    			start=mid+1;
    		}else{
    			end = mid;
    		}
    	}
    	return nums[start];
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
}
