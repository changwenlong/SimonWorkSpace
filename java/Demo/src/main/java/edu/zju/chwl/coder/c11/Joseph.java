package edu.zju.chwl.coder.c11;

import java.util.Arrays;

import org.junit.Test;

public class Joseph {
    public int getResult(int n, int m) {
       	int leave = n;
        boolean[] flag = new boolean[n];
        Arrays.fill(flag, true);
        int count = 1;
        int index = 0;
        while(leave>1){
            if(flag[index]){
                if(count==m){
                    flag[index]=false;
                    leave--;
                    count = 1;
                }else{
                    count++;                   
                }
            }           
            index = (index+1)%n;
        }
        int ret = 0;
        for(int i=0;i<n;i++){
            if(flag[i]){
                ret = i+1;
            }
        }
        return ret;
    }
    
    public int getResult(int n) {
       	int leave = n;
        boolean[] flag = new boolean[n];
        Arrays.fill(flag, true);
        int times = 1;
        int count = 1;
        int index = 0;
        int temp = 0;
        while(leave>1){
        	index = temp;
        	count=1;
        	int size=leave;
            for(int i=0;i<size;i++){
            	while(!flag[index]){
            		index = (index+1)%n;
            	}
            	if(count!=1){
            		flag[index]=false;
            		leave--;
            	}else{
            		temp =index;
            	}
        		index = (index+1)%n;
        		count = count%(times+1)+1;
            }
            times++;
        }
        int ret = 0;
        for(int i=0;i<n;i++){
            if(flag[i]){
                ret = i+1;
            }
        }
        return ret;
    }
    
	@Test
	public void test() {
		System.out.println(getResult(5,3));
		System.out.println(getResult(210));
	}
}
