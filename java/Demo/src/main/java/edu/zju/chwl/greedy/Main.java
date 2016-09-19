package edu.zju.chwl.greedy;

import java.util.Scanner;


public class Main{
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int s = in.nextInt();
            int l = in.nextInt();
            int count = (l+1)/(s+1);
            count = Math.min(n, count);
            if(count%13==0){
                count--;
            }
            int sum = n/count;
            int yu = n%count;
			if(yu!=0){
            	sum++;
            	if(yu%13==0&&(count-yu)==1){//查看最后最后一张专辑的情况
            		sum++;
            	}
            }
            System.out.println(sum);
        }
    }
}