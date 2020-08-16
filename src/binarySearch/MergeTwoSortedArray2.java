package binarySearch;

import java.util.Scanner;
/**
 * Merge Two Sorted Array A and B into a third array C
 * http://www.lintcode.com/en/problem/merge-sorted-array-ii/
 */
public class MergeTwoSortedArray2 {
	
	/**
	 * 
	 * @param a: input sorted array A
	 * @param b: input sorted array B
	 * @return c: merged sorted array of A and B.
	 */
	public static int[] mergeSortedArray(int[] a,int[] b) {
		int len1 = a.length;
		int len2 = b.length; 
		int len = len1 + len2;
		int[] c = new int[len];
		
		int i, j, k;
		i = j = k = 0;
		while (i < len1 && j < len2) {
			if (a[i] < b[j]) {
				c[k++] = a[i++];
			} else {
				c[k++] = b[j++];
			}
		}
		while (i < len1) {
			c[k++] = a[i++];
		}
		while (j < len2) {
			c[k++] = b[j++];
		}
		
		return c;
	}
	
	public static void displayArray(int[] arr, int size) {
		System.out.print("The array after removing duplicates become: ");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to Ben's Merge Two Sorted Array Test ***");
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Input your integer sorted array A \n" +
				"leave each number by space: ");
		String[] strs = sc.nextLine().split(" ");
		int[] arrA = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			arrA[i] = Integer.parseInt(strs[i]);
		}
		
		System.out.print("Input your integer sorted array B \n" +
				"leave each number by space: ");
		strs = sc.nextLine().split(" ");
		int[] arrB = new int[strs.length];
		for (int i = 0; i < strs.length; i++) {
			arrB[i] = Integer.parseInt(strs[i]);
		}
		
		int[] arrC = mergeSortedArray(arrA, arrB);
		
		if (arrC.length > 0) {
			displayArray(arrC, arrC.length);
		} else {
			System.out.print("Check your input arrays!!");
		}
	}
	
}
