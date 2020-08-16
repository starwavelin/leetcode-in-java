package sorting;

import java.util.Scanner;

/**
 * This is a Insertion sort example;
 * 
 * input:[9, 8, 10, 5], then
 * [8, 9, 10, 5]
 * [5, 8, 9, 10] done.
 * 
 * @author Guru
 *
 */

public class InsertionSort {

	public static void insertionSort(int[] nums) {		
		for (int i = 1; i < nums.length; i++) {
			int cur = nums[i];
			int j = i - 1;
			while (j >= 0 && nums[j] > cur) {
				nums[j + 1] = nums[j];
				j--;
			}
			if (j + 1 != i) {	// add this if condition to optimize performance
				nums[j + 1] = cur;
			}
		}
	}
	
	public static void displayResult(int[] ret) {
		for (int element : ret) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Xian's Insertion Sort Test ***");
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		insertionSort(testArray);
		displayResult(testArray);
	}
}
