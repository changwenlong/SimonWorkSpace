package edu.zju.chwl.thread;

import java.util.*;
import java.util.concurrent.*;

class Toast{
	public enum Status{DRY,BUTTERED,JAMMED}
	private Status status=Status.DRY;
	private final int id;
	public Toast(int idn){this.id=idn;}
	public void butter(){status=Status.BUTTERED;}
	public void jam(){status=Status.JAMMED;}
	public Status getStatus(){return status;}
	public int getId(){return id;}
	public String toString(){return "Toast "+id+":"+status;}
}

class ToastQueue extends LinkedBlockingQueue<Toast>{}

class Toaster implements Runnable{
	private ToastQueue dryQueue;
	private int count=0;
	private Random rand=new Random(47);
	public Toaster(ToastQueue dry){dryQueue=dry;}
	
	public void run() {
		try{
			while(!Thread.interrupted()){
				TimeUnit.MICROSECONDS.sleep(100+rand.nextInt(500));
				Toast t=new Toast(count++);
				System.out.println(t);
				dryQueue.put(t);
			}
		}catch(InterruptedException e){
			System.out.println("Toaster interrupted");
		}
		System.out.println("Toaster off");
	}	
}

class Butterer implements Runnable{
	private ToastQueue dryQueue,butteredQueue;
	private Random rand=new Random(47);
	public Butterer(ToastQueue dry,ToastQueue buttered){dryQueue=dry;butteredQueue=buttered;}
	
	public void run() {
		try{
			while(!Thread.interrupted()){
				TimeUnit.MICROSECONDS.sleep(100+rand.nextInt(500));
				Toast t=dryQueue.take();
				t.butter();
				System.out.println(t);
				butteredQueue.put(t);
			}
		}catch(InterruptedException e){
			System.out.println("Butterer interrupted");
		}
		System.out.println("Butterer off");
	}	
}

class Jammer implements Runnable{
	private ToastQueue butteredQueue,finishedQueue;
	private Random rand=new Random(47);
	public Jammer(ToastQueue buttered,ToastQueue finished){butteredQueue=buttered;finishedQueue=finished;}
	
	public void run() {
		try{
			while(!Thread.interrupted()){
				TimeUnit.MICROSECONDS.sleep(100+rand.nextInt(500));
				Toast t=butteredQueue.take();
				t.jam();
				System.out.println(t);
				finishedQueue.put(t);
			}
		}catch(InterruptedException e){
			System.out.println("Jammer interrupted");
		}
		System.out.println("Jammer off");
	}	
}

class Eater implements Runnable{
	private ToastQueue finishedQueue;
	private int count=0;
	private Random rand=new Random(47);
	public Eater(ToastQueue finished){finishedQueue=finished;}
	
	public void run() {
		try{
			while(!Thread.interrupted()){
				TimeUnit.MICROSECONDS.sleep(100+rand.nextInt(500));
				Toast t=finishedQueue.take();
				if(t.getId()!=count++||t.getStatus()!=Toast.Status.JAMMED){
					System.out.println(">>> Error"+t);
				}else{
					System.out.println("Chomp! "+t);
				}
			}
		}catch(InterruptedException e){
			System.out.println("Eater interrupted");
		}
		System.out.println("Eater off");
	}	
}

public class ToastOMatic {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		ToastQueue dryQueue=new ToastQueue(),
				bufferedQueue=new ToastQueue(),
				finishedQueue=new ToastQueue();
		ExecutorService exec=Executors.newCachedThreadPool();
		exec.execute(new Toaster(dryQueue));
		exec.execute(new Butterer(dryQueue,bufferedQueue));
		exec.execute(new Jammer(bufferedQueue,finishedQueue));
		exec.execute(new Eater(finishedQueue));
		TimeUnit.MILLISECONDS.sleep(200);
		exec.shutdownNow();

	}

}
