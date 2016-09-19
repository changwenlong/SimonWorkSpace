package edu.zju.chwl.coder.c5;

import org.junit.Test;

public class BinInsert {
	
    public int binInsert(int n, int m, int j, int i) {
        int cc=i-j+1;
        return ((~(((1<<cc)-1)<<j))&n)|(m<<j);
    }
    
    @Test
    public void test(){
    	System.out.println(binInsert(1024, 19, 2, 6));
    }
    
}
