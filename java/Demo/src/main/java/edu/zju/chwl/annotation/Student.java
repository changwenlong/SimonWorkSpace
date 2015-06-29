package edu.zju.chwl.annotation;

@DBTable(name="student")
public class Student {
	@SQLInteger(constraints=@Constraints(primaryKey=true,allowNull=false))
	private int id;
	@SQLString(value=30)
	private String name;
	@SQLInteger
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getId() {
		return id;
	}
	
}
