package edu.zju.chwl.hiho16;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		question2();
	}
	
	public static void question2() {
		System.out.println(gys(2,3));
		System.out.println(gys(8,12));
		System.out.println(gys(5,15));
	}
	
	public static int gys(int a,int b){
		if(a%b==0){
			return b;
		}else{
			return gys(b,a%b);
		}
	}

	/**
	 * p=(a+b+c)/2 s=p(p-a)(p-b)(p-c)
	 */
	public static void question1() {
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

}
