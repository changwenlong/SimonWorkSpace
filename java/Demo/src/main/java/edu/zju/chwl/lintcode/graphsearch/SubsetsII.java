package edu.zju.chwl.lintcode.graphsearch;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/subsets-ii
 * @author chwl
 * @Date 2016年3月10日 下午10:32:39
 */
public class SubsetsII {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(2);
		nums.add(2);
		nums.add(1);
		System.out.println(new SubsetsII().subsetsWithDup(nums));
	}
	
	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> nums) {
    	if(nums==null){
    		return null;
    	}
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        results.add(new ArrayList<Integer>());
        Collections.sort(nums);
        getSubsets(0,nums,results,new ArrayList<Integer>());
        return results;
    }

	private void getSubsets(int start,ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> results,
			ArrayList<Integer> list) {
		for(int i=start;i<nums.size();i++){
			if(i!=start&&nums.get(i)==nums.get(i-1)){
				continue;
			}
			list.add(nums.get(i));
			results.add(new ArrayList<Integer>(list));
			getSubsets(i+1,nums,results,list);
			list.remove(list.size()-1);
		}		
	}

}
