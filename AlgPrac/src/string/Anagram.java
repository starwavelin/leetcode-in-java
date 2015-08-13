package string;

import java.util.Arrays;
import java.util.Scanner;
/**
 * Determine if two words are anagrams
 * 
 * http://www.lintcode.com/en/problem/two-strings-are-anagrams/
 */
public class Anagram {
	
	/**
	 * This method uses API methods like Arrays.sort()
	 * 	and toCharArray();
	 * @param s: input String1
	 * @param t: input String2
	 * @return true if the two strings are anagrams otherwise return false
	 */
	public static boolean anagram1(String s, String t) {
		if (s == null && t == null) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		
		char[] s1 = s.toCharArray();
		char[] t1 = t.toCharArray();
		
		Arrays.sort(s1);
		Arrays.sort(t1);
		
		int size = s1.length;
		for (int i = 0; i <size; i++) {
			if (s1[i] != t1[i]) {
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean anagram2(String s, String t) {
		return false;
	}
	
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Anagram Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input a string please: ");
		String s = sc.next().trim();
		System.out.print("Input another string please: ");
		String t = sc.next().trim();
		
		boolean result = anagram1(s, t);
		if (result) {
			System.out.println("The given " + s + " and " + t + " are anagrams.");
		} else {
			System.out.println("The given two strings are Not anagrams!");
		}
	}
}
