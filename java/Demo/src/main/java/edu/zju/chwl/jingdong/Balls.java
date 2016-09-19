package edu.zju.chwl.jingdong;

import org.junit.Test;

public class Balls {
	public int calcDistance(int A, int B, int C, int D) {
		return (A+B+C+D)*3;
	}
	
	@Test
	public void test(){
		System.out.println(calcDistance(100,90,80,70));
	}
	
}
