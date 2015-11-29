package edu.zju.chwl.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class TestingThreadFactory implements ThreadFactory {

	public final AtomicInteger numCreated=new AtomicInteger();
	
	private final ThreadFactory factory=Executors.defaultThreadFactory();
	
	public Thread newThread(Runnable r){
		numCreated.incrementAndGet();
		return factory.newThread(r);
	}
	
	public void testPoolExpansion() throws InterruptedException{
		int MAX_SIZE=10;
		ExecutorService exec=Executors.newFixedThreadPool(MAX_SIZE);
		
		for(int i=0;i<MAX_SIZE*10;i++){
			exec.execute(this.newThread(new Runnable(){
				public void run(){
					try{
						Thread.sleep(Long.MAX_VALUE);
					}catch(InterruptedException e){
						Thread.currentThread().interrupt();
					}
				}
			}));
		}
		
		for(int i=0;i<20&&this.numCreated.get()<MAX_SIZE;i++){
			Thread.sleep(100);
		}
		
		System.out.println(this.numCreated.get());
	}
	
	public static void main(String[] args) throws InterruptedException {
		new TestingThreadFactory().testPoolExpansion();
	}
}
