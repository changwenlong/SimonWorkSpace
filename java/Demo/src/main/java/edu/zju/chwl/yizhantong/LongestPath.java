package edu.zju.chwl.yizhantong;

import org.junit.Test;


class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class LongestPath {
    public int findPath(TreeNode root) {
        if(root==null){
        	return 0;
        }
        getPath(root);
        return maxPath;
    }

    int maxPath=Integer.MIN_VALUE;
	private int getPath(TreeNode root) {
		//记录左右子树最大长度
		int left=0;
		int right=0;
		if(root.left!=null){//处理左子树
			int leftPath = getPath(root.left);//左子树的最大长度
			if(root.left.val==root.val){//如果这个节点和左子树颜色一样
				left=leftPath;
			}
		}
		if(root.right!=null){//处理右子树
			int rightPath = getPath(root.right);
			if(root.right.val==root.val){
				right=rightPath;
			}
		}
		
		//记录最大长度值，包含左子树最大路径+根节点+右子树
		maxPath=Math.max(maxPath, left+right+1);
		
		return Math.max(left, right)+1;
	}
	
	@Test
	public void test(){
		TreeNode root = new TreeNode(1);
		TreeNode left=new TreeNode(1);
		root.left=left;
		left.left=new TreeNode(0);
		left.right=new TreeNode(1);
		left.left.left=new TreeNode(0);
		TreeNode right=new TreeNode(1);
		root.right=right;
		right.left=new TreeNode(1);
		right.right=new TreeNode(1);
		right.right.right=new TreeNode(1);
		System.out.println(findPath(root));
	}
}
