package array;

import java.util.Arrays;
import java.util.HashSet;

/***************************************************************************
* Problem No. : 1
* Problem Name: Two Sum
* Problem URL : https://leetcode.com/problems/two-sum/description/
* Date        : Oct 18 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given an array of integers, return indices of the two numbers such that they add up to a specific target.
* 	Assumption:
* 		1. If there are more than 1 solutions, return 1 solution is fine
* 		2. If there are no solutions, return [-1, -1]
	Example:
* 	Input: [33, -2, 14, 5, 4, 9] target 3
* 	Output: [1, 3]
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-array, tag-two-pointers, tag-sort, tag-hash
***************************************************************************/
public class TwoSum {
	/**
	 * Before delve into the two sum of returning indices of the two integers summing up to the target,
	 * let's see if the problem just asked:
	 * Do you see there are two elements sum up to be the target？If yes return true otherwise false.
	 */
	public static class Array1 {
		/**
		 * Solution 1:
		 * Brute force:
		 * for each integer, I scan the left integers and see if there is one added to this integer to sum up to be target
		 * if yes, return true.
		 * if finish the whole process but cannot find one, return false
		 * 
		 * Time complexity: O(n^2) cuz nested for loops
		 * Space complexity: O(1) cuz just open two pointers
		 */
		public boolean twoSumExist1(int[] nums, int target) {
			if (nums == null || nums.length < 2)
				return false;
			for (int i = 0; i < nums.length; i++) {
				for (int j = i+1; j < nums.length; j++) {
					if (nums[i] + nums[j] == target)
						return true;
				}
			}
			return false;
		}
		
		/**
		 * Solution 2:
		 * Sort first:
		 * 	I don't need to return indices so I don't need to preserve the orders of integers. 
		 * I sort the array first, then use two pointers, one from the starting point and the other from the ending point.
		 * If the current sum > target, decrease the ending pointer;
		 * if the current sum < target, increase the starting pointer;
		 * if equal, bingo!
		 * 
		 * Time complexity: O(nlogn) -- sorting
		 * Space complexity: O(1) cuz just open two pointers
		 * Note: 
		 * 	this solution can be used to solve Two Sum II (input array is sorted)
		 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
		 */
		public boolean twoSumExist2(int[] nums, int target) {
			if (nums == null || nums.length < 2)
				return false;
			Arrays.sort(nums);
			int i = 0, j = nums.length - 1;
			while (i < j) {
				if (nums[i] + nums[j] > target) {
					j--;
				} else if (nums[i] + nums[j] < target) {
					i++;
				} else {
					return true;
				}
			}
			return false;
		}

		/**
		 * Solution 3:
		 * Use space to trade for time.
		 * 	Use HashSet. We just traverse the int array once, for each element we encounter, we first test if 
		 * (target - currentInteger) already exists in the set, if yes return true; if no, add this integer into 
		 * the set.
		 * 
		 * Time Complexity: O(n) cuz only traverse once
		 * Space Complexity: O(n) cuz open a HashSet which would be size n
		 */
		public boolean twoSumExist3(int[] nums, int target) {
			if (nums == null || nums.length < 2) 
				return false;
			HashSet<Integer> set = new HashSet<>();
			for (int i = 0; i < nums.length; i++) {
				if (set.contains(target - nums[i]))
					return true;
				set.add(nums[i]);
			}
			return false;
		}
	}
	
	/**
	 * Now we start the real Two Sum problem, wanting indices being returned
	 */
	public static class Array2 {
		
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{33, -2, 14, 5, 4, 9};
		int target1 = 3; // has solution
		int target2 = 20; // no solution
		
		Array1 arr1 = new Array1();
		System.out.println("Is there a solution for target1? " + arr1.twoSumExist1(nums, target1));
		System.out.println("Is there a solution for target2? " + arr1.twoSumExist1(nums, target2));
		System.out.println("Is there a solution for target1? " + arr1.twoSumExist2(nums, target1));
		System.out.println("Is there a solution for target2? " + arr1.twoSumExist2(nums, target2));
		System.out.println("Is there a solution for target1? " + arr1.twoSumExist3(nums, target1));
		System.out.println("Is there a solution for target2? " + arr1.twoSumExist3(nums, target2));
	}
}
