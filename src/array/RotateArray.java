package array;

/***************************************************************************
* Problem No. : 189
* Problem Name: Rotate Array
* Problem URL : https://leetcode.com/problems/rotate-array/description/
* Date        : Oct 17 2017
* Author      :	@codingbro
* Notes       :
* 	Scenario:
* 		Given an integer array, and k steps. Move all of its elements after k to the front.
* 	Assumption:
* 		1. The input array doesn't need to be ordered
	Example:
* 	Input: [7, 89, -13, 25, 6], k = 3
* 	Output: [-13, 25, 6, 7, 89]
* 	Data Structure and Alg:
* 		See solutions in the code comments
* Complexity  :
* 	Time Complexity: See solutions in the code comments
* 	Space Complexity: See solutions in the code comments
*
* meta        : tag-array, tag-math, tag-two-pointers
***************************************************************************/
public class RotateArray {
	public static class Array {
		/**
		 * Solution 1:
		 * 取模映射法
		 * orig array		: [7, 89, -13, 25, 6], k = 3
		 *
		 * replicate array	: [7, 89, -13, 25, 6]
		 *
		 * then we can draw lines for the mappings.
		 * ie. 7-->25, 89 -->6, -13 --> 7 (by elements)
		 * then by indexes, we have
		 * 	replicate's 0 to orig's 3
		 *  replicate's 1 to orig's 4
		 *  replicate's 2 to orig's 0
		 * So, we can see, replicate's index is linear increasing from 0, which can be handled in a typical for loop
		 * And, orig's index is actually also linear increasing with a format (i+k) % arraySize, i starts from 0.
		 *
		 * Space Complexity O(n) cuz replicate a new array of the original n-element array
		 * Time Complexity O(n) cuz traverse the whole array
		 */
		public void rotate(int[] nums, int k) {
			if (nums == null || nums.length == 0)
				return;

			int[] t = new int[nums.length];
			for (int i = 0; i < nums.length; i++) {
				t[i] = nums[i];
			}
			for (int i = 0; i < nums.length; i++) {
				nums[(i+k) % nums.length] = t[i];
			}
		}

		/**
		 * Solution 2:
		 * Hint told us we can do it in O(1) space, OK, with Solution 1 presented,
		 * we can try not to open a space of the whole array, but use some variables to do that.
		 * A little complicated but you can consult the following link:
		 * http://www.cnblogs.com/grandyang/p/4298711.html 解法二 section
		 */


		/**
		 * Solution 3:
		 * Denote n = nums.length, k steps.
		 * Then we use reverse methods,
		 * 	Orig: [7, 89, -13, 25, 6], k = 3
		 * Reverse the two subarrays, index 0 to n-k-1, and index n-k to n-1, we got
		 * 	[89, 7,    6, 25, -13]
		 * Then reverse the whole array, index 0 to n-1, we got
		 * 	[-13, 25, 6, 7, 89]
		 *
		 * two-pointers:
		 * 	the reverse process needs to pointers one from the beginning index, and the other from the end index
		 * then these two pointers move toward each other (start++, end--), like making a sandwich 夹逼法则
		 * this type of two pointers moving toward each other is common in many sorting algorithms.
		 * See tag `tag-sort`
		 *
		 * Time Complexity O(n)
		 * Space Complexity O(1) cuz we just use one extra variable tmp
		 *
		 * Tricky part: Question didn't say k < n so if k > n,
		 * 	you shall know k actually can be represented as k = k % n
		 */
		public void rotate3(int[] nums, int k) {
			if (nums == null || nums.length == 0)
				return;
			k %= nums.length;


			/* The following is wrong because it mistakenly consider k steps as index of k!!!
			 * 混淆了, k steps的话，断开两个subarray 的地方应该是 0 --> n-k-1, n-k --> n-1
			reverse(nums, 0, k-1);
			reverse(nums, k, nums.length-1);
			reverse(nums, 0, nums.length-1);
			*/

			reverse(nums, 0, nums.length-k-1);
			reverse(nums, nums.length-k, nums.length-1);
			reverse(nums, 0, nums.length-1);
		}

		/**
		 * help method to rotate3()
		 */
		private void reverse(int[] nums, int start, int end) {
			while (start < end) {
				int tmp = nums[start];
				nums[start++] = nums[end];
				nums[end--] = tmp;
			}
		}
	}

	public static void main(String[] args) {
		Array arr = new Array();
		int[] nums1 = new int[]{7, 89, -13, 25, 6};
		int k = 8; // k = 3
		arr.rotate(nums1, k);
		System.out.print("Now the array is: ");
		for (int num : nums1) {
			System.out.print(num + " ");
		}
		System.out.println();

		int[] nums2 = new int[]{7, 89, -13, 25, 6, 278};
		k = 4;
		arr.rotate3(nums2, k);
		System.out.print("Now the array is: ");
		for (int num : nums2) {
			System.out.print(num + " ");
		}
		System.out.println();

		int[] nums3 = new int[]{1, 2, 3};
		k = 1;
		arr.rotate3(nums3, k);
		System.out.print("Now the array is: ");
		for (int num : nums3) {
			System.out.print(num + " ");//expect 3, 1, 2
		}
		System.out.println();
	}
}
