package binarySearch;

import java.util.Scanner;

/***************************************************************************
* Problem No. : 26
* Problem Name: Remove Duplicates from Sorted Array
* Problem URL : https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
* Date        : Oct 21 2017
* Author      :	Xian Lin
* Notes       : 
* 	Scenario: 
* 		Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
* 	Assumption:
* 		1. Sorted Array
* 		2. Do it in place
	Example:
* 	Input: [1, 2, 2]
* 	Output: should return new length 2, and the first two elements in the new array will be 1, 2, respectively.
* 	Data Structure and Alg:
* 		Use two pointers prev and cur, prev starts from index 0 and cur starts from index 1
* 		Use cur to traverse the array till cur reaches the array length
* 			if (nums[prev] == nums[cur]) cur++ to continue traverse the array
* 			if (nums[prev] != nums[cur]) prev++, use nums[cur] to replace nums[prev], cur++
* 		The length of the new array is prev + 1.
* 		
* Complexity  : 
* 	Time Complexity: O(n) cuz traverse the whole array
* 	Space Complexity: O(1) cuz just open two pointers cur and prev
* 
* meta        : tag-array, tag-two-pointers
***************************************************************************/
public class RemoveDupSortedArray {
	
	public static int removeDup(int[] nums) {
		if (nums == null) {
			return 0;
		}
		if (nums.length < 2) {
			return nums.length;
		}
		int prev = 0, cur = 1;
		while (cur < nums.length) {
			if (nums[prev] == nums[cur]) {
				cur++;
			} else {
				nums[++prev] = nums[cur++];
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
		System.out.println("*** Welcome to Xian's Remove Duplicates in Sorted Array I Test ***");
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer sorted array (with duplicates), leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		int size = removeDup(testArray);
		System.out.println(String.format("The new array has size: %d", size));
		if (removeDup(testArray) > 0) {
			displayArray(testArray, size);
		} else {
			System.out.print("Check your input array!!");
		}
	}
}
