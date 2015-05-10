package edu.zju.chwl;

import java.math.BigInteger;
import java.util.Scanner;

class Main {
	public static int N = 10000;

	public static int size = 0;

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		s.nextBigInteger();
		int n = s.nextInt();
		int k = s.nextInt();
		s.close();
		BigInteger bn = BigInteger.valueOf(n);
		for (int i = 0; i < k; i++) {
			boolean tmp = isPa(getArr(bn), size);
			if (tmp) {
				System.out.println(bn);
				System.out.println(i);
				return;
			} else {
				bn = bn.add(adverse(getArr(bn), size));
			}
		}
		System.out.println(bn);
		System.out.println(k);
	}

	public static boolean isPa(int[] arr, int size) {
		for (int i = 0; i <= size / 2; i++) {
			if (arr[i] != arr[size - 1 - i]) {
				return false;
			}
		}
		return true;
	}

	public static int[] getArr(BigInteger a) {
		size = 0;
		int arr[] = new int[N];
		while (a.divide(BigInteger.valueOf(10)) != BigInteger.valueOf(0)) {
			arr[size++] = a.mod(BigInteger.valueOf(10)).intValue();
			a = a.divide(BigInteger.valueOf(10));
		}
		arr[size++] = a.intValue();
		return arr;
	}

	public static BigInteger myPow(int a) {
		BigInteger rr = BigInteger.valueOf(1);
		for (int i = 0; i < a; i++) {
			rr = rr.multiply(BigInteger.valueOf(10));
		}
		return rr;
	}

	public static BigInteger adverse(int arr[], int size) {
		BigInteger result = BigInteger.valueOf(0);
		for (int i = 0; i < size; i++) {
			result = result.add(BigInteger.valueOf(arr[i]).multiply(
					myPow(size - 1 - i)));
		}
		return result;
	}

}
