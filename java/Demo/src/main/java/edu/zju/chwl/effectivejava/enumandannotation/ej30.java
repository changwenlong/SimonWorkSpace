package edu.zju.chwl.effectivejava.enumandannotation;

import java.util.HashMap;
import java.util.Map;


public class ej30 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double x=6.0,y=2.0;
		for(Operation op:Operation.values()){
			System.out.printf("%.2f %s %.2f = %.2f\n", x,op,y,op.apply(x, y));
		}
	}

	enum Operation {
		PLUS("+") {
			@Override
			double apply(double x, double y) {
				return x + y;
			}
		},
		MINUS("-")
		{
			@Override
			double apply(double x, double y) {
				return x-y;
			}
		},TIMES("*") {
			@Override
			double apply(double x, double y) {
				return x * y;
			}
		},DIVIDE("/") {
			@Override
			double apply(double x, double y) {
				return x / y;
			}
		};
		
		private final String symbol;

		Operation(String symbol) {
			this.symbol = symbol;
		}

		@Override
		public String toString() {
			return this.symbol;
		}

		abstract double apply(double x, double y);
		
		private static final Map<String,Operation> stringToEnum = new HashMap<String,Operation>();
		
		static{
			for(Operation op : Operation.values()){
				stringToEnum.put(op.toString(), op);				
			}
		}
		
		public static Operation getEnum(String symbol){
			return stringToEnum.get(symbol);
		}
	}

}
