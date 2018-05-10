package string;
/***************************************************************************
* Problem No. : NLC 1
* Problem Name: Longest Uniform Substring
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
public class LongestUniformSubstring {

	/**
	 * Let's start with an easier problem. Let's say I just want you to find
	 * out the length of the longest uniform substring, what shall you do?
	 * 
	 * Idea:
	 * Use two pointers (prev and cur) to traverse the string and keep a var for curLen and another var for longestLen
	 * when prev == cur, we increment curLen; when prev != cur, we reset curLen = 1;
	 * when curLen > longestLen, we update longestLen = curLen.  
	 */
	public static class EasierVersion {
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
	
	/**
	 * Best Solution:
	 * 不需要记录curLen，直接利用双指针i,j 
	 * (j-i)获得一个新长度跟记录的长度比对，如果大于记录的长度我们就更新记录的长度以及对应的index（就是i）
	 * 
	 * @author xianlin
	 */
	public static class Solution2 {
		public int[] lus(String s) {
			int index = -1, len = 0;
			if (s == null || s.length() == 0) {
				return new int[] {index, len};
			}
			int i = 0, j = 1;
			while (i < s.length()) {
				if (j == s.length() || s.charAt(j) != s.charAt(i)) {
					if (j - i > len) {
						len = j - i;
						index = i;
					}
					i = j;
				}
				j++;
			}
			return new int[] {index, len};
		}
	}
	
	
	public static void main(String[] args) {
		/* The easier version of this problem */
		EasierVersion lus = new EasierVersion();
		System.out.println("Length of longest substring for an empty string is: " 
				+ lus.getLength2("")); // 0
		System.out.println("Length of longest substring for X is: " 
				+ lus.getLength2("X")); // 1
		System.out.println("Length of longest substring for aaoooookkg is: " 
				+ lus.getLength2("aaoooookkg")); // 5
		System.out.println("Length of longest substring for c9999999bdllllllllF is: " 
				+ lus.getLength2("c9999999bdllllllllF")); 
			// output: 8. There are seven 9's and eight l's. output is contributed by eight l's
		System.out.println();
		
		
		Solution sl = new Solution();
		System.out.println("an empty string, starting index: " + sl.longestUniformSubstring("")[0]
				+ " longest length: " + sl.longestUniformSubstring("")[1]); // -1, 0
		System.out.println("X, starting index: " + sl.longestUniformSubstring("X")[0]
				+ " longest length: " + sl.longestUniformSubstring("X")[1]); // 0, 1
		System.out.println("aaoooookkg, starting index: " + sl.longestUniformSubstring("aaoooookkg")[0]
				+ " longest length: " + sl.longestUniformSubstring("aaoooookkg")[1]); // 2, 5
		System.out.println("c9999999bdllllllllF, starting index: " 
				+ sl.longestUniformSubstring("c9999999bdllllllllF")[0]
				+ " longest length: " + sl.longestUniformSubstring("c9999999bdllllllllF")[1]);
			// output: 10, 8. 
			// There are seven 9's and eight l's. output is contributed by eight l's
		System.out.println();
		
		Solution2 s2 = new Solution2();
		System.out.println("an empty string, starting index: " + s2.lus("")[0]
				+ " longest length: " + s2.lus("")[1]); // -1, 0
		System.out.println("X, starting index: " + s2.lus("X")[0]
				+ " longest length: " + s2.lus("X")[1]); // 0, 1
		System.out.println("aaoooookkg, starting index: " + s2.lus("aaoooookkg")[0]
				+ " longest length: " + s2.lus("aaoooookkg")[1]); // 2, 5
		System.out.println("c9999999bdllllllllF, starting index: " 
				+ s2.lus("c9999999bdllllllllF")[0]
				+ " longest length: " + s2.lus("c9999999bdllllllllF")[1]);
			// output: 10, 8. 
			// There are seven 9's and eight l's. output is contributed by eight l's
		
	}
}
