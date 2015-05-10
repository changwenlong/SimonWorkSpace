package edu.zju.chwl;
import java.util.Scanner;

class oj_1024 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			int a = s.nextInt();
			System.out.println((int)getFactorialCount(a));
		}
		s.close();
	}

	public static double getFactorialCount(int n) {
		double count = 0;
		while (n > 0) {
			count += Math.log10((double) n);
			n--;
		}
		return Math.floor(count + 1);
	}

}
