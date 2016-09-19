package edu.zju.chwl.coder.c4;

public class BST {
	public  boolean checkBST(TreeNode root){
		inOrder(root);
		return flag;
	}
	
	boolean flag=true;
	int val=Integer.MIN_VALUE;
	private void inOrder(TreeNode root){
		if(root==null){
			return;
		}
		inOrder(root.left);
		if(root.val<val){
			flag =false;
			return;
		}else{
			val=root.val;
		}
		inOrder(root.right);
		
	}
}
