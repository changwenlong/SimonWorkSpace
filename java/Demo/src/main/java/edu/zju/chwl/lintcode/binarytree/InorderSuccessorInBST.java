package edu.zju.chwl.lintcode.binarytree;

import edu.zju.chwl.util.Tools;

public class InorderSuccessorInBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InorderSuccessorInBST b=new InorderSuccessorInBST();
		TreeNode root=new TreeNode(2);
		TreeNode left=new TreeNode(1);
		TreeNode right=new TreeNode(3);
		root.left=left;
		root.right=right;
		//right.left=new TreeNode(15);
		//right.right=new TreeNode(7);
		Tools.print(b.inorderSuccessor(root,root).val);
	}

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    	if(root==null){
    		return null;
    	}
    	TreeNode parent=root;
    	if(root.val==p.val){
    		return getLeft(root.right);
    	}else if(root.val>p.val){
    		root=root.left;
    	}else{
    		root=root.right;
    	}
    	while(root!=null){
        	if(root.val==p.val){
        		if(root.right!=null){
        			return getLeft(root.right);
        		}else if(root.val>parent.val){
        			return null;
        		}else{
        			return parent;
        		}
        	}else if(root.val>p.val){
        		parent=root;
        		root=root.left;
        	}else{
        		parent=root;
        		root=root.right;
        	}
    	}
    	return null;
    }
    
    public TreeNode getLeft(TreeNode root) {
    	if(root==null){
    		return null;
    	}
    	while(root.left!=null){
    		root=root.left;
    	}
    	return root;
    }
}
