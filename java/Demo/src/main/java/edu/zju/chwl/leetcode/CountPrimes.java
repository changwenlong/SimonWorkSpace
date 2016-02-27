package edu.zju.chwl.leetcode;

/**
 * https://leetcode.com/problems/count-primes/
 * @author chwl
 * @Date 2016年2月21日 下午7:46:59
 */
public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(4));
		System.out.println(countPrimes(6));
		System.out.println(countPrimes(8));
		System.out.println(countPrimes(12));
	}

	public static int countPrimes(int n) {
		if (n <= 2) {
			return 0;
		}
		boolean[] notPrime = new boolean[n];
		notPrime[1] = true;
		notPrime[2] = false;
		int result = 0;
		for (int i = 2; i < n; i++) {
			if (!notPrime[i]) {
				for (int j = i+i; j < n; j += i) {
					notPrime[j] = true;
				}
				result++;
			}
		}
		return result;
	}
}
