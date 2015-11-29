package edu.zju.chwl.lintcode.binarytree;

import edu.zju.chwl.util.Tools;

public class InsertNodeInBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(2);
		TreeNode left=new TreeNode(1);
		TreeNode right=new TreeNode(4);
		root.left=left;
		root.right=right;
		TreeNode left1=new TreeNode(3);
		right.left=left1;
		TreeNode node=new TreeNode(6);
		printBinary(insertNode(root,node));
	}
	
    public static TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
    	if(root==null){
    		return node;
    	}
    	TreeNode temp=root;
    	while(temp!=null){
    		if(node.val>temp.val){
    			if(temp.right==null){
    				temp.right=node;
    				break;
    			}
    			temp=temp.right;
    		}else{
    			if(temp.left==null){
    				temp.left=node;
    				break;
    			}
    			temp=temp.left;
    		}
    	}
    	return root;
    }
    
    public static void printBinary(TreeNode root){
    	if(root!=null){
    		printBinary(root.left);
    		Tools.print(root.val);
    		printBinary(root.right);
    	}
    }

}
