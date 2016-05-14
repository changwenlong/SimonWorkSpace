package edu.zju.chwl.offer.basicknowledge;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.zju.chwl.offer.datastructure.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * @author a590450
 * @date 16 Mar 2016 11:08:53
 */
public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if(head==null){
			return null;
		}
		ListNode node = head.next;
		head.next=null;
		while(node !=null){
			ListNode tmp = node.next;
			node.next = head;
			head=node;
			node=tmp;
		}
		return head;
	}
	
	@Test
	public void reverse(){
		ListNode head = new ListNode(1);
		head.next=new ListNode(2);
		assertEquals("21", ListNode.display(reverseList(head)));
	}
	
	
}


