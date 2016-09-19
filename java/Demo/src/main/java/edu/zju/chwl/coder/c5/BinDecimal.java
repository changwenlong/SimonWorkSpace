package edu.zju.chwl.coder.c5;

import org.junit.Test;

public class BinDecimal {
    public String printBin(double num) {
    	if(num>=1||num<=0){
    		return "Error";
    	}
    	StringBuilder sb = new StringBuilder();
    	sb.append(0).append(".");
    	while(num>0){
    		num*=2;
    		if(sb.length()>=32){
    			return "Error";
    		}
    		if(num>=1){
    			sb.append(1);
    			num-=1;
    		}else{
    			sb.append(0);
    		}
    	}
    	return sb.toString();
	}
    
    @Test
    public void test(){
    	System.out.println(printBin(0.625));
    }
}
