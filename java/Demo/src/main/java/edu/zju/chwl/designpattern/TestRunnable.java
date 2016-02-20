package edu.zju.chwl.designpattern;


public class TestRunnable implements Runnable{

	private static TestRunnable instance=null;

	public static synchronized TestRunnable getInstance() {
		if(instance==null){
			instance=new TestRunnable();
			System.out.println(instance);
		}
		return instance;
	}

	@Override
	public void run() {
		long beginTime = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++) {
			TestRunnable.getInstance();
		}
		System.out.println(System.currentTimeMillis() - beginTime);
	}


	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 5; i++) {
			new Thread(new TestRunnable()).start();
		}
	}

}