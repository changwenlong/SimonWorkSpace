package edu.zju.chwl.coder.c9;

import org.junit.Test;

public class Coin {

	public int countWays(int n) {
		count(getIndex(n), n);
		return (int) count;
	}

	long count = 0;
	int[] nums = new int[] { 25, 10, 5, 1 };

	private void count(int index, int n) {
		if (n == 0) {
			count = (count + 1) % 1000000007;
			return;
		}
		for (int i = index; i < nums.length; i++) {
			count(Math.max(getIndex(n - nums[i]), i), n - nums[i]);
		}
	}

	private int getIndex(int n) {
		for (int i = 0; i < nums.length; i++) {
			if (n / nums[i] > 0) {
				return i;
			}
		}
		return -1;
	}

	@Test
	public void test() {

		for (int i = 1; i < 100; i++) {
			System.out.println(i + ":" + countWays(i));
			count=0;
		}
	}
}
