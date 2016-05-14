package edu.zju.chwl.wangyi;

import java.util.*;

import org.junit.*;

/**
 * http://www.nowcoder.com/test/question/ac27e60e63b549d6a9b59f815d9bc6e2?pid=1429468&tid=2876312
 * 给定部分大小关系 求两个数的大小关系
 * 解决方法：通过给定的大小关系构造出一个图 再通过图来判定两个数的大小关系
 * 
 * 同类扩展：给定数组中两个数之间大小关系 对数组进行排序
 * 解决方法：通过给定的大小关系构造出一个图 再求图的拓扑排序即为数组排序
 * @author chwl
 * @Date 2016年3月30日 上午12:47:16
 */
public class Cmp {
	public int cmp(int g1, int g2, int[][] records, int n) {
		if (n == 0) {
			return 0;
		}
		//图的邻接链表，构造图
		Map<Integer, Set<Integer>> lists = new HashMap<Integer, Set<Integer>>();
		for (int i = 0; i < n; i++) {
			if(records[i][0]==records[i][1]){
				continue;
			}
			Set<Integer> list = lists.get(records[i][0]);
			if (list == null) {
				list = new HashSet<Integer>();
			}
			list.add(records[i][1]);
			lists.put(records[i][0], list);
		}
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(g1);
		if (searchChild(g2, lists, q)) {
			return 1;
		}
		q.clear();
		q.add(g2);
		if (searchChild(g1, lists, q)) {
			return -1;
		}
		return 0;
	}

	//遍历子节点
	public boolean searchChild(int g1, Map<Integer, Set<Integer>> lists,
			LinkedList<Integer> q) {
		while (!q.isEmpty()) {
			Integer value = q.poll();
			Set<Integer> list = lists.get(value);
			if (list != null) {
				for (Integer item : list) {
					if (item == g1) {
						return true;
					}
					q.add(item);
				}
			}

		}
		return false;
	}

	@Test
	public void test() {
		System.out.println(cmp(12, 2, new int[][] { { 5, 5 }, { 2, 4 },
				{ 8, 6 }, { 12, 10 }, { 12, 12 }, { 6, 12 }, { 2, 3 },
				{ 8, 5 }, { 7, 5 }, { 5, 5 }, { 3, 10 }, { 11, 11 },
				{ 12, 12 }, { 10, 11 }, { 7, 3 }, { 2, 3 }, { 11, 5 },
				{ 1, 9 }, { 8, 12 }, { 3, 10 }, { 8, 4 }, { 7, 1 }, { 9, 5 },
				{ 6, 4 }, { 1, 11 }, { 7, 9 }, { 12, 12 }, { 4, 11 }, { 8, 6 },
				{ 2, 3 }, { 12, 5 }, { 2, 7 }, { 4, 11 }, { 4, 11 }, { 3, 3 },
				{ 4, 11 }, { 3, 4 }, { 8, 1 }, { 10, 9 }, { 4, 5 }, { 6, 9 },
				{ 8, 10 }, { 7, 11 }, { 12, 5 }, { 2, 12 }, { 1, 9 }, { 7, 3 },
				{ 8, 10 }, { 2, 1 }, { 8, 4 }, { 3, 11 }, { 6, 4 }, { 2, 4 },
				{ 7, 1 }, { 6, 6 }, { 8, 1 }, { 1, 4 }, { 3, 5 }, { 12, 10 },
				{ 1, 5 }, { 2, 4 }, { 6, 3 }, { 7, 12 }, { 6, 10 }, { 6, 11 },
				{ 7, 12 }, { 7, 4 }, { 9, 5 }, { 2, 11 }, { 2, 6 }, { 6, 5 },
				{ 8, 5 }, { 1, 9 }, { 6, 4 }, { 7, 1 }, { 1, 1 }, { 2, 9 },
				{ 8, 4 }, { 6, 5 }, { 1, 10 }, { 6, 3 }, { 8, 7 }, { 8, 2 },
				{ 6, 5 }, { 2, 12 }, { 4, 9 }, { 7, 11 }, { 4, 9 }, { 2, 10 },
				{ 8, 10 }, { 12, 10 }, { 6, 3 }, { 2, 10 }, { 12, 9 },
				{ 8, 4 }, { 2, 12 }, { 7, 11 }, { 9, 5 }, { 3, 5 }, { 2, 5 },
				{ 7, 9 }, { 8, 10 }, { 7, 9 }, { 4, 4 }, { 2, 3 }, { 2, 2 },
				{ 7, 3 }, { 6, 5 }, { 2, 4 }, { 4, 9 }, { 8, 10 }, { 12, 9 },
				{ 2, 9 }, { 8, 9 }, { 12, 5 }, { 8, 2 }, { 3, 12 }, { 1, 12 },
				{ 1, 12 }, { 8, 2 }, { 2, 5 }, { 1, 10 }, { 12, 5 }, { 3, 4 },
				{ 8, 11 }, { 2, 12 }, { 8, 2 }, { 10, 11 }, { 8, 3 }, { 2, 7 },
				{ 8, 6 }, { 1, 10 }, { 7, 12 }, { 8, 6 }, { 1, 1 }, { 3, 4 } },
				136));
		;
	}
}
