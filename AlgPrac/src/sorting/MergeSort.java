package sorting;

import java.util.Scanner;
/**
 * This is a MergeSort example;
 * 
 * input:[9, 8, 10, 5], then
 * [9] [8] [10] [5] 
 * [8, 9], [5, 10]
 * [5, 8, 9, 10] done.
 * 
 * @author Guru
 *
 */
public class MergeSort {
	
	public static void mergeSort(int[] arr) {
		sort(arr, 0, arr.length - 1);
	}
	
	private static void sort(int[] arr, int low, int high) {
		if (high <= low) {	// be careful of this exit condition!!!
			return;
		}
		int mid = low + (high - low) / 2;
		sort(arr, low, mid);
		sort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}
	
	private static void merge(int[] arr, int low, int mid, int high) {
		int[] helpArr = new int[arr.length];
		for (int i = low; i <= high; i++) {
			helpArr[i] = arr[i];
		}
		int i = low;
		int j = mid + 1;
		int k = low;
		
		// Copy the smallest values from either the left or the right side back
	    // to the target array
		while (i <= mid && j <= high) {
			if (helpArr[i] <= helpArr[j]) {
				arr[k++] = helpArr[i++];
			} else {
				arr[k++] = helpArr[j++];
			}
		}
		
		// Copy the rest of the left side of the helpArr into the target array
		while (i <= mid) {
			arr[k++] = helpArr[i++];
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Merge Sort Test ***");

		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n"
				+ "leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArr[i] = Integer.parseInt(strs[i]);
		}
		
		mergeSort(testArr);
		displayResult(testArr);
	}
	
	public static void displayResult(int[] ret) {
		for (int element : ret) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}