package edu.zju.chwl.offer.timeandspace;

import edu.zju.chwl.offer.datastructure.ListNode;
import org.junit.*;

public class FindFirstCommonNode {
	
    public ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
    	 if(pHead1==null||pHead2==null){
    		 return null;
    	 }
    	 int len1 = length(pHead1);
    	 int len2 = length(pHead2);
    	 ListNode head1= pHead1;
    	 ListNode head2= pHead2;
    	 if(len1>len2){
    		 int count =len1-len2;
    		 while(count>0){
    			 head1=head1.next;
    			 count--;
    		 }
    	 }else if(len1<len2){
    		 int count =len2-len1;
    		 while(count>0){
    			 head2=head2.next;
    			 count--;
    		 }
    	 }
    	 while(head1!=null&&head2!=null){
    		 if(head1==head2){
    			 return head1;
    		 }
    		 head1=head1.next;
    		 head2=head2.next;
    	 }
    	 return null;   	 
    }
    
    public int length(ListNode node){
    	ListNode head=node;
    	int count=0;
    	while(head!=null){
    		count++;
    		head=head.next;
    	}
    	return count;
    }
    
    @Test 
    public void commonNode(){
    	ListNode node = new ListNode(6);
    	node.next=new ListNode(7);
    	ListNode head1 = new ListNode(1);
    	head1.next=new ListNode(2);
    	head1.next.next=new ListNode(3);
    	head1.next.next.next=node;
    	ListNode head2 = new ListNode(4);
    	head2.next = new ListNode(5);
    	head2.next.next = node;
    	System.out.print(findFirstCommonNode(head1,head2).val);
    }
}
