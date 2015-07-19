package edu.zju.chwl.concurrent;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


public class Memoizer2<A,V> implements Computable<A,V>{

	private final Computable<A,V> c;
	
	public Memoizer2(Computable<A,V> c){
		this.c=c;
	}
	
	private final Map<A,V> cache=new ConcurrentHashMap<A,V>();
	
	
	public V compute(A arg) throws InterruptedException {
		V value=cache.get(arg);
		if(value==null){
			value=c.compute(arg);
			cache.put(arg, value);
		}
		return value;
	}

}
