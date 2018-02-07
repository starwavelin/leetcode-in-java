package stack;

import java.util.ArrayDeque;
import java.util.Deque;


public class ValidParentheses {
	
	/**
	 * Enum all the case of invalidity and return false, 
	 * then see if the stack will be empty (meaning matches and no parentheses left).
	 * 
	 * 3 cases:
	 * 	不匹配，右多，左多。
	 */
	public boolean isValid(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
				stack.push(s.charAt(i));
			} else {
				if (stack.isEmpty() 
						|| (s.charAt(i) == ')' && stack.peek() != '(') 
						|| (s.charAt(i) == ']' && stack.peek() != '[')
						|| (s.charAt(i) == '}' && stack.peek() != '{') ) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}

}
