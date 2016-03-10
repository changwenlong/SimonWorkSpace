package edu.zju.chwl.lintcode.datastructure;

import java.util.HashMap;

/**
 * http://www.lintcode.com/en/problem/longest-consecutive-sequence/
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * O(n)
 * HashMap
 * 
 * @author a590450
 * @date 2 Mar 2016 16:22:52
 */
public class LongestConsecutiveSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
		System.out.println(longestConsecutive(new int[]{1,2,0,1}));
	}
	
    public static int longestConsecutive(int[] nums) {
        if(nums==null||nums.length==0){
        	return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int max=0;
        for(int num:nums){
        	int left = map.get(num-1)==null?0:map.get(num-1);
        	int right = map.get(num+1)==null?0:map.get(num+1);
        	int value = 1+left+right;
        	if(map.get(num)==null){
        		//获取但前位置的值，更新最左边和最后边的值用作之后的计算
            	map.put(num, value);
            	map.put(num-left, value);
            	map.put(num+right, value);
            	max = value>max?value:max;
        	}
        }
        return max;
    }

}
