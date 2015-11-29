package edu.zju.chwl.lintcode.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import edu.zju.chwl.util.Tools;

public class BinaryTreeLevelOrderTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeLevelOrderTraversal b=new BinaryTreeLevelOrderTraversal();
		TreeNode root=new TreeNode(3);
		TreeNode left=new TreeNode(9);
		TreeNode right=new TreeNode(20);
		root.left=left;
		root.right=right;
		right.left=new TreeNode(15);
		right.right=new TreeNode(7);

		left.left=new TreeNode(1);
		left.right=new TreeNode(8);
		Tools.print(b.levelOrder(root));
	}
	
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
    	Queue<TreeNode> q=new LinkedList<TreeNode>();
    	if(root!=null){
    		q.offer(root);
    		while(!q.isEmpty()){
    	    	ArrayList<Integer> countList=new ArrayList<Integer>();
    			int size=q.size();
    			for(int i=0;i<size;i++){
        			TreeNode node=q.poll();    				
        			countList.add(node.val);
        			if(node.left!=null){    				
        				q.offer(node.left);
        			}
        			if(node.right!=null){
        				q.offer(node.right);
        			}
    			}
    			list.add(countList);
    		}
    	}
    	return list;
    }

}
