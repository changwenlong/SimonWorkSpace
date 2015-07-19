package edu.zju.chwl.concurrent;

import java.util.concurrent.*;


public class Memoizer<A,V> implements Computable<A,V>{

	private final Computable<A,V> c;
	
	public Memoizer(Computable<A,V> c){
		this.c=c;
	}
	
	private final ConcurrentMap<A,Future<V>> cache=new ConcurrentHashMap<A,Future<V>>();
	
	public V compute(final A arg) throws InterruptedException {
		Future<V> value=cache.get(arg);
		if(value==null){
			FutureTask<V> valueT=new FutureTask<V>(new Callable<V>(){
		
				public V call() throws Exception {
					return c.compute(arg);
				}
				
			});
			value=cache.putIfAbsent(arg, valueT);
			if(value==null){
				value=valueT;
				valueT.run();
			}			
		}
		V result=null;
		try {
			result=value.get();
		} catch (ExecutionException e) {
			cache.remove(arg);
			e.printStackTrace();
		}
		return result;
	}

}
