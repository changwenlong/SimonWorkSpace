package edu.zju.chwl.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * @author a590450
 * @date 19 Feb 2016 16:26:29
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		AddTwoNumbers a=new AddTwoNumbers();
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(5);
		ListNode node=a.addTwoNumbers(l1,l2);
		while(node!=null){
			System.out.print(node.val);
			node=node.next;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode node = dummy;
		int acc=0;
		while(l1!=null&&l2!=null){
			int sum = l1.val+l2.val+acc;
			node.next=new ListNode(sum%10);
			acc=sum/10;
			l1=l1.next;
			l2=l2.next;
			node=node.next;
		}
		while(l1!=null){
			int sum=l1.val+acc;
			node.next=new ListNode(sum%10);
			acc=sum/10;
			l1=l1.next;
			node = node.next;
		}
		while(l2!=null){
			int sum=l2.val+acc;
			node.next=new ListNode(sum%10);
			acc=sum/10;
			l2=l2.next;
			node = node.next;
		}
		if(acc==1){
			node.next=new ListNode(acc);
		}
		return dummy.next;
	}

}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
