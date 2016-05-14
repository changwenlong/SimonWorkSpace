package edu.zju.chwl.coder.c2;

import org.junit.Test;

public class Partition {
    public ListNode partition(ListNode pHead, int x) {
        ListNode dummyHead=new ListNode(0);
        ListNode headNode=dummyHead;
        ListNode dummyTail=new ListNode(0);
        ListNode tailNode=dummyTail;
        ListNode dummy=pHead;
        while(dummy!=null){
        	if(dummy.val<x){
        		insert(headNode,dummy);
        		headNode=headNode.next;
        	}else{
        		insert(tailNode,dummy);
        		tailNode=tailNode.next;
        	}
        	dummy=dummy.next;
        }
        tailNode.next=null;
        headNode.next=dummyTail.next;
        return dummyHead.next;
    }
    
    public void insert(ListNode node,ListNode insertNode){
    	node.next=insertNode;
    }
    
    @Test
    public void test(){
    	ListNode head = new ListNode(1);
    	head.next=new ListNode(4);
    	head.next.next=new ListNode(3);
    	head.next.next.next=new ListNode(2);
    	head.next.next.next.next=new ListNode(3);
		System.out.println(partition(head,3));
    }
}
