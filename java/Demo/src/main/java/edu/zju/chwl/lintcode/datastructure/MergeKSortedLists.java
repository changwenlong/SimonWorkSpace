package edu.zju.chwl.lintcode.datastructure;

import java.util.List;

/**
 * http://www.lintcode.com/en/problem/merge-k-sorted-lists/
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 归并排序实现
 * @author a590450
 * @date 3 Mar 2016 10:27:13
 */
public class MergeKSortedLists {
	
	public static void main(String[] args){
		ListNode[] nodes=new ListNode[3];
		nodes[0] =new ListNode(2);
		nodes[0].next=new ListNode(4);
		nodes[2]=new ListNode(-1);
		nodes[2].next=new ListNode(3);
		ListNode result = mergeKLists(nodes);
		while(result!=null){
			System.out.println(result.val);
			result=result.next;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0){
        	return null;
        }
        return helper(lists,0,lists.length-1);
    }

	private static ListNode helper(ListNode[] lists, int start, int end) {
		if(start==end){
			return lists[start];
		}
		int mid = start +(end-start)/2;
		return merge(helper(lists,start,mid),helper(lists,mid+1,end));
	}

	private static ListNode merge(ListNode node, ListNode node2) {
		if(node==null){
			return node2;
		}
		if(node2==null){
			return node;
		}
		ListNode dummy = new ListNode(0);
		ListNode n = dummy;
		while(node!=null&&node2!=null){
			ListNode tmp;
			if(node.val<node2.val){
				tmp = node;
				node = node.next;
			}else{
				tmp = node2;
				node2 = node2.next;
			}
			n.next = tmp;
			n = tmp;
		}
		if(node!=null){
			n.next = node;
		}
		if(node2!=null){
			n.next = node2;
		}
		return dummy.next;
	}
    
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0) {
			return null;
		}
		return helper1(lists, 0, lists.size() - 1);

	}
	
	private static ListNode helper1(List<ListNode> lists, int start, int end) {
		if(start==end){
			return lists.get(start);
		}
		int mid = start +(end-start)/2;
		return merge(helper1(lists,start,mid),helper1(lists,mid+1,end));
	}
}
