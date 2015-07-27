package stack;

import java.util.Stack;

public class MaxStack {
	
	private Stack<Integer> s1;
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
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's "
				+ " MaxStack Test ***");
		MaxStack ms = new MaxStack();
		
		ms.push(19);
		ms.push(3);
		ms.push(6);
		ms.push(28);
		ms.push(17);
		System.out.println("Now the max is " + ms.getMax());
		
		ms.pop();
		System.out.println("Now the max is " + ms.getMax());
		
		ms.pop();
		System.out.println("Now the max is " + ms.getMax());
	}
	
}
