package edu.zju.chwl.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations-ii/
 * @author a590450
 * @date 11 Mar 2016 16:08:50
 */
public class PermutationsII {
	
	public static void main(String[] args) {
		System.out.println(new PermutationsII().permute(new int[]{1,1,2}));

	}
	
    public List<List<Integer>> permute(int[] nums) {
        if(nums==null){
        	return null;
        }
        int len = nums.length;
        //用来保存那些位置还能放元素
        boolean[] loc=new boolean[len];
        Arrays.fill(loc, true);
        ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        dfs(loc,results,new ArrayList<Integer>(),nums);
        return results;
    }

	private void dfs(boolean[] loc, ArrayList<List<Integer>> results,
			ArrayList<Integer> list, int[] nums) {
		if(list.size()==loc.length){
			results.add(getList(list,nums));
			return;
		}
		for(int i=0;i<loc.length;i++){
			if(loc[i]){
				//重复出现的元素的位置不能在前一元素前
				if(i!=0&&!loc[i-1]&&nums[i]==nums[i-1]){
					continue;
				}
				list.add(i);
				loc[i]=false;
				dfs(loc,results,list,nums);
				loc[i]=true;
				list.remove(list.size()-1);
			}
		}
		
	}

	private List<Integer> getList(ArrayList<Integer> list, int[] nums) {
		ArrayList<Integer> result = new ArrayList<Integer>(list);
		for(int i=0;i<list.size();i++){
			int loc = list.get(i);
			result.set(loc, nums[i]);
		}
		return result;
	}

}
