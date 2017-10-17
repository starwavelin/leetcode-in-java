package string;

/***************************************************************************
* Problem No. : 186, 151
* Problem Name: Reverse Words in a String II and I
* Problem URL : See code below
* Date        : Oct 17 2017
* Author	  :	Xian Lin
* 
* meta        : tag-string, tag-array, tag-two-pointers
***************************************************************************/
public class ReverseWords {
	/**
	* Notes       : 186
	* 	Scenario:
	* 		https://leetcode.com/problems/reverse-words-in-a-string-ii/description/
	* 		Given an input string, reverse the string word by word
	* 	Assumption:
	* 		1. No leading or trailing spaces
	* 		2. Each word has exact one space in between
		Example:
	* 	Input: "I love you"
	* 	Output: "you love I"
	* 	Data Structure and Alg:
	* 		  
	* Complexity  : 
	* 	Time Complexity: O(n) -- traverse the whole string
	* 	Space Complexity: O(1) -- use an extra var to do the reverse/swap
	*/
	public static class Words2 {
		/* use two pointers to slice a word */
		public void reverseWords(char[] s) {
			if (s == null || s.length == 0)
				return;
			for (int i = 0, j = 0; j <= s.length; j++) { // think: why here we want j <= s.length ?
				if (j == s.length || s[j] == ' ') { // think: why `j == s.length` should be placed before ` s[j] == ' '`?
					reverse(s, i, j - 1);
					i = j + 1;
				}
			}
			reverse(s, 0, s.length - 1);
		}
		
		/* in Rotate Array problem, I used `while (start < end)`
		 * this time I am using a for loop which follows the thought of binary search
		 * */
		private void reverse(char[] s, int start, int end) {
//			while (start < end) {
//				char t = s[start];
//				s[start++] = s[end];
//				s[end--] = t;
//			}
			
			for (int i = 0; i <= (end - start) / 2; i++) {
				char t = s[start + i];
				s[start + i] = s[end - i];
				s[end - i] = t;
			}
			/* But to be honest, this +i -i approach seems to be easier to errored, 
			 * suggest using the `while (start < end)` one*/
		}
	}
	
	
	/**
	* Notes       : 151
	* 	Scenario: 
	* 		https://leetcode.com/problems/reverse-words-in-a-string/description/
	* 		Given an input string, reverse the string word by word
	* 	Assumption:
	* 		1. Yes, we have leading or trailing spaces
	* 		2. Each word has one or more spaces in between
		Example:
	* 	Input: "___I__love__you___"  // I used underscore to represent space.
	* 	Output: "you love I"
	* 	Data Structure and Alg:
	* 		  
	* Complexity  : 
	* 	Time Complexity: O(n) -- traverse the whole string
	* 	Space Complexity: O(n) -- 
	*/
	public static class Words1 {
		
	}
	
	
	
	public static void main(String[] args) {
		/* The input should be typical, no leading/trailing spaces, words are separated by exact one space */
		Words2 w2 = new Words2();
		char[] tWords = "The Sky is Blue".toCharArray();
		w2.reverseWords(tWords);
		System.out.println("Now the typical words become: " + new String(tWords));
		
		/* The input should be special, having leading/trailing spaces, and words are separated by >1 space */
		
		
	}
}
