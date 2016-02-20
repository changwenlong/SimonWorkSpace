package edu.zju.chwl.jvm;

public class TestHeapGC {

	/**
	 * jvm参数配置：-XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -Xms40M -Xmx40M -Xmn20M
	 * -Xms：设置初始堆大小
	 * -Xmx：设置最大堆大小
	 * -Xmn：设置初始新生代大小
	 * -XX:SurvivorRatio=8:设置新生代中eden与survivor的大小比例
	*/
	public static void main(String[] args) {
		byte[] b1 = new byte[1024 * 1024 / 2];
		byte[] b2 = new byte[1024 * 1024 * 8];
		b2 = null;
		b2 = new byte[1024 * 1024 * 8];// 进行一次新生代 GC （Minor GC）
		//System.gc();//进行一次Full GC
	}

}
