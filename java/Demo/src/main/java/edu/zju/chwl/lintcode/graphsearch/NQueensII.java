package edu.zju.chwl.lintcode.graphsearch;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/n-queens-ii/
 * 
 * @author a590450
 * @date 10 Mar 2016 15:23:12
 */
public class NQueensII {

	public static void main(String[] args) {
		System.out.println(totalNQueens1(8));
	}

	static int result = 0;

	/**
	 * 使用位运算来实现 对于点（x,y） y方向上的bit mask就是y diagonal方向上所有点的y-x值一致，为保证bit
	 * mask为正，使用y-x+(n-1) anti-diagonal方向上所有的点x+y值一致，bit mask使用x+y
	 * 
	 * @param n
	 * @return
	 */
	public static int totalNQueens1(int n) {
		if (n == 0) {
			return 0;
		}
		bitDFS(0, 0, 0, 0, n);
		return result;
	}

	private static void bitDFS(int x, int y, int diag, int antiDiag, int n) {
		if (x == n) {
			result++;
			return;
		}
		for (int i = 0; i < n; i++) {
			boolean yMask = ((1 << i) & y) == 0;
			boolean diagMask = ((1 << (n - 1 + x - i)) & diag) == 0;
			boolean antiDiagMask = ((1 << (x + i)) & antiDiag) == 0;
			if (yMask && diagMask && antiDiagMask) {
				bitDFS(x + 1, y | (1 << i), diag | (1 << (n - 1 + x - i)),
						antiDiag | (1 << (x + i)), n);
			}
		}
	}

	/**
	 * 使用常规的dfs
	 * 
	 * @param n
	 * @return
	 */
	public static int totalNQueens(int n) {
		if (n == 0) {
			return 0;
		}
		boolean[] columns = new boolean[n + 2];
		Arrays.fill(columns, true);

		dfs(columns, new ArrayList<Integer>(), n);
		return result;
	}

	private static void dfs(boolean[] columns, ArrayList<Integer> list, int n) {
		if (list.size() == n) {
			result++;
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!columns[i]) {
				continue;
			}
			int rowIndex = list.size();
			int columnIndex = i - 1;
			boolean flag = false;
			for (int j = 0; j < list.size(); j++) {
				if (Math.abs(rowIndex - j) == Math.abs(columnIndex
						- list.get(j))) {
					flag = true;
					break;
				}
			}
			if (flag) {
				continue;
			}
			list.add(columnIndex);
			columns[i] = false;
			dfs(columns, list, n);
			columns[i] = true;
			list.remove(list.size() - 1);
		}
	}

}
