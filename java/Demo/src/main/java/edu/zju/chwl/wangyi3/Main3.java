package edu.zju.chwl.wangyi3;

import java.util.*;

public class Main3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNextInt()){
			int w = in.nextInt();
			int h = in.nextInt();
			int val=0;
			boolean[][] nums = new boolean[h][w];
			for(int i=0;i<h;i++){
				for(int j=0;j<w;j++){
					if(!nums[i][j]){
						if((i+2)<h) nums[i+2][j]=true;
						if((j+2)<w) nums[i][j+2]=true;
						val++;
					}
				}
			}
			System.out.println(val);
		}
	}
}
/*
 3 2
 */
