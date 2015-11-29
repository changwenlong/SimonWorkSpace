package edu.zju.chwl.lintcode.binarytree;

import java.util.ArrayList;
import java.util.HashMap;

public class LowestCommonAncestor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root=new TreeNode(1);
		TreeNode right=new TreeNode(2);
		root.right=right;
		TreeNode right1=new TreeNode(3);
		right.right=right1;
		TreeNode right2=new TreeNode(4);
		right1.right=right2;
		TreeNode right3=new TreeNode(5);
		right2.right=right3;
		System.out.println(new LowestCommonAncestor().lowestCommonAncestor1(root, right1, right3));
	}
	private HashMap<Integer,TreeNode> map;
	private int flag=0;
	
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
    	map=new HashMap<Integer,TreeNode>();
    	helper(root,A,B);
    	ArrayList<TreeNode> aLine=new ArrayList<TreeNode>();
    	getLine(map,aLine,A);
    	ArrayList<TreeNode> bLine=new ArrayList<TreeNode>();
    	getLine(map,bLine,B);
    	int i,j;
    	for(i=aLine.size()-1,j=bLine.size()-1;i>=0&&j>=0;i--,j--){
    		if((i-1)<0||(j-1)<0||aLine.get(i-1).val!=bLine.get(j-1).val){
    			return aLine.get(i);
    		}
    	}
        return null;
    }

	private void getLine(HashMap<Integer, TreeNode> map2,
			ArrayList<TreeNode> aLine, TreeNode a) {
		aLine.add(a);
		TreeNode node=a;
		while((node=map2.get(node.val))!=null){
			aLine.add(node);			
		}
		
	}

	private void helper(TreeNode root, TreeNode a, TreeNode b) {
		if(root==null)
			return;
		if((root.val==a.val||root.val==b.val)&&flag==2){
			flag++;
			return;
		}else{
			if(root.left!=null){
				map.put(root.left.val, root);
				helper(root.left,a,b);
			}
			if(root.right!=null){
				map.put(root.right.val, root);
				helper(root.right,a,b);
			}
		}
		
	}
	
	//Version 2: Divide & Conquer
	/**
	 * 
	 * @param root
	 * @param A
	 * @param B
	 * @return
	 */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode A, TreeNode B) {
    	if(root==null||root==A||root==B){
    		return root;
    	}
    	
    	TreeNode left=lowestCommonAncestor1(root.left,A,B);
    	TreeNode right=lowestCommonAncestor1(root.right,A,B);
    	
    	if(left!=null&&right!=null){
    		return root;
    	}
    	if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    	
    }
}
