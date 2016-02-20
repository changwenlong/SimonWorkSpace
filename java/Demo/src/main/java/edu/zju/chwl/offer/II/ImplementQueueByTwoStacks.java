package edu.zju.chwl.offer.II;

import java.util.Stack;

public class ImplementQueueByTwoStacks {

    private Stack<Integer> stack1=new Stack<Integer>();
    private Stack<Integer> stack2=new Stack<Integer>();

    public ImplementQueueByTwoStacks() {
       // do initialization if necessary
    }
    
    public void push(int element) {
        stack1.push(element);
    }

    public int pop() {
        if(stack2.isEmpty()){
        	while(!stack1.isEmpty()){
        		stack2.push(stack1.pop());
        	}
        }
        return stack2.pop();
    }

    public int top() {
    	if(stack2.isEmpty()){
        	while(!stack1.isEmpty()){
        		stack2.push(stack1.pop());
        	}
        }
        return stack2.peek();
    }
}
