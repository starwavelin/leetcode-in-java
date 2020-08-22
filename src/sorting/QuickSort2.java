package sorting;

import java.util.Scanner;

/**
 * This is my QuickSort Version 2.
 * The index of pivot (abbreviated as variable "pivot") is defined within the partition function.
 * The pivot is always the rightmost element in a partitioned array.
 */
public class QuickSort2 {

	public static void sort(int[] nums) {
		if (nums == null || nums.length == 0) {
		    return;
		}
		quicksort(nums, 0, nums.length - 1);
	}

	private static void quicksort(int[] nums, int left, int right) {
		if (left < right) {
		    int partitionIndex = partition(nums, left, right);
		    quicksort(nums, left, partitionIndex - 1);
		    quicksort(nums, partitionIndex + 1, right);
		}
	}

	private static int partition(int[] nums, int left, int right) {
		int pivot = right;
		int i = left - 1; // i is the slow Pointer
		// j is the fast Pointer
		for (int j = left; j <= pivot - 1; j++) {
		    if (nums[j] < nums[pivot]) {
		    	i++;
		    	if (i != j) {
		    		swap(nums, i, j);
		    	}
		    }
		}
		swap(nums, pivot, i + 1);
		return i + 1;
	}

	private static void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		System.out.println("*** Welcome to Coding Bro's Quick Sort Two (pivot as rightmost element) Test ***");

		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArr[i] = Integer.parseInt(strs[i]);
		}

		sort(testArr);
		displayResult(testArr);
	}

	public static void displayResult(int[] ret) {
		for (int element : ret) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
