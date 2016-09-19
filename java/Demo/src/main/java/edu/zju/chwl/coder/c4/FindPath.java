package edu.zju.chwl.coder.c4;

import java.util.ArrayList;

public class FindPath {
    public ArrayList<ArrayList<Integer>> findPath(TreeNode root,int target) {
    	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
    	dfs(root,lists,new ArrayList<Integer>(),target,0);
    	return lists;
    }
    
    private void dfs(TreeNode root, ArrayList<ArrayList<Integer>> lists, ArrayList<Integer> list, int target, int sum){
    	if(root==null) return;
    	list.add(root.val);
    	sum+=root.val;
    	if(root.left==null&&root.right==null&&sum==target){
    		lists.add(new ArrayList<Integer>(list));
    	}
    	dfs(root.left,lists,list,target,sum);
    	dfs(root.right,lists,list,target,sum);
    	list.remove(list.size()-1);
    }
}
