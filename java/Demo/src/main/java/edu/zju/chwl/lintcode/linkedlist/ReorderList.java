package edu.zju.chwl.lintcode.linkedlist;

public class ReorderList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNode.createListNode(new int[] { 0,1,2,3,4,5 });
		ReorderList reorderList = new ReorderList();
		reorderList.reorderList(head);
		ListNode.print(head);
	}
	
    public void reorderList(ListNode head) {  
        if(head==null){
        	return;
        }
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode fast=dummy;
        ListNode slow=dummy;
        //find mid element
        while(fast.next!=null){
        	slow=slow.next;
        	fast=fast.next;
        	if(fast.next==null){
        		break;
        	}
        	fast=fast.next;        	
        }
        ListNode midHead=slow.next;
        slow.next=null;
        ListNode mid=reverseList(midHead);
        while(mid!=null){
        	ListNode temp=head.next;
        	ListNode midTemp=mid.next;
        	head.next=mid;
        	mid.next=temp;
        	head=temp;
        	mid=midTemp;
        }
        
        head=dummy.next;
    }


	private ListNode reverseList(ListNode head) {
		if(head==null){
			return head;
		}
		ListNode node=head.next;
		head.next=null;
		while(node!=null){
			ListNode temp=node.next;
			node.next=head;
			head=node;
			node=temp;
		}
		return head;		
	}

}
