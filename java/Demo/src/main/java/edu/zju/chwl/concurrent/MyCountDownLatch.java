package edu.zju.chwl.concurrent;

public class MyCountDownLatch {
	
	private int count;
	
	public MyCountDownLatch(int count){
		this.count=count;
	}
	
	public synchronized void await() throws InterruptedException{
		if(count>0){
			this.wait();
		}
	}
	
	public synchronized void countDown(){
		count--;
		if(count==0){
			this.notifyAll();
		}
	}
}
