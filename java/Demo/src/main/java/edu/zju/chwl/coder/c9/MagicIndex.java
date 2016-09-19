package edu.zju.chwl.coder.c9;

import org.junit.Test;

/**
 * 二分查找实现 O(logn)
 * @author chwl
 * @Date 2016年5月22日 下午12:30:06
 */
public class MagicIndex {
    public boolean findMagicIndex(int[] arr, int n) {
		int low=0;
		int high=n;
		while(low<high){
			int mid=low+(high-low)/2;
			if(arr[mid]==mid){
				return true;
			}else if(arr[mid]>mid){
				high=mid;
			}else{
				low=mid+1;
			}
		}
		if(arr[low]==low) return true;
		return false;	
	}
    
    public boolean findMagicIndex2(int[] arr, int n) {
		int low=0;
		int high=n;
		while(low<=high){
			int mid=low+(high-low)/2;
			if(arr[mid]==mid){
				return true;
			}else if(arr[mid]>mid){
				high=mid-1;
			}else{
				low=mid+1;
			}
		}
		return false;	
	}
    
    @Test
    public void test(){
    	System.out.println(findMagicIndex(new int[]{0,2,3,4,5},5));;
    }
}
