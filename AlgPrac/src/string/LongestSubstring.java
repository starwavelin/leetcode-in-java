package string;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * Longest Substrign without repeating characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 *
 */
public class LongestSubstring {
	
	public static int lengthOfLongestSubstring(String s) {
		int[] charMap = new int[256];
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
		System.out.println("*** Welcome to Ben's "
				+ " Longest Substring without Repeating Characters Test ***");
		
		System.out.print("Give a String : ");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		
		System.out.println("The length of the longest substring"
				+ " without repeating characters is " + lengthOfLongestSubstring(s));
	}
	
}
