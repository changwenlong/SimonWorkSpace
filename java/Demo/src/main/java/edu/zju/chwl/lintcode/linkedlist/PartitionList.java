package edu.zju.chwl.lintcode.linkedlist;

public class PartitionList {

	public static void main(String[] args) {
		PartitionList partitionList = new PartitionList();
		ListNode head = ListNode.createListNode(new int[] { 1,4,3,2,5,2 });
		ListNode.print(partitionList.partition(head,3));
	}
	
	public ListNode partition(ListNode head, int x) {
		if(head==null){
			return null;
		}
		ListNode ltDummy=new ListNode(0);
		ListNode gtDummy=new ListNode(0);
		ListNode ltNode=ltDummy;
		ListNode gtNode=gtDummy;
		while(head!=null){
			if(head.val<x){
				ltNode.next=head;
				ltNode=head;
			}else{
				gtNode.next=head;
				gtNode=head;
				
			}
			head=head.next;
		}
		ltNode.next=gtDummy.next;
		gtNode.next=null;
		return ltDummy.next;
    }
}
