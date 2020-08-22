package string;

import java.util.Scanner;

/***************************************************************************
* Problem No. : 340
* Problem Name: Longest Substring With At Most K Distinct Characters
* Problem URL : https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
* Date        : Dec 13 2017
* Author	  :	@codingbro
* Notes       : 
* 	Scenario: 
* 		
* 	Assumption:
* 		
	Example:
* 	Input: "aaabbcaggbbd", 3
* 	Output: 7 (formed by aaabbca)
* 	Input: "bcaggbbd", 3
* 	Output: 5 (formed by ggbbd)
* 
* 	Data Structure and Alg:
* 		see code comments  
* Complexity  : 
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
* 
* meta        : tag-string, tag-hash, tag-array-map, tag-two-pointers
***************************************************************************/
public class LongestSubstringWithAtMostKDistinctChars {
	
	/**
	 * 这道题map存的是什么？count表示的是什么？
	 * map stores key - a character; value - the occurrence of this character
	 * count - the number of distinct characters
	 */
	public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0) {
        	return 0;
        }
        int[] map = new int[256];
		int l = 0, count = 0, maxLen = 0;
		for (int r = 0; r < s.length(); r++) {
			if (map[s.charAt(r)]++ == 0) {
				count++;
			}
			while (count > k && l < s.length()) {
				map[s.charAt(l)]--;
				if (map[s.charAt(l)] == 0) {
					count--;
				}
				l++;
			}
			maxLen = Math.max(maxLen, r - l + 1);
		}
		return maxLen;
    }
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Longest Substring With At Most K Distinct Characters Test ***");
		System.out.print("Give a String : ");
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		System.out.println("The length of the longest substring with at most 3 characters is " 
				+ lengthOfLongestSubstringKDistinct(s, 3)); //toggle methods
	}

}
