package edu.zju.chwl.offer.basicknowledge;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * 
 * @author a590450
 * @date 15 Mar 2016 14:54:55
 */
public class Search2DMatrixII {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		int rowCount = matrix.length;
		int columnCount = matrix[0].length;
		int size = rowCount < columnCount ? rowCount : columnCount;
		int index = getIndex(matrix, size, target);
		if(index<0){
			return false;
		}
		if(matrix[index][index]==target){
			return true;
		}
		int i = index,j=index+1;
		while(i>=0&&j<columnCount){
			if(matrix[i][j]==target){
				return true;
			}else if(matrix[i][j]>target){
				i--;
			}else{
				j++;
			}
		}
		i = index+1;j=index;
		while(i<rowCount&&j>=0){
			if(matrix[i][j]==target){
				return true;
			}else if(matrix[i][j]>target){
				j--;
			}else{
				i++;
			}
		}
		return false;
	}

	//二分查找
	private int getIndex(int[][] matrix, int size, int target) {
		int low = 0;
		int high = size - 1;
		while (low <high) {
			int mid = low + (high - low) / 2;
			if (matrix[mid][mid] == target) {
				return mid;
			} else if (matrix[mid][mid] > target) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if(matrix[low][low]==target){
			return low;
		}else if(matrix[low][low]>target){
			return low - 1;
		}else{
			return low;
		}
	}

	int[][] matrix = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
			{ 6, 8, 11, 15 } };

	@Test
	public void testGetIndex() {
		System.out.println(getIndex(matrix,4,1));
		System.out.println(getIndex(matrix,4,0));
		System.out.println(getIndex(matrix,4,15));
		System.out.println(getIndex(matrix,4,4));
		System.out.println(getIndex(matrix,4,5));
		System.out.println(getIndex(new int[][]{{1,3}},1,3));
	}
	
	@Test
	public void searchMin() {
		assertTrue(searchMatrix(matrix, 1));
	}

	@Test
	public void searchMax() {
		assertTrue(searchMatrix(matrix, 15));
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
		assertFalse(searchMatrix(matrix, 16));
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
