package edu.zju.chwl.easyrpc;

import java.io.IOException;

public class TestRPC {

	public static void main(String[] args) throws IOException, InterruptedException {		
		Calculator c=RpcFramework.refer(Calculator.class,"localhost", 2015);
		System.out.println(c.calculate(20, 5));
		System.out.println(c.calculate(20, 4));

	}

}
