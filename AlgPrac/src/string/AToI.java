package string;

import java.util.Scanner;


/***************************************************************************
* Problem No. : 8
* Problem Name: String to Integer (atoi)
* Problem URL : https://leetcode.com/problems/string-to-integer-atoi/description/
* Date        : May 2, 2018
* Author      : Xian Lin
* Notes       :
* 	Scenario:
* 		Convert a string into an integer
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
* meta        : tag-string, tag-math
***************************************************************************/
public class AToI {
	
	// Integer.MAX_VALUE = 2147483647  the last digit of this number is 7
	
	private static final int maxDiv10 = Integer.MAX_VALUE / 10;
	
	public static int atoi(String str) {
		int i = 0;
		str = str.trim();
		int n = str.length();
		int sign = 1; // sign = 1 represents "+"
		if (i < n && str.charAt(i) == '+') {
			i++;
		} else if (i < n && str.charAt(i) == '-') {
			sign = -1;
			i++;
		}
		int num = 0;
		while (i < n && Character.isDigit(str.charAt(i))) {
			int digit = Character.getNumericValue(str.charAt(i));
			
			// overflow handling
			if (num > maxDiv10 || num == maxDiv10 && digit >= 8) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			num = num * 10 + digit;
			i++;
		}
		return sign * num;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's String to Integer Test ***");
		
		System.out.print("Give a String that you wanna convert to int type: ");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		System.out.println("Your input as an integer should be " + atoi(s));
	}
	
}
