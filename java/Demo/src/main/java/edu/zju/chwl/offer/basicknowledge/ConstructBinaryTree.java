package edu.zju.chwl.offer.basicknowledge;

import java.util.ArrayList;

import org.junit.Test;

import edu.zju.chwl.offer.datastructure.TreeNode;
import static org.junit.Assert.*;
/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * @author a590450
 * @date 16 Mar 2016 12:57:10
 */
public class ConstructBinaryTree {
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder==null||preorder.length==0){
			return null;
		}
		return helper(preorder,0,inorder,0,preorder.length);
	}
	
	public TreeNode helper(int[] preorder,int preStart,int[] inorder,int inStart,int size){
		if(size==0){
			return null;
		}
		int value = preorder[preStart];
		TreeNode root = new TreeNode(value);
		int index=-1;
		for(int i=inStart;i<size+inStart;i++){
			if(inorder[i]==value){
				index=i;
			}
		}
		int leftSize = index-inStart;
		int rightSize=size-leftSize-1;
		root.left=helper(preorder,preStart+1,inorder,inStart,leftSize);
		root.right=helper(preorder,preStart+leftSize+1,inorder,index+1,rightSize);
		return root;
	}
	
	@Test
	public void testBuildTree(){
		assertEquals("12473568",TreeNode.preOrder(buildTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6})));
	}
	
	@Test
	public void testBuildTree1(){
		assertEquals("12473568",TreeNode.preOrder1(buildTree(new int[]{1,2,4,7,3,5,6,8},new int[]{4,7,2,1,5,3,8,6}),new ArrayList<Integer>()));
	}
}

