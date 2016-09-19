package edu.zju.chwl.thread;

import java.util.concurrent.TimeUnit;

import org.drools.time.TimeUtils;
import org.junit.Test;

public class InterruptedDemo {
	
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable(){
			@Override
			public void run() {	
				int i=0;
				while(true){
					System.out.println("Thread is running"+i++);
					if(Thread.currentThread().isInterrupted()){
						return;
					}
				}
			}
			
		});
		thread.start();
		Thread.sleep(20);
		System.out.println("Before interrupt");
		thread.interrupt();
		System.out.println("thread is interupted:"+thread.isInterrupted());
		System.out.println("After interrupt");
	}
}
