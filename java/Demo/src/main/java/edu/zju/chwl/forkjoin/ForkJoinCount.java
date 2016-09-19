package edu.zju.chwl.forkjoin;

import java.util.Random;
import java.util.concurrent.*;

public class ForkJoinCount {

	static final int splitSize=20000000;
		
	static final int n=100000000;
	
	public static int sum(int low, int high) {
		Random random = new Random();
		int sum = 0;
		for (int i = low; i < high; i++) {
			sum += random.nextInt(2);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		forkjoin();
		sequential();
	}
	
	public static void forkjoin() {
		ForkJoinPool pool = new ForkJoinPool(64);
		long start = System.currentTimeMillis();
		ForkJoinTask<Integer> retFuture = pool.submit(new CountTask(1,n));
		try {
			retFuture.get();
		} catch (InterruptedException|ExecutionException e) {
		}
		System.out.println("Parallel processing time: "
				+ (System.currentTimeMillis() - start) + " ms");
	}
	
	public static void sequential() {
		long start = System.currentTimeMillis();
		sum(1,n);
		System.out.println("Sequential processing time: "
				+ (System.currentTimeMillis() - start) + " ms");
	}
	
	static class CountTask extends RecursiveTask<Integer>{

		private static final long serialVersionUID = 1L;
		
		private int start;
		
		private int end;
		
		CountTask(int start,int end){
			this.start=start;
			this.end=end;
		}

		@Override
		protected Integer compute() {
			if((end-start)<splitSize){
				return sum(start,end);
			}else{
				int mid = (start+end)>>>1;
				ForkJoinTask<Integer> leftTask = new CountTask(start, mid).fork();
				ForkJoinTask<Integer> rightTask = new CountTask(mid, end).fork();
				return leftTask.join()+rightTask.join();
				//不能这样写，要注意join方法会阻塞当前线程并等待获取结果
				//return new CountTask(start, mid).fork().join()+new CountTask(mid, end).fork().join();
			}
		}		
	}
}
