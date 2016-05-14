package edu.zju.chwl.offer.basicknowledge;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.zju.chwl.offer.datastructure.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * @author a590450
 * @date 16 Mar 2016 11:08:53
 */
public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||m<1){
        	return null;
        }
        ListNode node =head;
        ListNode left=null;
        int count = n-m+1;
        while(m>1){
        	left = node;
        	node =node.next;
        	m--;
        }
        ListNode reverseHead=node;
        ListNode reverseNode = node.next;
        while(count>1){
        	ListNode tmp=reverseNode.next;
        	reverseNode.next=reverseHead;
        	reverseHead=reverseNode;
        	reverseNode=tmp;
        	count--;
        }
        node.next = reverseNode;
        if(left==null){
        	return reverseHead;
        }else{
        	left.next=reverseHead;
        	return head;
        }
        
    }
	
	ListNode head = new ListNode(1);
	
	@Before
	public void inital(){
		ListNode node1 =new ListNode(2);
		head.next=node1;
		ListNode node2 =new ListNode(3);
		node1.next=node2;
		ListNode node3 =new ListNode(4);
		node2.next=node3;
		node3.next=new ListNode(5);
	}
	
	@Test
	public void reverse(){		
		assertEquals("14325", ListNode.display(reverseBetween(head,2,4)));
	}
	
	@Test
	public void reverseOne(){		
		assertEquals("12345", ListNode.display(reverseBetween(head,3,3)));
	}
	
	
	@Test
	public void reverseFormStart(){		
		assertEquals("43215", ListNode.display(reverseBetween(head,1,4)));
	}
	
	@Test
	public void reverseToEnd(){		
		assertEquals("12543", ListNode.display(reverseBetween(head,3,5)));
	}
	
	@Test
	public void reverseAll(){		
		assertEquals("54321", ListNode.display(reverseBetween(head,1,5)));
	}
	
}

