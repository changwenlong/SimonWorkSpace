package edu.zju.chwl.offer.II;

import edu.zju.chwl.lintcode.linkedlist.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorder {

	public static void main(String[] args){
		TreeNode node=new ConstructBinaryTreeFromPreorderAndInorder().buildTree(new int[]{2,1,3}, new int[]{1,2,3});
		TreeNode.preOrderPrint(node);
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if (preorder == null || preorder.length == 0) {
			return null;
		}
		int len = inorder.length;
		int val = preorder[0];
		TreeNode node = new TreeNode(val);
		if(len==1){
			return node;
		}
		int leftTreeLen = 0, rightTreeLen = 0;
		for (int i = 0; i < len; i++) {
			if (inorder[i] == val) {
				leftTreeLen = i;
				rightTreeLen = len - i-1;
			}
		}
		int[] leftPreOrder = getLeftPreOrder(preorder, leftTreeLen);
		int[] leftInOrder = getLeftInOrder(inorder,leftTreeLen);
		int[] rightPreOrder = getRightPreOrder(preorder,rightTreeLen,leftTreeLen+1);
		int[] rightInOrder = getRightInOrder(inorder,rightTreeLen,leftTreeLen+1);

		node.left = buildTree(leftPreOrder, leftInOrder);
		node.right = buildTree(rightPreOrder, rightInOrder);
		return node;
	}

	private int[] getLeftPreOrder(int[] preorder, int leftTreeLen) {
		int[] leftPreOrder=new int[leftTreeLen];
		for(int i=1;i<=leftTreeLen;i++){
			leftPreOrder[i-1]=preorder[i];
		}
		return leftPreOrder;
	}
	
	private int[] getLeftInOrder(int[] inorder, int leftTreeLen) {
		int[] leftInOrder = new int[leftTreeLen];
		for(int i=0;i<leftTreeLen;i++){
			leftInOrder[i]=inorder[i];
		}
		return leftInOrder;
	}
	
	private int[] getRightPreOrder(int[] preorder, int rightTreeLen,int start) {
		int[] rightPreOrder=new int[rightTreeLen];
		for(int i=start;i<preorder.length;i++){
			rightPreOrder[i-start]=preorder[i];
		}
		return rightPreOrder;
	}
	
	private int[] getRightInOrder(int[] inorder, int rightTreeLen,int start) {
		int[] rightInOrder=new int[rightTreeLen];
		for(int i=start;i<inorder.length;i++){
			rightInOrder[i-start]=inorder[i];
		}
		return rightInOrder;
	}
}
