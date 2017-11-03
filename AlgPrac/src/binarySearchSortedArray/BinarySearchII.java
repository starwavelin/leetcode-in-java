package binarySearchSortedArray;

import java.util.Scanner;

public class BinarySearchII {
	
	/**
	 * 
	 * @param nums the input int array
	 * @param target the integer we want to find
	 * @return the LAST position of the integer we wanna find; otherwise, return -1
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
			if (nums[mid] == target) { //找最后一个，==的时候移动start
				start = mid;
			} else if (nums[mid] < target) {
				start = mid;
			} else {
				end = mid;
			}
		}
		
		if (nums[end] == target) {
			return end;
		} else if (nums[start] == target) {
			return start;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Binary Search II Test ***");
		
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
				+ target + " is found at position " + result + " as its Last occurrence.");
		} else {
			System.out.print("The number " + target + " is NOT found!");
		}
	}
	
}
