package edu.zju.chwl.offer.II;

import edu.zju.chwl.util.Tools;

public class Search2DMatrixII {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = new int[][] {
				{ 1, 2, 8, 10, 16, 21, 23, 30, 31, 37, 39, 43, 44, 46, 53, 59,
						66, 68, 71 },
				{ 6, 7, 10, 18, 28, 31, 33, 38, 44, 48, 53, 60, 61, 66, 69, 70,
						74, 77, 78 },
				{ 13, 22, 30, 33, 37, 44, 45, 49, 59, 66, 75, 76, 80, 90, 96,
						101, 107, 110, 113 },
				{ 20, 31, 38, 44, 52, 54, 60, 61, 64, 76, 86, 87, 96, 100, 101,
						108, 113, 117, 126 },
				{ 22, 38, 40, 45, 60, 70, 71, 79, 84, 86, 87, 93, 98, 105, 109,
						111, 114, 123, 127 },
				{ 29, 44, 53, 54, 70, 78, 82, 87, 88, 90, 97, 107, 117, 125,
						129, 139, 141, 142, 149 } };
		Tools.print(new Search2DMatrixII().searchMatrix(matrix, 44));
	}

	public int searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int count = 0;
		int x = matrix.length;
		int y = matrix[0].length;
		int k=0;
		for (int i = x - 1; i >= 0; i--) {
			for (int j = k; j < y; j++) {
				if (matrix[i][j] > target) {
					break;
				}else if (matrix[i][j] == target) {
					count++;
				}else{
					k++;
				}
			}

		}
		return count;
	}
}
