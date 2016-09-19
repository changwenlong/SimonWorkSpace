package edu.zju.chwl.didi;

import java.util.*;

public class Main2 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNextInt()) {
			int n = in.nextInt();
			System.out.println(getNum(n));
		}

		in.close();
	}

	private static int getNum(int n) {
		int cnt = 0;
		while (n > 0) {
			cnt += (n / 5);
			n = n / 5;
		}
		return cnt;
	}

}
