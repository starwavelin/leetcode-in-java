package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utility.ListUtil;

/***************************************************************************
* Problem No. : 18
* Problem Name: Four Sum
* Problem URL : https://leetcode.com/problems/4sum/description/
* Date        : Oct 30 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given an array S of n integers, find four integers in S such that their sum equals a given number, target. 
* 		Return all the unique quadruplets.
* 	Assumption:
* 		1. 
	Example:
* 	Input: [1, 0, -1, 0, -2, 2], and target = 0
* 	Output: 
* 		[
  			[-1,  0, 0, 1],
  			[-2, -1, 1, 2],
  			[-2,  0, 0, 2]
		]
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-array, tag-two-pointers, tag-sort, tag-hash
***************************************************************************/
public class FourSum {
	
	/**
	 * Solution 1:
	 * 	Sort the given input array first, then for each element in the outer loop, the inner one becomes a 3Sum problem,
	 * and we solve the 3Sum problem in O(n^2). Then total time complexity is O(n^3). 
	 * And the key point is to de-duplicates.
	 * Space complexity is O(1) cuz we just use several pointers to help us.
	 */
	public static List<List<Integer>> fourSum1(int[] nums, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length < 4) {
			return res;
		}
		Arrays.sort(nums);
		int i = 0;
		while (i < nums.length - 3) {
			/* 3Sum problem inside */
			int threeSumTarget = k - nums[i];
			int j = i + 1;
			while (j < nums.length - 2) {
				int twoSumTarget = threeSumTarget - nums[j];
				int l = j + 1, r = nums.length - 1;
				while (l < r) {
					if (nums[l] + nums[r] < twoSumTarget) {
						l++;
					} else if (nums[l] + nums[r] > twoSumTarget) {
						r--;
					} else {
						List<Integer> rec = new ArrayList<>();
						rec.add(nums[i]);
						rec.add(nums[j]);
						rec.add(nums[l++]);
						rec.add(nums[r--]);
						res.add(rec);
						while (l < nums.length - 1 && nums[l] == nums[l - 1]) {
							l++;
						}
					}
				}
				j++; //对while loop始终不忘记loop counter的自增
				while (j < nums.length - 2 && nums[j] == nums[j - 1]) {
					j++;
				}
			}
			i++;
			while (i < nums.length - 3 && nums[i] == nums[i - 1]) {
				i++;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{1, 0, -1, 0, -2, 2};
		int k = 0;
		List<List<Integer>> res = fourSum1(nums, k);
		for (List<Integer> l : res) {
			System.out.print("One result is: ");
			ListUtil.display(l);
		}
		
		
	}

}
