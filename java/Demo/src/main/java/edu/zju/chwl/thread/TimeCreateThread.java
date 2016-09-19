package edu.zju.chwl.thread;

public class TimeCreateThread {

	public static void main(String[] args) {
		long a = System.currentTimeMillis();
		new Thread(new Runnable(){
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		});
		System.out.println(System.currentTimeMillis()-a);
	}

}
