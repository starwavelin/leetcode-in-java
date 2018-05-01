package stack;

import java.util.ArrayDeque;
import java.util.Deque;
/***************************************************************************
* Problem No. : 
* Problem Name: Max Stack
* Problem URL : 
* Date        : Oct 14 2017
* Author	  :	Xian Lin
* Notes       : 
* 	This problem is just a transformation of Min Stack.
* The only part we want to change is 
* 	when pushing, we want the value being pushed is greater than or equal to the peek of the max stack, 
* then we push it to the max stack
* For fun, I rewrote it using ArrayDeque
* 
* meta        : tag-stack
***************************************************************************/
public class MaxStack2 {
	
	Deque<Integer> dataS;
	Deque<Integer> maxS;
	
	public MaxStack2() {
		dataS = new ArrayDeque<>();
		maxS = new ArrayDeque<>();
	}
	
	public void push(int x) {
		dataS.offerLast(x);
		if (maxS.isEmpty() || x >= maxS.peekLast())
			maxS.offerLast(x);
	}
	
	public void pop() {
		if (!dataS.isEmpty()) {
			if (dataS.pollLast().equals(maxS.peekLast()))
				maxS.pollLast();
		}
	}
	
	public int peek() {
		if (!dataS.isEmpty()) {
			return dataS.peekLast(); 
		}
		return Integer.MIN_VALUE;
	}
	
	public int getMax() {
		if (!maxS.isEmpty()) {
			return maxS.peekLast(); 
		}
		return Integer.MIN_VALUE;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's MaxStack Test ***");
		MaxStack2 ms = new MaxStack2();
		
		ms.push(19);
		ms.push(3);
		ms.push(6);
		ms.push(28);
		ms.push(17);
		System.out.println("Now the max is " + ms.getMax()); //should be 28
		
		ms.pop();
		System.out.println("Now the max is " + ms.getMax()); //should be 28
		
		ms.pop();
		System.out.println("Now the max is " + ms.getMax()); //should be 19
		
		MaxStack2 ms2 = new MaxStack2();
		ms2.push(16);
		ms2.push(32);
		ms2.push(32);
		ms2.push(16);
		
		ms2.pop();
		System.out.println("Now the max is " + ms2.getMax()); //should be 32
		ms2.pop();
		System.out.println("Now the max is " + ms2.getMax()); //should be 32
		ms2.pop();
		System.out.println("Now the max is " + ms2.getMax()); //should be 16
	}
	
	/**
	 * private Stack<Integer> s1;
	private Stack<Integer> s2; // store max values
	
	public MaxStack() {
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
	}
	
	public void push(int num) {
		s1.push(num);
		if (s2.isEmpty() || s2.peek() <= num) {
			s2.push(num);
		}
	}
	
	public int pop() {
		int ret = s1.pop();
		if (ret == s2.peek()) {
			s2.pop();
		}
		return ret;
	}
	
	public int getMax() {
		return s2.peek();
	}
	 */
}
