package edu.zju.chwl.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadFileOperate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i=0;i<2;i++){
			//executor.execute(new ReadFile());	
			executor.execute(new WriteFile());
		}
		ReadFile.latch.countDown();

	}

}

class ReadFile implements Runnable{

	public static CountDownLatch latch = new CountDownLatch(1);
	
	@Override
	public void run() {
		try {
			BufferedReader in = new BufferedReader( new FileReader(new File("c://temp/10.in")));
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String line;
			while((line=in.readLine())!=null){
				System.out.println(Thread.currentThread().getName()+" : "+line);
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}

class WriteFile implements Runnable{

	public static CountDownLatch latch = new CountDownLatch(1);
	
	@Override
	public void run() {
		try {
			BufferedWriter out = new BufferedWriter( new FileWriter(new File("c://temp/10.in")));
			try {
				latch.await();
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i=0;i<10;i++){
				System.out.println(Thread.currentThread().getName()+" : "+i);
				out.write(Thread.currentThread().getName()+" : "+i);
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
