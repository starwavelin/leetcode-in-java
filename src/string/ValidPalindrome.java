package string;

import java.util.Scanner;
/***************************************************************************
* Problem No. : 125
* Problem Name: Valid Palindrome
* Problem URL : https://leetcode.com/problems/valid-palindrome/description/
* Date        : Apr 17 2018
* Author      : Xian Lin
* Notes       :
* 	Scenario:
* 		Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
* 	Assumption:
*
	Example:
* 	Input/Output:
* 		"a ba" output true
* 		"akaa" output false
*
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  :
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments
*
* meta        : tag-two-pointers
***************************************************************************/
public class ValidPalindrome {
	/**
	 * 只需要建立两个指针，left和right, 分别从字符的开头和结尾处开始遍历整个字符串，
	 * 如果遇到非字母数字的字符就跳过，继续往下找，直到找到下一个字母数字或者结束遍历，
	 * 如果遇到大写字母，就将其转为小写。
	 * 等左右指针都找到字母数字时，比较这两个字符，
	 * 若相等，则继续比较下面两个分别找到的字母数字，若不相等，直接返回false. 
	 */
	public static class Sol {
		/**
		 * Interesting part:
		 * At least in Java, we can still apply
		 * Character.toLowerCase(s.charAt(i)) if the ith character in string s is a digit
		 * @param s
		 * @return
		 */
		public boolean isPalindrome(String s) {
			if (s == null || s.length() <= 1) {
				return true;
			}
			int i = 0, j = s.length() - 1;
			while (i < j) {
				while (i < s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
					i++;
				}
				while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
					j--;
				}
				if (i < j && Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
					return false;
				}
				i++; j--;
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's Valid Palindrome Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your string: ");
		String s = sc.nextLine();
		
		Sol sol = new Sol();
		boolean ret = sol.isPalindrome(s);
		System.out.println("The statement that the given string " + s + " is a palindrome is " + ret);
	}
}
