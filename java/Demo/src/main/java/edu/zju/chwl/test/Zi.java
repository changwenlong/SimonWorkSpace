package edu.zju.chwl.test;

public class Zi extends Fu {

	Zi(String name) {

		super(name);

//		System.out.println("Zi");

	}

	// 此时创建�?类对象时，�?用值

	static String aa = "chang";

	Zi() {

		super(aa);

	}

	@Override
	public String toString() {

		// TODO Auto-generated method stub

		return name;

	}

	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {

		// TODO Auto-generated method stub

		System.out.println(new Zi());

	}

}

class Fu {

	String name;

	Fu(String name) {

		this.name = name;

//		System.out.println("Fu");

	}

	@Override
	public String toString() {

		// TODO Auto-generated method stub

		return name;

	}

}
