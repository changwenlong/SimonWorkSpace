package edu.zju.chwl.lintcode.binarytree;

import java.util.ArrayList;

import edu.zju.chwl.util.Tools;

public class BinaryTreePreorderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		TreeNode right=new TreeNode(2);
		root.right=right;
		TreeNode left1=new TreeNode(3);
		right.left=left1;
		
		Tools.print(preorderTraversal(root));

	}
	
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
    	ArrayList<Integer> list = new ArrayList<Integer>();
    	if(root!=null){
    		list.add(root.val);
    		list.addAll(preorderTraversal(root.left));
    		list.addAll(preorderTraversal(root.right));
    	}
    	return list;
    }
}
