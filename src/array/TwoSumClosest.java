package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

/***************************************************************************
* Problem No. : 
* Problem Name: Two Sum Closest
* Problem URL : 
* Date        : Oct 18 2017
* Author	  :	@codingbro
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
		int i = 0, j = nums.length - 1;
		int sum = nums[i] + nums[j]; /* In case the problem wants you to return sum */
		int minDiff = Math.abs(sum - target);
		while (i < j) {
			int localSum = nums[i] + nums[j];
			int localDiff = Math.abs(localSum - target);
			if (localDiff == 0) {
				sum = localSum;
				return 0;
			}
			if (localDiff < minDiff) {
				minDiff = localDiff;
				sum = localSum;
			}	
			if (localSum > target) {
				j--;
			} else if (localSum < target) {
				i++;
			}
		}
		return minDiff;
	}
	
	/**
	 * Solution:
	 * 	Based on getMinDiff2, this time we want indices of the minDiff being returned. So also similar to Solution 2 of 
	 * TwoSum, we use a helper class to store value and index of an element.
	 * And again similar to getMinDiff2, in the while loop, instead of updating minDiff, we update minDiffIndices.
	 * 
	 * Time Complexity: O(nlogn) cuz sorting
	 * Space Complexity: O(n) cuz traverse the array to store each element's original index first.
	 */
	public static int[] twoSumClosestIndices(int[] nums, int target) {
		class Elem {
			int val;
			int index;
			public Elem(int val, int index) { this.val = val; this.index = index; }
		}
		if (nums == null || nums.length < 2) {
			return new int[]{-1, -1};
		}
		List<Elem> elems = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			elems.add(new Elem(nums[i], i));
		}
		elems.sort((Elem e1, Elem e2) -> e1.val - e2.val);
		int i = 0, j = elems.size() - 1, minDiff = Math.abs(elems.get(i).val + elems.get(j).val - target);
		int[] ret = (elems.get(i).index < elems.get(j).index) 
				? new int[]{ elems.get(i).index, elems.get(j).index }
				: new int[]{ elems.get(j).index, elems.get(i).index };
		while (i < j) {
			if (Math.abs(elems.get(i).val + elems.get(j).val - target) < minDiff) {
				ret = (elems.get(i).index < elems.get(j).index) 
						? new int[]{ elems.get(i).index, elems.get(j).index }
						: new int[]{ elems.get(j).index, elems.get(i).index };
			}
			if (elems.get(i).val + elems.get(j).val > target) {
				j--;
			} else if (elems.get(i).val + elems.get(j).val < target) {
				i++;
			} else { // when == target, means difference is 0, directly return their indices.
				return (elems.get(i).index < elems.get(j).index) 
						? new int[]{ elems.get(i).index, elems.get(j).index }
						: new int[]{ elems.get(j).index, elems.get(i).index };
			}
		}
		return ret;
	} 
	
	public static void main(String[] args) {
		int[] nums = new int[]{33, -2, 14, 5, 4, 9};
		int target = 22; // minDiff = 1, indices = [2, 5]
		
		System.out.println("The minimum difference is " + getMinDiff1(nums, target));
		System.out.println("The minimum difference is " + getMinDiff2(nums, target));
		
		// Reset nums
		nums = new int[]{33, -2, 14, 5, 4, 9};
		System.out.println(String.format("The minimum difference have indices: %d %d", twoSumClosestIndices(nums, target)[0], twoSumClosestIndices(nums, target)[1]));
		nums = new int[]{33, -2, 9, 5, 4, 14};
		System.out.println(String.format("The minimum difference have indices: %d %d", twoSumClosestIndices(nums, target)[0], twoSumClosestIndices(nums, target)[1]));
		nums = new int[]{3, 5};
		target = 8;
		System.out.println(String.format("The minimum difference have indices: %d %d", twoSumClosestIndices(nums, target)[0], twoSumClosestIndices(nums, target)[1]));
		nums = new int[]{3, 7};
		target = 8;
		System.out.println(String.format("The minimum difference have indices: %d %d", twoSumClosestIndices(nums, target)[0], twoSumClosestIndices(nums, target)[1]));
		nums = new int[]{6, 4};
		target = 8;
		System.out.println(String.format("The minimum difference have indices: %d %d", twoSumClosestIndices(nums, target)[0], twoSumClosestIndices(nums, target)[1]));
	}
}
