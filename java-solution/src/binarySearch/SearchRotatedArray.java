package binarySearch;

import java.util.Scanner;
/**
 * Given a rotated sorted array with no duplicates; find a target value in it.
 * http://www.lintcode.com/en/problem/search-in-rotated-sorted-array/
 * 
 */
public class SearchRotatedArray {
	
	/**
	 * @param nums: an integer rotated array
	 * @param target: an int to be searched
	 * @return : the index of the target; if not found, return -1
	 */
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int start = 0, end = nums.length - 1, mid;
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[start] < nums[mid]) {
				if (nums[start] <= target && target <= nums[mid]) {
					end = mid;
				} else {
					start = mid; // remain a rotated array
				}
			} else {
				if (nums[mid] <= target && target <= nums[end]) {
					start = mid;
				} else {	
					end = mid;	// remain a rotated array
				}
			}
		}
		if (nums[start] == target) {
			return start;
		} else if (nums[end] == target) {
			return end;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Search in Rotated Array Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer sorted array, \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		System.out.print("Give your target number: ");
		int target = sc.nextInt();
		int result = search(testArray, target);
		if (result != -1) {
			System.out.print("The number " + target + " is found at position " + result);
		} else {
			System.out.print("The number " + target + " is NOT found!");
		}
	}
}
