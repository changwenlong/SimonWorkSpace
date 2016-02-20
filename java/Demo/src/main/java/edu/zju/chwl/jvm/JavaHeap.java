package edu.zju.chwl.jvm;

public class JavaHeap {
	/**
	 * jvm参数：-Xms20M -Xmx20M
	 * -Xms：初始堆大小
	 * -Xmx：最大堆大小
	 */
	public static void main(String[] args) {		
		try {
			byte[] b1 = new byte[1024*1024*21];
		} catch (Throwable e) {
			e.printStackTrace();
		}						
	}
}
