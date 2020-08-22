package string;

import java.util.Arrays;
import java.util.Scanner;

/***************************************************************************
* Problem No. : 3
* Problem Name: Longest Substring Without Repeating Characters
* Problem URL : https://leetcode.com/problems/longest-substring-without-repeating-characters/
* Date        : Oct 18 2017
* Author      :	@codingbro
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
* 		see code comments
* Complexity  :
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
*
* meta        : tag-string, tag-hash, tag-array-map, tag-two-pointers
***************************************************************************/
public class LongestSubstringWithoutRepeatingCharacters {
	/**
	 * Quick ref of ASCII table: http://www.asciitable.com/
	 * 	A-Z: 65-90
	 * 	a-z: 97-122
	 * Solution 1：Two pointers
	 * 	Assume all the 256 ASCII characters are eligible to be in the input string,
	 * then setup an array map of size 256 with the ASCII number to be the index and the latest (right) index of a char to be the value.
	 * Use two pointers, and use the right pointer to traverse the string;
	 * and we only update the left pointer when a char appears again.
	 * 	And the left pointer = (the index of the previous appearance of this repeated character) + 1;
	 * The maxLen = (right - left + 1);
	 *
	 * ie. Input string: abcadef	use our eyes, we can figure out the longest substring w/o repeating chars is bcadef which has length 6.
	 * Follow our algorithm,
	 * 	Step 1: Initialize array map, left pointer = right pointer = index 0.
	 * 		-1, -1, -1, -1, -1, -1			l = 0, r = 0
	 * 		 a,  b,  c,  d,  e,  f
	 * 	Step 2: right pointer scanned to the char that right before the repeated "a"
	 * 		 0,  1,  2, -1, -1, -1			l = 0, r = 2
	 * 		 a,  b,  c,  d,  e,  f
	 * 	Step 3: when right pointer scanned the repeated "a"
	 * 		 3,  1,  2, -1, -1, -1			l = 1, r = 3
	 * 		 a,  b,  c,  d,  e,  f
	 * 	Step 4: when right pointer scanned the repeated "a"
	 * 		 3,  1,  2,  4,  5,  6			l = 1, r = 6
	 * 		 a,  b,  c,  d,  e,  f
	 * So, maxLen = 6 - 1 + 1 = 5.
	 *
	 * Time Complexity: O(n) - scanned the whole input string once, one pass
	 * Space Complexity: O(1) / O(n) -- need to discuss with the interviewer, cuz we open a new array of size 256
	 * 		If the intpu string has length of 1M, surely it is O(1), but if the input string is just 100 characters long, then it would be O(n)
	 *
	 * If you want another example, you can test "abcacef" which the longest substring is contributed from acef,
	 * 	when c appears the 2nd time, the l will be updated from 2 plus 1 to be 3. maxLen = 6 - 3 + 1 = 4
	 */
	public static int lengthOfLongestSubstring1(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] map = new int[256]; //size of extended ASCII
		Arrays.fill(map, -1);
		int l = 0, maxLen = 0;
		for (int r = 0; r < s.length(); r++) { // 易错点：Java中 array.length; cuz length is a field for array. But, s.length(): length() method for string
			if (map[s.charAt(r)] >= l) { // found a repeated occurrence of the char at s.charAt(r), need to update l
				l = map[s.charAt(r)] + 1;
			}
			/* Or I can write the above 3 lines as
			 * l = Math.max(map[s.charAt(r)] + 1, l);
			 * */
			map[s.charAt(r)] = r; // put right index as value into the array map
			maxLen = Math.max(r - l + 1, maxLen);
		}
		return maxLen;
	}

	/**
	 * If we are sure the input string contains lower case letters only,
	 * we can further shrink the size of the array map into 26
	 */
	public static int lengthOfLongestSubstring2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] map = new int[26];
		Arrays.fill(map, -1); /* map中的每个格子初始化成-1的好处是假如重复的字符是index=0的那个数，仍可通过循环中的if简单判断出来 */
		int l = 0, maxLen = 0;
		for (int r = 0; r < s.length(); r++) {
			if (map[s.charAt(r) - 'a'] >= l) {
				l = map[s.charAt(r) - 'a'] + 1;
			}
			map[s.charAt(r) - 'a'] = r;
			maxLen = Math.max(maxLen, r - l + 1);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Longest Substring without Repeating Characters Test ***");
		System.out.print("Give a String : ");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println("The length of the longest substring without repeating characters is "
				+ lengthOfLongestSubstring2(s)); //toggle methods
	}
}
