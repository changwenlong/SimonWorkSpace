package edu.zju.chwl.coder.c2;

public class RemoveNode {

    public boolean removeNode(ListNode node) {
        if(node.next==null){
            node=null;
            return false;
        }else{
            node.val=node.next.val;
            node.next=node.next.next;
            return true;
        }
    }
}
