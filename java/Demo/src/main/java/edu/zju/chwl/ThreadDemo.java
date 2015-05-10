package edu.zju.chwl;

public class ThreadDemo {
	public static void main(String[] args){
		MyThread thread=new MyThread("threadName");
		thread.start();
	}
}

class MyThread extends Thread{
	
	public MyThread(String name){
		super(name);
	}

	@Override
	public void run() {
		System.out.format("hello %s!", this.getName());
	}
	
}