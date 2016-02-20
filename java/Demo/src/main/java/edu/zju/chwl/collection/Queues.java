package edu.zju.chwl.collection;

import java.util.*;

public class Queues {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int count=10;
		Queue<Person> q=new PriorityQueue<Person>();
		//SortedSet<Person> q=new TreeSet<Person>();
		Gen gen=new Gen();
		for(int i=0;i<count;i++){
			q.add(gen.next());
		}
		System.out.println(q);
	}

}



class Gen{
	String[] students={"changwenlong","changlongwen","wenlongchang","wenchanglong","longchangwen","longwenchang"};
	Random random=new Random();
	public Person next(){
		int index=random.nextInt(6);
		System.out.println(index);
		return new Person(students[index],index+20);
	}
}

class Person implements Comparable<Person>{
	private String name;
	private int age;
	Person(String name,int age){
		this.name=name;
		this.age=age;
	}
	@Override
	public String toString(){
		return this.name+":"+this.age;
	}
	@Override
	public int compareTo(Person o) {
		// TODO Auto-generated method stub
		return this.name.compareTo(o.name);
	}
}