package edu.zju.chwl.huawei;

import java.util.*;

public class Main7 {	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n=in.nextInt();
			int m=in.nextInt();
			int[] scores=new int[n];
			for (int i = 0; i < n; i++) {
				scores[i] = in.nextInt();
			}
			for(int i=0;i<m;i++){
				char op = in.next().charAt(0);
				if(op=='Q'){
					System.out.println(getMax(scores,in.nextInt(),in.nextInt()));
				}
				if(op=='U'){
					scores[in.nextInt()-1]=in.nextInt();
				}
			}
		}			
	}

	private static int getMax(int[] scores, int a, int b) {
		int i=Math.min(a, b);
		int j=Math.max(a, b);
		int max=scores[i-1];
		for(int k=i;k<j;k++){
			max=Math.max(max, scores[k]);
		}
		return max;
	}

}
