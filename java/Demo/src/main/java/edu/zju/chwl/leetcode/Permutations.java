package edu.zju.chwl.leetcode;

import java.util.*;

/**
 * https://leetcode.com/problems/permutations/
 * @author a590450
 * @date 11 Mar 2016 16:34:48
 */
public class Permutations {

	public static void main(String[] args) {
		System.out.println(new Permutations().permute(new int[] { 1, 2, 3 }));

	}

	public List<List<Integer>> permute(int[] nums) {
		if (nums == null) {
			return null;
		}
		int len = nums.length;
		//保存那些元素已经放好了位置
		boolean[] hash = new boolean[len];
		Arrays.fill(hash, true);
		ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
		dfs(hash, results, new ArrayList<Integer>(), nums);
		return results;
	}

	private void dfs(boolean[] hash, ArrayList<List<Integer>> results,
			ArrayList<Integer> list, int[] nums) {
		if (list.size() == hash.length) {
			results.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = 0; i < hash.length; i++) {
			if (hash[i]) {
				list.add(nums[i]);
				hash[i] = false;
				dfs(hash, results, list, nums);
				hash[i] = true;
				list.remove(list.size() - 1);
			}
		}

	}

}
