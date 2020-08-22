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
	public static void mergeSort(int[] nums) {
		sort(nums, 0, nums.length - 1);
	}
	
	private static void sort(int[] nums, int start, int end) {
		if (end <= start) {	// be careful of this exit condition!!!
			return;
		}
		int mid = start + (end - start) / 2;
		sort(nums, start, mid);
		sort(nums, mid + 1, end);
		merge(nums, start, mid, end);
	}
	
	private static void merge(int[] nums, int start, int mid, int end) {
		int[] tmp = new int[nums.length];
		int i = start, j = mid + 1, k = start;
		
		while (i <= mid && j <= end) {
			tmp[k++] = (nums[i] < nums[j]) ? nums[i++] : nums[j++];
		}
		while (i <= mid) {
			tmp[k++] = nums[i++];
		}
		while (j <= end) {
			tmp[k++] = nums[j++];
		}
		for (i = start; i < k; i++) {
			nums[i] = tmp[i];
		}
	}
	
	public static void displayResult(int[] ret) {
		for (int element : ret) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Merge Sort Test ***");
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArr = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArr[i] = Integer.parseInt(strs[i]);
		}
		mergeSort(testArr);
		displayResult(testArr);
	}
}