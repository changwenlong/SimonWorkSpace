package edu.zju.chwl.wangyi;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] matrix = new int[n][m];
			for (int i = 0; i < n; i++) {
				String s = in.next();
				for (int j = 0; j < m; j++) {
					matrix[i][j] = s.charAt(j)-'0';
				}
			}
			int[][] lines = new int[CNT + 2][2];
			lines[CNT + 1] = new int[] { n, m };
			if (n < 4 || m < 4) {
				System.out.println(0);
				return;
			}
			dfs(matrix, n, m, lines, CNT);
			System.out.println(max);
		}

	}

	public static final int CNT = 3;

	public static int max = 0;

	private static void dfs(int[][] matrix, int n, int m, int[][] lines, int num) {
		if (num == 0) {
			getMax(matrix, n, m, lines);
			return;
		}
		int rowIndex = lines[CNT - num][0];
		int colIndex = lines[CNT - num][1];
		for (int i = 0; i < n - rowIndex - num; i++) {
			for (int j = 0; j < m - colIndex - num; j++) {
				lines[CNT - num + 1] = new int[] { rowIndex + i + 1,
						colIndex + j + 1 };
				dfs(matrix, n, m, lines, num - 1);
				lines[CNT - num + 1] = new int[] { 0, 0 };
			}
		}
	}

	private static void getMax(int[][] matrix, int n, int m, int[][] lines) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= CNT; i++) {
			for (int j = 0; j <= CNT; j++) {
				int sum = 0;
				for (int i2 = lines[i][0]; i2 < lines[i + 1][0]; i2++) {
					for (int j2 = lines[j][1]; j2 < lines[j + 1][1]; j2++) {
						sum += matrix[i2][j2];
					}
				}
				min = Math.min(min, sum);
			}
		}
		max = Math.max(max, min);
	}

}
