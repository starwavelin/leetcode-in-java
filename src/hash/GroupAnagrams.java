package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/***************************************************************************
* Problem No. : 49
* Problem Name: Group Anagrams
* Problem URL : https://leetcode.com/problems/group-anagrams/description/
* Date        : Oct 26 2017
* Author      :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		
* 	Assumption:
* 
	Example:
* 	Input/Output:
* 		
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  : 
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments   
* 
* meta        : tag-hash, tag-array-map, tag-bloomberg
***************************************************************************/
public class GroupAnagrams {

	public static class Sol {
		public List<List<String>> groupAnagrams(String[] strs) {
	        if (strs == null || strs.length == 0) {
	            return new ArrayList<>();
	        }
	        List<List<String>> res = new ArrayList<>();
	        Map<String, List<String>> map = new HashMap<>();
	        for (String word : strs) {
	            char[] tmp = word.toCharArray();
	            Arrays.sort(tmp);
	            String key = String.valueOf(tmp);
//	            String key = tmp.toString();
	            System.out.println("key is: " + key);
	            
	            map.putIfAbsent(key, new ArrayList<String>());
	            map.get(key).add(word);
	        }
	        for (String key : map.keySet()) {
	            res.add(map.get(key));
	        }
	        return res;
	    }
	}
	
	public static void main(String[] args) {
		Sol sc = new Sol();
		String[] strs = new String[]{"abc", "kfc", "bca", "cfk"};
		List<List<String>> res = sc.groupAnagrams(strs);
		System.out.println("The size of the result set is： " + res.size()); // should return 2
		for (int i = 0; i < res.size(); i++) {
			for (String s : res.get(i)) {
				System.out.print(s + "\t");
			}
			System.out.println();
		}
	}
}
