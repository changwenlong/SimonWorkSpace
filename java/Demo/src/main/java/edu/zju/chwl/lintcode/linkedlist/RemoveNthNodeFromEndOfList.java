package edu.zju.chwl.lintcode.linkedlist;

public class RemoveNthNodeFromEndOfList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

    ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode fast=head;
    	while(n-->0){
    		fast=fast.next;
    	}
    	ListNode slow=head;
    	if(fast==null){
    		return head.next;
    	}
    	
		fast = fast.next;
		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}
    	slow.next=slow.next.next;
        return head;
    }
}
