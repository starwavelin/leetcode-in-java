package stack;

import java.util.ArrayDeque;
import java.util.Deque;

/***************************************************************************
* Problem No. : 232
* Problem Name: Implement Queue Using Stacks
* Problem URL : https://leetcode.com/problems/implement-queue-using-stacks/description/
* Date        : Oct 14 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Design a queue using stacks only, you should implement a queue's push, pop, peek and empty methods 
* 	Assumption:
* 		1. integer elements
	Example:
		
* 	Input: 
* 	Output: 
* 	Data Structure and Alg:
* 		Using two stacks, one is for pushing only and the other one is for popping only.
* 	When do we pour all elements from pushStack into popStack?
* 	1. when there are elements within popStack, we do NOT pour elements from pushStack into it.
* 	2. when pouring elements from pushStack to popStack, make sure you pour all elements from pushStack into it.
* 	3. IF you follow the 2 rules above, you can encapsulate the action of pouring elements from pushStack to popStack in
* 	peek() and pop(), or peek() and push(). It is totally your call.
* 			
* Complexity  : 
* 	Time Complexity: O(1) for push, pop, peek and empty
* 	Space Complexity: O(n) n--the number of integers need to be put into stacks.
* 
* meta        : tag-stack; tag-queue
***************************************************************************/
public class QueueUsingStacks {
	public static class MyQueue {
		/* Again, we wanna use ArrayDeque to simulate Stack, best practice in Java 
		 * Deque is an interface 
		 * 	Interface Deque<E>
		 * */
		Deque<Integer> pushStack;
		Deque<Integer> popStack;
		
		/** Initialize your data structure here. */
	    public MyQueue() {
	    	pushStack = new ArrayDeque<>();
	    	popStack = new ArrayDeque<>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        pushStack.offerLast(x);
	    }
	    
	    /** 
	     * when pop(),
	     * 	if there is any element in popStack, pop that element;
	     * 	if not, pour first then pop from popStack
	     * 
	     * Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        if (this.empty()) {
	        	return Integer.MIN_VALUE; //If no elements in the queue, pop MIN_VALUE
	        }
	        if (popStack.isEmpty()) {
	        	pour();
	        }
	        return popStack.pollLast();
	    }
	    
	    /** 
	     * when peek(),
	     * 	if there is any element in popStack, peek that element;
	     * 	if not, pour first then peek the top element from popStack 
	     * 
	     * Get the front element. */
	    public int peek() {
	    	if (this.empty()) {
	        	return Integer.MIN_VALUE; //If no elements in the queue, peek MIN_VALUE
	        }
	    	if (popStack.isEmpty()) {
	    		pour();
	    	}
	        return popStack.peekLast();
	    }
	    
	    private void pour() {
	    	while(!pushStack.isEmpty()) {
	    		popStack.offerLast(pushStack.pollLast());
	    	}
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return pushStack.isEmpty() && popStack.isEmpty();
	    }
	}
	
	public static void main (String[] args) {
		MyQueue q = new MyQueue();
		
		/*
		q.push(1);
		q.push(4);
		q.push(7);
		System.out.println("When popping elements from the queue, we are expecting: "
				+ q.pop() + " " + q.pop() + " " + q.pop()); // 1 4 7
		
		q.push(5);
		q.push(6);
		q.push(8);
		System.out.println("When popping two elements from the queue, we are expecting: "
				+ q.pop() + " " + q.pop()); // 5 6
		
		q.push(15);
		q.push(30);
		q.push(45);
		System.out.println("When popping two elements from the queue, we are expecting: "
				+ q.pop() + " " + q.pop()); // 8 15
		
		System.out.println("Then peek the queue, we get: " + q.peek()); // 30
		*/
		
		q.push(1);
		q.push(2);
		System.out.println("Then peek the queue, we get: " + q.peek()); // 1
		
	}
}