package edu.zju.chwl;

//clone 浅复制
public class Page58 implements Cloneable{
	private int age;
	private String name="chang";
	private StringBuffer sex=new StringBuffer("male");
	public StringBuffer getSex() {
		return sex;
	}
	public void setSex(StringBuffer sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	protected Object clone(){
		Object o=null;
		try{
			o=super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return o;
	}
	@Override
	public String toString() {
		return String.format("name:%s;age:%d;sex:%s", name,age,sex);
	}
	
	public void changeName(){
		this.name="changed name";
	}
	public void changeSex(){
		this.sex.append(" female");
	}
	public void changeAge(){
		this.age=100;
	}
	
}
