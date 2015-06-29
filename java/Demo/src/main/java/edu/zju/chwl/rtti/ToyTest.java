package edu.zju.chwl.rtti;

public class ToyTest {

	public static void main(String[] args) {
		try {
			Class c=Class.forName("edu.zju.chwl.rtti.FancyToy");
			printInfo(c);
			for(Class item:c.getInterfaces()){
				printInfo(item);
			}
			printInfo(c.getSuperclass());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	private static void printInfo(Class c) {
		System.out.format("Class name:%s is a interface? [%s]\n"
				+ "Simple name:%s\nCanonical name:%s\n", c.getName(),c.isInterface()
				,c.getSimpleName(),c.getCanonicalName());
		
	}

}

interface HasBatteries{}
interface Waterproof{}
interface Shoots{}
class Toy{
	Toy(){}
	Toy(int i){}
}

class FancyToy extends Toy implements HasBatteries,Waterproof,Shoots{
	public FancyToy() {
		super(1);
	}
}