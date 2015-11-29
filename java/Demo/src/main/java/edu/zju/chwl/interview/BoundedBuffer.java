package edu.zju.chwl.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * As an example, suppose we have a bounded buffer which supports put and take methods. 
 * If a take is attempted on an empty buffer, then the thread will block until an item becomes available; 
 * if a put is attempted on a full buffer, then the thread will block until a space becomes available. 
 * We would like to keep waiting put threads and take threads in separate wait-sets so that we can use 
 * the optimization of only notifying a single thread at a time when items or spaces become available in the buffer. 
 * This can be achieved using two Condition instances.
 * 
 * from JDK
 * http://docs.oracle.com/javase/7/docs/api/java/util/concurrent/locks/Condition.html
 */
public class BoundedBuffer {
	final Lock lock = new ReentrantLock();
	final Condition notFull = lock.newCondition();
	final Condition notEmpty = lock.newCondition();

	final Object[] items = new Object[100];
	int putptr, takeptr, count;

	public void put(Object x) throws InterruptedException {
		lock.lock();
		try {
			while (count == items.length)
				notFull.await();
			items[putptr] = x;
			if (++putptr == items.length)
				putptr = 0;
			++count;
			notEmpty.signal();
		} finally {
			lock.unlock();
		}
	}

	public Object take() throws InterruptedException {
		lock.lock();
		try {
			while (count == 0)
				notEmpty.await();
			Object x = items[takeptr];
			if (++takeptr == items.length)
				takeptr = 0;
			--count;
			notFull.signal();
			return x;
		} finally {
			lock.unlock();
		}
	}
}
