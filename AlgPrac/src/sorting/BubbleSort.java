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

	public static void bubbleSort(int[] input) {
		for (int j = input.length - 1; j > 0; j--) {
			for (int i = 0; i < j; i++) {
				if (input[i] > input[i + 1]) {
					swap(i, i + 1, input);
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
		System.out.println("*** Welcome to Ben's Bubble Sort Test ***");

		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer sorted array, \n"
				+ "leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		bubbleSort(testArray);
		displayResult(testArray);
	}
	
	public static void displayResult(int[] ret) {
		for (int element : ret) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

}
