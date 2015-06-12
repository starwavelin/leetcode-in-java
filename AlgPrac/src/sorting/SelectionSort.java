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

	public static void selectionSort(int[] input) {		
		for (int i = 0; i < input.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < input.length; j++) {
				if (input[j] < input[minIndex]) {
					minIndex = j;
				}
			}
			if (i != minIndex) {
				swap(i, minIndex, input);
			}
		}
	}
	
	private static void swap(int i, int j, int[] input) {
		int tmp = input[i];
		input[i] = input[j];
		input[j] = tmp;
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Selection Sort Test ***");

		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer array, \n"
				+ "leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] testArray = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			testArray[i] = Integer.parseInt(strs[i]);
		}
		
		selectionSort(testArray);
		displayResult(testArray);
	}
	
	public static void displayResult(int[] ret) {
		for (int element : ret) {
			System.out.print(element + " ");
		}
		System.out.println();
	}
}
