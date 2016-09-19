package edu.zju.chwl.coder.c9;

import org.junit.Test;

public class Queens {
    public int nQueens(int n) {
        int y=0;
        int major=0;
        int minor=0;
        nQueens(0,y,major,minor,n);
        return count;
    }

    int count=0;
	private void nQueens(int row,int y, int major, int minor,int n) {
		if(row==n){
			count++;
		}
		for(int i=0;i<n;i++){
			int yBit = y&(1<<i);
			int majorBit = major&(1<<(i-row+n));
			int minorBit = minor&(1<<(i+row));
			if(yBit==0&&majorBit==0&&minorBit==0){
				yBit = y|(1<<i);
				majorBit = major|(1<<(i-row+n));
				minorBit = minor|(1<<(i+row));
				nQueens(row+1,yBit,majorBit,minorBit,n);
			}
		}		
	}
	
	@Test
	public void test() {
		System.out.println(nQueens(10));;
	}
}
