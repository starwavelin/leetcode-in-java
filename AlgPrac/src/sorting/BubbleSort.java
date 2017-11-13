package sorting;

import java.util.Scanner;

/**
 * This is a Bubble sort example.
 * 
 * input:[9, 8, 10, 5], then
 * [8, 9, 10, 5]
 * [8, 9, 5, 10]
 * [8, 5, 9, 10]
 * [5, 8, 9, 10] done.
 * 
 * @author Guru
 *
 */

public class BubbleSort {

	public static void bubbleSort(int[] nums) {
		for (int i = nums.length - 1; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				if (nums[j] < nums[j - 1]) {
					int t = nums[j];
					nums[j] = nums[j - 1];
					nums[j - 1] = t;
				}
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
		System.out.println("*** Welcome to Xian's Bubble Sort Test ***");
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		bubbleSort(testArray);
		displayResult(testArray);
	}
}
