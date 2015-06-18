package binarySearchSortedArray;

import java.util.Scanner;
/**
 * Remove duplicates in a sorted array such that each element 
 * appear only once and return the new length.
 * Do not allocate extra space for another array, 
 * you must do this in place with constant memory.
 * http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-array/
 */
public class RemoveDupSortedArray {
	
	public static int removeDup(int[] nums) {
		if (nums.length < 2) {
			return nums.length;
		}
		int prev = 0;
		for (int cur = 0; cur < nums.length; cur++) {
			if (nums[prev] != nums[cur]) {
				prev++;
				nums[prev] = nums[cur];
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
		System.out.println("*** Welcome to Ben's Remove Duplicates in Sorted Array Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer sorted array (with duplicates), \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		int size = removeDup(testArray);
		if (size > 0) {
			displayArray(testArray, size);
		} else {
			System.out.print("Check your input array!!");
		}
	}
}
