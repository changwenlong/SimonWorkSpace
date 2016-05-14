package edu.zju.chwl.hiho.microsoft;

import java.util.Scanner;

public class Main1 {
	public static void main(String[] args) {
		p1();
	}
	
	public static void p1(){
    	try(Scanner in = new Scanner(System.in)){
    		int t= in.nextInt();
    		for(int i=0;i<t;i++){
    			int n=in.nextInt();
    			int p = in.nextInt();;
    			int w=in.nextInt();;
    			int h=in.nextInt();
    			int[] nums=new int[n];
    			for(int j=0;j<n;j++){
    				nums[j]=in.nextInt();;
    			}
    			int s=1;
    			for(;;s++){
    				int row=p*(h/s);
        			int column= w/s;
        			for(int num:nums){
        				int use = num/column;
        				if(num%column!=0){
        					use++;
        				}
        				row-=use;
        			}
        			if(row<0){
        				System.out.println(s-1);
        				break;
        			}
    			}
    		}
    	}
        
    }
}
