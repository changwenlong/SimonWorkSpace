package edu.zju.chwl.lintcode.graphsearch;

import java.util.*;

/**
 * http://www.lintcode.com/en/problem/n-queens/
 * 
 * @author a590450
 * @date 10 Mar 2016 15:23:12
 */
public class NQueens {

	public static void main(String[] args) {
		System.out.println(new NQueens().solveNQueens(4));
	}

	
	
	/**
	 * 使用位运算来实现
	 * 对于点（x,y）
	 * y方向上的bit mask就是y
	 * diagonal方向上所有点的y-x值一致，为保证bit mask为正，使用y-x+(n-1)
	 * anti-diagonal方向上所有的点x+y值一致，bit mask使用x+y
	 * @param n
	 * @return
	 */

	public ArrayList<ArrayList<String>> solveNQueens(int n) {
		if (n == 0) {
			return null;
		}
		ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
		char[] charArr = new char[n];
		Arrays.fill(charArr, '.');
		String str = String.valueOf(charArr);
		bitDFS(0,0,0,0,n,results,new ArrayList<Integer>(),str);
		return results;
	}

	private void bitDFS(int x, int y, int diag, int antiDiag, int n,ArrayList<ArrayList<String>> results, ArrayList<Integer> list,String str) {
		if(x==n){
			results.add(getStringList(list, n, str));
			return;
		}
		for(int i=0;i<n;i++){
			boolean yMask = ((1<<i)&y)==0;
			boolean diagMask = ((1<<(n-1+x-i))&diag)==0;
			boolean antiDiagMask =((1<<(x+i))&antiDiag)==0;
			if(yMask&&diagMask&&antiDiagMask){
				list.add(i);
				bitDFS(x+1,y|(1<<i),diag|(1<<(n-1+x-i)),antiDiag|(1<<(x+i)),n,results,list,str);
				list.remove(list.size()-1);
			}
		}		
	}
	
	private ArrayList<String> getStringList(ArrayList<Integer> list, int n, String str) {
		ArrayList<String> strList = new ArrayList<String>();
		for (Integer i : list) {
			strList.add(str.substring(0, i) + 'Q' + str.substring(i+1));
		}
		return strList;
	}

}
