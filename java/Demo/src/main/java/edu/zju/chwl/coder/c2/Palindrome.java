package edu.zju.chwl.coder.c2;

import org.junit.Test;

public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        if(head==null||head.next==null){
        	return true;
        }
        ListNode mid = findMidNode(head);
        ListNode headList = headInsert(mid);
        while(headList!=null){
        	if(headList.val!=head.val){
        		return false;
        	}
        	headList=headList.next;
        	head=head.next;
        }
        return true;
    }

	private ListNode headInsert(ListNode mid) {
		ListNode head=null;
		while(mid!=null){
			ListNode temp=mid.next;
			mid.next=head;
			head=mid;
			mid=temp;
		}
		return head;
	}

	private ListNode findMidNode(ListNode head) {
		ListNode slow=head;
		ListNode fast=head;
		while(fast!=null&&fast.next!=null){
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}
	
    @Test
    public void test(){
    	ListNode a = new ListNode(1);
    	a.next=new ListNode(2);
    	a.next.next=new ListNode(2);
    	a.next.next.next=new ListNode(1);
		System.out.println(isPalindrome(a));
    }
}
