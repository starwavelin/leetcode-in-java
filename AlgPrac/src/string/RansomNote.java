package string;

import java.util.HashMap;

/***************************************************************************
* Problem No. : 383
* Problem Name: Ransom Note
* Problem URL : https://leetcode.com/problems/ransom-note/description/
* Date        : Oct 23 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		See if the 1st string can be constructed from the 2nd string.
* Actually the problem can be rephrased as "Are the characters in the 1st string a subset of the characters in the 2nd string?"
* Since subset, the order of characters doesn't matter.
* 	Assumption:
* 		1. If I tell you both strings contain lower case characters only, can you make your code more space saving? 
	Example:
* 	Input/Output: 
* 		canConstruct("a", "b") -> false
		canConstruct("aa", "ab") -> false
		canConstruct("aa", "aab") -> true
		canConstruct("aa", "aba") -> true
* 	Data Structure and Alg:
* 		see code comments  
* Complexity  : 
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
* 
* meta        : tag-string, tag-hash, tag-array-map
* 
* Related Q   : strStr (where orders of chars matter)
***************************************************************************/
public class RansomNote {
	
	/**
	 * Solution 1:
	 * 	Store the chars from magazine into a HashMap with key to be char and value to be the frequency of each char.
	 * Then traverse the ransomNote string, for each char we encounter, we decrement its frequency from the map.
	 * If we encounter any char whose frequency will be less than 0, return false; otherwise after the traversal is done, return true.
	 * 
	 * Time Complexity: O(n) - traverse magazine once, traverse ransomNote once
	 * Space Complexity: O(n) - n is the length of characters in the magazine
	 */
	public static boolean canConstruct1(String ransomNote, String magazine) {
        if (ransomNote == null || ransomNote == "" 
        		|| magazine == null || magazine == "") {
        	return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] ran = ransomNote.toCharArray();
        char[] mag = magazine.toCharArray();
        for (char c : mag) {
        	map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : ran) {
        	int count = map.getOrDefault(c, 0) - 1;
        	if (count < 0) {
        		return false;
        	}
        	map.put(c, count); // update the frequency of the used character
        }
        return true;
    }

	
	public static void main(String[] args) {
		String str1 = "aa", str2 = "ab", str3 = "aba";
		System.out.println("Can str1 be constructed by str2? " + canConstruct1(str1, str2));
		System.out.println("Can str1 be constructed by str3? " + canConstruct1(str1, str3));
		 
	}
}
