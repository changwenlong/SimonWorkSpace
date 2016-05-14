package edu.zju.chwl.offer.timeandspace;

import org.junit.*;
//数组中的逆序对
public class InversePairs {

	private int number;
	public int inversePairs(int[] array) {
		if (array == null || array.length < 2) {
			return 0;
		}
		int len = array.length;
		mergeSort(array, 0, len - 1, new int[len]);
		return number;
	}

	private void mergeSort(int[] nums, int start, int end, int[] copy) {
		if (start == end) {
			return;
		}
		int mid = (end - start) / 2 + start;
		mergeSort(nums, start, mid, copy);
		mergeSort(nums, mid + 1, end, copy);
		merge(nums, start, mid, end, copy);
	}

	public void merge(int[] nums, int start, int mid, int end, int[] copy) {
		int count = start;
		int p1, p2;
		// merge两个有序的序列
		for (p1 = start, p2 = mid + 1; p1 <= mid && p2 <= end;) {
			if (nums[p1] <= nums[p2]) {
				copy[count] = nums[p1++];
			} else {
				copy[count] = nums[p2++];
				number+=(mid-p1+1);//记录逆序对
			}
			count++;
		}
		for (int i = p1; i <= mid; i++) {
			copy[count++] = nums[i];
		}
		for (int i = p2; i <= end; i++) {
			copy[count++] = nums[i];
		}
		// 将排序好的序列复制回原数组
		for (int i = start; i <= end; i++) {
			nums[i] = copy[i];
		}
	}

	@Test
	public void mergeSort() {
		int[] nums = new int[] { 2, 5, 3, 1, 8, 4, 7 };
		mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
		for (int i : nums) {
			System.out.print(i + ",");
		}
	}
	
	@Test
	public void inversePairs() {
		int[] nums = new int[] { 2, 5, 3, 1, 8, 4, 7 };
		System.out.print(inversePairs(nums));
	}
}
