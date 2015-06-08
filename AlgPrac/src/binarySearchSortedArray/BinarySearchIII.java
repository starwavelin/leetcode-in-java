package binarySearchSortedArray;

import java.util.Scanner;

public class BinarySearchIII {
	
	/**
	 * 
	 * @param nums the input int array
	 * @param target the integer we want to find
	 * @return the ANY position of the integer we wanna find; otherwise, return -1
	 */
	public static int binarySearch(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		int start = 0;
		int end = nums.length - 1;
		int mid;
		
		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if (nums[start] == target) {
			return start;
		}
		
		if (nums[end] == target) {
			return end;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Binary Search III Test ***");
		
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
		int result = binarySearch(testArray, target);
		if (result != -1) {
			System.out.print("The number " 
				+ target + " is found at position " + result);
		} else {
			System.out.print("The number " + target + " is NOT found!");
		}
	}
}
