package binarySearch;

import java.util.Scanner;

public class BinarySearchIII {
	
	/**
	 * Solution 1: iteration template
	 * @param nums the input int array
	 * @param target the integer we want to find
	 * @return the ANY position of the integer we wanna find; otherwise, return -1
	 */
	private static class Solution1 {
		public int binarySearch(int[] nums, int target) {
			if (nums == null || nums.length == 0) {
				return -1;
			}
			
			int start = 0, end = nums.length - 1, mid;
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
			} else if (nums[end] == target) {
				return end;
			}
			return -1;
		}
	}
	
	private static class Solution2 {
		public int binarySearch(int[] nums, int target) {
			if (nums == null || nums.length == 0) {
				return -1;
			}
			return search(nums, 0, nums.length - 1, target);
		}
		
		private int search(int[] nums, int start, int end, int target) {
			if (start > end)
				return -1;
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < target) {
				return search(nums, mid + 1, end, target);
			} else {
				return search(nums, start, mid - 1, target); 
				// be careful, here should replace end with mid - 1.
				// And return the function
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Binary Search III Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer sorted array, \nleave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		System.out.print("Give your target number: ");
		int target = sc.nextInt();
		
		Solution2 sol = new Solution2(); // Toggle Solutions here
		
		int result = sol.binarySearch(testArray, target);
		if (result != -1) {
			System.out.print("The number " + target + " is found at position " + result);
		} else {
			System.out.print("The number " + target + " is NOT found!");
		}
	}
}
