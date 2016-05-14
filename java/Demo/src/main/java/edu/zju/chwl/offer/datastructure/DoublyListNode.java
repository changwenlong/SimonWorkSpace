package edu.zju.chwl.offer.datastructure;

public class DoublyListNode {
	public int val;
	public DoublyListNode next, prev;

	public DoublyListNode(int val) {
		this.val = val;
		this.next = this.prev = null;
	}
	
	public static DoublyListNode createList(int[] nums){
		if(nums==null||nums.length==0){
			return null;
		}
		DoublyListNode dummy = new DoublyListNode(0);
		DoublyListNode head = dummy;
		for(int num: nums){
			DoublyListNode node = new DoublyListNode(num);
			node.prev=head;
			head.next=node;
			head = head.next;
		}
		dummy.next.prev=null;
		return dummy.next;
	}
	
	public static String display(DoublyListNode head){
		StringBuilder sb = new StringBuilder("");
		while(head!=null){
			sb.append(head.val);
			head=head.next;
		}
		return sb.toString();
	}
}
