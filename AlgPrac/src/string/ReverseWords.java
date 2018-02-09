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
			for (int i = 0, j = 0; j < s.length; j++) {
	            if (j == s.length - 1 || s[j + 1] == ' ') {
	                reverse(s, i, j);
	                i = j + 2;
	            }
	        }
			reverse(s, 0, s.length - 1);
		}
		
		private void reverse(char[] s, int start, int end) {
			while (start < end) {
				char t = s[start];
				s[start++] = s[end];
				s[end--] = t;
			}
			
//			for (int i = 0; i <= (end - start) / 2; i++) {
//				char t = s[start + i];
//				s[start + i] = s[end - i];
//				s[end - i] = t;
//			}
			/* But to be honest, this +i -i approach seems to be easier to error, 
			 * suggest to use the `while (start < end)` one*/
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
		/**
		 * If it is okay to use Java String methods like split, trim.
		 * Time Complexity: O(n)
		 * Space Complexity: O(n) -- tmp array and sb string builder.
		 */
		public String reverseWords1(String s) {
			if (s == null)
				return null;
			if (s.trim().length() == 0)
				return "";
			String[] tmp = s.trim().split("\\s+"); // "\s+" matches one or more spaces and the first "\" is the escaping character
			StringBuilder sb = new StringBuilder();
			for (int i = tmp.length-1; i > 0; i--) {
				sb.append(tmp[i] + " ");
			}
			sb.append(tmp[0]);
			return sb.toString();
		}
		
		/**
		 * This time I don't allow you to use methods provided by String class of Java, 
		 * so no trim() or split(), what can you do?
		 * Well, you can use String's substring()
		 * Two pointers!!
		 *   Let faster pointer i start from the end of the string and travel back, 
		 *   when i hits space char, pointer j always = i
		 *   when i hits non-space char, dont update j,
		 *   then when i == 0 or i-1 hits a space char, extract (i, j) to the string builder
		 *   do this till pointer i reaches index 0.
		 *   Then convert sb into string
		 * Well, tricky part:
		 * 	when doing extraction for the 1st time, we don't append " " to sb, but for any time following,
		 *  we append " " first then the word being extracted.  
		 */
		public String reverseWords2(String s) {
			if (s == null)
				return null;
			if (s.length() == 0)
				return "";
			StringBuilder sb = new StringBuilder();
			int j = s.length();
			for (int i = s.length() - 1; i >= 0; i--) {
				if (s.charAt(i) == ' ') {
					j = i;
				} else if (i == 0 || s.charAt(i - 1) == ' ') {
					if (sb.length() > 0) {
						sb.append(" ");
					}
					sb.append(s.substring(i, j));
				}
			}
			return sb.toString();
		}
	}
	
	
	
	public static void main(String[] args) {
		/* The input should be typical, no leading/trailing spaces, words are separated by exact one space */
		Words2 w2 = new Words2();
		char[] tWords = "The Sky is Blue".toCharArray();
		w2.reverseWords(tWords);
		System.out.println("Now the typical words become: " + new String(tWords));
		
		/* The input should be special, having leading/trailing spaces, and words are separated by >1 space */
		Words1 w1 = new Words1();
		System.out.println("Reverse using naive way is: " + w1.reverseWords1("   Hello    How   are you   "));
		
		System.out.println("Reverse using naive way is: " + w1.reverseWords2("   You are    a    cool guy!  "));
	}
}
