package edu.zju.chwl.singleton;

//静态内部类
public class Singleton3 {
	private Singleton3(){}
	
	private static class SigletonHolder {
		private static final Singleton3 instance = new Singleton3();
	}
	
	public static Singleton3 getInstance(){
		return SigletonHolder.instance;
	}
}