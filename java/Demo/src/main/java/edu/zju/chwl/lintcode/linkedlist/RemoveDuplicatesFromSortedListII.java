package edu.zju.chwl.lintcode.linkedlist;

public class RemoveDuplicatesFromSortedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNode.createListNode(new int[] { 0, 1, 1, 2, 3, 3 });
		ListNode.print(RemoveDuplicatesFromSortedListII.deleteDuplicates(head));
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = null;
		ListNode slow = dummy;
		ListNode result = dummy;
		ListNode fast = head.next;
		while (head != null) {
			if (fast == null) {
				if (head.val != slow.val) {
					result.next = head;
					result = head;
					result.next = null;
				}
				head = head.next;
			} else if (slow == dummy) {
				if (head.val != fast.val) {
					result.next = head;
					result = head;
					result.next = null;
				}
				slow = head;
				head = fast;
				fast = fast.next;
			} else {
				if (head.val != slow.val && head.val != fast.val) {
					result.next = head;
					result = head;
					result.next = null;
				}
				slow = head;
				head = fast;
				fast = fast.next;
			}
		}
		return dummy.next;
	}

}
