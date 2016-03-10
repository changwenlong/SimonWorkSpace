package edu.zju.chwl.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/combination-sum-ii/
 * 
 * DFS的思想
 * 
 * @author chwl
 * @Date 2016年3月8日 下午11:02:08
 */
public class CombinationSumII {

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] { 10,1,2,7,6,1,5 }, 8));
		System.out.println(combinationSum(new int[] { 2,2,2 }, 2));

	}

	public static List<List<Integer>> combinationSum(int[] candidates,
			int target) {
		if (candidates == null || candidates.length == 0) {
			return Collections.emptyList();
		}
		Arrays.sort(candidates);
		ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
		helper(candidates, 0, target, new ArrayList<Integer>(), lists);
		return lists;
	}

	private static void helper(int[] candidates, int start, int target,
			List<Integer> list, List<List<Integer>> lists) {
		if (target == 0) {
			lists.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = start; i < candidates.length; i++) {
			//去重
			if (i != start && candidates[i] == candidates[i-1]){
	            continue;
	        }
			if (target <candidates[i]) {
				break;
			}
			list.add(candidates[i]);
			helper(candidates, i+1, target - candidates[i], list, lists);
			list.remove(list.size() - 1);
		}
	}

}
