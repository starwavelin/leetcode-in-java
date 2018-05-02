package sorting;

import java.util.HashSet;
import java.util.Set;

/***************************************************************************
* Problem No. : 41
* Problem Name: First Missing Positive
* Problem URL : https://leetcode.com/problems/first-missing-positive/description/
* Date        : Dec 13 2017
* Author      :	Xian Lin
* Notes       :
* 	Scenario:
*
* 	Assumption:
*
	Example:
* 	Input: [2, 1, 0, -1]
* 	Output: 3
* 	Input: [4, 5, -1, 1]
* 	Output: 2
*
* 	Data Structure and Alg:
* 		see code comments
* Complexity  :
* 	Time Complexity: O() -- see code comments
* 	Space Complexity: O() -- see code comments
*
* meta        : tag-hash, tag-sort
***************************************************************************/
public class FirstMissingPositive {

	/**
	 * Solution 1:
	 * Space O(n) solution using hash
	 * Time Complexity O(n) -- 扫两遍，第一遍是input array, 第二遍是 From 1 to max
	 *
	 * Use a hashset to store all the positive integers in the given array,
	 * use a max to get the maximum integer from the given array.
	 * Then traverse the numbers from 1 to max,
	 * 	if there is a number missing in the hashset, that number is the first missing positive
	 * 	else return max + 1.
	 */
	public static int firstMissingPositive1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}
		Set<Integer> set = new HashSet<>();
		int max = nums[0];
		for (int num : nums) {
			if (num > max) {
				max = num;
			}
			if (num > 0) {
				set.add(num);
			}
		}
		for (int i = 1; i <= max; i++) {
			if (!set.contains(i)) {
				return i;
			}
		}
		return max + 1;
	}

	/**
	 * Solution 2:
	 * Space O(1) solution using the idea of bucket sort
	 * Time Complexity O(n)
	 *
	 * Since it requires us to use O(1) space, that means we are not able to create any new array/map/set,
	 * then the idea is to overwrite the original input array.
	 * Bucket-sort idea
	 *
	 */
	public static int firstMissingPositive2(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 1;
		}
		int i = 0;
		int len = nums.length;
		while (i < len) {
			if (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
				int k = nums[i];
				nums[i] = nums[nums[i] - 1]; //注意swap函数的写法，这里nums[i]已经发生了变化
				nums[k - 1] = k;
				//swap(nums, i, nums[i] - 1);
			} else {
				i++;
			}
		}
		for (i = 0; i < len; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return len + 1;
	}

	public static void swap(int[] nums, int i, int j) {
		int k = nums[i];
		nums[i] = nums[j];
		nums[j] = k;
	}

	public static void main(String[] args) {
		int[] nums1 = new int[]{2, 1, 0, -1};
		int[] nums2 = new int[]{4, 5, -1, 1, 2};
		System.out.println("The first missing positive is: " + firstMissingPositive2(nums1));
		System.out.println("The first missing positive is: " + firstMissingPositive2(nums2));
	}
}
