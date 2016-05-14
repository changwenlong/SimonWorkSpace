package edu.zju.chwl.offer.add;

import edu.zju.chwl.offer.datastructure.ListNode;

/**
 * 链表中环的入口节点
 * @author chwl
 * @Date 2016年4月17日 下午8:47:28
 */
public class EntryNodeOfLoop {
	
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead==null){
        	return pHead;
        }
        ListNode head = pHead;
        ListNode slow = head;
        ListNode fast = head.next;
        if(fast==null){//不存在环
        	return null;
        }
        while(slow!=fast){
        	slow =  slow.next;
        	if(fast.next==null||fast.next.next==null){//不存在环
        		return null;
        	}
        	fast = fast.next.next;
        }
        ListNode node = head;
        slow=slow.next;
        while(slow!=node){
        	slow=slow.next;
        	node= node.next;
        }
        return node;
    }
}
