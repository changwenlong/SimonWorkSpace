package edu.zju.chwl.offer.codequality;

import org.junit.Test;

/**
 * http://www.lintcode.com/en/problem/subtree/
 * @author a590450
 * @date 21 Mar 2016 16:45:47
 */
public class Subtree {

	public boolean isSubtree(TreeNode t1, TreeNode t2) {
		if(hasSubtree(t1,t2)){
			return true;
		}
		if(t1!=null&&isSubtree(t1.left,t2)){
			return true;
		}
		if(t1!=null&&isSubtree(t1.right,t2)){
			return true;
		}
		return false;
	}

	private boolean hasSubtree(TreeNode t1, TreeNode t2) {
		if (t2 == null)
			return true;
		if (t1 == null)
			return false;
		boolean result = true;
		if (t1.val == t2.val) {
			result = hasSubtree(t1.left, t2.left)
					&& hasSubtree(t1.right, t2.right);
		} else {
			return false;
		}
		return result;
	}
	
	@Test
	public void isSubtreeRight(){
		TreeNode t1 = new TreeNode(1);
		t1.right=new TreeNode(2);
		t1.right.right=new TreeNode(3);
		t1.right.right.right=new TreeNode(4);
		TreeNode t2 = new TreeNode(3);
		t2.right=new TreeNode(4);
		System.out.print(isSubtree(t1,t2));
	}
}

class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
		this.left = this.right = null;
	}
}