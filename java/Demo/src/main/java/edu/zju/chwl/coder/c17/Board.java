package edu.zju.chwl.coder.c17;

import org.junit.Test;

public class Board {
    public boolean checkWon(int[][] board) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int line = 0;
        int reLine=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i][j]==1){
                   rows[i] |= (1<<j);
                   cols[j] |= (1<<i);
                   if(i==j||(i+j)==2){
                       line |= (1<<i);
                       reLine |= (1<<i);
                   }
                }
            }
        }
        for(int i=0;i<3;i++){
            if(rows[i]==7||cols[i]==7){
                return true;
            }
        }
        if(line==7||reLine==7) return true;
        return false;
    }
    
	@Test
	public void test(){
		System.out.println(checkWon(new int[][]{{-1,1,-1},{0,0,1},{0,0,0}}));
	}
	
}
