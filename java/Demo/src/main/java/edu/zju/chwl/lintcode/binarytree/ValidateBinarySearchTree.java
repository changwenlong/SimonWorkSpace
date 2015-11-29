package edu.zju.chwl.lintcode.binarytree;

import java.util.ArrayList;

public class ValidateBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public static boolean isValidBST(TreeNode root) {
        // write your code here
    	if(root==null){
    		return true;
    	}
    	ArrayList<Integer> list=midOrder(root);
    	boolean flag=true;
    	for(int i=1;i<list.size();i++){
    		if(list.get(i)<=list.get(i-1)){
    			flag=false;
    			break;
    		}
    	}
    	return flag;
    }
    
    public static ArrayList<Integer> midOrder(TreeNode root){
    	ArrayList<Integer> list=new ArrayList<Integer>();
    	if(root!=null){
    		list.addAll(midOrder(root.left));
    		list.add(root.val);
    		list.addAll(midOrder(root.right));
    	}
    	return list;
    }

}
