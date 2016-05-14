package edu.zju.chwl.hiho.microsoft;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		p2();
	}
	
	public static void p2(){
    	try(Scanner in = new Scanner(System.in)){
    		int n= in.nextInt();
    		int m= in.nextInt();
    		in.nextLine();
    		int[][] allow=new int[n][4];
    		boolean[] isAllow=new boolean[n];
    		int a=0;
    		for(int i=0;i<n;i++){
    			String line = in.nextLine();
    			if(line.startsWith("allow")){
    				setArray(allow[a],line.substring(6));
    				isAllow[a]=true;
    			}else{
    				setArray(allow[a],line.substring(5));
    				isAllow[a]=false;
    			}
    			a++;
    		}
    		for(int i=0;i<m;i++){
    			String[] strs = in.nextLine().split("\\.");
    			int[] nums=new int[strs.length];
    			for(int j=0;j<strs.length;j++){
    				nums[j]=Integer.valueOf(strs[j]);
    			}
    			boolean flag=true;
    			for(int j=0;j<a;j++){
    				if(match(nums,allow[j])){
    					flag=false;
    					if(isAllow[j]){
    						System.out.println("YES");
    					}else{
    						System.out.println("NO");
    					}    					
    					break;
    				}
    			}
    			if(flag){
    				System.out.println("YES");
    			}
    			
    		}
    	}
        
    }

	private static boolean match(int[] nums, int[] match) {
		for(int i=0;i<match.length;i++){
			if((nums[i]&match[i])!=match[i]){
				return false;
			}
		}
		return true;
	}

	private static void setArray(int[] arr, String substring) {
		String[] strs=substring.split("\\.");
		if(substring.contains("/")){
			String[] ss=strs[3].split("/");
			int port=Integer.valueOf(ss[1]);
			strs[3]=ss[0];
			int i=0;
			for(;i<port/8;i++){
				arr[i]=Integer.valueOf(strs[i]);
			}
			int bits=port%8;
			arr[i]=Integer.valueOf(strs[i])&(256-(int)Math.pow(2, 8-bits));
			i++;
			for(;i<4;i++){
				arr[i]=0;
			}
			
		}else{
			for(int i=0;i<4;i++){
				arr[i]=Integer.valueOf(strs[i]);
			}
		}
		
	}
}
