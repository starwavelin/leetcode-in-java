package stack;

import java.util.Scanner;
import java.util.Stack;

public class InfixToPostfix {
	
	// stack stores operators only
	Stack<Character> stack = new Stack<Character>();
	
	public String inToPost(String input) {
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			char ch = input.charAt(i);
			if (ch == '(') {
				stack.push('(');
			} else if (ch == ')') {
				char oper = stack.peek();
				while (oper !='(' && !stack.isEmpty()) {
					output += oper;
					stack.pop();
					oper = stack.peek();
				}
				stack.pop();	// pop the '(' which matches ')'
			} else if (ch == '+' || ch == '-') {
				if (stack.isEmpty()) {
					stack.push(ch);
				} else {
					char oper = stack.peek();
					while (!stack.isEmpty() && oper != '(' && oper != ')') {
						stack.pop();
						output += oper;
					}
					stack.push(ch);
				}
			} else if (ch == '*' || ch == '/') {
				if (stack.isEmpty()) {
					stack.push(ch);
				} else {
					char oper = stack.peek();
					while (!stack.isEmpty() && oper != '+' && oper != '-') {
						stack.pop();
						output += oper;
					}
					stack.push(ch);
				}
			} else {
				output += ch;
			}
		}
		while (!stack.isEmpty()) {
			char oper = stack.peek();
			if (oper != '(') {
				stack.pop();
				output += oper;
			}
		}
		return output;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Infix To Postfix Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please type in an infix expression, such as (1+2)*4: ");
		String input = sc.next();
		System.out.println("The infix expression you typed is: " + input);
		
		InfixToPostfix test = new InfixToPostfix();
		System.out.println("The postfix expression after conversion is " + test.inToPost(input));
		
	}
	
}
