package edu.zju.chwl.leetcode;

import java.util.ArrayList;
import java.util.List;


/**
 * https://leetcode.com/problems/binary-tree-paths/
 * @author a590450
 * @date 22 Feb 2016 15:06:53
 */
public class BinaryTreePaths {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);
		root.left = left;
		root.right = right;
		left.right = new TreeNode(5);
		left.left = new TreeNode(4);
		System.out.println(binaryTreePaths(root));

	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<String>();
		path(root, new StringBuilder(), paths);
		return paths;
	}

	//DFS
	public static void path(TreeNode node, StringBuilder sb, List<String> list) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			sb.append(node.val);
			list.add(sb.toString());
		}


		int len = sb.length();
		if (node.left != null) {
			sb.append( node.val+"->");
			path(node.left, sb, list);
			sb.setLength(len);
		}

		if (node.right != null) {
			sb.append(node.val+"->");
			path(node.right, sb, list);
			sb.setLength(len);
		}
	}

}
