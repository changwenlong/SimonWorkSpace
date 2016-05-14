package edu.zju.chwl.offer.datastructure;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int val) {
		this.val = val;
		this.next = null;
	}
	
	public static String display(ListNode node){
		StringBuilder ss=new StringBuilder("");
		while(node!=null){
			ss.append(node.val);
			node = node.next;
		}
		return ss.toString();
	}
}
