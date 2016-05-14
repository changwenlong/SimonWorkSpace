package edu.zju.chwl.offer.thoughtofsolution;

import java.util.*;

import org.junit.*;

import edu.zju.chwl.offer.datastructure.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * 
 * 借助队列完成二叉树的层次遍历
 * @author a590450
 * @date 29 Mar 2016 10:30:45
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(root==null){
        	return lists;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
        	int size = q.size();
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	for(int i=0;i<size;i++){
        		TreeNode node = q.poll();
        		list.add(node.val);
        		if(node.left!=null){
        			q.add(node.left);
        		}
        		if(node.right!=null){
        			q.add(node.right);
        		}
        	}
        	lists.add(list);
        }
        return lists;
    }
    
    public List<Integer> levelOrder1(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null){
        	return list;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
        	int size = q.size();
        	for(int i=0;i<size;i++){
        		TreeNode node = q.poll();
        		list.add(node.val);
        		if(node.left!=null){
        			q.add(node.left);
        		}
        		if(node.right!=null){
        			q.add(node.right);
        		}
        	}
        }
        return list;
    }
    
    @Test
    public void testLevelOrder(){
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	TreeNode rightNode = new TreeNode(20);
    	rightNode.left=new TreeNode(15);
    	rightNode.right=new TreeNode(7);
    	root.right=rightNode;
    	List<List<Integer>> list = levelOrder(root);
    	Assert.assertEquals("[[3], [9, 20], [15, 7]]", list.toString());
    }
    
    public List<List<Integer>> levelOrder2(TreeNode root) {
        LinkedList<List<Integer>> lists = new LinkedList<List<Integer>>();
        if(root==null){
        	return lists;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
        	int size = q.size();
        	LinkedList<Integer> list = new LinkedList<Integer>();
        	for(int i=0;i<size;i++){
        		TreeNode node = q.poll();
        		list.add(node.val);
        		if(node.left!=null){
        			q.add(node.left);
        		}
        		if(node.right!=null){
        			q.add(node.right);
        		}
        	}
        	lists.add(0, list);
        }
        return lists;
    }
    
    @Test
    public void testLevelOrder2(){
    	TreeNode root = new TreeNode(3);
    	root.left = new TreeNode(9);
    	TreeNode rightNode = new TreeNode(20);
    	rightNode.left=new TreeNode(15);
    	rightNode.right=new TreeNode(7);
    	root.right=rightNode;
    	List<List<Integer>> list = levelOrder2(root);
    	Assert.assertEquals("[[15, 7], [9, 20], [3]]", list.toString());
    }
    
}
