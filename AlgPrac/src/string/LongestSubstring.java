package string;

import java.util.Arrays;
import java.util.Scanner;

/***************************************************************************
* Problem No. : 3
* Problem Name: Longest Substring Without Repeating Characters
* Problem URL : https://leetcode.com/problems/longest-substring-without-repeating-characters/
* Date        : Oct 18 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given a string, find the length of the longest substring without repeating characters.
* 	Assumption:
* 		1. What's the definition of substring? Consecutive characters!!! 
* 			See the 3rd example for the difference between "substring" and "subsequence".
* 		2. Can input be an empty string? Yes, then its length will be 0
* 		3. What character can be there in this string? Lower case characters only (a - z). 
	Example:
* 	Input/Output: Given "abcabcbb", the answer is "abc", which the length is 3.
* 		Given "bbbbb", the answer is "b", with the length of 1.	
* 		Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, 
* 			"pwke" is a subsequence and not a substring.
* 	Data Structure and Alg:
* 		@needOrganize  
* Complexity  : 
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
* 
* meta        : tag-string, tag-hash, tag-array-map
***************************************************************************/
public class LongestSubstring {
	/**
	 * Quick ref of ASCII table: http://www.asciitable.com/
	 * 
	 */
	public static int lengthOfLongestSubstring1(String s) {
		int[] charMap = new int[256]; //size of extended ASCII
		Arrays.fill(charMap, -1);
		int i = 0, maxLen = 0;
		for (int j = 0; j < s.length(); j++) {
			if (charMap[s.charAt(j)] >= i) {
				i = charMap[s.charAt(j)] + 1;
			}
			charMap[s.charAt(j)] = j;
			maxLen = Math.max(j - i + 1, maxLen);
		}
		return maxLen;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's Longest Substring without Repeating Characters Test ***");
		System.out.print("Give a String : ");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println("The length of the longest substring without repeating characters is " + lengthOfLongestSubstring1(s));
	}
}