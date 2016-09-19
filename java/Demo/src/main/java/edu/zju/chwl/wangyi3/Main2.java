package edu.zju.chwl.wangyi3;

import java.util.*;

public class Main2 {
	static int ret = 0;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			ret = 0;
			int n = in.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = in.nextInt();
			}
			Arrays.sort(nums);
			dfs(nums, 0, 0, 1, n);
			System.out.println(ret);
		}

	}

	private static void dfs(int[] nums, int start, int a, int b, int n) {
		if (start != 0) {
			if (a > b) {
				ret++;
			} else if (a < b) {
				return;
			}
		}
		for (int i = start; i < n; i++) {
			a += nums[i];
			b *= nums[i];
			dfs(nums, i + 1, a, b, n);
			a -= nums[i];
			b /= nums[i];			
			while (i < n - 1 && nums[i] == nums[i + 1]) {
				i++;
			}
		}

	}
}
/*
3 
1 1 1 
3 
1 1 2
 */
