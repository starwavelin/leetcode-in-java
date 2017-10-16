package stack;

import java.util.Queue; //In Java, Queue is an interface
import java.util.LinkedList;
/***************************************************************************
* Problem No. : 225
* Problem Name: Implement Stack Using Queues
* Problem URL : https://leetcode.com/problems/implement-stack-using-queues/description/
* Date        : Oct 14 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Design a stack using queues only
* 	Assumption:
* 		1. integer elements
	Example:
		
* 	Input: 
* 	Output: 
* 	Data Structure and Alg:
* 		Using two queues, one is dataQ which is for pushing elements in and keeping tracking of the top of the stack;
*  the other one is helpQ, which is for pop. 
*  The core part is when popping, we wanna swap the reference of dataQ and helpQ, then remove the only element of
*  helpQ to finish the popping. empty() checking is only focus on dataQ.
* 			
* Complexity  : 
* 	Time Complexity: O(1) for push, peek and empty; O(n) for pop.
* 	Space Complexity: O(n) n--the number of integers need to be put into stacks.
* 
* meta        : tag-stack; tag-queue
***************************************************************************/
public class StackUsingQueues {
	public static class MyStack {
		private Queue<Integer> dataQ;
		private Queue<Integer> helpQ;
		private int topElement;
		
		/** Initialize your data structure here. */
	    public MyStack() {
	    	dataQ = new LinkedList<>();
	    	helpQ = new LinkedList<>();
	    }
	    
	    /** Push element x onto stack. */
	    public void push(int x) {
	        dataQ.offer(x);
	        topElement = x;
	    }
	    
	    /** Removes the element on top of the stack and returns that element. */
	    public int pop() {
	        while(dataQ.size() > 1) {
	        	/* we need to update topElement in pop method!!!*/
	        	topElement = dataQ.poll();
	        	helpQ.offer(topElement);
	        }
	        Queue tmp = dataQ;
	        dataQ = helpQ;
	        helpQ = tmp;
	        return helpQ.poll();
	    }
	    
	    /** Get the top element. */
	    public int top() {
	    	return topElement;
	    }
	    
	    /** Returns whether the stack is empty. */
	    public boolean empty() {
	        return dataQ.isEmpty();
	    }	
	}
	
	public static void main(String[] args) {
		MyStack stack = new MyStack();
		stack.push(1);
		stack.push(3);
		stack.push(5);
		System.out.println("pop one element, I got: " + stack.pop()); // 5
		System.out.println("Now the peak is : " + stack.top()); // 3
		stack.push(-12);
		System.out.println("Now the peek is: " + stack.top()); // -12
	}
}
