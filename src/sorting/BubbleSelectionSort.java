package sorting;

import java.util.Scanner;

/**
 * This is a combination of Bubble and Selection sort;
 * you can figure it out ^^
 * 
 * input:[9, 8, 10, 5], then
 * [8, 9, 10, 5]
 * [5, 9, 10, 8]
 * [5, 8, 10, 9]
 * [5, 8, 9, 10] done.
 * 
 * @author Guru
 *
 */

public class BubbleSelectionSort {

	public static void bubbleSelectionSort(int[] input) {
		for (int i = 0; i < input.length - 1; i++) {
			for (int j = i + 1; j < input.length; j++) {
				if (input[i] > input[j]) {
					swap(i, j, input);
				}
			}
		}
	}
	
	private static void swap(int i, int j, int[] input) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's BubbleSelection Sort Test ***");

		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n"
				+ "leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		bubbleSelectionSort(testArray);
		displayResult(testArray);
	}
	
	public static void displayResult(int[] ret) {
		for (int element : ret) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

}
