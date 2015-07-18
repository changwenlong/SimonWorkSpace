package edu.zju.chwl.thread;

public abstract class IntGenerator {
	private volatile boolean canceled=false;
	public abstract int next();
	public void cancel(){canceled=true;}
	public boolean iscanceled(){return canceled;}
}
