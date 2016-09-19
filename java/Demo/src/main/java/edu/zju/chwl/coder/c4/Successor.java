package edu.zju.chwl.coder.c4;

import org.junit.Test;

public class Successor {
    public int findSucc(TreeNode root, int p) {
    	inOrder(root,p);
    	return a;
    }
    
    boolean flag=true;
	int val=-1;
	int a=-1;
	private void inOrder(TreeNode root,int p){
		if(root==null){
			return;
		}
		inOrder(root.left,p);
		if(val==p&&flag){
			a=root.val;
			flag=false;
		}else{
			val=root.val;
		}
		inOrder(root.right,p);
		
	}
	
    @Test
    public void test(){
    	TreeNode tree = new TreeNode(0);
    	tree.left=new TreeNode(1);
    	tree.right=new TreeNode(2);
    	tree.left.left=new TreeNode(3);
    	tree.left.right=new TreeNode(4);

    	tree.right.left=new TreeNode(5);
    	tree.right.right=new TreeNode(6);
		int node = findSucc(tree,3);
    	System.out.println(node);
    }
}
