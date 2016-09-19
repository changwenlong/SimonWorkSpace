package edu.zju.chwl.coder.c9;

import java.util.Arrays;

import org.junit.Test;

public class Robot {
	/**
	 * dp
	 * f[i][j]:到(i,j)的所有走法
	 * 初始值:f[0][j]=1 f[i][0]=1
	 * 推导：f[i][j]=f[i-1][j]+f[i]f[j-1]
	 * 结果：f[x-1][y-1]
	 * @param x
	 * @param y
	 * @return
	 */
    public int countWays(int x, int y) {
        int[][] f=new int[x][y];
        Arrays.fill(f[0], 1);
        for(int i=0;i<x;i++){
        	f[i][0]=1;
        }
        for(int i=1;i<x;i++){
        	for(int j=1;j<y;j++){
        		f[i][j]=f[i-1][j]+f[i][j-1];
        	}
        }
        return f[x-1][y-1];
    }
    
    public int countWays(int[][] map, int x, int y) {
        long[][] f=new long[x][y];
        for(int i=0;i<y;i++){
        	if(map[0][i]!=1) break;
        	f[0][i]=1;
        }
        for(int i=0;i<x;i++){
        	if(map[i][0]!=1) break;
        	f[i][0]=1;
        }
        for(int i=1;i<x;i++){
        	for(int j=1;j<y;j++){
        		if(map[i][j]!=1){
        			map[i][j]=0;
        			continue;
        		}
        		f[i][j]=(f[i-1][j]+f[i][j-1])%1000000007;
        	}
        }
        return (int)f[x-1][y-1];
    }
    
    @Test
    public void test(){
    	System.out.println(countWays(1, 11));
    }
}
