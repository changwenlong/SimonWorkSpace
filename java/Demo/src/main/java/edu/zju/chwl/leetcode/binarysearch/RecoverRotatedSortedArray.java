package edu.zju.chwl.leetcode.binarysearch;

import java.util.ArrayList;

public class RecoverRotatedSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> nums=new ArrayList<Integer>();
		for(int i=0;i<9;i++){
			nums.add(1);
		}
		nums.add(-1);
		for(int i=0;i<11;i++){
			nums.add(1);
		}
		recoverRotatedSortedArray(nums);
		System.out.println(nums);
		

	}
	
    public static void recoverRotatedSortedArray(ArrayList<Integer> nums) {
    	for(int i=0;i<nums.size()-1;i++){
    		if(nums.get(i)>nums.get(i+1)){
        		turnAround(nums,0,i);
        		turnAround(nums,i+1,nums.size()-1);
        		turnAround(nums,0,nums.size()-1);
        		return;
    		}
    	}
    }

	public static void turnAround(ArrayList<Integer> nums, int start,int end) {
		for(int i=start;i<=(start+end)/2;i++){
			int temp=nums.get(i);
			nums.set(i,nums.get(end-(i-start)));
			nums.set(end-(i-start), temp);
		}
		
	}

}
