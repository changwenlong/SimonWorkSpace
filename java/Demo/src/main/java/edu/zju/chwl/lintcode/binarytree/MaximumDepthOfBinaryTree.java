package edu.zju.chwl.lintcode.binarytree;

import edu.zju.chwl.util.Tools;

public class MaximumDepthOfBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		TreeNode left=new TreeNode(2);
		TreeNode right=new TreeNode(3);
		root.left=left;
		root.right=right;
		TreeNode left1=new TreeNode(4);
		TreeNode right1=new TreeNode(5);
		right.left=left1;
		right.right=right1;
		
		Tools.print(maxDepth(root));

	}

    public static int maxDepth(TreeNode root) {
        // write your code here
    	if(root==null){
    		return 0;
    	}
    	return max(maxDepth(root.left),maxDepth(root.right))+1;
    }
    
    public static int max(int a,int b){
    	return a>b?a:b;
    }
    

}

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}

	@Override
	public String toString() {
		return val+" ";
	}
	
}
