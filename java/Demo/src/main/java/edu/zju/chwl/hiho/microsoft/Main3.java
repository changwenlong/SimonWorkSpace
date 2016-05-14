package edu.zju.chwl.hiho.microsoft;

import java.util.Scanner;

public class Main3 {
	public static void main(String[] args) {
		p3();
	}
	
	public static void p3(){
    	try(Scanner in = new Scanner(System.in)){
    		int n= in.nextInt();
    		int m = in.nextInt();
    		in.nextLine();
    		boolean[][] grid = new boolean[n][m];
    		int[][] matrix = new int[n][m];
    		for(int i=0;i<n;i++){
    			String line = in.nextLine();
    			for(int j=0;j<m;j++){
    				if(line.charAt(j)=='b'){
    					grid[i][j]=true;
    				}else{
    					grid[i][j]=false;
    				}    				
    			}
    		}
    		if(grid[0][0]){
    			matrix[0][0]=1;
    		}else{
    			matrix[0][0]=0;
    		}
    		run(0,0,true,grid,n,m,matrix);
    		System.out.println(matrix[n-1][m-1]);;
    	}
        
    }

	private static void run(int row, int column, boolean direction, boolean[][] grid, int n, int m,int[][] matrix) {
		if(row==n-1&&column==m-1){
			return;
		}
		if(direction){//true:right
			if(column==m-1){
				run(row,column,false,grid,n,m,matrix);
			}
			for(int i=column;i<m-1;i++){
				if(grid[row][i+1]){
					matrix[row][i+1]=matrix[row][column]+1;
					run(row,i+1,true,grid,n,m,matrix);
					if(row!=n-1){
						matrix[row+1][i]=matrix[row][column];
						if(grid[row+1][i]){
							matrix[row+1][i]++;
						}
						run(row+1,i,false,grid,n,m,matrix);
					}
					break;
				}
			}
		}else{//false:bottom
			if(row==n-1){
				run(row,column,true,grid,n,m,matrix);
			}
			for(int i=row;i<n-1;i++){
				if(grid[i+1][column]){
					matrix[i+1][column]=matrix[row][column]+1;
					run(i+1,column,false,grid,n,m,matrix);
					if(column!=m-1){
						matrix[i][column+1]=matrix[row][column];
						if(grid[i][column+1]){
							matrix[i][column+1]++;
						}
						run(i,row+1,true,grid,n,m,matrix);
					}
					break;
				}
			}
		}
		
	}
}
