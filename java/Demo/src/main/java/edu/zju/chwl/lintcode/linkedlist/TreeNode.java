package edu.zju.chwl.lintcode.linkedlist;

import edu.zju.chwl.util.Tools;

public class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
	
	public static void preOrderPrint(TreeNode node){
		if(node!=null){
			Tools.print(node.val);
			preOrderPrint(node.left);
			preOrderPrint(node.right);
		}
	}
}
