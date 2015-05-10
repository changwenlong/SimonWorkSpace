package edu.zju.chwl;

public class Node {
	private int value;
	private Node leftchild = null;
	private Node rightchild = null;

	// public Node(){}

	/*
	 * public Node(){
	 * 
	 * leftchild = new Node<T>(); rightchild = new Node<T>(); }
	 */

	public void setValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public Node getLeftChild() {
		// leftchild = new Node();
		return leftchild;
	}

	public Node getRightChild() {
		// rightchild =new Node();
		return rightchild;
	}

	public void setLeftChild(Node t) {
		this.leftchild = t;
	}

	public void setRightChild(Node t) {
		this.rightchild = t;
	}	
	
}
