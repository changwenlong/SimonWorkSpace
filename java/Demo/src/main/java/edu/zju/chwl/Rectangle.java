package edu.zju.chwl;

abstract class Shape{
	abstract public int getArea();
}

public class Rectangle extends Shape {
	public Rectangle(int width,int height) {
		this.width=width;
		this.height=height;
	}
	private int width;
	private int height;
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	@Override
	public int getArea() {
		return width*height;
	}
	
}
