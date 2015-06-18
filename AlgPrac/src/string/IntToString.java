package string;

import java.util.Scanner;
/**
 * Convert an integer into a String
 *
 */
public class IntToString {
	
	/**
	 * Convert an integer to a String
	 * @param i the integer to be converted to String
	 * @return a String representation of the input integer
	 */
	public static String intToStr(int i) {
		StringBuilder sb = new StringBuilder();
		while (i != 0) {
			int n = i % 10;
			sb.append(n);
			i = i / 10;
		}
//		sb = sb.reverse();
		String s = sb.substring(0);
		sb = new StringBuilder();
		for (int j = s.length() - 1; j >= 0; j--) {
			sb.append(s.charAt(j));
		}
		s = sb.substring(0);
		return s;
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Integer to String Test ***");
		
		System.out.print("Give an integer that you wanna convert to String type: ");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int input = Integer.parseInt(s);
		System.out.println("Your input as a string should be " + intToStr(input));
	}
}
