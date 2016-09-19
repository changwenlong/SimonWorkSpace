package edu.zju.chwl.wangyi;

import java.util.*;

public class Main9 {

	public static void main(String[] args) {
		String a ="q"+"qw";
		String b = new String(a);
		System.out.println(a=="qqw");
		System.out.println(a.equals(b));
		
		Scanner in = new Scanner(System.in);
		while(in.hasNext()){
			int n = in.nextInt();
			int m = in.nextInt();
			int[][] matrix = new int[n][m];
			for(int i = 0;i<n;i++){
				for(int j=0;j<m;j++){
					matrix[i][j] = in.nextInt();
				}
			}
			if(n<4||m<4){
				System.out.println(0);
				return;
			}
			
		}
	}

}
