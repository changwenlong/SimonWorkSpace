package edu.zju.chwl.coder.c4;

import org.junit.*;

public class MinimalBST {
    public TreeNode buildMinimalBST(int[] vals) {
         TreeNode root = getTree(vals,0,vals.length-1);
         return root;
    }

	public static TreeNode getTree(int[] vals, int start, int end) {
		if(end<start){
			return null;
		}
		int mid=start+(end-start)/2;
		TreeNode root = new TreeNode(vals[mid]);
		root.left=getTree(vals,start,mid-1);
		root.right=getTree(vals,mid+1,end);
		return root;
	}
	
	
	@Test
	public void test(){
		buildMinimalBST(new int[]{1,2,3,4,5,6,7,8,9});
	}
}
