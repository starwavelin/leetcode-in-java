package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/***************************************************************************
* Problem No. : 716
* Problem Name: Max Stack
* Problem URL : https://leetcode.com/problems/max-stack/description/
* Date        : May 1, 2018
* Author      : Xian Lin
* Notes       :
* 	Scenario:
* 		
* 	Assumption:
* 		
	Example:
* 	Input/Output:
* 		
* 	Data Structure and Alg:
* 		see code comments
* Complexity  :
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
*
* meta        : tag-stack, tag-data-structure
***************************************************************************/
public class MaxStack {
	Deque<Integer> stack;
	Deque<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack() {
        stack = new ArrayDeque<>();
		maxStack = new ArrayDeque<>();
    }
    
    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peek();
		maxStack.push(max > x ? max : x);
		stack.push(x);
    }
    
    public int pop() {
        maxStack.pop();
		return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = peekMax();
		Stack<Integer> buffer = new Stack();
		while (top() != max) {
            buffer.push(pop());
        }	
		pop();
		while (!buffer.isEmpty()) {
            push(buffer.pop());
        }	
		return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */