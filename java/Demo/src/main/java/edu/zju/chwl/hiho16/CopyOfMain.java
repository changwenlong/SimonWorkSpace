package edu.zju.chwl.hiho16;

import java.util.Scanner;

public class CopyOfMain {

	public static void main(String[] args) {
		question1();
	}

	/**
	 * p=(a+b+c)/2 s=p(p-a)(p-b)(p-c)
	 */
	public static void question1() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int t = in.nextInt();
			for (int i = 0; i < t; i++) {
				int sum = 0;
				double a = -1, b = -1, c = -1;
				double d=0;
				for (int j = 0; j < 4; j++) {
					int value = in.nextInt();
					if (j < 3) {
						if (value > c) {
							a = b;
							b = c;
							c = value;

						} else if (value > b) {
							a = b;
							b = value;
						} else {
							a = value;
						}
					}
					d=value;
					sum += value;
				}
				double p = (double) sum / 2;
				double avg = (double) sum / 3;
				if(avg>c){
					a=b=c=avg;
				}else if((a+b+d)/2>b){
					a=b=(a+b+d)/2;
				}else{
					a+=d;
				}
				System.out.format("%.10f\n",
						Math.sqrt(p * (p - a) * (p - b) * (p - c)));
			}
		}
	}

	public static void question2() {

	}

	public static void question3() {

	}

	public static void question4() {

	}

	public static void getInput() {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println(a + b);
		}
	}

}
