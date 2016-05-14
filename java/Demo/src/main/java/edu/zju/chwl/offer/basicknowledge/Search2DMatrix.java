package edu.zju.chwl.offer.basicknowledge;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * @author a590450
 * @date 15 Mar 2016 14:54:55
 */
public class Search2DMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;
		int count = rowCount * columnCount;
		int low = 0, high = count - 1;
		int i = 0, j = 0;
		while (low < high) {
			int mid = low + (high - low) / 2;
			i = mid / columnCount;
			j = mid % columnCount;
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		// when low == high
		if (matrix[low / columnCount][low % columnCount] == target) {
			return true;
		}
		return false;
	}

	int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };

	@Test
	public void searchMin() {
		assertTrue(searchMatrix(matrix, 1));
	}

	@Test
	public void searchMax() {
		assertTrue(searchMatrix(matrix, 50));
	}

	@Test
	public void searchMid() {
		assertTrue(searchMatrix(matrix, 7));
	}

	@Test
	public void searchMinNotExists() {
		assertFalse(searchMatrix(matrix, 0));
	}

	@Test
	public void searchMaxNotExists() {
		assertFalse(searchMatrix(matrix, 51));
	}

	@Test
	public void searchMidNotExists() {
		assertFalse(searchMatrix(matrix, 6));
	}

	@Test
	public void searchNull() {
		assertFalse(searchMatrix(null, 16));
	}

	@Test
	public void searchEmpty() {
		assertFalse(searchMatrix(new int[0][], 16));
	}
}
