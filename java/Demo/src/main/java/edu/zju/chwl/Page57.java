package edu.zju.chwl;

//引用类型(不可变的引用类型[8个基本类的包装类+String]除外)与基本类型
public class Page57 {
	private StringBuilder name;
	private int age;
	public StringBuilder getName() {
		return name;
	}
	public void setName(StringBuilder name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return String.format("name:%s\nage:%d", name,age);
	}
	
}

class Obj{
	private String str="default value";
	private int i=0;
	public void setStr(String str){
		this.str=str;
	}
	public void setI(int i){
		this.i=i;
	}
	@Override
	public String toString(){
		return str+":"+i;
	}
}

class TestObj{
	private Obj obj=new Obj();
	public Obj getObj(){
		return obj;
	}
	public void changeObj(Obj o){
		o.setI(1);
		o.setStr("changed value");
	}
}
