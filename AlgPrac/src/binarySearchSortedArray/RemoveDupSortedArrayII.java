package binarySearchSortedArray;

import java.util.Scanner;
/**
 * 
 * Like RemoveDupSortedArray but this time we allow an element
 * to be duplicated at most twice
 * http://www.lintcode.com/en/problem/remove-duplicates-from-sorted-array-ii/
 *
 */

public class RemoveDupSortedArrayII {
	/**
     * @param nums: a array of integers
     * @return : return an integer
     */
	public static int removeDup(int[] nums) {
		if (nums.length <= 2) {
			return nums.length;
		}
		int prev = 1;
		int cur = 2;
		while (cur < nums.length) {
			if (nums[cur] == nums[prev] && nums[cur] == nums[prev - 1]) {
				cur++;
			} else {
				prev++;
				nums[prev] = nums[cur];
				cur++;
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
		System.out.println("*** Welcome to Ben's Remove Duplicates in Sorted Array II Test ***");
		
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
