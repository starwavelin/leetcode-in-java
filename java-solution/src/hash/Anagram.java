package hash;

import java.util.Arrays;
import java.util.Scanner;

/***************************************************************************
* Problem No. : 242
* Problem Name: Valid Anagram
* Problem URL : https://leetcode.com/problems/valid-anagram/description/
* Date        : Oct 26 2017
* Author      :	Xian Lin
* Notes       :
* 	Scenario:
* 		@needOrganize
* 	Assumption:
*
	Example:
* 	Input/Output:
*
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  :
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments
*
* meta        : tag-hash, tag-array-map, tag-bloomberg
***************************************************************************/
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

	/**
	 * Use an integer array to count the appearance of characters
	 * in the two given strings. If there is an unmatched character,
	 * its corresponding cell in the integer array would have value -1,
	 * which we return false immediately
	 * @param s: given string s1
	 * @param t: given string s2
	 * @return true if they are anagrams; false otherwise.
	 */
	public static boolean anagram2(String s, String t) {
		if (s == null && t == null) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}

		int[] count = new int[256];
		int size = s.length();
		for (int i = 0; i < size; i++) {
			count[(int) s.charAt(i)]++;
		}
		for (int i = 0; i < size; i++) {
			count[(int) t.charAt(i)]--;
			if (count[(int) t.charAt(i)] < 0) {
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		System.out.println("*** Welcome to Coding Bro's Anagram Test ***");

		Scanner sc = new Scanner(System.in);
		System.out.print("Input a string please: ");
		String s = sc.next().trim();
		System.out.print("Input another string please: ");
		String t = sc.next().trim();

		boolean result = anagram2(s, t);
		if (result) {
			System.out.println("The given " + s + " and " + t + " are anagrams.");
		} else {
			System.out.println("The given two strings are Not anagrams!");
		}
	}
}
