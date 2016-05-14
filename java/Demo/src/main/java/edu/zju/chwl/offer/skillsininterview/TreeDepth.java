package edu.zju.chwl.offer.skillsininterview;

import edu.zju.chwl.offer.datastructure.TreeNode;

/**
 * 求树的深度
 * @author a590450
 * @date 1 Apr 2016 16:10:20
 */
public class TreeDepth {


	
	public int treeDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Integer depth = 0;
		getDepth(root,depth);
		return depth;
	}

	private int getDepth(TreeNode root, Integer depth) {
		if (root == null) {
			depth=0;
			return depth;
		}
		Integer left = 0,right = 0;
		getDepth(root.left, left);
		getDepth(root.right, right);
		return 1+(left>right?left:right);
	}
}
