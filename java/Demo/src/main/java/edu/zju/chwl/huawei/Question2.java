package edu.zju.chwl.huawei;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Question2 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int a;
		List<Integer> odd = new ArrayList<Integer>();
		List<Integer> even = new ArrayList<Integer>();
		while (cin.hasNext()) {
			a = cin.nextInt();
			if (a % 2 == 1) {
				odd.add(a);
			} else {
				even.add(a);
			}
		}
		Collections.sort(odd);
		Collections.reverse(odd);
		for (int i = 0; i < odd.size(); i++) {
			System.out.print(odd.get(i));
			if (i != odd.size() - 1) {
				System.out.print(" ");
			}
		}
		Collections.sort(even);
		for (int i = 0; i < even.size(); i++) {
			System.out.print(" " + even.get(i));
		}
		cin.close();
	}

}
