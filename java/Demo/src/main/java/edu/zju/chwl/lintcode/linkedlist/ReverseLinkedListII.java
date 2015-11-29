package edu.zju.chwl.lintcode.linkedlist;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = ListNode.createListNode(new int[] { 3760,2881,7595,3904,5069,4421,8560,8879,8488,5040,5792,56,1007,2270,3403,6062 });
		ListNode.print(new ReverseLinkedListII().reverseBetween(head,2,7));
	}

	public ListNode reverseBetween(ListNode head, int m , int n) {
        if (m >= n || head == null) {
            return head;
        }
    	int i = 1;
    	ListNode slow = head;
    	ListNode fast = head;
    	ListNode dummy = new ListNode(0);
    	dummy.next = head;
    	ListNode prior = dummy;
        while(i != m){
        	slow = slow.next;
        	fast = fast.next;
        	prior=prior.next;
        	i++;
        }
        while(i != n){
        	fast = fast.next;
        	i++;
        }
        ListNode pre = fast.next;
        while(m != i+1){
        	ListNode temp = slow;
        	slow=slow.next;
        	temp.next=pre;
        	pre = temp;
        	i--;
        }
        prior.next = pre;
        return dummy.next;      
    }
}
