package binary_search;

/***************************************************************************
* Problem No. : 162
* Problem Name: Find Peak Element
* Problem URL : https://leetcode.com/problems/find-peak-element/description/
* Date        : Feb 16 2018
* Author      : @codingbro
* Notes       : 
* 	Scenario: 
* 		
* 	Assumption:
* 		1. 
	Example:
* 	Input:
* 	Output: 
* 		
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-binary_search
***************************************************************************/
public class FindPeakElement {
	
	private static class Solution {
		public int findPeakElement(int[] nums) {
	        if (nums == null || nums.length == 0) {
	            return -1;
	        }
	        int n = nums.length;
	        if (n == 1) {
	            return 0;
	        }
	        if (nums[0] > nums[1]) {
	            return 0;
	        } else if (nums[n-1] > nums[n-2]) {
	            return n -1;
	        }
	        
	        int start = 0, end = n - 1, mid;
	        while (start < end) {
	            mid = start + (end - start) / 2;
	            if ( (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) ) {
	                return mid;
	            } else if (nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1]) {
	                start = mid;
	            } else if (nums[mid-1] > nums[mid] && nums[mid] > nums[mid+1]) {
	                end = mid;
	            } else {
	                start = mid;
	            }
	        }
	        return -1;
	    }
	}
	
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[0];
		System.out.println(s.findPeakElement(nums)); // output: -1
		nums = new int[] {38};
		System.out.println(s.findPeakElement(nums)); // output: 0
		nums = new int[] {-5, 67};
		System.out.println(s.findPeakElement(nums)); // output: 1
		nums = new int[] {8798, -89};
		System.out.println(s.findPeakElement(nums)); // output: 0
		nums = new int[] {1, 2, 3, 1, 4, 3};
		System.out.println(s.findPeakElement(nums)); // output: 2 or 4 would be right
	}
}
