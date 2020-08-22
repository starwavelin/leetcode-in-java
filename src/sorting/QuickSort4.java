package sorting;

import java.util.Scanner;
/**
 * This is my QuickSort version II using the last element of the input array as
 * the pivot
 */
public class QuickSort4 {
	
	public static void quickSort(int[] nums) {
		// check for empty or null array
		if (nums == null || nums.length <= 1) {
			return;
		}
		sort(nums, 0, nums.length - 1);
	}

	private static void sort(int[] nums, int start, int end) {
		if (end <= start) {
			return;
		} else {
			int pivot = nums[end];	// always choose the last element as the pivot
			int par = partition(nums, start, end, pivot);
			sort(nums, start, par - 1);
			sort(nums, par + 1, end);			
		}
	}
	
	private static int partition(int[] nums, int start, int end, int pivot) {
		int i = start - 1;
		int j = end;
		while (true) {
			while (nums[++i] < pivot) {;} // try to find the item which is larger than pivot
			while (j > 0 && nums[--j] > pivot) {;} // try to find the item which is smaller than pivot
			if (i >= j) {
				break;
			} else {
				swap(nums, i, j);
			}
		}//while(true)
		swap(nums, i, end);  // pivot is now at its final position of the ultimately sorted array
		return i; // return the index of the pivot
	}
	
	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Coding Bro's Quick Sort VI Test ***");

		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \nleave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArr[i] = Integer.parseInt(strs[i]);
		}

		quickSort(testArr);
		displayResult(testArr);
	}

	public static void displayResult(int[] ret) {
		for (int element : ret) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
