package edu.zju.chwl;

import java.util.Scanner;

public class HuaWei1 {

	public int judgeS(String[] a, String b) {

		for (int i = 0; i < a.length; i++) {
			if (b.equals(a[i])) {
				return i + 1;
			}
		}

		return 0;
	}

	public static void main(String[] args) {

		HuaWei1 y = new HuaWei1();
		String[] a = { "yi", "er", "san", "si", "wu", "liu", "qi", "ba", "jiu" };
		Scanner s = new Scanner(System.in);
		String br = s.next();
		for (int i = 0; i < br.length(); i++) {
			char c = br.charAt(i);
			String t = "";
			if (c == 'i' || c == 'r' || c == 'a') {

				t = br.substring(i - 1, i + 1);
				int result = y.judgeS(a, t);
				if (result != 0) {
					System.out.print(result);
				}
			} else if (c == 'u' && br.charAt(i - 1) == 'w') {

				System.out.print(5);
			} else if (c == 'u' || c == 'n') {

				t = br.substring(i - 2, i + 1);
				int result = y.judgeS(a, t);
				if (result != 0) {
					System.out.print(result);
				}
			}
		}
		s.close();
	}

}
