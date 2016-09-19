package edu.zju.chwl.coder.c11;


import org.junit.Test;

public class FinderIII {
	
    public int[] findElement(int[][] mat, int n, int m, int x) {
        int min = Math.min(n, m);
        if(mat[min-1][min-1]<x&&m>n){
        	return getRight(mat,min-1,min,x);
        }
        
        if(mat[min-1][min-1]<x&&m<n){
        	return getLeft(mat,min,min-1,x);
        }
        
        int index = 0;
        for(int i=0;i<min;i++){
        	if(mat[i][i]>=x){
        		if(mat[i][i]==x){
            		return new int[]{i,i};       			
        		}else{
        			index = i;
        			break;
        		}
        	}
        }
        
        int[] nums = getRight(mat,index-1,index,x);
        if(nums==null){
        	return getLeft(mat,index,index-1,x);
        }else{
        	return nums;
        }
    }

	private int[] getLeft(int[][] mat, int i, int j, int x) {
		if(i>=mat.length||j<0){
			return null;
		}
		if(mat[i][j]==x){
			return new int[]{i,j};
		}else if(mat[i][j]>x){
			return getLeft(mat,i,j-1,x);
		}else{
			return getLeft(mat,i+1,j,x);
		}
	}

	private int[] getRight(int[][] mat, int i, int j, int x) {
		if(i<0||j>=mat[0].length){
			return null;
		}
		if(mat[i][j]==x){
			return new int[]{i,j};
		}else if(mat[i][j]>x){
			return getRight(mat,i-1,j,x);
		}else{
			return getRight(mat,i,j+1,x);
		}
	}
	
    @Test
	public void test() {
    	int[] arr = findElement(new int[][]{{1,2,3},{4,5,6}},2,3,3);
		System.out.println(arr[0]+" "+arr[1]);
    }
}
