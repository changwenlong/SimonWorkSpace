package edu.zju.chwl.jmm;

public class PossibleRecordering {
	static int x=0,y=0;
	static int a=0,b=0;
	
	public static void main(String[] args) throws InterruptedException {
		while(true){
			doOperate1();
		}

	}
	
	public static void doOperate() throws InterruptedException{
		
		Thread one = new Thread(new Runnable(){
			@Override
			public void run() {
				a=1;
				x=b;				
			}
			
		});
		
		Thread other = new Thread(new Runnable(){
			@Override
			public void run() {
				b=1;
				y=a;
			}
			
		});
		
		one.start();
		other.start();
		one.join();
		other.join();
		if(x==0&&y==0){
			System.out.println(true);
			System.out.println("("+x+","+y+")");
		}
		x=0;y=0;
		a=0;b=0;
	}

	public static void doOperate1() throws InterruptedException{
		boolean flag = false;
		int c=0;
		if(flag){//控制依赖性，采用猜测执行来克服控制相关性对并行度的影响
			c=1;
		}
		if(c==1){
			System.out.println(c);			
		}
	}
}
