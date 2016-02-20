package edu.zju.chwl.jvm;

public class TestStack {
	private int count = 0;

	// 没有出口的递归函数
	public void recursion() {
		count++;// 每次调用深度加 1
		recursion();// 递归
	}

	public void testStackOverFlowError() {
		try {
			recursion();
		} catch (Throwable e) {
			System.out.println("deep of stack is " + count);// 打印栈溢出的深度
			e.printStackTrace();
		}
	}

	/**
	 * JVM参数设置：-Xss8M -Xss：设置单个线程栈的大小
	 */
/*	public void testOutOfMemoryError() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				int i=0;
				try {
					for(;i<1024*1024*10/4;i++){
						int value=new Integer(i);
					}
				} catch (Throwable e) {
					System.out.println("use thread stack is " + i*4);// 打印栈溢出的深度
					e.printStackTrace();
				}
			}
		}).start();
	}*/

	public static void main(String[] args) {
		TestStack ts = new TestStack();
		ts.testStackOverFlowError();//测试StackOverFlowError
		//ts.testOutOfMemoryError();// 测试OutOfMemoryError
	}
}