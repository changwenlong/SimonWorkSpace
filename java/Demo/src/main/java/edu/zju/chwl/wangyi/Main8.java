package edu.zju.chwl.wangyi;

import java.util.*;

public class Main8 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int m = in.nextInt();
		int[][] matrix = new int[n][m];
		for(int i = 0;i<n;i++){
			String str = in.next();
			for(int j=0;j<m;j++){
				matrix[i][j] = (str.charAt(j)=='.')?0:-1;
			}
		}
		Point loc = new Point(in.nextInt(),in.nextInt());
		int k = in.nextInt();
		Point[] steps = new Point[k];
		for(int i=0;i<k;i++){
			steps[i]=new Point(in.nextInt(),in.nextInt());
		}
		if(n==1&&m==1){
			System.out.println(1);
			return;
		}
		int ret = getStep(loc,matrix,n,m,steps,k);
		int cnt=0;
		for(int i = 0;i<n;i++){
			for(int j=0;j<m;j++){
				if(cnt>1){
					System.out.println(-1);
					return;
				}
				if(matrix[i][j]==0){
					cnt++;
				}
			}
		}
		System.out.println(ret);
	}

	private static int getStep(Point loc, int[][] matrix, int n, int m,
			Point[] steps, int k) {
		int max = -1;
		Queue<Point> q = new LinkedList<Point>();
		q.offer(loc);
		while (!q.isEmpty()) {
			int cnt = q.size();
			for (int i = 0; i < cnt; i++) {
				Point point = q.poll();
				for (int j = 0; j < k; j++) {
					int x = point.x + steps[j].x;
					int y = point.y + steps[j].y;
					if (x == loc.x && y == loc.y)
						continue;
					if (!isOuter(x, y, matrix, n, m)) {
						matrix[x][y] = matrix[point.x][point.y] + 1;
						max = Math.max(max, matrix[x][y]);
						q.offer(new Point(x, y));
					}
				}
			}
		}
		return max;
	}

	private static boolean isOuter(int x, int y, int[][] matrix, int n, int m) {
		if (x < 0 || x >= n || y < 0 || y >= m || matrix[x][y] != 0)
			return true;
		return false;
	}

	public static class Point {
		public int x, y;

		public Point(int a, int b) {
			this.x = a;
			this.y = b;
		}
	}

}
