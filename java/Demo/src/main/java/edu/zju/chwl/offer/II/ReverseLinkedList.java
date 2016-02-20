package edu.zju.chwl.offer.II;

import edu.zju.chwl.lintcode.linkedlist.ListNode;

public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        ListNode prev=null;
        while(head!=null){
            ListNode temp=head.next;
            head.next=prev;
            prev=head;
            head=temp;
        }
        return prev;
    }
}
