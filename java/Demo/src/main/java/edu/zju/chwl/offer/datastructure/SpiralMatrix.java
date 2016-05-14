package edu.zju.chwl.offer.datastructure;

import java.util.*;

import org.junit.*;

/**
 * https://leetcode.com/problems/spiral-matrix/
 * http://www.lintcode.com/en/problem/spiral-matrix/
 * @author a590450
 * @date 25 Mar 2016 15:15:48
 */
public class SpiralMatrix {
	
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(matrix==null||matrix.length==0){
        	return list;
        }
        int rowCount = matrix.length;
        int columnCount = matrix[0].length;
        printSpiral(list,matrix,rowCount,columnCount,0);
        return list;
    }
    
    private void printSpiral(List<Integer> list,int[][] matrix,int rowCount,int columnCount,int index){
    	if(rowCount<=0||columnCount<=0){
    		return;
    	}
    	for(int j=index;j<index+columnCount;j++){
    		list.add(matrix[index][j]);
    	}
    	for(int i=index+1;i<index+rowCount;i++){
    		list.add(matrix[i][index+columnCount-1]);
    	}
    	//注意rowCount为1的情况
    	for(int j=index +columnCount-2;j>=index && rowCount>1;j--){
    		list.add(matrix[index+rowCount-1][j]);
    	}
    	//注意columnCount为1的情况
    	for(int i =index+rowCount-2;i>index && columnCount>1;i--){
    		list.add(matrix[i][index]);
    	}
    	printSpiral(list,matrix,rowCount-2,columnCount-2,index+1);
    }
    
    @Test
    public void spiralOrder42(){
    	Assert.assertEquals("[1, 2, 4, 6, 8, 7, 5, 3]",spiralOrder(new int[][]{{1,2},{3,4},{5,6},{7,8}}).toString());
    }
    
    @Test
    public void spiralOrder24(){
    	Assert.assertEquals("[1, 2, 3, 4, 8, 7, 6, 5]",spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8}}).toString());
    }
    
    @Test
    public void spiralOrder33(){
    	Assert.assertEquals("[1, 2, 3, 6, 9, 8, 7, 4, 5]",spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}).toString());
    }
    
    @Test
    public void spiralOrder12(){
    	Assert.assertEquals("[2, 3]",spiralOrder(new int[][]{{2,3}}).toString());
    }
    
    @Test
    public void spiralOrder21(){
    	Assert.assertEquals("[2, 3, 4]",spiralOrder(new int[][]{{2},{3},{4}}).toString());
    }
    
}
