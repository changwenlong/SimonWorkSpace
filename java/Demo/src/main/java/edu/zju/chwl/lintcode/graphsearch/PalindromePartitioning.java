package edu.zju.chwl.lintcode.graphsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * http://www.lintcode.com/en/problem/palindrome-partitioning/
 * 
 * 实现：判断回文串（DP）+树的所有路径遍历（DFS）
 * 
 * @author chwl
 * @Date 2016年3月7日 下午11:53:58
 */
public class PalindromePartitioning {

	public static void main(String[] args) {
		System.out.println(partition("aab"));
	}

	public static List<List<String>> partition(String s) {
		if (s == null || s.isEmpty()) {
			return Collections.emptyList();
		}
		List<List<String>> lists = new ArrayList<List<String>>();
		helper(0, isPalindrome(s), s, lists, new ArrayList<String>());
		return lists;
	}

	//遍历树的所有路径  DFS
	private static void helper(int i, boolean[][] ispalindrome, String s,
			List<List<String>> lists, List<String> list) {
		if (i == s.length()) {
			//遍历到叶节点 保存
			lists.add(new ArrayList<String>(list));
			return;
		} 
		boolean[] palindrome = ispalindrome[i];
		for (int j = i; j < palindrome.length; j++) {
			if (palindrome[j]) {
				list.add(s.substring(i, j + 1));
				helper(j + 1, ispalindrome, s, lists, list);
				list.remove(list.size()-1);
			}
		}
	}

	//用来判断回文串 高效dp
	public static boolean[][] isPalindrome(String s) {
		if (s == null || s.isEmpty()) {
			return new boolean[0][];
		}
		int len = s.length();
		boolean[][] dp = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			dp[i][i] = true;
		}
		for (int i = len - 2; i >= 0; i--) {
			for (int j = i + 1; j < len; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					if ((j - 1) < (i + 1) || dp[i + 1][j - 1]) {
						dp[i][j] = true;
					}
				}
			}
		}
		return dp;
	}

}
