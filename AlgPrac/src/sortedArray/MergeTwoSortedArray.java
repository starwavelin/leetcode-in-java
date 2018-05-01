package sortedArray;

import java.util.Scanner;
/**
 * Merge Two Sorted Array A and B into Array A,
 * given A has enough space to hold the merged result.
 * A has m elements but size of A is m+n; B has n elements
 * http://www.lintcode.com/en/problem/merge-sorted-array/
 */
public class MergeTwoSortedArray {
	
	
	public static void mergeSortedArray(int a[], int m, int b[], int n) {
		 int i, j, k;
		 i = m - 1; j = n - 1; k = m + n - 1;
		 while (i >= 0 && j >= 0) {
			 if (a[i] > b[j]) {
				 a[k--] = a[i--]; 
			 } else {
				 a[k--] = b[j--];
			 }
		 }
		 while (i >= 0) {
			 a[k--] = a[i--];
		 }
		 while (j >= 0) {
			 a[k--] = b[j--];
		 }
	}
	
	public static void displayArray(int[] arr, int size) {
		System.out.print("The array after removing duplicates become: ");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Merge Two Sorted Array II Test ***");
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input your integer sorted array B (B's length is less than A)\n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] arrB = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			arrB[i] = Integer.parseInt(strs[i]);
		}
		
		System.out.print("Input your integer sorted array A (A has enough space to hold B)\n" +
				"leave each number by space: ");
		strs = sc.nextLine().split(" ");
		int[] arrA = new int[strs.length + arrB.length];
		for (int i = 0; i < strs.length; i++) {
			arrA[i] = Integer.parseInt(strs[i]);
		}
		
		mergeSortedArray(arrA, arrA.length - arrB.length, arrB, arrB.length);
		
		if (arrA.length > 0) {
			displayArray(arrA, arrA.length);
		} else {
			System.out.print("Check your input arrays!!");
		}
	}
}
