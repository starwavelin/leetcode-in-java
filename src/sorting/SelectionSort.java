package sorting;

import java.util.Scanner;

/**
 * This is a Selection sort example;
 * 
 * input:[9, 8, 10, 5], then
 * [5, 8, 10, 9]
 * [5, 8, 9, 10] done.
 * 
 * @author Guru
 *
 */

public class SelectionSort {

	public static void selectionSort(int[] nums) {		
		for (int i = 0; i < nums.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] < nums[min]) {
					min = j;
				}
			}
			if (i != min) {
				int tmp = nums[i];
				nums[i] = nums[min];
				nums[min] = tmp;
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
		System.out.println("*** Welcome to @codingbro's Selection Sort Test ***");
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		selectionSort(testArray);
		displayResult(testArray);
	}
}
