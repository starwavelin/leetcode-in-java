package string;
/***************************************************************************
* Problem No. : 
* Problem Name: Longest Substring With Repeating Characters
* Problem URL : 
* Date        : Jan 3 2017
* Author      :	Xian Lin
* Notes       : 
* 	Scenario:
* 		Also known as Longest Uniform Substring. 
* 		Given a string, find the starting index and the length of the longest substring with repeating characters.
* 	Assumption:
* 		1. Can input be an empty string? Yes, then its index will be -1 and length will be 0
	Example:
* 	Input/Output: 
* 		Given "aaoooookk", the answer is int[]{2, 5}.
* 		ooooo contributes to the answer with starting index 2 and length 5.
* 	Data Structure and Alg:
* 		see code comments  
* Complexity  : 
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
* 
* meta        : tag-string, tag-two-pointers
***************************************************************************/
public class LongestSubstringWithRepeatingCharacters {

	/**
	 * Let's start with an easier problem. Let's say I just want you to find
	 * out the length of the longest uniform substring, what shall you do?
	 * 
	 * Idea:
	 * Use two pointers (prev and cur) to traverse the string and keep a var for curLen and another var for longestLen
	 * when prev == cur, we increment curLen; when prev != cur, we reset curLen = 1;
	 * when curLen > longestLen, we update longestLen = curLen.  
	 */
	public static class LongestUniformSubstring {
		public int getLength(String s) {
			int longestLen = 0;
			if (s == null || s.length() == 0) {
				return 0;
			}
			char prev = s.charAt(0);
			longestLen = 1;
			int curLen = 1;
			for (int i = 1; i < s.length(); i++) {
				char cur = s.charAt(i);
				if (cur == prev) {
					curLen++;
				} else {
					curLen = 1;
				}
				if (curLen > longestLen) {
					longestLen = curLen;
				}
				prev = cur;
			}
			return longestLen;
		}
		
		/**
		 * Using two pointers is fine as above. But since the string has indices,
		 * could I just utilize the natural index i 
		 * and compare s.charAt(i) and s.charAt(i-1) to reduce the variables used?
		 */
		public int getLength2(String s) {
			int longestLen = 0;
			if (s == null || s.length() == 0) {
				return longestLen;
			}
			/* The input string has at least one character now. */
			longestLen = 1;
			int curLen = 1;
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == s.charAt(i-1)) {
					curLen++;
				} else {
					curLen = 1;
				}
				if (curLen > longestLen) {
					longestLen = curLen;
				}
			}
			return longestLen;
		}
	}
	
	/**
	 * Then do the actual problem
	 */
	public static class Solution {
		/**
		 * Solution is similar to the 2nd solution of LongestUniformSubstring:
		 * add one var to record the start index of the LUS, and another var to record the starting index 
		 * of the current uniform substring.
		 * When cur != prev, in another word when s.charAt(i) != s.charAt(i-1), we update curStart (and curLen)
		 * When curLen > longestLen, we update longestStart and longestLen.
		 */
		public int[] longestUniformSubstring(String s) {
			int longestStart = -1;
			int longestLen = 0;
			if (s == null || s.length() == 0) {
				return new int[] {longestStart, longestLen};
			}
			// Now s should have at least one character
			longestStart = 0;
			longestLen = 1;
			int curStart = 0, curLen = 1;
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i) == s.charAt(i - 1)) {
					curLen++;
				} else {
					curStart = i;
					curLen = 1;
				}
				if (curLen > longestLen) {
					longestStart = curStart;
					longestLen = curLen;
				}
			}
			return new int[] {longestStart, longestLen};
		}
	}
	
	public static void main(String[] args) {
		/* The easier version of this problem */
		LongestUniformSubstring lus = new LongestUniformSubstring();
		System.out.println("Length of longest substring for an empty string is: " 
				+ lus.getLength2("")); // 0
		System.out.println("Length of longest substring for X is: " 
				+ lus.getLength2("X")); // 1
		System.out.println("Length of longest substring for aaoooookkg is: " 
				+ lus.getLength2("aaoooookkg")); // 5
		System.out.println("Length of longest substring for c9999999bdllllllllF is: " 
				+ lus.getLength2("c9999999bdllllllllF")); 
			// output: 8. There are 7 9's and 8 l's. output is contributed by 8 l's
		
		
		Solution sl = new Solution();
		System.out.println("an empty string, staring index: " + sl.longestUniformSubstring("")[0]
				+ " longest length: " + sl.longestUniformSubstring("")[1]); // -1, 0
		System.out.println("X, staring index: " + sl.longestUniformSubstring("X")[0]
				+ " longest length: " + sl.longestUniformSubstring("X")[1]); // 0, 1
		System.out.println("aaoooookkg, staring index: " + sl.longestUniformSubstring("aaoooookkg")[0]
				+ " longest length: " + sl.longestUniformSubstring("aaoooookkg")[1]); // 2, 5
		System.out.println("c9999999bdllllllllF, staring index: " 
				+ sl.longestUniformSubstring("c9999999bdllllllllF")[0]
				+ " longest length: " + sl.longestUniformSubstring("c9999999bdllllllllF")[1]);
			// output: 10, 8. 
			// There are 7 9's and 8 l's. output is contributed by 8 l's
	}
}
