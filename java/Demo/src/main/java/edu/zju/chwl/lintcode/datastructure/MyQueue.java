package edu.zju.chwl.lintcode.datastructure;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * https://leetcode.com/problems/implement-queue-using-stacks/
 * @author chwl
 * @Date 2016年3月6日 上午11:12:46
 */
public class MyQueue {

	private Stack<Integer> inStack = new Stack<Integer>();

	private Stack<Integer> outStack = new Stack<Integer>();

	// Push element x to the back of queue.
	public void push(int x) {
		inStack.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		tranfer();
		if (!outStack.isEmpty()) {
			outStack.pop();
		} else {
			throw new EmptyStackException();
		}
	}

	// Get the front element.
	public int peek() {
		tranfer();
		if (!outStack.isEmpty()) {
			return outStack.peek();
		} else {
			throw new EmptyStackException();
		}
	}

	private void tranfer() {
		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
	}

	// Return whether the queue is empty.
	public boolean empty() {
		if (outStack.isEmpty() && inStack.isEmpty()) {
			return true;
		}
		return false;
	}

}
