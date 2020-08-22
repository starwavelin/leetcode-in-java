package array;

import java.util.Arrays;

/***************************************************************************
* Problem No. : 259
* Problem Name: Three Sum Smaller
* Problem URL : https://leetcode.com/problems/3sum-smaller/description/
* Date        : Feb 9 2018
* Author      : @codingbro
* Notes       : 
* 	Scenario: 
* 		
* 	Assumption:
* 		1. 
	Example:
* 	Input: [-2, 0, 1, 3] target = 2
* 	Output: 2.
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-array, tag-two-pointers, tag-sort
***************************************************************************/
public class ThreeSumSmaller {
	
	public static class Solution {
		
		/**
		 * 注：
		 * 本题是不同的index i就可以算一个解，所以不要对loop counter i 去重。
		 */
		public int threeSumSmaller(int[] nums, int target) {
	        if (nums == null || nums.length < 3) {
	            return 0;
	        }    
	        int res = 0;
	        Arrays.sort(nums);
	        int i = 0;
	        while (i < nums.length - 2) {
	            int l = i + 1, r = nums.length - 1;
	            while (l < r) {
	                int localSum = nums[i] + nums[l] + nums[r];
	                if (localSum < target) {
	                    res += r - l;
	                    l++;
	                } else {
	                    r--;
	                }
	            }
	            i++;
	        }
	        return res;
	    }
	}
}
