package edu.zju.chwl.huawei;

import java.util.Scanner;

public class Question3 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int m = cin.nextInt();
		int[][] arr = new int[n][m];
		int a;
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				a = cin.nextInt();
				if (a == 1 && j > 0) {
					arr[i][j] = arr[i][j - 1] + 1;
				} else {
					arr[i][j] = a;
				}
			}
			for (int j = 0; j < m; j++) {
				if (arr[i][j] > max) {
					if (max == 0) {
						max = 1;
						break;
					} else {
						int times = 1;
						for (int k = i - 1; k >= 0; k--) {
							if (arr[k][j] <= max) {
								break;
							}
							times++;
							if (times == (max + 1)) {
								max++;
								break;
							}
						}
					}
				}
			}
		}
		System.out.println(max);
		cin.close();
	}
}
