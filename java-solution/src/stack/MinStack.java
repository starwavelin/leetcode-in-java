package stack;

import java.util.ArrayDeque;
import java.util.Deque;
/***************************************************************************
* Problem No. : 155
* Problem Name: Min Stack
* Problem URL : https://leetcode.com/problems/min-stack/description/
* Date        : Oct 14 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Design a stack that can do push, pop, peek a typical stack can do, plus a function to getMin()
* 	Assumption:
* 		1. Assume stack stores integers 
* 		2. repeated integers are allowed
* 		3. if no values in the stack, just return Integer.MIN_VALUE;
	Example:
		when i just pushed -3, then top is -3, min is -3;
		then i pushed in -5, then top is -5, min is -5;
		then i pushed in another -5, then top is -5, min is -5;
		then i pushed in 4, then top is 4, but min should still be -5.
		then if i poped out 4, -5, -5, i should have top as -3 and min as -3 too. 
* 	Input: 
* 	Output: 
* 	Data Structure and Alg:
* 		Basic idea is to use two typical stacks, one for data and the other one for keeping min value
* 	sol 1 is when pushing int into the data stack, if that int is also the new min value, push it to min stack as well;
* 		if it is not, then we push the current top of the min stack again if the min stack is not empty.
* 		then when popping, we pop element from both the data stack and the min stack.
* 	sol 2 is when pushing int into the data stack, we only want to push it to min stack as well if the min stack is currently empty,
* 		or this element is less than or equal to the top element in the min stack.
* 		then when popping, we pop the top element from the data stack, and only pop element from min stack if the top of minstack equals the element being poped fomr data stack.
* 	This file presents solution 2.	
* Complexity  : 
* 	Time Complexity: O(1) for push, pop, peek and getMin
* 	Space Complexity: O(n) n--the number of integers need to be put into stacks.
* 
* meta        : tag-stack
***************************************************************************/
public class MinStack {
	
	Deque<Integer> dataS;
	Deque<Integer> minS;
	
	public MinStack() {
		dataS = new ArrayDeque<>();
		minS = new ArrayDeque<>();
	}
	
	public void push(int val) {
		dataS.offerLast(val);
		if (minS.isEmpty() || val <= minS.peekLast()) {
			minS.offerLast(val);
		}
	}
	
	/**
	 * Note at the line of comparing dataS.pollLast() and minS.peekLast(), 
	 * if you directly write dataS.pollLast() == minS.peekLast(), that would not work even it the two integers are equivalent in value,
	 * because these two methods -- pollLast() or peekLast(), return a autoboxed Integer type (object type).
	 * So, you either need to assign dataS.pollLast() to an int variable then do == comparison, 
	 * or use .equals()
	 * I used .equals() cuz it would save me from declaring another variable.
	 */
	public void pop() {
		if (!dataS.isEmpty()) {
			if (dataS.pollLast().equals(minS.peekLast()))
				minS.pollLast();
		}
	}
	
	public int top() {
		if (!dataS.isEmpty()) {
			return dataS.peekLast();
		}	
		return Integer.MIN_VALUE;
	}
	
	public int getMin() {
		if (!minS.isEmpty()) {
			return minS.peekLast();
		}
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's MinStack Test ***");
		MinStack ms = new MinStack();
		
//		ms.push(-3);
//		ms.push(-5);
//		ms.push(-5);
//		ms.push(4);
//		System.out.println("Now the min is " + ms.getMin()); //should be -5
//		
//		ms.pop();
//		System.out.println("Now the min is " + ms.getMin()); //should be -5
//		
//		ms.pop();
//		ms.pop();
//		System.out.println("Now the min is " + ms.getMin()); //should be -3
//		
//		ms.pop();
//		System.out.println("Now the min is " + ms.getMin()); //should be Integer.MIN_VALUE
		
		ms.push(512);
		ms.push(-1024);
		ms.push(-1024);
		ms.push(512);
		
		ms.pop();
		System.out.println("Now the min is " + ms.getMin()); //should be -1024
		ms.pop();
		System.out.println("Now the min is " + ms.getMin()); //should be -1024
		ms.pop();
		System.out.println("Now the min is " + ms.getMin()); //should be 512
	}
	
	/**
	 * The following is the old way of writing it up. We don't need it to be thread-safe so we can use the new way.
	Stack<Integer> s1;	// the stack for push() and pop()
	Stack<Integer> s2;	// the stack for storing the min value
	
	public MinStack() {
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}
	
	public void push(int val) {
		s1.push(val);
		if (s2.isEmpty() || s2.peek() >= val) {
			s2.push(val);
		}
	}
	
	public int pop() {
		int ret = s1.pop();
		if (ret == s2.peek()) {
			s2.pop();
		}
		return ret;
	}
	
	public int getMin() {
		if (s2.isEmpty()) {
			System.out.println("The stack is empty so return -1");
			return -1;
		}
		return s2.peek();
	}
	 */
}
