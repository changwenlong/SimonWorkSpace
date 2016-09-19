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
		TreeNode p = root;	
		TreeNode lastVisited = null;
		while (!stack.isEmpty()||p!=null) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
	 		TreeNode node = stack.peek();
			TreeNode right = node.right;
    		if (right == null || right == lastVisited) {
				list.add(stack.pop().val);//访问元素
				lastVisited = node;
			}else{
				p = node.right;    				
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
		TreeNode p = root;
		while (!stack.isEmpty()||p!=null) {
			while (p != null) {
				list.add(p.val);//访问元素
				stack.push(p);
				p = p.left;
			}
		 	p = stack.pop();
    		p = p.right;  
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
		TreeNode p = root;
		while (!stack.isEmpty()||p!=null) {
			while (p != null) {
				stack.push(p);
				p = p.left;
			}
		 	p = stack.pop();
			list.add(p.val);//访问元素
    		p = p.right;    	       	
		}
		return list;
	}
}