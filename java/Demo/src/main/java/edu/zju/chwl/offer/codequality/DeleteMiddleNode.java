package edu.zju.chwl.offer.codequality;

import edu.zju.chwl.offer.datastructure.ListNode;

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * @author a590450
 * @date 21 Mar 2016 15:40:02
 */
public class DeleteMiddleNode {
	public void deleteNode(ListNode node) {
        if(node==null||node.next==null){
            return;
        }
        node.val=node.next.val;
        node.next=node.next.next;
	}
	
}


