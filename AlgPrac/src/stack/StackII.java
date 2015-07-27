package stack;

import java.util.LinkedList;

/**
 * Stack implemented using LinkedList
 *
 */

public class StackII {
	
	LinkedList<Integer> ll;
	
	public StackII() {
		ll = new LinkedList<Integer>();
	}
	
	public void push(int val) {
		ll.addLast(val);
	}
	
	public int pop() {
		return ll.removeLast();
	}
	
	public int getTop() {
		return ll.getLast();
	}
	
	public void displayStack() {
		System.out.print("{");
		for (int k : ll) {
			System.out.print(k + ", ");
		}
		System.out.print("}\n");
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's "
				+ " Stack implemented by LinkedList Test ***");
		Stack stack = new Stack();
		
		stack.push(2);
		stack.push(7);
		stack.push(4);
		
		stack.displayStack();
		
		stack.pop();
		stack.displayStack();
	}
}
