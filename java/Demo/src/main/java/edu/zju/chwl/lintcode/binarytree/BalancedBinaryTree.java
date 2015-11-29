package edu.zju.chwl.lintcode.binarytree;

import edu.zju.chwl.util.Tools;

public class BalancedBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedBinaryTree b=new BalancedBinaryTree();
		TreeNode root=new TreeNode(3);
		TreeNode left=new TreeNode(9);
		TreeNode right=new TreeNode(20);
		root.left=left;
		root.right=right;
		right.left=new TreeNode(15);
		right.right=new TreeNode(7);
		Tools.print(b.isBalanced(root));

	}
	
    public boolean isBalanced(TreeNode root) {
        // write your code here
    	return height(root)!=-1;
    }

	private int height(TreeNode root) {
		if(root==null){
			return 0;
		}
		int left=height(root.left);
		int right=height(root.right);
		//不平衡时，高度返回-1
		if(left==-1||right==-1||Math.abs(left-right)>1){
			return -1;
		}
		return Math.max(height(root.left),height(root.right))+1;
	}

}
