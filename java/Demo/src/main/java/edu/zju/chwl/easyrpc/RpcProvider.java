package edu.zju.chwl.easyrpc;

import java.io.IOException;

public class RpcProvider {

	public static void main(String[] args) throws IOException {
		//启动服务端，暴露服务
		RpcFramework.export(new CalculatorImpl(), 2015);
	}

}
