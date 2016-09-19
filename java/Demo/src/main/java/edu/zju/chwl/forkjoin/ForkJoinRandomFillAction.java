package edu.zju.chwl.forkjoin;

import static java.util.Arrays.asList;

import java.util.Random;
import java.util.concurrent.*;

public class ForkJoinRandomFillAction {
	
	public static void main(String[] args){
		sequential();
		forkjoin();
		threadPool();
	}

	public static void loadArray(int[] array, int low, int high) {
		Random random = new Random();
		for (int i = low; i < high; i++) {
			array[i] = random.nextInt(10000);
		}
	}

	static final int arrayLength = 30000000;

	static final int iterations = 4;

	static final int splitSize = 40000;

	// 顺序实现
	public static void sequential() {

		int array[] = new int[arrayLength];

		for (int i = 0; i < iterations; i++) {
			long start = System.currentTimeMillis();
			loadArray(array, 0, array.length);
			System.out.println("Sequential processing time: "
					+ (System.currentTimeMillis() - start) + " ms");
		}

	}

	// 使用fork join并发递归实现
	public static void forkjoin() {

		int array[] = new int[arrayLength];

		System.out.println("Number of processor available: " + Runtime.getRuntime().availableProcessors());

		ForkJoinPool fjpool = new ForkJoinPool(64); 

		for (int i = 0; i < iterations; i++) {
			// Create a task with the complete array
			RecursiveAction task = new RandomFillAction(array, 0, array.length);
			long start = System.currentTimeMillis();
			fjpool.invoke(task);//阻塞等待返回結果
			System.out.println("Parallel processing time: "
					+ (System.currentTimeMillis() - start) + " ms");
		}

		System.out
				.println("Number of steals: " + fjpool.getStealCount() + "\n");

	}

	//使用线程池并发递归实现, 和fork join 的效率差不多, 但不灵活,一开始就要定义好每个线程处理那些数据
	public static void threadPool() {

		int array[] = new int[arrayLength];

		ExecutorService threadPool = Executors.newFixedThreadPool(64);
		ExecutorCompletionService<Boolean> completionService = new ExecutorCompletionService<Boolean>(
				threadPool);
		for (int i = 0; i < iterations; i++) {
			long start = System.currentTimeMillis();
			int size = (array.length - 1) / splitSize + 1;
			for (int j = 0; j < size; j++) {
				completionService.submit(new FillTask(array, j * splitSize,
						(j + 1) * splitSize), true);
			}
			for (int j = 0; j < size; j++) {
				try {
					completionService.take().get();//确保任务已执行完
				} catch (InterruptedException | ExecutionException e) {
				}
			}
			System.out.println("Thread Pool processing time: "
					+ (System.currentTimeMillis() - start) + " ms");
		}

	}
	
	static class FillTask implements Runnable {

		final int low;
		final int high;
		private int[] array;

		public FillTask(int[] array, int low, int high) {
			this.low = low;
			this.high = high;
			this.array = array;
		}

		@Override
		public void run() {
			loadArray(array,low,high);
		}

	}
	
	static class RandomFillAction extends RecursiveAction {
		private static final long serialVersionUID = 1L;
		final int low;
		final int high;
		private int[] array;

		public RandomFillAction(int[] array, int low, int high) {
			this.low = low;
			this.high = high;
			this.array = array;
		}

		@Override
		protected void compute() {
			if (high - low > splitSize) {
				int mid = (low + high) >>> 1;
				invokeAll(asList(new RandomFillAction(array, low, mid),
						new RandomFillAction(array, mid, high)));
				//注意不能两个Action分开invoke,invoke会等待执行完成
				//new RandomFillAction(array, low, mid).invoke();
				//new RandomFillAction(array, mid, high).invoke();
			} else {
				loadArray(array,low,high);
			}
		}
	}
}

