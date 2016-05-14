package edu.zju.chwl.offer.datastructure;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}
	
	public static String preOrder(TreeNode root){
		if(root==null){
			return "";
		}
		StringBuilder sb=new StringBuilder();
		sb.append(root.val);
		sb.append(preOrder(root.left));
		sb.append(preOrder(root.right));
		return sb.toString();
		
	}
	
	public static List<Integer> preOrder1(TreeNode root,List<Integer> list){
		if(root==null){
			return list;
		}
		list.add(root.val);
		preOrder1(root.left,list);
		preOrder1(root.right,list);
		return list;	
	}
	
	//非递归实现，后序遍历
    public static ArrayList<Integer> postorder(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();		
		TreeNode lastVisited = null;
		while (!stack.isEmpty()||root!=null) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
		 	if(!stack.isEmpty()){
		 		TreeNode node = stack.peek();
				TreeNode right = node.right;
        		if (right == null || right == lastVisited) {
    				list.add(stack.pop().val);
    				lastVisited = node;
    			}else{
    				root = node.right;    				
    			}
        	}
		}
		return list;
	}
    
    //非递归实现，前序遍历
    public static ArrayList<Integer> preorder(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!stack.isEmpty()||root!=null) {
			while (root != null) {
				list.add(root.val);
				stack.add(root);
				root = root.left;
			}
		 	if(!stack.isEmpty()){
		 		TreeNode node = stack.pop();
    			root = node.right;    	
        	}
		}
		return list;
	}
    
  //非递归实现，中序遍历
    public static ArrayList<Integer> inorder(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!stack.isEmpty()||root!=null) {
			while (root != null) {
				stack.add(root);
				root = root.left;
			}
		 	if(!stack.isEmpty()){
		 		TreeNode node = stack.pop();
				list.add(node.val);
    			root = node.right;    	
        	}
		}
		return list;
	}
}