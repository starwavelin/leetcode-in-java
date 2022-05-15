package binary_search;

/***************************************************************************
* Problem No. : 81
* Problem Name: Search Rotated Sorted Array II
* Problem URL : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
* Date        : Feb 17 2018
* Author      : @codingbro
* Notes       : 
* 	Scenario: 
* 		Allow duplicates in the rotated sorted array
* 	Assumption:
* 		1. 
	Example:
* 	Input: [1,1,3,1], 3
* 	Output:  true
* 		
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-binary_search
***************************************************************************/
public class SearchRotatedArray2 {
	
	/**
	 * 时复一般情况O(logn)，但由于 if (nums[mid] == nums[start]) { start++; } 可能退化到O(n)
	 */
	private static class Solution {
		public boolean search(int[] nums, int target) {
			if (nums == null || nums.length == 0)
				return false;
			int start = 0, end = nums.length - 1, mid;
			while (start + 1 < end) {
				mid = start + (end - start) / 2;
				if (nums[mid] == target) {
					return true;
				} else if (nums[mid] > nums[start]) {
					if (nums[start] <= target && target <= nums[mid]) {
						end = mid;
					} else {
						start = mid;
					}
				} else if (nums[mid] < nums[start]) {
					if (nums[mid] <= target && target <= nums[end]) {
						start = mid;
					} else {
						end = mid;
					}
				} else {
					start++;
				}
			}
			if (nums[start] == target || nums[end] == target) {
				return true;
			}
			return false;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
