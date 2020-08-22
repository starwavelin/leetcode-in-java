package string;
/***************************************************************************
* Problem No. : 680
* Problem Name: Valid Palindrome II
* Problem URL : https://leetcode.com/problems/valid-palindrome-ii/description/
* Date        : Apr 17 2018
* Author      : @codingbro
* Notes       :
* 	Scenario:
* 		Given a non-empty string, determine if it is a palindrome by removing at most one character.
* 	Assumption:
*		1. string only contains a-z lowercase characters
*		2. input string's length cannot exceed 50000 characters
*	Example:
* 	Input/Output:
* 		"aba" output true
* 		"acba" output true (remove c or b)
* 		"accba" output true (remove b)
* 		"aceba" output false
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  :
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments
*
* meta        : tag-two-pointers
***************************************************************************/
public class ValidPalindrome2 {
	
	/**
	 * Q125的拓展，主要在于s[left]!=s[right]的时候，我们对s[left+1]到s[right]和s[left]到s[right-1]进行判断，
	 * 只要有一个为true即说明删一个字符可以使s成回文，反之则不行。
	 * 这个子判断过程可以写成辅助函数。
	 */
	public static class Solution {
		public boolean isPalindrome(String s) {
			int i = 0, j = s.length() - 1;
			while (i < j) {
				if (s.charAt(i) != s.charAt(j)) {
					return isValid(s, i+1, j) || isValid(s, i, j-1);
				}
				i++; j--;
			}
			return true;
		}
		
		// Do a typical palindrome validation
		private boolean isValid(String s, int left, int right) {
			while (left < right) {
				if (s.charAt(left) != s.charAt(right)) {
					return false;
				}
				left++; right--;
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println("aba: " + s.isPalindrome("aba")); //true
		System.out.println("acba: " + s.isPalindrome("acba")); //true
		System.out.println("accba: " + s.isPalindrome("accba")); //true
		System.out.println("aceba: " + s.isPalindrome("aceba")); //false
	}
}
