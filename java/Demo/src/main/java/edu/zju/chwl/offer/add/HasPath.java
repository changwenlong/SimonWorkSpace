package edu.zju.chwl.offer.add;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * 矩阵中的路径
 * 
 * 回溯法：变形的DFS
 * @author chwl
 * @Date 2016年4月23日 下午6:06:42
 */
public class HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
    	if(matrix==null||matrix.length==0||matrix.length!=rows*cols||str.length>matrix.length){
    		return false;
    	}
    	boolean[] flags=new boolean[rows*cols];
    	Arrays.fill(flags, false);
    	for(int i=0;i<rows;i++){
    		for(int j=0;j<cols;j++){
    			if(hasPath(matrix,rows,cols,str,flags,i,j,0)){
    				return true;
    			}
    		}
    	}
    	return false;
    }

	private boolean hasPath(char[] matrix, int rows, int cols, char[] str,
			boolean[] flags, int i, int j, int count) {
		if(count==str.length){
			return true;
		}
		int pos=i*cols+j;
		if(i<0||i>=rows||j<0||j>=cols||flags[pos]||matrix[pos]!=str[count]){
			return false;
		}
		flags[pos]=true;
		count++;
		boolean hasPath = hasPath(matrix,rows,cols,str,flags,i-1,j,count)||
				hasPath(matrix,rows,cols,str,flags,i+1,j,count)||
				hasPath(matrix,rows,cols,str,flags,i,j-1,count)||
				hasPath(matrix,rows,cols,str,flags,i,j+1,count);
        if(!hasPath){//别忘了恢复标记，恢复现场
            flags[pos]=false;
        }
        return hasPath;
	}
	
    @Test
    public void test(){
    	char[] matrix = "abcesfcsadee".toCharArray();
		Assert.assertTrue(hasPath(matrix,3,4,"bcced".toCharArray()));
		Assert.assertFalse(hasPath(matrix,3,4,"abcb".toCharArray()));
    }
}
