package edu.zju.chwl.array;



public class TestCountingGenerator {

	public static void main(String[] args) {
		int len = 10;
		for (Class<?> clazz : CountingGenetator.class.getClasses()) {
			System.out.print(clazz.getSimpleName() + ":");
			try {
				Generator<?> generator;
				if(clazz.isInstance(new CountingGenetator.String())){
					generator=(Generator<?>)clazz.getDeclaredConstructor(int.class).newInstance(4);
				}else{
					generator = (Generator<?>) clazz.newInstance();
				}
				for (int i = 0; i < len; i++) {
					System.out.print(generator.next() + " ");
				}
				System.out.println();
			} catch (Exception e) {
				throw new RuntimeException();
			}
		}

	}

}
