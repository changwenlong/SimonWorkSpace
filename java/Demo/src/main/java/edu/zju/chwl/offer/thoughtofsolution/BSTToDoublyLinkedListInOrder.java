package edu.zju.chwl.offer.thoughtofsolution;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

import edu.zju.chwl.offer.datastructure.DoublyListNode;
import edu.zju.chwl.offer.datastructure.TreeNode;

/**
 * http://www.lintcode.com/en/problem/convert-binary-search-tree-to-doubly-linked-list/
 * 
 * 非递归中序遍历BST 构造双向链表
 * 
 * @author a590450
 * @date 25 Mar 2016 14:22:08
 */
public class BSTToDoublyLinkedListInOrder {

    public DoublyListNode bstToDoublyList(TreeNode root) {  
        if(root==null){
        	return null;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        DoublyListNode dummy = new DoublyListNode(0);
        DoublyListNode head = dummy;
        while(!s.isEmpty()||root!=null){
        	while(root!=null){
        		s.add(root);
        		root=root.left;
        	}
        	if(!s.isEmpty()){
        		TreeNode node = s.pop();
        		DoublyListNode dNode = new DoublyListNode(node.val);
        		dNode.prev=head;
        		head.next=dNode;
        		head = head.next;
        		root = node.right;
        	}
        }
        dummy.next.prev=null;
        return dummy.next;
    }
    
    @Test
    public void bstToDList(){
    	TreeNode root = new TreeNode(4);
    	root.right = new TreeNode(5);
    	TreeNode left = new TreeNode(2);
    	root.left=left;
    	left.left=new TreeNode(1);
    	left.right=new TreeNode(3);
    	Assert.assertEquals("12345",DoublyListNode.display(bstToDoublyList(root)));
    	System.out.print(TreeNode.preorder(root));
    	System.out.print(TreeNode.inorder(root));
    	System.out.print(TreeNode.postorder(root));
    }    
}
