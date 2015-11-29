package edu.zju.chwl.lintcode.dp;

import edu.zju.chwl.util.Tools;

public class UniquePathsWithObstacle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tools.print(new UniquePathsWithObstacle().uniquePathsWithObstacles(new int[][]{{0,0},{0,0},{0,0},{1,0},{0,0}}));

	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length == 0) {
			return 0;
		}
		int n = obstacleGrid[0].length;
		int m = obstacleGrid.length;
		int[][] sum = new int[m][n];
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				break;
			}
			sum[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			if (obstacleGrid[0][i] == 1) {
				break;
			}
			sum[0][i] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (obstacleGrid[i][j] != 1) {
					sum[i][j] = sum[i - 1][j] + sum[i][j - 1];
				}
			}
		}
		return sum[m - 1][n - 1];
	}

}
