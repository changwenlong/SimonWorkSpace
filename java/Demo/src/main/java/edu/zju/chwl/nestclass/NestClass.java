package edu.zju.chwl.nestclass;

public class NestClass {
	
	public static void main(String[] args){
		LinkedHashMap hashMap = new LinkedHashMap();
		hashMap.printEntry();
	}
}

class HashMap{
	
	Entry entry;
	
	HashMap(){
		entry = new Entry();
	}
	
	public void printEntry(){
		entry.print();
	}
	
	class Entry{
		public void print(){
		}
	}
}

class LinkedHashMap extends HashMap{
	
	LinkedHashMap(){
		super();
	}
	
	Entry header = new Entry();		
	
	class Entry extends HashMap.Entry{
		public void print(){
			System.out.println("LinkedHashMap.Entry");
		}
	}
}
