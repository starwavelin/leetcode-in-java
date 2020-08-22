package string;

import java.util.Scanner;
/**
 * Convert an integer into a String
 *
 */
public class IntToString {
	
	/**
	 * Convert an integer to a String
	 * @param input: the integer to be converted to String
	 * @return a String representation of the input integer
	 */
	public static String intToStr(int input) {
		StringBuilder sb = new StringBuilder();
		while (input != 0) {
			int n = input % 10;
			sb.append(n);
			input = input / 10;
		}
		String s = sb.substring(0);
		sb = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			sb.append(s.charAt(i));
		}
		s = sb.substring(0);
		return s;
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Integer to String Test ***");
		
		System.out.print("Give an integer that you wanna convert to String type: ");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int input = Integer.parseInt(s);
		System.out.println("Your input as a string should be " + intToStr(input));
	}
}
