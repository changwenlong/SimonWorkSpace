package edu.zju.chwl.lintcode.graphsearch;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/subsets/
 * @author chwl
 * @Date 2016年3月10日 下午10:32:39
 */
public class Subsets {

	public static void main(String[] args) {
		System.out.println(new Subsets().subsets(new int[]{3,2,1}));
	}
	
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
    	if(nums==null){
    		return null;
    	}
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        results.add(new ArrayList<Integer>());
        Arrays.sort(nums);
        getSubsets(0,nums,results,new ArrayList<Integer>());
        return results;
    }

	private void getSubsets(int start,int[] nums, ArrayList<ArrayList<Integer>> results,
			ArrayList<Integer> list) {
		for(int i=start;i<nums.length;i++){
			list.add(nums[i]);
			results.add(new ArrayList<Integer>(list));
			getSubsets(i+1,nums,results,list);
			list.remove(list.size()-1);
		}		
	}

}
