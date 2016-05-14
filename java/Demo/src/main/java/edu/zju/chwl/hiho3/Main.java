package edu.zju.chwl.hiho3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		p2();
	}
	
	public static void p2(){
    	try(Scanner in = new Scanner(System.in)){
    		long n= in.nextLong();
    		long m = in.nextLong();
    		int size = 1000000+100;
    		boolean[] zi = new boolean[size];
    		zi[2] = false;
    		for(int i=2;i<size;i++){
    			if(!zi[i]){
    				for(int j=i+i;j<size;j=j+i){
        				zi[j]=true;
        			}
    			}
    		}
    		int[] result = new int[size];
    		int count=0;
    		for(int i=2;i<size;i++){
    			if(!zi[i]){
    				result[count++]=i;
    			}
    		}    		
    		long x =getMaxYue(m,n);
    		int a = getNumber(m,result,count);
    		int b = getNumber(n,result,count);
    		int c = getNumber(x,result,count);
    		x=getMaxYue(a*b, c);
    		System.out.print(a*b/x+" "+c/x);    		
    	}        
    }

	private static int getNumber(long m, int[] result, int count) {
		int num=1;
		for(int i=0;i<count;i++){
			int value=result[i];
			long c=0;
			while(m%value==0){
				c++;
				m/=value;
			}
			num*=(c+1);
		}
		if(m>result[count-1]){
			return num*2;
		}
		return num;
	}

	private static long getMaxYue(long m, long n) {
		if(n==0){
			return m;
		}
		return getMaxYue(n, m%n);
	}

	public static void p1(){
    	try(Scanner in = new Scanner(System.in)){
    		int n= in.nextInt();
    		int[] nums = new int[n];
    		int pos =1;
    		for(int i=0;i<n;i++){
    			nums[i]=in.nextInt();
    			if(i!=0&&nums[i]<nums[i-1]){
    				pos=i;
    			}
    		}
    		for(int i=0;i<pos;i++){
    			if(i!=0){
    				System.out.print(" ");
    			}
    			System.out.print(nums[i]);
    		}
    	}
        
    }
}
