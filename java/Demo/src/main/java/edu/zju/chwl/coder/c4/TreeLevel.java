package edu.zju.chwl.coder.c4;

import java.util.LinkedList;

import org.junit.Test;

import edu.zju.chwl.coder.c2.ListNode;

public class TreeLevel {
    public ListNode getTreeLevel(TreeNode root, int dep) {
    	if(root==null) return null;
    	if(dep==1) return new ListNode(root.val);
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        ListNode dummy = new ListNode(0);
        ListNode head=dummy;
        while(!q.isEmpty()){
        	dep--;
        	int len = q.size();
        	for(int i=0;i<len;i++){
            	TreeNode node = q.poll();           	
            	if(dep!=1){
                	if(node.left!=null) q.offer(node.left);
                	if(node.right!=null) q.offer(node.right);           		
            	}else{
                	if(node.left!=null){
                		head.next=new ListNode(node.left.val);
                		head=head.next;
                	} 
                	if(node.right!=null){
                		head.next=new ListNode(node.right.val);
                		head=head.next;
                	}
            	}
        	}
        	if(dep==0) break;
        }
        return dummy.next;
    }
    
    @Test
    public void test(){
    	TreeNode tree = new TreeNode(0);
    	tree.left=new TreeNode(1);
    	tree.right=new TreeNode(2);
    	tree.left.left=new TreeNode(3);
    	tree.left.right=new TreeNode(4);

    	tree.right.left=new TreeNode(5);
    	tree.right.right=new TreeNode(6);
		ListNode node = getTreeLevel(tree,3);
    	System.out.println(node);
    }
}
