package edu.zju.chwl.lintcode.graphsearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * http://www.lintcode.com/en/problem/combination-sum/
 * https://leetcode.com/problems/combination-sum/
 * 
 * DFS的思想
 * 
 * @author chwl
 * @Date 2016年3月8日 下午11:02:08
 */
public class CombinationSum {

	public static void main(String[] args) {
		System.out.println(combinationSum(new int[] { 2, 3, 6, 7 }, 7));

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
			if (target >= candidates[i]) {
				list.add(candidates[i]);
				helper(candidates, i, target - candidates[i], list, lists);
				list.remove(list.size() - 1);
			} else {
				break;
			}
		}
	}

}
