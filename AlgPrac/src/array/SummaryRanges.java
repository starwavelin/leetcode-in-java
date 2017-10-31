package array;

import java.util.ArrayList;
import java.util.List;

/***************************************************************************
* Problem No. : 228
* Problem Name: Summary Ranges
* Problem URL : https://leetcode.com/problems/summary-ranges/description/
* Date        : Oct 31 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given a sorted integer array without duplicates, return the summary of its ranges.
* 	Assumption:
* 		1. Integers in the array can be negative.
* 		2. Array is sorted
* 		3. No duplicate integers
	Example:
* 	Input/Output: 
* 		Input: [0,2,3,4,6,8,9]
		Output: ["0","2->4","6","8->9"]
* 	Data Structure and Alg:
* 		User two pointers one pass;
*  		two pointers var cur and pointer i.
*  		  cur starts from nums[i], i moves gradually
*  		The comparions between nums[i+1] and nums[i] is the key point.
*  
*  		@needCorrection
*  		once reaches the element satisfying nums[j] - nums[j-1] > 1,
*  			insert range nums[i] to nums[j-1] into the list
*  			set pointer i = j
*  
* Complexity  : 
* 	Time Complexity: O(n) -- traverse the given array one pass
* 	Space Complexity: O(1) -- Just two extra pointers
* 
* meta        : tag-array, tag-two-pointers
***************************************************************************/
public class SummaryRanges {
	/**
	 * Note: slow pointer chasing the fast pointer.
	 */
	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		return null;
	}
}
