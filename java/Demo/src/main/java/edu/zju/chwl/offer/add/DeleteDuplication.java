package edu.zju.chwl.offer.add;

import edu.zju.chwl.offer.datastructure.ListNode;

/**
 * 删除链表中重复的节点
 * @author chwl
 * @Date 2016年4月17日 下午9:08:25
 */
public class DeleteDuplication {
	
    public ListNode deleteDuplication(ListNode pHead)
    {
    	if(pHead==null){
    		return null;
    	}
    	int value = pHead.val;
		ListNode dummy = new ListNode(value-1);
        dummy.next=pHead;
    	ListNode pos = dummy;
    	ListNode node = pHead.next;
    	boolean flag=false;//用来标记最后几个节点是不是重复
    	while(node!=null){
    		if(node.val!=value){
    			flag=false;
    			value=node.val;
    			if(pos.next.next!=node){
    				pos.next=node;
    			}else{
        			pos=pos.next;
    			}
    		}else{
    			flag=true;
    		}
    		node=node.next;    		
    	}
    	if(flag){
    		pos.next=null;
    	}
    	return dummy.next;
    }
}
