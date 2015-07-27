package stack;

/**
 * This is a stack implemented using array
 */

public class Stack {
	
	int[] array;
	int size;
	int top; 		// pointer always points to the top element of the stack
	public final int arraySize = 30; // 30 a hard-coded size of the array. 
	
	public Stack() {
		array = new int[arraySize];	
		size = 0;	// size of the stack
		top = -1;
	}
	
	public void push(int val) {
		if (size == arraySize) {
			System.out.println("The size of the stack is full, "
					+ " you cannot push elements into it any more.");
			return;
		}
		array[++top] = val;
		size++;
	}
	
	public int pop() {
		if (top == -1) {
			System.out.println("Sorry but no elements in the stack"
					+ " for you to pop...");
			return -1;
		}
		int val = array[top--];
		size--;
		return val;
	}
	
	public int getTop() {
		return array[top];
	}
	
	public void displayStack() {
		System.out.print("{");
		for (int i = 0; i < size - 1; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.print(array[size - 1]);
		System.out.print("}\n");
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's "
				+ " Stack implemented by Array Test ***");
		Stack stack = new Stack();
		
		stack.push(3);
		stack.push(8);
		stack.push(5);
		
		stack.displayStack();
		
		stack.pop();
		stack.displayStack();
	}
}
