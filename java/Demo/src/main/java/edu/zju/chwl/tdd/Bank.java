package edu.zju.chwl.tdd;

import java.util.HashMap;

public class Bank {
	
	public Money reduce(Expression source,String to){
		return source.reduce(this,to);
	}
	
	public HashMap<Pair,Integer> rates = new HashMap<Pair,Integer>();
	
	public void addRate(String from,String to,int rate){
		rates.put(new Pair(from,to), rate);
	}
	
	public int rate(String from,String to){
		if(from.equals(to)){
			return 1;
		}
		return rates.get(new Pair(from,to));
	}
	
	class Pair{
		private String from;
		private String to;
		Pair(String from,String to){
			this.from=from;
			this.to=to;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((from == null) ? 0 : from.hashCode());
			result = prime * result + ((to == null) ? 0 : to.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			Pair pair = (Pair) obj;
			return pair.from.equals(from)&&pair.to.equals(to);
		}
	}
}
