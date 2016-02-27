package edu.zju.chwl.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * https://leetcode.com/problems/number-of-islands/
 * 
 * BFS
 * 
 * @author chwl
 * @Date 2016年2月21日 下午2:01:21
 */
public class NumberOfIslands {

	public static void main(String[] args) {
		NumberOfIslands noi = new NumberOfIslands();
		System.out.println(noi.numIslands(new char[][] {
				new char[] { '1', '1', '1', '1', '0' },
				new char[] { '1', '1', '0', '1', '0' },
				new char[] { '1', '1', '0', '0', '0' },
				new char[] { '0', '0', '0', '0', '0' } }));
		System.out.println(noi.numIslands(new char[][] {
				new char[] { '1', '1', '0', '0', '0' },
				new char[] { '1', '1', '0', '0', '0' },
				new char[] { '0', '0', '1', '0', '0' },
				new char[] { '0', '0', '0', '1', '1' } }));
		System.out
				.println(noi.numIslands(new char[][] { new char[] { '1' }, }));
		System.out
				.println(noi.numIslands(new char[][] { new char[] { '0' }, }));
		System.out.println(noi.numIslands(new char[][] {
				new char[] { '1', '1', '1', '1', '1', '1' },
				new char[] { '1', '0', '0', '0', '0', '1' },
				new char[] { '1', '0', '1', '1', '0', '1' },
				new char[] { '1', '0', '0', '0', '0', '1' },
				new char[] { '1', '1', '1', '1', '1', '1' } }));
		System.out.println(noi.numIslands(new char[][] {
				new char[] { '0', '0', '0', '0' },
				new char[] { '0', '1', '1', '0' },
				new char[] { '0', '0', '0', '0' }, }));

	}

	class Point {
		int x;
		int y;

		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public String toString() {
			return "[" + x + "," + y + "]";
		}
	}

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int m = grid.length;
		int n = grid[0].length;
		boolean[][] access = new boolean[m][n];
		int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
		int result = 0;
		Queue<Point> q = new LinkedList<Point>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (!access[i][j] && grid[i][j] == '1') {
					q.offer(new Point(i, j));
					access[i][j] = true;
				}else{
					continue;
				}
				while (!q.isEmpty()) {
					Point point = q.poll();
					for(int k=0;k<4;k++){
						int x = point.x+direction[k][0];
						int y = point.y+direction[k][1];
						if (x>=0&&x<m&&y>=0&&y<n&& grid[x][y] == '1'&&!access[x][y]) {
							q.offer(new Point(x, y));
							access[x][y] = true;
						}
					}
				}
				result++;
			}
		}
		return result;
	}
}
