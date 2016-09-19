package edu.zju.chwl.huawei;

import java.util.*;

/**
 * 回溯法实现
 * @author chwl
 * @Date 2016年5月23日 下午9:32:29
 */
public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[][] nums = new int[9][9];
		int[] rows = new int[9];
		int[] columns = new int[10];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				int num = in.nextInt();
				nums[i][j] = num;
				if (num != 0) {
					rows[i] = rows[i] | (1 << (num - 1));
					columns[j] = columns[j] | (1 << (num - 1));
				} else {
					nums[i][j] = num;
				}
			}
		}

		shudu(nums, rows, columns, 0, 0);
	}
	
	static boolean flag=true;

	private static void shudu(int[][] nums, int[] rows, int[] columns, int i,
			int j) {
		if(i>8||j>8){
			if(!flag) return;
			for (int i1 = 0; i1 < 9; i1++) {
				for (int j1 = 0; j1 < 9; j1++) {
					if (j1 != 0) {
						System.out.print(" ");
					}
					System.out.print(nums[i1][j1]);
				}
				System.out.println();
			}
			flag=false;
			return;
		}
		if (nums[i][j] != 0){
			if(j==8){
				shudu(nums,rows,columns,i+1,0);
			}else{
				shudu(nums,rows,columns,i,j+1);				
			}
		}else{
			for (int k = 0; k < 9; k++) {
				if ((rows[i] & (1 << k)) == 0 && (columns[j] & (1 << k)) == 0) {
					nums[i][j] = k + 1;
					rows[i] = rows[i] | (1 << k);
					columns[j] = columns[j] | (1 << k);
					if(j==8){
						shudu(nums,rows,columns,i+1,0);
					}else{
						shudu(nums,rows,columns,i,j+1);				
					}
					nums[i][j]=0;
					rows[i] = rows[i] & ~(1 << k);
					columns[j] = columns[j] & ~(1 << k);
				}
				
			}
		}


	}

}
