package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/***************************************************************************
* Problem No. : 
* Problem Name: Find all unique substrings of given length
* Problem URL : 
* Date        : Jan 2 2018
* Author      : @codingbro
* Notes       : 
* 	Scenario: 
* 		Give an input String s, find all the unique substring of length k, and order them. 
* 	Assumption:
* 		1. 
	Example:
* 	Input: "bddda" k = 2
* 	Output: ["bd", "dd", "da"]
* 		
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-string
***************************************************************************/
public class AllUniqueSubstrings {

	/**
	 * Before delve into AllUniqueSubstringsOfGivenLength problem, 
	 * we can get familiar with all substrings problem first.
	 * Per https://stackoverflow.com/questions/2560262/generate-all-unique-substrings-for-given-string
	 * A naive solution is to traverse the entire string and generate substrings from length 1 to n.
	 * And we can use a set to make the generated substrings unique.
	 * 
	 * Time Complexity: O(n^2)
	 */
	public static class AllSubstrings {
		public List<String> generateAllUniqueSubstrings(String s) {
			List<String> res = new ArrayList<>();
			if (s == null || s.length() == 0) {
				return res;
			}
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < s.length() - i; j++) {
					String el = s.substring(j, j + i + 1);
					if (!res.contains(el)) {
						res.add(el);
					}
				}
			}
			return res;
		}
		/*
		 * Note: If we use Set<String> res = new HashSet<>() to solve this problem, 
		 * we will not have the answer in the order of one-char two-char three-char
		 * cuz Set doesn't preserve the order.
		 * Since List also has contains method, we can use it to de-duplicate.
		 * */
	}
	
	/**
	 * Solve the all unique substrings with given length k and sort in order problem.
	 * Idea:
	 * 	Based on the template given above, we can use TreeSet to preserve the order and 
	 * add one checking condition el.length() == k
	 */
	public static class Sol {
		public List<String> getAllUniqueSubstrings(String s, int k) {
			Set<String> res = new TreeSet<>();
			if (s == null || s.length() == 0 || k <= 0) {
				return new ArrayList<String>(res);
			}
			for (int i = 0; i < s.length(); i++) {
				for (int j = 0; j < s.length() - i; j++) {
					String el = s.substring(j, j + i + 1);
					if (!res.contains(el) && el.length() == k) {
						res.add(el);
					}
				}
			}
			return new ArrayList<String>(res);
		}
	}
	
	public static void main(String[] args) {
		AllSubstrings as = new AllSubstrings();
		List<String> res = as.generateAllUniqueSubstrings("abc"); //should output a, b, c, ab, bc, abc
		for (String s : res) {
			System.out.print(s + ", ");
		}
		System.out.println();
		res = as.generateAllUniqueSubstrings("cbc"); //should output c, b, cb, bc, cbc
		for (String s : res) {
			System.out.print(s + ", ");
		}
		System.out.println();
		
		Sol sl = new Sol();
		res = sl.getAllUniqueSubstrings("dbbbco", 2); // should output bb, bc, co, db
		for (String s : res) {
			System.out.print(s + ", ");
		}
		System.out.println();
	}
}
