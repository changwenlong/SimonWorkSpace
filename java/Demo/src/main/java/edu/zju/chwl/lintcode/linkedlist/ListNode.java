package edu.zju.chwl.lintcode.linkedlist;

public class ListNode {
	int val;
	ListNode next;

	ListNode(int val) {
		this.val = val;
		this.next = null;
	}
	
	public static ListNode createListNode(int[] arr){
		ListNode dummy=new ListNode(0);
		ListNode head=dummy;
		for(int value:arr){
			ListNode node=new ListNode(value);
			head.next=node;
			head=node;
		}
		return dummy.next;
	}
	
	public static void print(ListNode head){
		while(head!=null){
			System.out.println(head.val);
			head=head.next;
		}
	}
}
