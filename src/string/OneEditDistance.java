package string;

/***************************************************************************
* Problem No. : 161
* Problem Name: One Edit Distance
* Problem URL : https://leetcode.com/problems/one-edit-distance/description/
* Date        : Oct 23 2017
* Author      :	@codingbro
* Notes       :
* 	Scenario:
* 		Given two strings S and T, determine if they are both one edit distance apart.
* 	Assumption:
* 		 @needOrganize  http://www.cnblogs.com/grandyang/p/5184698.html
	Example:
* 	Input/Output:
*
* 	Data Structure and Alg:
* 		see code comments
* Complexity  :
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
*
* meta        : tag-string
***************************************************************************/
public class OneEditDistance {

	/**
	 * Based on length difference of the two input strings, we can decompose this problem into 3 cases:
	 * 1. diff > 1, return false
	 * 2. diff == 1, see if there is exact one extra char in s or t, and remaining chars are the same for s and t,
	 * 	if yes return true, otherwise false.
	 * 3. diff == 0, see if there is exact one char difference between s and t, if yes return true, otherwise false.
	 *
	 * Time Complexity: O(m + n) - m is the length of s and n is the length of t
	 * Space Complexity: O(1) - cuz just open one new var
	 *
	 * 关键点：
	 * 	#1 用好 String 中的 substring() method
	 *  #2 比较两个substrings内容的时候用 substring1.equals(substring2) !!!
	 */
	public static boolean isOneEditDistance1(String s, String t) {
        int diff = Math.abs(s.length() - t.length());
        if (diff > 1) {
        	return false;
        } else if (diff == 1) {
        	if (s.length() == 0 || t.length() == 0) { // handle the case when either s or t is an empty string
        		return true;
        	} else {
        		if (s.length() > t.length()) {
        			for (int i = 0; i < t.length(); i++) {
        				if (s.charAt(i) != t.charAt(i))
        					return s.substring(i + 1).equals(t.substring(i));
        			}
        		} else {
        			for (int i = 0; i < s.length(); i++) {
        				if (s.charAt(i) != t.charAt(i))
        					return t.substring(i + 1).equals(s.substring(i));
        			}
        		}
        	}
        } else {
        	int count = 0; // count the occurrence of different chars
        	for (int i = 0; i < s.length(); i++) {
        		if (s.charAt(i) != t.charAt(i))
        			count++;
        	}
        	return count == 1;
        }
        return true;
    }

	/**
	 * Solution 2:
	 * 	Based on Solution 1, the 2nd case diff == 1 is tedious cuz we consider the length of s and t seperately inside this case.
	 * Since this question just returns a boolean value of whether they are one edit distance, we can manipulate s and t at the very beginning.
	 *
	 */
	public static boolean isOneEditDistance2(String s, String t) {
		/* manipulate s and t at the beginning; we want s length always <= t */
		if (s.length() > t.length()) {
			String tmp = s;
			s = t;
			t = tmp;
		} // now s length <= t
		if (t.length() - s.length() > 1) {
			return false;
		} else if (t.length() - s.length() == 1) {
			if (s == "") {
				return true;
			}
			for (int i = 0; i< s.length(); i++) {
				if (s.charAt(i) != t.charAt(i)) {
					return s.substring(i).equals(t.substring(i + 1));
				}
			}
		} else {
			int count = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) != t.charAt(i)) {
					count++;
				}
			}
			return count == 1;
		}
		return true;
    }

	public static void main(String[] args) {
		/* For fun */
//		String s = "";
//		System.out.println("s is: " + s);
//		System.out.println("s.charAt(0) is: " + s.charAt(0));

		/* Solution 1 */
//		System.out.println("Are the two strings one edit distance? " + isOneEditDistance1("", "")); 	//false, 0 distance
//		System.out.println("Are the two strings one edit distance? " + isOneEditDistance1("", "1"));	//true
//		System.out.println("Are the two strings one edit distance? " + isOneEditDistance1("abcddd", "abddd")); //true
//		System.out.println("Are the two strings one edit distance? " + isOneEditDistance1("abcd", "abxd")); //true
//		System.out.println("Are the two strings one edit distance? " + isOneEditDistance1("abcd", "abcd")); //false, 0 distance
//		System.out.println("Are the two strings one edit distance? " + isOneEditDistance1("abcd", "abedk")); //false, 2 distances

		/* Solution 2 */
		System.out.println("Are the two strings one edit distance? " + isOneEditDistance2("", "")); 	//false, 0 distance
		System.out.println("Are the two strings one edit distance? " + isOneEditDistance2("", "1"));	//true
		System.out.println("Are the two strings one edit distance? " + isOneEditDistance2("abcddd", "abddd")); //true
		System.out.println("Are the two strings one edit distance? " + isOneEditDistance2("abcd", "abxd")); //true
		System.out.println("Are the two strings one edit distance? " + isOneEditDistance2("abcd", "abcd")); //false, 0 distance
		System.out.println("Are the two strings one edit distance? " + isOneEditDistance2("abcd", "abedk")); //false, 2 distances
	}
}
