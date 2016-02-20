package edu.zju.chwl.jvm;

import java.util.ArrayList;
import java.util.List;

public class RuntimeConstantPool {
	/**
	 * jvm参数：-XX:PermSize=10M -XX:MaxPermSize=10M  -Xms10M -Xmx10M
	 * -XX:PermSize：初始方法区大小
	 * -XX:MaxPermSize：最大方法区大小
	 */
	public static void main(String[] args) {
		try {
			// 使用List保持着常量池引用，避免Full GC回收常量池行为
			List<String> list = new ArrayList<String>();
			// 10MB的PermSize在integer范围内足够产生OOM了
			int i = 0;
			while (true) {
				list.add(String.valueOf(i++).intern());
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
