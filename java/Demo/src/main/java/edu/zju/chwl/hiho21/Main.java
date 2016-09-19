package edu.zju.chwl.hiho21;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			double[] ps = new double[n];
			for(int i=0;i<n;i++){
				ps[i]=(double)in.nextInt()/1000;
			}
			helper(0,0,ps,1-ps[0],1);
			helper(0,1,ps,ps[0],1);
			System.out.println(sum);
		}

	}
	
	private static void helper(int pos, int val, double[] ps, double p,int len) {
		if(val==1){
			if(pos==ps.length-1){
				sum+=(p*len);
			}else{
				sum=sum+(p*(1-ps[pos+1]))*(len);
				helper(pos+1,1,ps,p*ps[pos+1],len+1);
			}
		}else{
			if(pos==ps.length-1){
				sum+=(p*len);
			}else{
				helper(pos+1,0,ps,p*(1-ps[pos+1]),len+1);
				helper(pos+1,1,ps,p*ps[pos+1],len+1);
			}
		}
		
	}

	static double sum = 0.0;

}
