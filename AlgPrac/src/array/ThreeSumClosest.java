package array;

import java.util.Arrays;

/***************************************************************************
* Problem No. : 16
* Problem Name: Three Sum Closest
* Problem URL : https://leetcode.com/problems/3sum-closest/description/
* Date        : Oct 30 2017
* Author	  :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
* 		Return the sum of the three integers.
* 	Assumption:
* 		1. You may assume that each input would have exactly one solution.
	Example:
* 	Input: [-1, -4, 1, 2] target = 1
* 	Output: 2.  2 is the sum which has minDiff = 1 between 1. 2 is contributed from -1, 1, 2.
* 	Data Structure and Alg:
* 		See Code Comments  
* Complexity  : 
* 	Time Complexity: O() -- See Code Comments
* 	Space Complexity: O() -- See Code Comments
* 
* meta        : tag-array, tag-two-pointers, tag-sort
***************************************************************************/
public class ThreeSumClosest {

	/**
	 * Solution 1:
	 * 	Sort the input array, get the initial threeSum and the diff between target and threeSum.
	 * Then for each element el in the input array, use two pointers to 
	 * At the end return the sum.
	 * 
	 * Time Complexity: O(n^2) -- O(n) traverse for outer loop element and O(n) for inner loop twoSumClosest
	 * Space Complexity: O(1)
	 */
	public static int threeSumClosest(int[] nums, int target) {
        int res = Integer.MIN_VALUE;
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        res = nums[0] + nums[1] + nums[nums.length - 1];
        int diff = Math.abs(res - target);
        
        int i = 0;
        while (i < nums.length) {
            int j = i + 1, k = nums.length - 1;   /* j - left pointer, k - right pointer */ 
            while (j < k) {
                int localSum = nums[i] + nums[j] + nums[k];
                int localDiff = Math.abs(localSum - target);
                if (localDiff == 0) {
                    return localSum;
                }
                if (localDiff < diff) { 
                    diff = localDiff;
                    res = localSum;
                }
                if (localSum < target) { //注意这里的比较应该是 localSum 跟 target ！！
                    j++;
                } else {
                    k--;
                }
            }
            i++;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
        }
        return res;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[]{-4, 1, 2, -1};
		int k = 1;
		System.out.println(String.format("The 3 sum cloeset to %d is %d", k, threeSumClosest(nums, k)));
			// closest sum: 2
		
		nums = new int[]{1, 2, 3};
		k = 100;
		System.out.println(String.format("The 3 sum cloeset to %d is %d", k, threeSumClosest(nums, k)));
			// closest sum: 6
		
		nums = new int[]{0, 2, 1, -3};
		k = 1;
		System.out.println(String.format("The 3 sum cloeset to %d is %d", k, threeSumClosest(nums, k)));
			// closest sum: 0
	}
}
