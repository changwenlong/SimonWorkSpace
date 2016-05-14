package edu.zju.chwl.offer.thoughtofsolution;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.zju.chwl.offer.datastructure.TreeNode;

/**
 * http://www.lintcode.com/en/problem/binary-tree-path-sum/
 * 
 * 打印二叉树的所有路径的变形题 https://leetcode.com/problems/binary-tree-paths/
 * 
 * @author a590450
 * @date 23 Mar 2016 16:06:29
 */
public class BinaryTreePathSum {

	public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
		ArrayList<List<Integer>> resultList = new ArrayList<List<Integer>>();
		if (root == null) {
			return resultList;
		}
		recursionPath(root, target, resultList, new ArrayList<Integer>(), 0);
		return resultList;
	}

	private void recursionPath(TreeNode node, int target,
			ArrayList<List<Integer>> resultList, ArrayList<Integer> list,
			int sum) {
		if (node == null) {
			return;
		}
		list.add(node.val);
		sum = sum + node.val;
		if (node.left == null && node.right == null) {
			if (target == sum) {
				resultList.add(new ArrayList<Integer>(list));
			}
		} else {
			recursionPath(node.left, target, resultList, list, sum);
			recursionPath(node.right, target, resultList, list, sum);
		}
		//什么时候remove元素需要特别注意
		list.remove(list.size() - 1);
	}


	@Test
	public void pathSum() {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(4);
		TreeNode left = new TreeNode(2);
		root.left = left;
		left.left = new TreeNode(2);
		left.right = new TreeNode(3);
		System.out.print(binaryTreePathSum(root, 5));
	}
}
