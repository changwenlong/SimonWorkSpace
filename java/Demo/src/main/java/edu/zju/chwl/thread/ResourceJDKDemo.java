package edu.zju.chwl.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多生产者多消费者模式 
 * 1.刚开始使用if条件判断，会导致不该运行的线程运行了，出现了数据错误的现象
 * 原因：线程p0进过条件判断，进入等待状态，但p0被唤醒，再次获得执行权时，躲过了if判断，从而数据出错 
 * 解决方法：使用while循环判断
 * 2.使用while条件判断，会导致死锁现象 
 * 原因：生产者线程p0在正常生产后，唤醒了同为生产者线程的p1 
 * 解决方法：使用notifyAll
 * 3.使用notifyAll，解决了死锁现象 原因：notifyAll能保证始终会唤醒对方线程 
 * Created by chwl on 2015/6/25.
 */
public class ResourceJDKDemo implements Resource {
	
	private int count,proInt,conInt;
	private Object goods[] = new Object[1000];
	
	final Lock lock=new ReentrantLock();
	
	final Condition notFull=lock.newCondition();
	final Condition notEmpty=lock.newCondition();

	// 生产方法
	public synchronized void set() {
		lock.lock();
		try{
			while (count==goods.length) {
				try {
					notFull.await();
				} catch (InterruptedException e) {
				}
			}
			goods[proInt]=new Object();
			if(++proInt==goods.length) proInt=0;			
			this.count++;
			System.out.println(Thread.currentThread().getName() + "----produce goods----" + proInt);
			notEmpty.signal();
		}finally{
			lock.unlock();
		}
		

	}

	// 消费方法
	public void out() {
		lock.lock();
		try{
			while (count==0) {
				try {
					notEmpty.await();
				} catch (InterruptedException e) {
				}
			}
			this.count--;
			if(++conInt==goods.length) conInt=0;
			System.out.println(Thread.currentThread().getName()
					+ "---------consumer goods---------" + conInt);
			notFull.signal();
		}finally{
			lock.unlock();
		}
	}

}
