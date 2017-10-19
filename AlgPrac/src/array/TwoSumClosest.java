package array;

import java.util.Arrays;
import java.util.TreeSet;

/***************************************************************************
* Problem No. : 
* Problem Name: Two Sum Closest
* Problem URL : 
* Date        : Oct 18 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given an array of integers, return 
* 		#1 the minimum absolute difference between the sum of two numbers and a specific target.
* 		#2 indices of the two numbers such that their sum is closest to a specific target.
* 	Assumption:
* 		1. For #1, if the input is invalid, you may return Integer.MAX_VALUE
* 		2. For #2, if there are multiple indices satisfying the rule, returning one pair will be fine.
	Example:
* 	Input: [33, -2, 14, 5, 4, 9] target 22
* 	Output: 
* 		For Requirement #1, the minDiff is 1
* 		And for #2, the minDiff is contributed from 14 and 9, so you will return [2, 5]
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-array, tag-two-pointers, tag-sort, tag-hash, tag-bloomberg
***************************************************************************/
public class TwoSumClosest {

	/**
	 * Solution 1: Similar to Sol 1 of Two Sum Exist
	 * Brute force:
	 * 	For each element in the nums array, find all the differences between (currentElement + elementBeingScanned) and target,
	 * save these differences into a TreeSet.
	 * 	
	 * Time Complexity: O(n^2) cuz nested for loop
	 * Space Complexity: O(1) cuz just use two scanners
	 */
	public static int getMinDiff1(int[] nums, int target) {
		if (nums == null || nums.length < 2)
			return Integer.MAX_VALUE;
		TreeSet<Integer> set = new TreeSet<>();
			// Side Note: If you declare set as `Set<Integer> set = new TreeSet<>();` 
			// then set var will only have methods available for Set interface but not TreeSet class.
			// you will not have set.first() via this declaration though
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				set.add(Math.abs(nums[i] + nums[j] - target));
			}
		}
		return set.first();
	}
	
	/**
	 * Solution 2: Similar to Sol 2 of Two Sum Exist
	 * Sort first:
	 * 	1. Sort the array.
	 * 	2. Then use two scanners from the starting and ending index of the array, and gradually move them toward each other
	 *  3. Set a minDiff var to store the final result
	 *  4. For each two numbers the scanners are pointing, get their sum and then calculate the absolute difference between this sum and target
	 *  	if the abs diff is less than the current minDiff, update minDIff
	 *  	if sum > target
	 *  		right pointer--
	 *  	else if sum < target
	 *  		left pointer++
	 *  5. Do Step 4 till left pointer > right pointer
	 * 	
	 * Time Complexity: O(nlogn) cuz sorting
	 * Space Complexity: O(1) cuz just use two scanners
	 */
	public static int getMinDiff2(int[] nums, int target) {
		if (nums == null || nums.length < 2)
			return Integer.MAX_VALUE;
		Arrays.sort(nums);
		int i = 0, j = nums.length - 1, minDiff = Math.abs(nums[i] + nums[j] - target);
		while (i < j) {
			if (minDiff == 0)
				return 0;
			if (Math.abs(nums[i] + nums[j] - target) < minDiff)
				minDiff = Math.abs(nums[i] + nums[j] - target);
			if (nums[i] + nums[j] > target) {
				j--;
			} else if (nums[i] + nums[j] < target) {
				i++;
			}
		}
		return minDiff;
	}
	
	
	public static void main(String[] args) {
		int[] nums = new int[]{33, -2, 14, 5, 4, 9};
		int target = 22; // minDiff = 1, indices = [2, 4]
		
		System.out.println("The minimum difference is " + getMinDiff1(nums, target));
		System.out.println("The minimum difference is " + getMinDiff2(nums, target));
	}
}
