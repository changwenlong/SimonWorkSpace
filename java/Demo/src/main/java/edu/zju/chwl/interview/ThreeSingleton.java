package edu.zju.chwl.interview;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 知道单例模式吗？
 * 扩展单例模式，控制实际产生实例数目为 3 个
 */
public class ThreeSingleton {
	private final static String DEFAULT_PREKEY = "cache";
	private static Map<String, ThreeSingleton> map = new HashMap<String, ThreeSingleton>();
	private static int number = 1;
	private final static int NUM_MAX = 3;

	private ThreeSingleton() {

	}

	public static synchronized ThreeSingleton getInstance() {
		String key = DEFAULT_PREKEY + number;
		ThreeSingleton threeSingleton = map.get(key);
		if (threeSingleton == null) {
			threeSingleton = new ThreeSingleton();
			map.put(key, threeSingleton);
		}
		number++;
		if (number > NUM_MAX) {
			number = 1;
		}
		return threeSingleton;
	}

	public static void main(String args[]) {
		ThreeSingleton t1 = getInstance();
		ThreeSingleton t2 = getInstance();
		ThreeSingleton t3 = getInstance();
		ThreeSingleton t4 = getInstance();
		ThreeSingleton t5 = getInstance();
		ThreeSingleton t6 = getInstance();
		HashSet<ThreeSingleton> set = new HashSet<ThreeSingleton>();
		set.add(t1);
		set.add(t2);
		set.add(t3);
		set.add(t4);
		set.add(t5);
		set.add(t6);
		System.out.println(set.size() == 3);
	}
}
