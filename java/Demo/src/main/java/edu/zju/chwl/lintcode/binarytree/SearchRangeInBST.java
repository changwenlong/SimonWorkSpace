package edu.zju.chwl.lintcode.binarytree;

import java.util.ArrayList;
import java.util.Collections;

public class SearchRangeInBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		TreeNode left = new TreeNode(8);
		TreeNode right = new TreeNode(22);
		root.left = left;
		root.right = right;
		TreeNode left1 = new TreeNode(4);
		TreeNode right1 = new TreeNode(12);
		left.left = left1;
		left.right = right1;
		System.out.println(new SearchRangeInBST().searchRange(root, 10, 22));

	}

	private ArrayList<Integer> resultList;

	public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
		resultList = new ArrayList<Integer>();
		helper(root, k1, k2);
		Collections.sort(resultList);
		return resultList;
	}

	public void helper(TreeNode root, int k1, int k2) {
		if (root == null) {
			return;
		}
		if (root.val < k1) {
			helper(root.right, k1, k2);
		} else if (root.val > k2) {
			helper(root.left, k1, k2);
		} else {
			resultList.add(root.val);
			helper(root.right, k1, k2);
			helper(root.left, k1, k2);
		}
	}
}
