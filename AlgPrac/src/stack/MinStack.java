package stack;

import java.util.Stack;

public class MinStack {
	
	
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
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's "
				+ " MinStack Test ***");
		MinStack ms = new MinStack();
		
		ms.push(7);
		ms.push(10);
		ms.push(12);
		ms.push(3);
		System.out.println("Now the min is " + ms.getMin());
		
		ms.pop();
		System.out.println("Now the min is " + ms.getMin());
		
		ms.pop();
		System.out.println("Now the min is " + ms.getMin());
	}
	
}
