package edu.zju.chwl.lintcode.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> triangle=new ArrayList<ArrayList<Integer>>();
		triangle.add(new ArrayList<Integer>(Arrays.asList(2)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(3,4)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(6,5,7)));
		triangle.add(new ArrayList<Integer>(Arrays.asList(4,1,8,3)));
		System.out.println(new Triangle().minimumTotal(triangle));
	}

    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int size=triangle.size();
        int[][] results=new int[size][size];
        for(int i=0;i<triangle.get(size-1).size();i++){
        	results[size-1][i]=triangle.get(size-1).get(i);
        }
        for(int i=size-2;i>=0;i--){
        	for(int j=0;j<triangle.get(i).size();j++){
        		results[i][j]=Math.min(results[i+1][j],results[i+1][j+1])+
        				triangle.get(i).get(j);
        	}
        }
    	return results[0][0];
    }
}
