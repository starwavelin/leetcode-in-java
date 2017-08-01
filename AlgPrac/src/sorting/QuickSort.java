package sorting;

import java.util.Scanner;

/**
 * This is my QuickSort Version One using pivot as the middle element of the input array
 */
public class QuickSort {

	public static void quickSort(int[] nums) {
		// check for empty or null array
		if (nums == null || nums.length <= 1) {
			return;
		}
		sort(nums, 0, nums.length - 1);
	}

	private static void sort(int[] nums, int low, int high) {
		if (high <= low) {
			return;
		}
		// Get the pivot element from the middle of the list
		int pivot = nums[low + (high - low) / 2];
		int pivotIndex = partition(nums, low, high, pivot);
		// Recursion
		sort(nums, low, pivotIndex -1);
		sort(nums, pivotIndex + 1, high);
	}

	private static int partition(int[] nums, int low, int high, int pivot) {
		int i = low, j = high;
		
		// Divide into two lists
		while (i <= j) {
			// If the current value from the left list is smaller than the
			// pivot element, then get the next element from the left list
			while (nums[i] < pivot) { //if change to <=, stackoverflow, why?
				i++;
			}
			// If the current value from the right list is larger than the
			// pivot element, then get the next element from the right list
			while (nums[j] > pivot) {
				j--;
			}

			// If we have found a value in the left list larger
			// than or equal the pivot element and if we have found a value in the right
			// list smaller than the pivot element,
			// then we exchange the two values.
			// As we are done we can increase i and j
			if (i <= j) {  // from <= to <, infinity loop
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
				j--;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Quick Sort One (pivot as middle element) Test ***");

		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n"
				+ "leave each number by space: ");
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
