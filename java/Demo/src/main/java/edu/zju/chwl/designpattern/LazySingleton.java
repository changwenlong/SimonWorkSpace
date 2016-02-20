package edu.zju.chwl.designpattern;


public class LazySingleton implements Runnable {
	private LazySingleton() {
		//System.out.println("LazySingleton is create:"+this);
	}

	private static volatile LazySingleton instance = null;

	public static synchronized LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
			System.out.println(instance);
		}
		return instance;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			LazySingleton.getInstance();
		}
		System.out.println(System.currentTimeMillis() - beginTime);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			new Thread(new LazySingleton()).start();
		}
	}

}

