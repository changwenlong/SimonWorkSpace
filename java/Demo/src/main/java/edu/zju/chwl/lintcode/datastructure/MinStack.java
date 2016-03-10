package edu.zju.chwl.lintcode.datastructure;

import java.util.Stack;


/**
 * https://leetcode.com/problems/min-stack/
 * 
 * @author chwl
 * @Date 2016年3月6日 上午11:34:37
 */
public class MinStack {

	private Stack<Integer> stack =new Stack<Integer>();
	
	private Stack<Integer> minStack=new Stack<Integer>();
	
    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty()){
        	minStack.push(x);
        }else{
            int value =minStack.peek();
        	minStack.push(value<x?value:x);
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
