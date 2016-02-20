package edu.zju.chwl.jvm;

public class MinorGCAndFullGC {
	/**
	 * jvm参数：-XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -Xms40M -Xmx40M -Xmn20M
	 */
	public static void main(String[] args) {
		byte[] b1 = new byte[1024 * 1024 / 2];
		byte[] b2 = new byte[1024 * 1024 * 8];
		b2 = null;
		byte[] b3 = new byte[1024 * 1024 * 8];
		b3 = null;
		byte[] b4 = new byte[1024 * 1024 * 16];// Minor GC + Full GC
	}
}
