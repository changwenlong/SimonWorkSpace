package edu.zju.chwl.concurrent;

public interface Computable<A,V>{
	V compute(A arg) throws InterruptedException;
} 
