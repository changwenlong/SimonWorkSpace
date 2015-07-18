package edu.zju.chwl.thread;

import java.util.concurrent.locks.*;

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
public class ResourceWithLock implements Resource {
	public ResourceWithLock(String name) {
		this.name = name;
	}

	private String name;
	private int count;
	private boolean flag = false;
	
	private Lock lock=new ReentrantLock();
	
	private Condition pro_c=lock.newCondition();
	private Condition con_c=lock.newCondition();

	// 生产方法
	public void set() {
		lock.lock();
		try{
			while (flag) {
				try {
					pro_c.await();
				} catch (InterruptedException e) {
				}
			}
			this.count++;
			System.out.println(Thread.currentThread().getName() + "----produce----"
					+ name + count);
			flag = true;
			con_c.signal();
		}finally{
			lock.unlock();
		}
		

	}

	// 消费方法
	public void out() {
		lock.lock();
		try{
			while (!flag) {
				try {
					con_c.await();
				} catch (InterruptedException e) {
				}
			}
			System.out.println(Thread.currentThread().getName()
					+ "---------consumer---------" + name + count);
			flag = false;
			pro_c.signal();
		}finally{
			lock.unlock();
		}
	}

}
