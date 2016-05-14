package edu.zju.chwl.offer.thoughtofsolution;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

import edu.zju.chwl.lintcode.linkedlist.TreeNode;

/**
 * http://www.lintcode.com/en/problem/binary-tree-postorder-traversal/
 * 
 * 二叉树后续遍历，非递归实现，使用栈
 * 
 * @author chwl
 * @Date 2016年3月24日 下午11:03:16
 */
public class BinaryTreePostOrder {

	public ArrayList<Integer> postorderTraversal(TreeNode root) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		//把所有的左节点放入栈
		while (root != null) {
			stack.add(root);
			root = root.left;
		}
		//记录上一个被访问的节点
		TreeNode lastVisited = null;
		while (!stack.isEmpty()) {
			TreeNode node = stack.peek();
			TreeNode right = node.right;
			//左子树已经遍历过了，只需要关注右子树
			if (right == null || right == lastVisited) {
				list.add(stack.pop().val);
				lastVisited = node;
			} else {
				//把所有的左节点放入栈
				while (right != null) {
					stack.add(right);
					right = right.left;
				}
			}
		}
		return list;
	}
	
	@Test
	public void postOrder(){
		TreeNode root = new TreeNode(1);
		root.right=new TreeNode(2);
		root.right.left=new TreeNode(3);
		System.out.println(postorderTraversal(root));
	}
}
