package edu.zju.chwl.leetcode;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 1.复制节点，连接在原节点之后 A->A'->B->B'->C->C'
 * 2.遍历链表，指定随机指针
 * 3.拆分链表，得到结果
 * @author chwl
 * @Date 2016年3月28日 下午11:26:55
 */
public class CopyListWithRandomPointer {
	public RandomListNode copyRandomList(RandomListNode head) {
		if(head==null){
			return null;
		}
		copyNode(head);
		assignRandomPointer(head);
		return getCopyLinkedList(head);
	}
	
	//复制节点，连接原节点之后 A->A'->B->B'->C->C'
	public void copyNode(RandomListNode node){
		RandomListNode head = node;
		while(head!=null){
			RandomListNode nextNode=head.next;
			RandomListNode copyHead=new RandomListNode(head.label);
			head.next=copyHead;
			copyHead.next=nextNode;
			head = nextNode;
		}
	}
	
	//遍历链表，指定随机指针
	public void assignRandomPointer(RandomListNode node){
		RandomListNode head = node;
		while(head!=null){
			RandomListNode randomNode = head.random;
			if(randomNode!=null){
				head.next.random=randomNode.next;
			}
			head=head.next.next;
		}
	}
	
	//拆分链表，得到结果,得还原原先的链表
	public RandomListNode getCopyLinkedList(RandomListNode node){
		if(node ==null){
			return null;
		}
		RandomListNode head=node;
		RandomListNode dummy = node.next;
		RandomListNode copyHead = dummy;
		while(copyHead.next!=null){
			head.next=head.next.next;
			head=head.next;
			copyHead.next=copyHead.next.next;
			copyHead=copyHead.next;
		}
		head.next=null;
		return dummy;
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x) {
		this.label = x;
	}
}
