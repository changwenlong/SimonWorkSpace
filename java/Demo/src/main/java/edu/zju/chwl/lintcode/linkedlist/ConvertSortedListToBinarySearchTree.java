package edu.zju.chwl.lintcode.linkedlist;


public class ConvertSortedListToBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public TreeNode sortedListToBST(ListNode head) {  
        if(head==null){
        	return null;
        }
        int length=getLength(head);
        int[] arr=new int[length];
        for(int i=0;head!=null;head=head.next,i++){
        	arr[i]=head.val;
        }
        return sortedArrayToBST(arr,0,length-1);
    }

	private TreeNode sortedArrayToBST(int[] arr,int start,int end) {
		TreeNode node=new TreeNode(arr[(start+end)/2]);
		if((start+end)/2-1>=start){			
			node.left=sortedArrayToBST(arr,start,(start+end)/2-1);
		}
		if((start+end)/2+1<=end){			
			node.right=sortedArrayToBST(arr,(start+end)/2+1,end);
		}
		return node;
	}

	private int getLength(ListNode head) {
		int size=0;
		while(head!=null){
			size++;
			head=head.next;
		}
		return size;
	}

}
