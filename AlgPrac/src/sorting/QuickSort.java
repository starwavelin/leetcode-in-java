package sorting;

import java.util.Scanner;

/**
 * This is my QuickSort Version One.
 * The index of pivot (abbreviated as variable "pivot") is defined within the partition function.
 * The pivot is always the leftmost element in a partitioned array.
 */
public class QuickSort {

	public static void sort(int[] nums) {
		// check for empty or null array
		if (nums == null || nums.length <= 1) {
			return;
		}
		quickSort(nums, 0, nums.length - 1);
	}

	private static void quickSort(int[] nums, int left, int right) {
		if (left > right) {
			return;
		}
		
		int partitionIndex = partition(nums, left, right);
		
		// Recursion
		quickSort(nums, left, partitionIndex -1);
		quickSort(nums, partitionIndex + 1, right);
	}

	private static int partition(int[] nums, int left, int right) {
		int pivot = left;
		int i = pivot + 1; // slow pointer i, the fast pointer will be the j below
		for (int j = i; j <= right; j++) {
            if (nums[j] < nums[pivot]) {
                swap(nums, j, i);
                i++;
            }
        }
        swap(nums, pivot, i - 1);
		return i - 1;
	}
	
	private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

	public static void main(String[] args) {
		System.out.println("*** Welcome to Coding Bro's Quick Sort One (pivot as leftmost element) Test ***");

		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array,\n leave each number by space: ");
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
