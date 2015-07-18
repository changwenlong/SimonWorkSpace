package edu.zju.chwl.thread;

public class Producer implements Runnable {
	private Resource resource;

	public Producer(Resource resource) {
		this.resource = resource;
	}

	public void run() {
		while (true) {
			resource.set();
		}
	}
}
