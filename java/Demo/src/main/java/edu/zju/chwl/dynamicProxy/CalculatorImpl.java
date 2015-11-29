package edu.zju.chwl.dynamicProxy;

public class CalculatorImpl implements Calculator {

	@Override
	public int calculate(int a, int b) {
		System.out.println("**********Actual Method Execution**********");
		return a / b;
	}

}
