package edu.zju.chwl.coder.c2;

import org.junit.Test;


public class FindKthToTail {
    public ListNode findKthToTail(ListNode head,int k) {
    	if(head==null||k<1){
    		return null;
    	}
    	ListNode slow=head;
    	ListNode fast=head;
    	while(k>1&&fast!=null){
    		fast=fast.next;
    		k--;
    	}
		if(fast==null){
			return null;
		}
    	while(fast.next!=null){
    		slow=slow.next;
    		fast=fast.next;
    	}
    	return slow;
    }
    
    @Test
    public void test(){
    	System.out.println(findKthToTail(new ListNode(1),2));
    }
}
