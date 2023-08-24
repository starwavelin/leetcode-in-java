package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import utility.ListUtil;

/***************************************************************************
* Problem No. : 347
* Problem Name: Top K Frequent Elements
* Problem URL : https://leetcode.com/problems/top-k-frequent-elements/description/
* Date        : Oct 24 2017
* Author	  :	@codingbro
* Notes       : 
* 	Scenario: 
* 		Given a non-empty array of integers, return the k most frequent elements.
* 	Assumption:
* 		1. You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
* 		2. Solution should be better than O(nlogn) so the Java built in sorting is not allowed 
* 		3. If there are two elements having the same highest frequency, and k = 2, then return these two elements is fine
	Example:
* 	Input:  Given [1,1,2,3,1,2] and k = 2, 
* 	Output: return [1,2]
* 		
* 	Data Structure and Alg:
* 		See code comments
* Complexity  : 
* 	Time Complexity: See code comments
* 	Space Complexity: See code comments   
* 
* meta        : tag-heap, tag-hash, tag-tree-map, tag-sort
***************************************************************************/
public class TopKFrequentElementsSol3 {

	
	/**
	 * Solution 3: TreeMap
	 * 	1. Use a HashMap to store frequency:  key - element and value - its frequency  ---O(n)
	 *  2. Traverse the hashmap formed in Step 1 and use a TreeMap to store
	 *  	TreeMap key - frequency, value - elements, and have the key ordered in reverse order
	 *  	Note that there could be multiple elements under one frequency so TreeMap implementation allows the user to get
	 *  	several elements having the same number of occurrence. -- O(n)
	 *  3. Use a List to store the result for the element being polled from TreeMap, k times -- O(k)
	 *  
	 *  Time Complexity: O(n)
	 *  Space Complexity: O(n) -- HashMap uses O(n) and TreeMap uses O(n), and List uses O(k)
	 *  Run Time on LeetCode: 30ms
	 */
	public static List<Integer> topKFrequent2(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		TreeMap<Integer, List<Integer>> tMap = new TreeMap<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (!tMap.containsKey(entry.getValue())) {
				tMap.put(entry.getValue(), new ArrayList<Integer>());
			}
			tMap.get(entry.getValue()).add(entry.getKey());
		}

		List<Integer> res = new ArrayList<>();
		while (res.size() < k) {
			res.addAll(tMap.pollLastEntry().getValue());
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1, 1, 2, 3, 1, 2};
		
		/* Solution 3 */
		System.out.print("The top 2 unique elements are: ");
		ListUtil.display(topKFrequent2(nums, 2));
		
		nums = new int[]{1, 1, 1, 2, 2, 5, 5, 4, 3};
		System.out.print("Now the top 2 unique elements are: ");  // 2 and 5 are tie for the 2nd highest frequent element
		ListUtil.display(topKFrequent2(nums, 2));
	}
}
