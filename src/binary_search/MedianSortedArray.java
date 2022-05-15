package binary_search;

import java.util.Scanner;
/**
 * 
 * Find the median of two sorted array.
 * O(log k) solution. k = (len(arrA) + len(arrB)) / 2;
 * http://lintcode.com/en/problem/median-of-two-sorted-arrays/
 */

public class MedianSortedArray {
	
	public static double findMedianSortedArrays(int[] A, int[] B) {
		int len = A.length + B.length;
		if (len % 2 == 0) {
			return (findKth(A, 0, B, 0, len/2) 
					+ findKth(A, 0, B, 0, len/2 + 1)) / 2.0;
		} else {
			return findKth(A, 0, B, 0, len/2 + 1); 
		}
	}
	
	// Find the kth num of the two sorted arrays
	private static int findKth(int[] A, int A_start, int[] B, int B_start, int k) {
		if (A_start >= A.length) {
			return B[B_start + k - 1];
		}
		if (B_start >= B.length) {
			return A[A_start + k - 1];
		}
		
		if (k == 1) {return Math.min(A[A_start], B[B_start]);}
		
		int A_key = (A_start + k/2 - 1 < A.length)
				? A[A_start + k/2 - 1]
				: Integer.MAX_VALUE;
		int B_key = (B_start + k/2 - 1 < B.length) 
				? B[B_start + k/2 - 1]
				: Integer.MAX_VALUE;
				
		if (A_key < B_key) {
			return findKth(A, A_start + k/2, B, B_start, k - k/2);
		} else {
			return findKth(A, A_start, B, B_start + k/2, k - k/2);
		}		
	}
	
	public static void main(String[] args) {
		System.out.println("*** Welcome to @codingbro's Median Two Sorted Array Test ***");
		
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
		
		double median = findMedianSortedArrays(arrA, arrB);
		
		System.out.println("The median of the two sorted array is: " + median);
	}
}
