package edu.zju.chwl.coder.c2;

import org.junit.Test;

public class PlusAB {
    public ListNode plusAB(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        int acc=0;
        while(a!=null&&b!=null){
        	int val = a.val+b.val+acc;
        	acc=val/10;
        	ListNode node =new ListNode(val%10);
        	head.next=node;
        	head=head.next;
        	a=a.next;
        	b=b.next;
        }
        while(a!=null){
        	int val = a.val+acc;
        	acc=val/10;
        	ListNode node =new ListNode(val%10);
        	head.next=node;
        	head=head.next;
        	a=a.next;
        }
        while(b!=null){
        	int val = b.val+acc;
        	acc=val/10;
        	ListNode node =new ListNode(val%10);
        	head.next=node;
        	head=head.next;
        	b=b.next;
        }
        //进位别丢
        if(acc!=0){
        	ListNode node =new ListNode(1);
        	head.next=node;
        	head=head.next;
        }
        return dummy.next;
    }
    
    @Test
    public void test(){
    	ListNode a = new ListNode(7);
    	a.next=new ListNode(1);
    	a.next.next=new ListNode(6);
    	ListNode b = new ListNode(5);
    	b.next=new ListNode(9);
    	b.next.next=new ListNode(2);
		ListNode node = plusAB(a,b);
		System.out.println(node);
    }
}
