package arraysAndStrings;

import java.util.Scanner;

/**
 * ReverseWords version I,
 * using String array and inversely loop the array
 * 
 * O(n) time O(n) space:
 * this is a two-pass solution, 
 * 1st split the input string into a string array
 * 2nd extract the words in the reversed order from the array
 * @author Benjamin Lin
 *
 */
public class ReverseWordsI {
	
	public static String reverseWords(String s) {
		// Three boundary checking cases
		if (s == null) {
			return null;
		}
		s = s.trim();
		if (s.equals("")) {
			return "";
		}
		if (!s.contains(" ")) {
			return s;
		}
		
		String[] tmp = s.split("\\s+");
		String ret = "";
		for (int i = tmp.length - 1; i > 0; i--) {
			ret += tmp[i] + " ";
		}
		ret += tmp[0];
		
		return ret;
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Reverse Words Version I Test ***");
		
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
