package edu.zju.chwl.concurrent;

import java.util.*;


public class Memoizer1<A,V> implements Computable<A,V>{

	private final Computable<A,V> c;
	
	public Memoizer1(Computable<A,V> c){
		this.c=c;
	}
	
	private final Map<A,V> cache=new HashMap<A,V>();
	
	
	public synchronized V compute(A arg) throws InterruptedException {
		V value=cache.get(arg);
		if(value==null){
			value=c.compute(arg);
			cache.put(arg, value);
		}
		return value;
	}

}
