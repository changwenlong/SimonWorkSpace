package edu.zju.chwl.lintcode.binarytree;

import java.util.*;

public class BSTIterator {
	private List<TreeNode> list=new ArrayList<TreeNode>();
	private Iterator<TreeNode> iterator;
	
	public BSTIterator(TreeNode root) {
		iteratorInorder(root);
		iterator=list.iterator();
    }

    //@return: True if there has next node, or false
    public boolean hasNext() {
        return iterator.hasNext();
    }
    
    //@return: return next node
    public TreeNode next() {
        return iterator.next();
    }
    
    private void  iteratorInorder(TreeNode root){
    	Stack<TreeNode> stack=new Stack<TreeNode>();
    	TreeNode node=root;
    	while(node!=null||!stack.isEmpty()){
    		while(node!=null){
    			stack.push(node);
    			node=node.left;
    		}
    		if(!stack.isEmpty()){
    			node=stack.pop();
    			list.add(node);
    			node=node.right;
    		}
    	}
    }
}

