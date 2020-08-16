package hash;

import java.util.HashMap;
import java.util.Map;

/***************************************************************************
* Problem No. : 383
* Problem Name: Ransom Note
* Problem URL : https://leetcode.com/problems/ransom-note/description/
* Date        : March 29 2020
* Author      :	Xian Lin
* Notes       :
* 	Scenario:
* 		判断ransomNote当中的所有字符是否都在magazine中。
* 	Assumption:
*		Assume两者都只有小写字母.
*		Order doesn't matter
	Example:
* 	Input/Output:
*
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  :
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments
*
* meta        : tag-hash, tag-array-map
***************************************************************************/

class Solution1 {
	
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote == null || magazine == null) {
            return false;
        }
        if (ransomNote.length() == 0 && magazine.length() == 0) {
            return true;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
        	char magChar = magazine.charAt(i);
        	map.put(magChar, map.getOrDefault(magChar, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
        	char ransomChar = ransomNote.charAt(i);
        	map.put(ransomChar, map.getOrDefault(ransomChar, 0) - 1);
        	if (map.get(ransomChar) < 0) {
        		return false;
        	}
        }
        return true;
    }
}

class Solution2 {
	
	public boolean canConstruct(String ransomNote, String magazine) {
		if (ransomNote == null || magazine == null) {
            return false;
        }
        if (ransomNote.length() == 0 && magazine.length() == 0) {
            return true;
        }
        
        // based on assumption, both ransomNote and magazine are constructed by lower case Latin letters only
        int[] map = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
        	map[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
        	map[ransomNote.charAt(i) - 'a']--; 
        	if (map[ransomNote.charAt(i) - 'a'] < 0) {
        		return false;
        	}
        }
        return true;
    }
}

public class RansomNote {
	
}