package stack;

import java.util.LinkedList;


/***************************************************************************
* Problem No. : 
* Problem Name: 
* Problem URL : 
* Date        : Oct 15 2017
* Author	  :	@codingbro
* Notes       : 
* 	Scenario: 
* 1. Use Array to implement a stack
* 2. Use LinkedList to implement a stack 
* 	
* 
* meta        : tag-stack
***************************************************************************/
public class Stack {
	/**
	 * @author xianlin
	 * StackI uses array to implement a stack
	 */
	public static class StackI {
		private int[] array; 
		private int size;
		private int top;	//top pointer always points to the top element of the stack
		private final int MAX_SIZE = 5;	
		
		public StackI() {
			array = new int[MAX_SIZE];
			size = 0;
			top = -1; //initialize top to the first invalid position of the array, which is -1
		}
		
		public void push(int val) {
			if (size >= MAX_SIZE) {
				System.out.println("The stack is full and you cannot push items into it anymore..");
				return;
			}
			array[++top] = val;
			size++;
		}
		
		public int pop() {
			if (size == 0) {
				System.out.println("There is nothing to pop...");
				return Integer.MIN_VALUE;
			}
			size--;
			return array[top--];
		}
		
		public int peek() {
			return array[top];
		}
		
		public void displayStack() {
			System.out.println("Stack is: ");
			/* when displaying stack, we only display those elements up to size */
			for (int i = 0; i < size; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
		}
	}
	
	/**
	 * @author xianlin
	 * Let's review what methods provided by LinkedList API that may benefit our case
	 * offerLast, pollLast, peekLast
	 * 	
	 */
	public static class StackII {
		LinkedList<Integer> ll;
		
		public StackII() {
			ll = new LinkedList<>();
		}
		
		public void push(int val) {
			ll.offerLast(val);
		}
		
		public Integer pop() {
			return ll.pollLast();
			
			/* The following is wrong answer, why?
			 * Even if ll.pollLast() is not null, pollLast() will be executed twice
			 * one in the if condition checking, and the other one in the return statement.
			if (ll.pollLast() == null)
				return Integer.MIN_VALUE;
			return ll.pollLast();
			*/
		}
		
		public Integer peek() {
			return ll.peekLast();
		}
		
		public void displayStack() {
			System.out.println("Stack is: ");
			for (int val : ll) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Stack implemented by Array Test ***");
		
		/* Test stack implemented via array */
//		StackI stack1 = new StackI();
//		
//		stack1.push(3);
//		stack1.push(8);
//		stack1.push(5);
//		stack1.push(1027);
//		stack1.push(-988);
//		stack1.push(544);
//		
//		stack1.displayStack();
//		
//		stack1.pop();
//		stack1.displayStack();
//		
//		stack1.pop();stack1.pop();stack1.pop();stack1.pop();
//		stack1.displayStack();
//		
//		stack1.pop();
//		stack1.displayStack();
		/* Test stack implemented via linkedlinst */
		
		StackII stack2 = new StackII();
		stack2.push(1378);
		stack2.push(0);
		stack2.push(-97);
		stack2.displayStack();
		stack2.pop(); stack2.pop();
		stack2.displayStack();
		System.out.println("The peek is " + stack2.peek());
		stack2.pop();
		stack2.displayStack();
		System.out.println("The peek is " + stack2.peek());
	}
}
