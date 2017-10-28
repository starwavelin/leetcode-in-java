package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utility.ListUtil;
/***************************************************************************
* Problem No. : 15
* Problem Name: Three Sum
* Problem URL : https://leetcode.com/problems/3sum/description/
* Date        : Oct 27 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
* 		Find all unique triplets in the array which gives the sum of zero.
* 	Assumption:
* 		0. When there is no answer, return an empty list
* 		1. Duplicate elements could exist in the array S
* 		2. But your solution cannot contain duplicate triplets
	Example:
* 	Input: [-2, -3, -3, 2, -3, 6, 1, 0, 6]
* 	Output: 
* 		[
* 			[-3, -3, 6],
* 			[-3, 1, 2],
* 			[-2, 0, 2]
* 		]
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-array, tag-two-pointers, tag-sort, tag-hash
***************************************************************************/
public class ThreeSum {
	/**
	 * A brute force solution is: for each given num in nums, try to find the other two numbers in nums such that their sum is the 
	 * opposite of the given num. This solution uses 3 nested for loops so time complexity is O(n^3).
	 * We don't want this naive solution.
	 * 
	 * Solution 1:
	 * 	Sort the nums array first, then
	 * 	For each number in nums, we want to find the other two numbers whose sum is the opposite of the given num.
	 *  The outer for loop costs O(n) and the part inside the for loop is a two-sum on a sorted array problem,
	 *  which can be solved in O(n). So total time complexity is O(nlogn) + O(n^2) = O(n^2)
	 * Optimization and De-duplication:
	 * 	 1. The next fixed number in the outer for-loop should be the one which is next greater than current fixed number
	 * 		ie, [-3, -3, -3, -2, 0, 1, 2, 6, 6], cur fixed number is -3, than next fixed number should be -2,
	 * 			cuz [-3, 1, 2] [-3, 1, 2] are the same solution.
	 * 	 2. The left pointer of the two-sum subproblem should start from the one after the current fixed number,
	 * 		ie. If the current fixed number is -3, left pointer should start from -2; 
	 * 			if the cur fixed number is -2, left pointer should start from 0.
	 *   3. How many steps should left pointer move when we found a solution?
	 *   	ie, [-3, -3, -3, -2, 0, 1, 2, 6, 6], and we found one solution [-3, -3, 6] where the middle -3 is from index 1 and 6 is from index nums.lenth-1
	 *   	then if we just move left pointer one index to right and right pointer one index to left, 
	 *   		we will get another [-3, -3, 6] where the middle index is from index 2 and 6 is from index nums.length - 2.
	 *   	Duplication!
	 *   	So, left pointer should start from the next number that is greater than the cur fixed number, and when 
	 *   moving next pointer, we want to move it to the number that is not equal to the number left pointer currently points!!!
	 *   	In this example, once we found [-3, -3, 6], left pointer moves to number -2, right pointer moves to -6 with index nums.length - 2.
	 * 
	 * Space Complexity: O(1)
	 * 
	 * 口诀：	Sort后，cur下一个必找大于当前的，left pointer先为cur之下一个，如有解了，left pointer下一个必为大于当前的。
	 */
	public static List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 3) {
			return res;
		}
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length - 2) {
			int target = - nums[i];
			int l = i + 1, r = nums.length - 1;
			while (l < r) {
				if (nums[l] + nums[r] > target) {
					r--;
				} else if (nums[l] + nums[r] < target) {
					l++;
				} else {
					List<Integer> rec = new ArrayList<>();
					rec.add(nums[i]);
					rec.add(nums[l++]);
					rec.add(nums[r--]);
					res.add(rec);
					while (l < nums.length && nums[l] == nums[l - 1]) { //while去有解后leftpointer的重，leftpointer不可越界
						l++;
					}
				}
			}
			i++;
			while (i < nums.length && nums[i] == nums[i - 1]) { //while去curNumber的重，curNumber不可越界
				i++;
			}
		}
		return res;
	}
	
	
	public static List<List<Integer>> threeSum2(int[] nums) {
		return null;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{-2, -3, 0, -3, -3, 2, 6, 1, 6};
		List<List<Integer>> res = threeSum1(nums);
		for (List<Integer> l : res) {
			System.out.print("One result is: ");
			ListUtil.display(l);
		}
		
		System.out.println();
		nums = new int[]{0, 0, 0};
		res = threeSum1(nums);
		for (List<Integer> l : res) {
			System.out.print("One result is: ");
			ListUtil.display(l);
		}
		
	}
}
