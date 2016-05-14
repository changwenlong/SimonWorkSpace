package edu.zju.chwl.offer.skillsininterview;

import edu.zju.chwl.offer.datastructure.TreeNode;

public class BalanceTree {
	public boolean IsBalanced_Solution(TreeNode root) {
		return isBalanced(root,new StringBuilder());
	}
	
	/**
	 * s的长度用来保存节点的高度
	 */
	private boolean isBalanced(TreeNode root, StringBuilder s) {
		if (root == null) {
			s.append("");
			return true;
		}
		StringBuilder left = new StringBuilder(),right = new StringBuilder();
		if(isBalanced(root.left, left)&&isBalanced(root.right, right)){
			int lLen = left.length();
			int rLen = right.length();
			if(Math.abs(lLen-rLen)<=1){
				s.setLength((lLen>rLen?lLen:rLen)+1);
				return true;
			}
		}		
		return false;
	}
}
