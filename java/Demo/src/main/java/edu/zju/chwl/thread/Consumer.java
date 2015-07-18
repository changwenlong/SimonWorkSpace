package edu.zju.chwl.thread;

public class Consumer implements Runnable {
	private Resource resource;

	public Consumer(Resource resource) {
		this.resource = resource;
	}

	public void run() {
		while (true) {
			resource.out();
		}
	}
}
