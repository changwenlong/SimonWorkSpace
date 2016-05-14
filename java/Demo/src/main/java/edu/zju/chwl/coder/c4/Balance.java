package edu.zju.chwl.coder.c4;

public class Balance {
	
    public boolean isBalance(TreeNode root) {
        return height(root)==-1;
    }

	private int height(TreeNode root) {
		if(root==null){
			return 0;
		}
		int a=height(root.left);
		int b=height(root.right);
		if(a==-1||b==-1||Math.abs(a-b)>1){
			return -1;
		}
		return Math.max(a, b)+1;
	}
}
