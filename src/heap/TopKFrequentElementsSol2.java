package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

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
public class TopKFrequentElementsSol2 {

	public static int[] topKFrequentCode1(int[] nums, int k) {
		// count frequency
		Map<Integer, Integer> map = new HashMap<>();
		for (int n: nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		
		// construct the maxHeap, each element in the heap is {key, val} pair
		Queue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
		for (Map.Entry<Integer, Integer> entry: map.entrySet()) { //考点：efficiently traverse a HashMap
			if (minHeap.size() < k) {
				minHeap.offer(entry);
			} else if (entry.getValue() > minHeap.peek().getValue()) {
				minHeap.poll();
				minHeap.offer(entry);
			}
		}
		
		// form the result
		int[] res = new int[k];
		for (int i = 0; i < k; i++) {
			res[i] = minHeap.poll().getKey();
		}
		return res;
	}

	
	public static void main(String[] args) {
		int[] nums = new int[]{1, 1, 2, 3, 1, 2};
		/* Solution 1 */
		System.out.print("The top 2 unique elements are: " + topKFrequentCode1(nums, 2));
	}
}