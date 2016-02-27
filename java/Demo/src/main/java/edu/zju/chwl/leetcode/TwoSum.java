package edu.zju.chwl.leetcode;

import java.util.HashMap;

/**
 * 
 * https://leetcode.com/problems/two-sum/
 * 
 * @author chwl
 * @Date 2016年2月21日 下午4:51:49
 */
public class TwoSum {

	public static void main(String[] args) {
		int[] arr=twoSum(new int[]{3,2,4},6);
		for(int i:arr){
			System.out.println(i);
		}

	}
	
	public static int[] twoSum(int[] nums, int target) {
		int[] ans = null;
		HashMap<Integer,Integer> map =new HashMap<Integer,Integer>();
		for(int i=0;i<nums.length;i++){
			Integer index=map.get(target-nums[i]);
			if(index==null){
				map.put(nums[i], i);
			}else{
				ans = new int[] {index, i};
				break;
			}
		}
		
		return ans;
	}

}
