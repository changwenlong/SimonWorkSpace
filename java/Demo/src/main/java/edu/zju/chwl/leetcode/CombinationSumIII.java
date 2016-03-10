package edu.zju.chwl.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-iii/
 * 
 * DFS的思想
 * 
 * @author chwl
 * @Date 2016年3月8日 下午11:02:08
 */
public class CombinationSumIII {

	public static void main(String[] args) {
		System.out.println(combinationSum3(3,7));
		System.out.println(combinationSum3(3,9));

	}

	public static List<List<Integer>> combinationSum3(int k, int n) {
		ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
		helper(new int[]{1,2,3,4,5,6,7,8,9}, 0, n, new ArrayList<Integer>(), lists,k);
		return lists;
	}

	private static void helper(int[] candidates, int start, int target,
			List<Integer> list, List<List<Integer>> lists,int k) {
		if (list.size()>=k) {
			if(target == 0){				
				lists.add(new ArrayList<Integer>(list));
			}
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			if (target <candidates[i]) {
				break;
			}
			list.add(candidates[i]);
			helper(candidates, i+1, target - candidates[i], list, lists,k);
			list.remove(list.size() - 1);
		}
	}

}
