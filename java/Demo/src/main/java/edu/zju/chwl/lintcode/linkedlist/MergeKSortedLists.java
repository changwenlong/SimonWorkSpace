package edu.zju.chwl.lintcode.linkedlist;

import java.util.List;

public class MergeKSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    public ListNode mergeKLists(List<ListNode> lists) {  
        if(lists==null||lists.isEmpty()){
        	return null;
        }
        ListNode mergeList=lists.get(0);
        for(int i=1;i<lists.size();i++){
        	mergeList=getMergeList(mergeList,lists.get(i));
        }
        return mergeList;
    }

	private ListNode getMergeList(ListNode mergeList, ListNode listNode) {
		if(mergeList==null){
			return listNode;
		}
		if(listNode==null){
			return mergeList;
		}
		ListNode dummy=new ListNode(0);
		dummy.next=mergeList;
		ListNode prior=dummy;
		while(mergeList!=null&&listNode!=null){
			if(listNode.val<mergeList.val){
				ListNode temp=listNode;
				prior.next=temp;
				listNode=listNode.next;
				temp.next=mergeList;
			}else{
				mergeList=mergeList.next;
			}
			prior=prior.next;
		}
		if(listNode!=null){
			prior.next=listNode;
		}
		return dummy.next;
	}
    
    
}
