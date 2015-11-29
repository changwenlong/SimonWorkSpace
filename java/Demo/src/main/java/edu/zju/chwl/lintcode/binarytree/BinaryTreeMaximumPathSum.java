package edu.zju.chwl.lintcode.binarytree;

import edu.zju.chwl.util.Tools;

public class BinaryTreeMaximumPathSum {
	
	private class ResultType {
		// singlePath: 从root往下走到任意点的最大路径，这条路径可以不包含任何点
		// maxPath: 从树中任意到任意点的最大路径，这条路径至少包含一个点
		int singlePath, maxPath;

		ResultType(int singlePath, int maxPath) {
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeMaximumPathSum object=new BinaryTreeMaximumPathSum();
		TreeNode root=new TreeNode(-2);
		TreeNode left=new TreeNode(-1);
		TreeNode right=new TreeNode(-3);
		root.left=left;
		root.right=right;
		Tools.print(object.maxPathSum(root));
	}
	
    public int maxPathSum(TreeNode root) {
        // write your code here
    	ResultType result=helper(root);
    	return result.maxPath;
    }

	private ResultType helper(TreeNode root) {
		ResultType result = new ResultType(0,Integer.MIN_VALUE);;
		if(root!=null){
			ResultType left=helper(root.left);
			ResultType right=helper(root.right);
			int singlePath=Math.max(left.singlePath,right.singlePath);
			singlePath=Math.max(singlePath+root.val, 0);
			int maxPath=Math.max(left.singlePath+right.singlePath+root.val,left.maxPath);
			maxPath=Math.max(maxPath, right.maxPath);
			result=new ResultType(singlePath,maxPath);
		}
		return result;
	}

}
