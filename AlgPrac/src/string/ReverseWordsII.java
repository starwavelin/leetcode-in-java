package string;

import java.util.Scanner;


/**
 * ReverseWords version I,
 * words may have leading or trailing space
 * using String array and inversely loop the array
 * 
 * O(n) time O(n) space:
 * this is a one-pass solution, 
 * Keep tracking a word's begin and end position,
 * when we are at the beginning of a word, 
 * we append it.
 * 
 * This solution requires String.substring(i, j); 
 * the result doesn't contain leading/trailing spaces
 * @author Benjamin Lin
 *
 */
public class ReverseWordsII {
	
	public static String reverseWords(String s) {
		String ret = "";
		int j = s.length();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || s.charAt(i - 1) == ' ') {
				if (ret.length() != 0) {
					ret += " ";
				}
				ret += s.substring(i, j);
			}
		}
		
		return ret;		
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Reverse Words Version II Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your string array, \n" +
				"leave each word by space: ");
		String strs = sc.nextLine();
		
		String result = reverseWords(strs);
		if (result != null) {
			System.out.print("The reversed words are " + result);
		} else {
			System.out.print("Please check your input string!");
		}
	}
	
	
}
