package edu.zju.chwl.leetcode;

public class SameTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode p = new TreeNode(10);
		p.left=new TreeNode(5);
		p.right=new TreeNode(15);
		
		TreeNode q = new TreeNode(10);
		q.left=new TreeNode(5);
		q.left.right=new TreeNode(15);

		System.out.println(isSameTree(p,q));
	}

	public static boolean isSameTree(TreeNode p, TreeNode q) {
		System.out.println(mid(p));
		System.out.println(mid(q));
		return mid(p).equals(mid(q));
	}

	public static String mid(TreeNode node) {
		if (node == null) {
			return "$";
		}
		String value = node.val+"";
		value += mid(node.left);
		value += mid(node.right);
		return value;
	}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
