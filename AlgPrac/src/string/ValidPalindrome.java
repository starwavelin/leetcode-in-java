package string;

import java.util.Scanner;

/**
 * https://leetcode.com/problems/valid-palindrome/
 * in other words "a ba" is a palindrome cuz we only consider
 * alphabets and digits; the space doesn't cause it to be a non-palindrome.
 * that's also why we have to put the while(i < j) outside of 
 * bypass non-letter-digit character steps.
 */
public class ValidPalindrome {
	
	/**
	 * consider only alphanumeric characters
	 * O(n) runtime O(1) space
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		// speical case
		if (s == null) return false;
		if (s == "") return true;
		
		int i = 0, j = s.length() - 1;
		while (i < j) {
			// bypass non-letter characters
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			
			// core algorithm
			if (Character.toLowerCase(s.charAt(i))
					!= Character.toLowerCase(s.charAt(j))) {
				return false;
			}
			i++; j--;
		}
		return true;
		
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Valid Palindrome Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your string: ");
		String s = sc.nextLine();
		
		boolean ret = isPalindrome(s);
		System.out.println("The statement that the given string " + s
				+ " is a palindrome is " + ret);
	}
	
}
