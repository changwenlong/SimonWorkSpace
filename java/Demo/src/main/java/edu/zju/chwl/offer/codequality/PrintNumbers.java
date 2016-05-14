package edu.zju.chwl.offer.codequality;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

/**
 * http://www.lintcode.com/en/problem/print-numbers-by-recursion/
 * 
 * recursion
 * 
 * @author a590450
 * @date 22 Mar 2016 14:52:17
 */
public class PrintNumbers {

	public List<Integer> numbersByRecursion(int n) {

		ArrayList<Integer> res = new ArrayList<Integer>();
		num(n, 0, res);
		return res;
	}

	public void num(int n, int ans, ArrayList<Integer> res) {

		if (n == 0) {
			if (ans > 0) {
				res.add(ans);
			}
			return;
		}

		int i;
		for (i = 0; i <= 9; i++) {
			num(n - 1, ans * 10 + i, res);
		}

	}

	//超时
/*	private List<Integer> helper(int n) {
		LinkedList<Integer> resultList = new LinkedList<Integer>();
		if (n == 0) {
			resultList.add(0);
			return resultList;
		}
		List<Integer> list = helper(n - 1);
		resultList.addAll(list);
		int addNum = (int) Math.pow(10, n - 1);
		for (int i = 1; i < 10; i++) {
			int value = i * addNum;
			for (Integer item : list) {
				resultList.add(item + value);
			}
		}
		return resultList;
	}*/

	@Test
	public void printNumbers2() {
		LinkedList<Integer> expectedList = new LinkedList<Integer>();
		for (int i = 1; i < 100; i++) {
			expectedList.add(i);
		}
		Assert.assertEquals(expectedList, numbersByRecursion(2));
	}
}
