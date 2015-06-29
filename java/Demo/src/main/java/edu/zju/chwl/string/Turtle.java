package edu.zju.chwl.string;

import java.util.Formatter;
/**
 * @author chwl
 * @Date 2015年5月30日 下午8:31:08
 * 格式化输出：java.util.Formatter的format方法也可以完成格式化输出
 */
public class Turtle {
	
	private String name;
	private Formatter f;
	
	public Turtle(String name,Formatter f) {
		this.name=name;
		this.f=f;
	}

	public static void main(String[] args) {
		//参数是PrintStream
		Formatter format=new Formatter(System.err);
		Turtle t=new Turtle("Tommy", format);
		t.move(5);
		t.move(10);

	}

	private void move(int i) {
		f.format("%s moves %d step(s)\n",name,i);
		
	}

}
