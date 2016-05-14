package edu.zju.chwl.coder.c3;

import java.util.Stack;
/**
 * 汉诺塔问题
 * @author chwl
 * @Date 2016年5月12日 下午10:54:56
 */
public class MoveDisks {
	public static void main(String[] args) {
		Stack<Integer> origin=new Stack<Integer>();
		int n=6;
		for(int i=n;i>0;i--){
			origin.push(i);
		}
		Stack<Integer> dest=new Stack<Integer>();
		Stack<Integer> buffer=new Stack<Integer>();
		moveDisks(n,origin,dest,buffer);
		System.out.println(dest);
	}
	
	private static void moveDisks(int n,Stack<Integer> origin,Stack<Integer> dest,Stack<Integer> buffer){
		if(n<=0) return;
		//将顶端的n-1个盘子从origin移动到buffer，将dest当做缓冲区
		moveDisks(n-1,origin,buffer,dest);
		//将origin顶端的盘子移动到dest
		dest.push(origin.pop());
		//将顶端的n-1个盘子从buffer移动到dest，将origin当做缓冲区
		moveDisks(n-1,buffer,dest,origin);
	}
}


