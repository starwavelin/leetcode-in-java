package sorting;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;


/***************************************************************************
* Problem No. : 
* Problem Name: Stack Sort
* Problem URL : 
* Date        : Oct 29 2017
* Author	  :	@codingbro
* Notes       : 
* 	Scenario: 
* 		Sort a given stack in ascending order such that the largest element is on the top
* 	Assumption:
* 		1. You may use one additional help stack 
* 		2. Duplicate elements are allowed, but it doesn't matter
	Example:
* 	Input: [4， 2， 3， 1]  assume top is on the right end
* 	Output: 
* 		[1, 2, 3, 4]
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-stack, tag-sort
***************************************************************************/
public class StackSort {

	/**
	 * Solution 1: use Stack class to simply illustrate the logic
	 * 	We have two stacks: the input stack s and the help stack helpS.
	 * While s is not empty
	 * 	When helpS is empty, push one element from s into helpS.
	 * 	For the remaining elements in s, 
	 * 		while the one popped from s is greater than the peek of helpS, 
	 * 			push peek of helpS into s,
	 * 			then push the popped element from s into helpS
	 * 		if the one popped from s is less than or equal to the peek of helpS, 
	 * 			directly push this popped element into helpS  
	 * while s is empty, which means helpS is already sorted in the reverse order,
	 * 	we push all the elements from helpS into s one by one. 
	 * 
	 * Space Complexity: O(n)
	 * Time Complexity: O(n^2) cuz for each element popped from s, it may need to compare (n-1), (n-2), (n-3) ... elements 
	 * 	already in helpS, so the comparison takes time O(n^2)
	 */
	public static void sort1(Stack<Integer> s) {
		if (s == null || s.isEmpty()) {
			return;
		}
		Stack<Integer> helpS = new Stack<>();
		while (!s.isEmpty()) {
			if (helpS.isEmpty()) {
				helpS.push(s.pop());
			} else {
				int element = s.pop();
				while (!helpS.isEmpty() && element > helpS.peek()) { //坑: helpS could be empty after its element(s) being pushed into s, so
					s.push(helpS.pop());
				}
				helpS.push(element);
			}
		}
		while (!helpS.isEmpty()) {
			s.push(helpS.pop());
		}
	}
	
	/**
	 * Rewrite Solution 1 using industry standard -- using ArrayDeque to simulate Stack. 
	 * only offerLast() pollLast() and peekLast() methods used for ArrayDeque.
	 * Related Q: 这个问题像汉诺塔问题
	 */
	public static void sort2(Deque<Integer> s) {
		if (s == null || s.isEmpty()) {
			return;
		}
		Deque<Integer> helpS = new ArrayDeque<>();
		while (!s.isEmpty()) {
			if (helpS.isEmpty()) {
				helpS.offerLast(s.pollLast());
			} else {
				int element = s.pollLast();
				while (!helpS.isEmpty() && element > helpS.peekLast()) {
					s.offerLast(helpS.pollLast());
				}
				helpS.offerLast(element);
			}
		}
		while (!helpS.isEmpty()) {
			s.offerLast(helpS.pollLast());
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<>();
		s.push(4);
		s.push(2);
		s.push(3);
		s.push(1);
		sort1(s);
		System.out.println("After the Stack Sort, the Stack S becomes: " 
				+ s.pop() + " " + s.pop() + " " + s.pop() + " " + s.pop()); // 4 3 2 1
		
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(13);
		stack.push(5);
		stack.push(9);
		stack.push(6);
		sort2(stack);
		System.out.println("After the Stack Sort, the Stack S becomes: " 
				+ stack.pollLast() + " " + stack.pollLast() + " " + stack.pollLast() + " " + stack.pollLast()); // 13 9 6 5
	}
}
