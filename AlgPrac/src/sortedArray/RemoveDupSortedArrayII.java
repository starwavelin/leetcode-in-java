package sortedArray;

import java.util.Scanner;
/***************************************************************************
* Problem No. : 80
* Problem Name: Remove Duplicates from Sorted Array II
* Problem URL : https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/
* Date        : Oct 21 2017
* Author      :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given a sorted array, remove the duplicates in place such that each element can at most appear twice and return the new length.
* 	Assumption:
* 		1. This is a follow up of its I question.
* 		2. Sorted Array
* 		2. Do it in place
	Example:
* 	Input: [1, 2, 2, 2, 3, 4, 4, 5]
* 	Output: should return new length 7, and its first 7 elements in the new array will be 1, 2, 2, 3, 4, 4, 5
* 	Data Structure and Alg:
* 		See code comments
* Complexity  : 
* 	Time Complexity: O(n) cuz traverse the whole array
* 	Space Complexity: O(1) cuz just open two or three pointers, depending on the solution I use.
* 
* meta        : tag-array, tag-two-pointers
***************************************************************************/
public class RemoveDupSortedArrayII {
	
	/**
	 * Similar to the solution of Remove Duplicates from Sorted Array I
	 * Since we allow at most two duplicates, so that we can check starting from position 1 and 2.
	 * And for the case of just moving cur pointer and do nothing else, 
	 * 	only when nums[cur] == nums[prev] && nums[cur] == nums[prev - 1] we do so.
     */
	public static int removeDup(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length < 3) {
			return nums.length;
		}
		int prev = 1;
		int cur = 2;
		while (cur < nums.length) {
			if (nums[cur] == nums[prev] && nums[cur] == nums[prev - 1]) {
				cur++;
			} else {
				nums[++prev] = nums[cur++];
			}
		}
		return prev + 1;
	}
	
	/**
	 * Solution 2:
	 * 	This one is not as good as Solution 1. We use an extra var count to count the repetition frequency.
	 * count by default is 1
	 * 	 if nums[cur] == nums[prev] and count is already 2, we increment cur (the case of only moving cur)
	 * 	 if nums[cur] == nums[prev] but count is not 2 yet, which means we just found this number appears twice, we set count to be 2
	 * 	 if nums[cur] != nums[prev], we reset count to be 1.
	 * then default case is the same as Solution 1,
	 * 	 increment prev and assign its position with the value from position cur and then increment cur
	 */
	public static int removeDup2(int[] nums) {
		if (nums == null || nums.length < 3) {
			return nums.length;
		}
		// Attention: int prev = 1, cur = 2, count = 1; Errored in case [1, 1, 1]
		/* Use this way, we must start from prev = 0 and cur = 1 */
		int prev = 0, cur = 1, count = 1;
		while (cur < nums.length) {
			if (nums[cur] == nums[prev] && count == 2) {
				cur++;
			} else {
				if (nums[cur] == nums[prev]) { // first time discover nums[cur] == nums[prev], set count to be 2
					count = 2;
				} else { // nums[cur] now != nums[prev], reset count back to 1
					count = 1;
				}
				prev++;
				nums[prev] = nums[cur++];
			}
		}
		return prev + 1;
	}
	
	public static void displayArray(int[] arr, int size) {
		System.out.print("The array after removing duplicates become: ");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's Remove Duplicates in Sorted Array II Test ***");
		Scanner sc = new Scanner(System.in);
		
		/* Solution 1 */
		System.out.print("Input your integer sorted array (with duplicates), leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		int size = removeDup(testArray);
		displayResult(size, testArray);
		
		/* Solution 2 */
		System.out.print("\nInput your integer sorted array (with duplicates), leave each number by space: ");
		strs = sc.nextLine().split(" ");
		testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		size = removeDup2(testArray);
		displayResult(size, testArray);
	}
	
	private static void displayResult(int size, int[] arr) {
		System.out.println(String.format("The new array has size: %d", size));
		if (size > 0) {
			displayArray(arr, size);
		} else {
			System.out.print("Check your input array!!");
		}
	}
}
