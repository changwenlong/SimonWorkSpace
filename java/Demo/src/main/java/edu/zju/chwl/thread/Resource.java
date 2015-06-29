package edu.zju.chwl.thread;

/**
 * 多生产者多消费者模式
 * 1.刚开始使用if条件判断，会导致不该运行的线程运行了，出现了数据错误的现象
 * 原因：线程p0进过条件判断，进入等待状态，但p0被唤醒，再次获得执行权时，躲过了if判断，从而数据出错
 * 解决方法：使用while循环判断
 * 2.使用while条件判断，会导致死锁现象
 * 原因：生产者线程p0在正常生产后，唤醒了同为生产者线程的p1
 * 解决方法：使用notifyAll
 * 3.使用notifyAll，解决了死锁现象
 * 原因：notifyAll能保证始终会唤醒对方线程
 * Created by chwl on 2015/6/25.
 */
public class Resource {
    public Resource(String name){
        this.name=name;
    }
    private String name;
    private int count;
    private boolean flag=false;
    //生成方法
    public synchronized void set(){
       while(flag){
            try {this.wait();}catch (InterruptedException e){}
        }
        this.count++;
        System.out.println(Thread.currentThread().getName()+"----produce----" + name + count );
        flag=true;
        this.notifyAll();

    }
    //消费方法
    public synchronized void out(){
        while(!flag){
        	try {this.wait();}catch (InterruptedException e){}
        }
        System.out.println(Thread.currentThread().getName()+"---------consumer---------" + name + count);
        flag=false;
        this.notify();
    }

    public static void main(String[] args) {
        Resource r=new Resource("bread");
        Producer p1=new Producer(r);
        Producer p2=new Producer(r);
        Consumer c1=new Consumer(r);
        Consumer c2=new Consumer(r);
        Thread t1=new Thread(p1);
        Thread t2=new Thread(p2);
        Thread t3=new Thread(c1);
        Thread t4=new Thread(c2);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}

class Producer implements Runnable{
    private Resource resource;
    Producer(Resource resource){
        this.resource=resource;
    }
    public void run() {
        while(true){
            resource.set();
        }
    }
}

class Consumer implements Runnable{
    private Resource resource;
    Consumer(Resource resource){
        this.resource=resource;
    }
    public void run() {
        while (true){
            resource.out();
        }
    }
}
