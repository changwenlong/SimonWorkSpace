package edu.zju.chwl.coder.c3;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Test;

public class TwoStacksSort {
	
	public ArrayList<Integer> twoStacksSort(int[] numbers) {
		Stack<Integer> s = new Stack<Integer>();
		int pos = 0;
		while (pos < numbers.length) {
			int tmp = numbers[pos];
			while (!s.isEmpty() && s.peek() < tmp) {
				numbers[pos--] = s.pop();
			}
			s.push(tmp);
			pos++;
		}
		return new ArrayList<Integer>(s);
	}

	@Test
	public void test() {
		System.out.println(twoStacksSort(new int[] { 1, 5, 4, 3, 2,6 }));
	}

}
