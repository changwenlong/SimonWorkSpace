package edu.zju.chwl.lintcode.datastructure;

/**
 * http://www.lintcode.com/en/problem/rehashing/
 * 
 * @author a590450
 * @date 2 Mar 2016 10:52:01
 */
public class Rehashing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode[] node = new ListNode[4];
		ListNode n = new ListNode(21);
		n.next = new ListNode(9);
		node[1] = n;
		ListNode m = new ListNode(14);
		m.next=new ListNode(21);
		node[2] = m;
		ListNode[] result = rehashing(node);
		System.out.print(result);
	}

	public static ListNode[] rehashing(ListNode[] hashTable) {
		if (hashTable == null || hashTable.length == 0) {
			return new ListNode[0];
		}
		int len = hashTable.length * 2;
		ListNode[] newHashTable = new ListNode[len];
		for (ListNode node : hashTable) {
			while (node != null) {
				int hash = hashCode(node.val, len);
				ListNode p = new ListNode(node.val);
				ListNode n = newHashTable[hash];
				//尾插法
				if(n==null){
					newHashTable[hash] = p;
				}else{
					while(n.next!=null){
						n=n.next;
					}
					n.next=p;					
				}
				node = node.next;
			}
		}
		return newHashTable;
	}

	public static int hashCode(int val, int len) {
		int result = 0;
		if (val >= 0) {
			result = val % len;
		} else {
			result = (val % len + len) % len;
		}
		return result;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
