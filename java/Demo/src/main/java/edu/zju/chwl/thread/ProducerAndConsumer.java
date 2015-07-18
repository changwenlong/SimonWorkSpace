package edu.zju.chwl.thread;

public class ProducerAndConsumer {

	public static void main(String[] args) {
		//Resource r = new ResourceWithSync("bread");
		//Resource r = new ResourceWithLock("烤鸭");
		Resource r=new ResourceJDKDemo();
		doTask(r);
	}

	public static void doTask(Resource r) {
		Producer p1 = new Producer(r);
		Producer p2 = new Producer(r);
		Consumer c1 = new Consumer(r);
		Consumer c2 = new Consumer(r);
		Thread t1 = new Thread(p1);
		Thread t2 = new Thread(p2);
		Thread t3 = new Thread(c1);
		Thread t4 = new Thread(c2);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
