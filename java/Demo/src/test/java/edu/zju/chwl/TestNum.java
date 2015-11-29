package edu.zju.chwl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class TestNum {
	// ①通过匿名内部类覆盖ThreadLocal的initialValue()方法，指定初始值
	private static ThreadLocal<Integer> seqNum = new ThreadLocal<Integer>() {
		public Integer initialValue() {
			return 0;
		}
	};

	// ②获取下一个序列值
	public int getNextNum() {
		seqNum.set(seqNum.get() + 1);
		return seqNum.get();
	}

	public static void main(String[] args) throws IOException {
		/*TestNum sn = new TestNum();
		// ③ 3个线程共享sn，各自产生序列号
		TestClient t1 = new TestClient(sn);
		TestClient t2 = new TestClient(sn);
		TestClient t3 = new TestClient(sn);
		t1.start();
		t2.start();
		t3.start();*/
		BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
		r.readLine();
		int value=getElement(new int[]{88, 459, 5262, 88, -17, 677, 88, 667, -17, 459, 5262});
		System.out.println(new Integer(2)==new Integer(2));
		System.out.println(Integer.valueOf(2)==Integer.valueOf(2));
		System.out.println("12"==new String("12"));
	}

	private static class TestClient extends Thread {
		private TestNum sn;

		public TestClient(TestNum sn) {
			this.sn = sn;
		}
		public void run() {
			for (int i = 0; i < 3; i++) {
				// ④每个线程打出3个序列值
				System.out.println("thread[" + Thread.currentThread().getName() + "] --> sn["
						 + sn.getNextNum() + "]");
			}
		}
	}
	
	public static int getElement(int[] intArr){
	    Arrays.sort(intArr);
	    int result = 0;
	    for(int i=0;i<intArr.length;i+=2){
	        if(i==intArr.length-1||intArr[i]!=intArr[i+1]){
	            result=intArr[i];
	            break;
	        }
	    }
	    return result;
	}
}
