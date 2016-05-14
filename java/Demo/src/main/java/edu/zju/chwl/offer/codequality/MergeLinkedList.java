package edu.zju.chwl.offer.codequality;

import junit.framework.Assert;

import org.junit.Test;

import edu.zju.chwl.offer.datastructure.ListNode;

/**
 * http://www.lintcode.com/en/problem/merge-two-sorted-lists/
 * @author a590450
 * @date 22 Mar 2016 14:24:13
 */
public class MergeLinkedList {
	
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode dummy = new ListNode(0);
    	ListNode node = dummy;
        while(l1!=null&&l2!=null){
        	if(l1.val<l2.val){
        		node.next=l1;
        		l1=l1.next;
        	}else{
        		node.next=l2;
        		l2=l2.next;
        	}
        	node = node.next;
        }
        if(l1!=null){
        	node.next=l1;
        }
        if(l2!=null){
        	node.next=l2;
        }
        return dummy.next;
    }
    
    @Test
    public void mergeTwo(){
    	ListNode node1 = new ListNode(1);
    	node1.next=new ListNode(3);
    	ListNode node2 = new ListNode(2);
    	Assert.assertEquals("123", ListNode.display(mergeTwoLists(node1,node2)));
    }
    
    @Test
    public void mergeTwoOneNull(){
    	ListNode node1 = new ListNode(1);
    	node1.next=new ListNode(3);
    	Assert.assertEquals("13", ListNode.display(mergeTwoLists(node1,null)));
    }
}
