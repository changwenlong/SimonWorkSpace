package edu.zju.chwl.coder.c9;

import org.junit.Test;

/**
 * 二分查找实现 O(logn) 查找过程中可以过滤掉一部分元素
 * @author chwl
 * @Date 2016年5月22日 下午12:30:06
 */
public class MagicIndexII {
    public boolean findMagicIndex(int[] arr, int n) {
    	return magicFast(arr,0,n-1);
	}    
    
    public boolean magicFast(int[] arr,int low,int high){
    	if(high<low||low<0||high>=arr.length){
    		return false;
    	}
    	int mid=low+(high-low)/2;
    	if(arr[mid]==mid){
    		return true;
    	}else if(arr[mid]>mid){
    		return magicFast(arr,low,mid-1)||
    				magicFast(arr,arr[mid],high);
    	}else{
    		return magicFast(arr,low,arr[mid])||
    				magicFast(arr,mid+1,high);
    	}
    }
    
    @Test
    public void test(){
    	System.out.println(findMagicIndex(new int[]{1,1,3,4,5},5));;
    }
}
