package edu.zju.chwl.huawei;

import java.util.Scanner;

public class Question1 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int[] a = new int[10];
		int index;
		for (int i = 0; i < 10; i++) {
			index = cin.nextInt();
			a[index] = 1;
		}
		int count = 0;
		for (int j = 9; j >= 0; j--) {
			if (a[j] != 0 && count < 3) {
				count++;
				System.out.print(j);
			}
		}
		cin.close();
	}
}
